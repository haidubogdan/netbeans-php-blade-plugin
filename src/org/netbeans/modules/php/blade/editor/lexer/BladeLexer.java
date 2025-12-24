/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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

    public BladeLexer(LexerRestartInfo<BladeTokenId> info) {
        super(info, BladeAntlrColoringLexer::new);
    }

    @Override
    public Object state() {
        return new State(lexer);
    }

    @Override
    protected Token<BladeTokenId> mapToken(org.antlr.v4.runtime.Token antlrToken) {

        switch (antlrToken.getType()) {
            case BladeAntlrColoringLexer.HTML_TAG:
            case BladeAntlrColoringLexer.HTML:
                return groupToken(HTML, BladeAntlrColoringLexer.HTML);
            case BladeAntlrColoringLexer.COMPONENT_ATTR:
                return groupToken(BLADE_COMPONENT_ATTRIBUTE, BladeAntlrColoringLexer.COMPONENT_ATTR);
            case BladeAntlrColoringLexer.DIRECTIVE:
            case BladeAntlrColoringLexer.D_PHP:
            case BladeAntlrColoringLexer.D_ENDPHP:
                return token(BLADE_DIRECTIVE);
            case BladeAntlrColoringLexer.D_CUSTOM:
                return token(BLADE_CUSTOM_DIRECTIVE);
            case BladeAntlrColoringLexer.RAW_TAG:
            case BladeAntlrColoringLexer.CONTENT_TAG:
                return token(BLADE_ECHO_DELIMITOR);
            case BladeAntlrColoringLexer.BLADE_PHP_ECHO_EXPR:
                return token(PHP_BLADE_ECHO_EXPR);
            case BladeAntlrColoringLexer.D_UNKNOWN:
            case BladeAntlrColoringLexer.D_AT:
                return groupToken(BLADE_DIRECTIVE_UNKNOWN, BladeAntlrColoringLexer.D_UNKNOWN);
            case BladeAntlrColoringLexer.BLADE_PAREN:
                return token(BLADE_PAREN);
            case BladeAntlrColoringLexer.BLADE_COMMENT_START:
                return token(BLADE_COMMENT_START);
            case BladeAntlrColoringLexer.BLADE_COMMENT:
                return groupToken(BLADE_COMMENT, BladeAntlrColoringLexer.BLADE_COMMENT);
            case BladeAntlrColoringLexer.BLADE_COMMENT_END:
                return token(BLADE_COMMENT_END);
            case BladeAntlrColoringLexer.PHP_INLINE:
                return token(PHP_INLINE);
            case BladeAntlrColoringLexer.PHP_EXPRESSION:
                return groupToken(PHP_BLADE_EXPRESSION, BladeAntlrColoringLexer.PHP_EXPRESSION);
            case BladeAntlrColoringLexer.BLADE_PHP_INLINE:
                return groupToken(PHP_BLADE_INLINE_CODE, BladeAntlrColoringLexer.BLADE_PHP_INLINE);
            case BladeAntlrColoringLexer.ERROR: //??
                return token(WS_D);
            default:
                return token(OTHER);
        }
    }

    private static class State extends AbstractAntlrLexerBridge.LexerState<BladeAntlrColoringLexer> {
        final int rParenBalance;
        final int compAttrQuoteBalance;
        final boolean insideComponentTag;

        public State(BladeAntlrColoringLexer lexer) {
            super(lexer);
            this.rParenBalance = lexer.rParenBalance;
            this.compAttrQuoteBalance = lexer.compAttrQuoteBalance;
            this.insideComponentTag = lexer.insideComponentTag;
        }

        @Override
        public void restore(BladeAntlrColoringLexer lexer) {
            super.restore(lexer);
            lexer.rParenBalance = rParenBalance;
            lexer.compAttrQuoteBalance = compAttrQuoteBalance;
            lexer.insideComponentTag = insideComponentTag;
        }

    }

}
