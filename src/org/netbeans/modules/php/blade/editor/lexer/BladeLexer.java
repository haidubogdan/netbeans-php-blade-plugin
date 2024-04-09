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
package org.netbeans.modules.php.blade.editor.lexer;

import org.netbeans.api.lexer.Token;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrColoringLexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.spi.lexer.antlr4.AbstractAntlrLexerBridge;

/**
 *
 * @author bogdan
 */
public class BladeLexer extends AbstractAntlrLexerBridge<BladeAntlrColoringLexer, BladeTokenId> {
   // private static final Logger LOGGER = Logger.getLogger(BladeLexer.class.getName());
    public BladeLexer(LexerRestartInfo<BladeTokenId> info) {
        super(info, BladeAntlrColoringLexer::new);
        //LOGGER.log(Level.INFO, "Restarting lexer{0}", info.state());
    }

    @Override
    public Object state() {
        return new State(lexer);
    }

    @Override
    protected Token<BladeTokenId> mapToken(org.antlr.v4.runtime.Token antlrToken) {
        //debug text
        //String text = antlrToken.getText();
        int type = antlrToken.getType();
        //System.out.println(text + " " + type);
        switch (type) {
            case BladeAntlrColoringLexer.BLADE_COMMENT_START:
                return token(BLADE_COMMENT_START);
            case BladeAntlrColoringLexer.BLADE_COMMENT:
                return token(BLADE_COMMENT);
            case BladeAntlrColoringLexer.BLADE_COMMENT_END:
                return token(BLADE_COMMENT_END);
            case BladeAntlrColoringLexer.HTML_TAG:  
            case BladeAntlrColoringLexer.HTML:
                return token(HTML);
            case BladeAntlrColoringLexer.PHP_INLINE:
                return token(PHP_INLINE);
            case BladeAntlrColoringLexer.PHP_EXPRESSION:
                //System.out.println(antlrToken.getText());
                return token(PHP_BLADE_EXPRESSION);
            case BladeAntlrColoringLexer.BLADE_PHP_INLINE:
                return token(PHP_BLADE_INLINE_CODE);
            case BladeAntlrColoringLexer.DIRECTIVE:
            case BladeAntlrColoringLexer.D_PHP:
            case BladeAntlrColoringLexer.D_ENDPHP:
            case BladeAntlrColoringLexer.D_CUSTOM:
                return token(BLADE_DIRECTIVE);
            case BladeAntlrColoringLexer.RAW_TAG:
            case BladeAntlrColoringLexer.CONTENT_TAG:
                return token(BLADE_ECHO_DELIMITOR);
            case BladeAntlrColoringLexer.BLADE_PHP_ECHO_EXPR:
                return token(PHP_BLADE_ECHO_EXPR);
            case BladeAntlrColoringLexer.ERROR:
            case BladeAntlrColoringLexer.WS_EXPR:
            case BladeAntlrColoringLexer.WS_BEFORE_DIRECTIVE:    
                return token(WS_D);
            default:
                return token(OTHER);
        }
    }

    private static class State extends AbstractAntlrLexerBridge.LexerState<BladeAntlrColoringLexer> {

        final int currentRuleType;

        public State(BladeAntlrColoringLexer lexer) {
            super(lexer);
            this.currentRuleType = lexer.getCurrentRuleType();
        }

        @Override
        public void restore(BladeAntlrColoringLexer lexer) {
            super.restore(lexer);
            lexer.setCurrentRuleType(currentRuleType);
        }

    }

}
