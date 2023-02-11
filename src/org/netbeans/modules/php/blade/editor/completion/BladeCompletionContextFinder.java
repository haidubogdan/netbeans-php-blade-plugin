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
package org.netbeans.modules.php.blade.editor.completion;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.php.blade.editor.BladeSyntax;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;

/**
 *
 * @author Haidu Bogdan
 */
public class BladeCompletionContextFinder {

    public static enum CompletionContext {
        BLADE_ECHO,
        DIRECTIVE,
        PATH, //@extends, @include, @each paths
        SECTION_LABEL, //@section paths
        SECTION,
        FILTER,
        PHP,
        NONE,
        ALL;
    }

    private final static Collection<BladeTokenId> CTX_DELIMITERS = Arrays.asList(
            BladeTokenId.T_BLADE_DIRECTIVE,
            BladeTokenId.T_BLADE_IF, BladeTokenId.T_BLADE_FOR, BladeTokenId.T_BLADE_FOREACH
    );

    private final static Collection<BladeTokenId> PATH_KEYWORDS_TOKEN = Arrays.asList(
            BladeTokenId.T_BLADE_INCLUDE, BladeTokenId.T_BLADE_EXTENDS, BladeTokenId.T_BLADE_EACH
    );

    private final static Collection<BladeTokenId> SECTION_KEYWORDS_TOKEN = Arrays.asList(
            BladeTokenId.T_BLADE_SECTION
    );

    private final static Collection<BladeTokenId> PHP_KEYWORDS_TOKEN = Arrays.asList(
            BladeTokenId.T_BLADE_PHP_OPEN, BladeTokenId.T_BLADE_PHP
    );
    
    static enum KeywordCompletionType {
        SIMPLE, WITH_ARG, WITH_ARG_AND_ENDTAG, WITH_ENDTAG
    };
    
    public static CompletionContext find(final BladeParserResult info, final int offset) {
        assert info != null;
        CompletionContext result = CompletionContext.NONE;
        TokenHierarchy<?> th = info.getSnapshot().getTokenHierarchy();

        if (th == null) {
            return result;
        }

        TokenSequence<BladeTokenId> ts = th.tokenSequence(BladeTokenId.language());

        ts.move(offset);
        final boolean moveNextSucces = ts.moveNext();
        if (!moveNextSucces && !ts.movePrevious()) {
            return CompletionContext.NONE;
        }

        Token<BladeTokenId> token = ts.token();
        BladeTokenId id = token.id();

        if (PATH_KEYWORDS_TOKEN.contains(id)) {
            return CompletionContext.PATH; //@include | @extends | @each
        }
        if (SECTION_KEYWORDS_TOKEN.contains(id)) {
            return CompletionContext.SECTION_LABEL;
        }
        
        //completion for ending directive
        if (CTX_DELIMITERS.contains(id)) {
            return CompletionContext.DIRECTIVE; //standard blade directive
        }

        if (PHP_KEYWORDS_TOKEN.contains(id)) {
            return CompletionContext.PHP;
        }
        
        if (id.equals(BladeTokenId.T_BLADE_PHP_ECHO)){
            return CompletionContext.BLADE_ECHO;
        }
        
        boolean isStringParameter = false;

        int tokenIdOffset = ts.token().offset(th);
        result = findOffsetContext(token, (offset - tokenIdOffset), ts); //search for the previous context
        
        if (isStringParameter) { //we are in a expression with string parameter
            switch (result) {
                case SECTION: {
                    result = CompletionContext.SECTION_LABEL;
                    break;
                }
                case PATH: {
                    result =  CompletionContext.PATH;
                    break;
                }
                default: {
                    result = CompletionContext.NONE;
                }
            }
        }
        
        return result;
    }

    /**
     * 
     * @param BladeTokenId token
     * @param int tokenOffset
     * @param TokenSequence<BladeTokenId> tokenSequence
     * @return 
     */
    private static CompletionContext findOffsetContext(Token<BladeTokenId> token, int tokenOffset, TokenSequence<BladeTokenId> tokenSequence) {
        CompletionContext result = CompletionContext.NONE;

        List<? extends Token<BladeTokenId>> preceedingLineTokens = BladeLexerUtils.getPreceedingLineTokens(token, tokenOffset, tokenSequence);

        for (int i = 0; i < preceedingLineTokens.size(); i++) {
            Token<BladeTokenId> cToken = preceedingLineTokens.get(i);
            BladeTokenId id = cToken.id();
            String tText = cToken.text().toString().trim();
            if (id.equals(BladeTokenId.T_BLADE_SECTION)){
                return CompletionContext.SECTION_LABEL;
            } else if (BladeSyntax.DIRECTIVES_WITH_VIEW_PATH.contains(tText)){
                return CompletionContext.PATH;
            } else if (id.equals(BladeTokenId.T_BLADE_DIRECTIVE)) {
                return CompletionContext.DIRECTIVE;
            } else if (PHP_KEYWORDS_TOKEN.contains(id)) {
                //we are inside brakets from an expression
                return CompletionContext.PHP;
            }
        }
        return result;
    }

}
