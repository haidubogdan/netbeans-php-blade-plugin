/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.editor.parsing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.lib.editor.util.CharSequenceUtilities;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author Haidu Bogdan
 */
public class BladeParser extends Parser {

    Snapshot snapshot;
    BladeParserResult result;
    
    final static List<String> parseElements = new ArrayList<String>();
    static {
        parseElements.add( "@section" );
        parseElements.add( "@endsection" );
        
        parseElements.add( "@for" );
        parseElements.add( "@endfor" );
        
        parseElements.add( "@foreach" );
        parseElements.add( "@endforeach" );
        
        parseElements.add( "@if" );
        parseElements.add( "@endif" );
        
        parseElements.add( "@php" );
        parseElements.add( "@endphp" );
        
        parseElements.add( "@veratim" );
        parseElements.add( "@endverbatim" );
        
        parseElements.add( "@unless" );
        parseElements.add( "@endunless" );
    }
    
    @Override
    public void parse( Snapshot snapshot, Task task, SourceModificationEvent sme ) throws ParseException {
        this.snapshot = snapshot;
        result = new BladeParserResult( snapshot );
        
        TokenHierarchy<?> tokenHierarchy = snapshot.getTokenHierarchy();
        
        LanguagePath bladePath = null;
        
        for ( LanguagePath path : tokenHierarchy.languagePaths() ) {
            //skip BladeTokenId Mime
            if ( path.mimePath().endsWith( BladeTokenId.BLADE_MIME_SHORT ) ) { 
                bladePath = path; break; 
            }
            
        }
        
        if ( bladePath != null ) {
            
            List<TokenSequence<?>> tokenSequenceList = tokenHierarchy.tokenSequenceList( bladePath, 0, Integer.MAX_VALUE );
            List<Instruction> instructionList = new ArrayList<>();
            
            for ( TokenSequence<?> sequence : tokenSequenceList ) {
                
                while ( sequence.moveNext() ) {
                    
                    Token<BladeTokenId> token = (Token<BladeTokenId>) sequence.token();
                    
                    /* Parse instruction */
                    BladeTokenId id = token.id();
                    
                    if ( id == BladeTokenId.T_BLADE_DIRECTIVE){
                        CharSequence tokenText = token.text();
                        String directiveNameString = tokenText.toString().trim().replace(" ", "").replace("\n", "").replace("(", "");
                        if (parseElements.contains(directiveNameString)){
                            Instruction instruction = new Instruction();
                            CharSequence directiveName = directiveNameString.replace("@", "");
                            instruction.function = directiveName;
                            instruction.functionTokenIndex = sequence.index();
                            instruction.functionFrom = token.offset(tokenHierarchy);
                            instruction.functionLength = token.length();
                            instructionList.add( instruction );
                        }
                        
                    }
                }
                
            } 
            
            /* Analyse instruction structure */
            
            Stack<Instruction> instructionStack = new Stack<Instruction>();
            
            for ( Instruction instruction : instructionList ) {
                
                if ( CharSequenceUtilities.startsWith( instruction.function, "end" ) ) {
                    
                    if ( instructionStack.empty() ) { // End tag, but no more tokens on stack!
                        
                        result.addError( 
                            "Unopened '" + instruction.function + "' directive",
                            instruction.functionFrom,
                            instruction.functionLength
                        );

                    } else if ( CharSequenceUtilities.endsWith( instruction.function, instructionStack.peek().function ) ) {
                        // end[sth] found a [sth] on the stack!
                        
                        Instruction start = instructionStack.pop();
                        result.addDirective( start.function, start.functionFrom, instruction.functionFrom - start.functionFrom + instruction.functionLength, start.extra );
                        
                    } else {
                        // something wrong lies on the stack!
                        // assume that current token is invalid and let it stay on the stack

                        result.addError( 
                            "Unexpected '" + instruction.function + "', expected 'end" + instructionStack.peek().function + "'",
                            instruction.functionFrom,
                            instruction.functionLength
                        );
                        
                    }
                    
                } else {
                    instructionStack.push( instruction );
                }
                
            }
            
            // All instructions were parsed. Are there any left on the stack?
            if ( !instructionStack.empty() ) {
                // Yep, they were never closed!
                
                while ( !instructionStack.empty() ) {
                    
                    Instruction instruction = instructionStack.pop();
                    if (instruction.function.equals("section")){
                        //section can be defined without endsection
                        //to do peek element info for extra param
                        continue;
                    }
                    result.addError( 
                        "Unclosed '@" + instruction.function + "'",
                        instruction.functionFrom,
                        instruction.functionLength
                    );
                    
                }
                
            }
        }
        
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return result;
    }
    
    @Override
    public void addChangeListener(ChangeListener cl) {}

    @Override
    public void removeChangeListener(ChangeListener cl) {}
    
    static public class Factory extends ParserFactory {

        @Override
        public Parser createParser( Collection<Snapshot> clctn ) {
            return new BladeParser();
        }
        
    }
    
    class Instruction {
        
        CharSequence function = null;
        CharSequence extra = null;
        int startTokenIndex = 0;
        int endTokenIndex = 0;
        int functionTokenIndex = 0;
        
        int from = 0;
        int length = 0;
        
        int functionFrom = 0;
        int functionLength = 0;
        
    }
    
}
