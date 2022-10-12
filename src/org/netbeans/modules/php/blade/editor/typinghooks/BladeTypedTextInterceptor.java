/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
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
 */
package org.netbeans.modules.php.blade.editor.typinghooks;

import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.project.OptionsUtils;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.BladeSyntax;

import org.netbeans.spi.editor.typinghooks.TypedTextInterceptor;
import org.openide.util.Exceptions;

public class BladeTypedTextInterceptor implements TypedTextInterceptor {

    private final boolean isBlade;
    private boolean codeTemplateEditing;
    private static final Logger LOGGER = Logger.getLogger(BladeTypedTextInterceptor.class.getName());

    private BladeTypedTextInterceptor(MimePath mimePath) {
        String path = mimePath.getPath();
        isBlade = path.contains(BladeLanguage.BLADE_MIME_TYPE);
    }

    @Override
    public boolean beforeInsert(Context context) throws BadLocationException {
        return false;
    }

    @Override
    public void insert(MutableContext context) throws BadLocationException {
        if (!isBlade) {
            return;
        }
        Document document = context.getDocument();
        BaseDocument doc = (BaseDocument) document;
        int caretOffset = context.getOffset();
        String selection = context.getReplacedText();
        char ch = context.getText().charAt(0);
        if (doNotAutoCompleteQuotesAndBrackets(ch) || caretOffset == 0) {
            return;
        }
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        TokenSequence<BladeTokenId> ts = th.tokenSequence(BladeTokenId.language());

        if (ts == null) {
            return;
        }
        ts.move(caretOffset);
        if (!ts.moveNext() && !ts.movePrevious()) {
            return;
        }

        boolean skipQuote = false;
        boolean isInString = false;

        // complete quote or bracket
        if (isOpeningBracket(ch) || isQuote(ch)) {
            if (selection != null && selection.length() > 0) {
                surroundSelectionWithChars(selection, ch, context);
            } else {
                completeQuoteAndBracket(context, ch);
            }
        }

        // skip the same closing char
        if ((isClosingBracket(ch) || isQuote(ch))
                && TypingHooksUtils.sameAsExistingChar(doc, ch, caretOffset)) {
            if (isInString) {
                if (!skipQuote && isQuote(ch) && !TypingHooksUtils.isEscapeSequence(doc, caretOffset)) {
                    skipNextChar(context, ch, document, caretOffset);
                }
            } else {
                if (!skipQuote && !isClosingBracketMissing(ch)) {
                    skipNextChar(context, ch, document, caretOffset);
                }
            }
        } else if (ch == ' ') {
            Token<?> token = ts.token();
            Object t_id = token.id();
            String tText = token.text().toString();
            if (token.id().equals(BladeTokenId.T_BLADE_PHP_ECHO) || 
                    (token.id().equals(BladeTokenId.T_BLADE_COMMENT) && token.text().toString().endsWith("--}}"))){
                //we are inside an existing echo or comment
                return;
            }

            /**
            * blade bracket completer
            * one directional only 
            * for 
            * echo {{ }}
            * echo escaped {!! !!}
            * comment {{-- --}}
            * 
            */

            try {
                String s = doc.getText(caretOffset - 2, 2);
                String expectedBracket = BladeSyntax.OPEN_ECHO;
                
                if ("!!".equals(s) && caretOffset > 3) {
                    s = doc.getText(caretOffset - 3, 3);
                    expectedBracket = BladeSyntax.OPEN_ECHO_ESCAPED;
                } else if ("--".equals(s) && caretOffset > 4) {
                    s = doc.getText(caretOffset - 4, 4);
                    expectedBracket = BladeSyntax.OPEN_COMMENT;
                }
                token = ts.token();
                
                if (token.text().toString().startsWith("}")){
                    return;
                }
                
                String text = token.text().toString();
                if (expectedBracket.equals(s)) { // NOI18N
                    StringBuilder sb = new StringBuilder();
                    sb.append("  ");
                    String completeBracket = matching(expectedBracket);
                    sb.append(completeBracket);
                    
                    context.setText(sb.toString(), 1);
                }
            } catch (BadLocationException ble) {
                Exceptions.printStackTrace(ble);
            }
        }
    }

    @Override
    public void afterInsert(Context context) throws BadLocationException {
        if (!isBlade) {
            return;
        }
        BaseDocument doc = (BaseDocument) context.getDocument();
        doc.runAtomicAsUser(() -> {
            //do other magic
        });
    }

    @Override
    public void cancelled(Context context) {
    }

    /**
     * Surround the selected text with chars("", '', (), []).
     * <b>NOTE:</b> Replace the surrounding chars if the text is already
     * surrounded with chars.
     *
     * @param selection the selected text
     * @param ch the opening bracket
     * @param context the context
     */
    private void surroundSelectionWithChars(String selection, char ch, MutableContext context) {
        char firstChar = selection.charAt(0);
        if (firstChar != ch) {
            char lastChar = selection.charAt(selection.length() - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            if (selection.length() > 1
                    && (isOpeningBracket(firstChar) || isQuote(firstChar))
                    && lastChar == matching(firstChar)) {
                String innerText = selection.substring(1, selection.length() - 1);
                sb.append(innerText);
            } else {
                sb.append(selection);
            }
            sb.append(matching(ch));
            String text = sb.toString();
            context.setText(text, text.length());
        }
    }

    private void skipNextChar(MutableContext context, char ch, Document document, int dotPos) throws BadLocationException {
        context.setText(Character.toString(ch), 1);
        document.remove(dotPos, 1);
    }

    private void completeQuoteAndBracket(MutableContext context, char bracket) throws BadLocationException {
        if (codeTemplateEditing) {
            String text = context.getText() + bracket;
            context.setText(text, text.length() - 1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bracket);
        sb.append(matching(bracket));
        String text = sb.toString();
        context.setText(text, 1);
    }

    private static boolean isBracket(char c) {
        return isOpeningBracket(c) || isClosingBracket(c);
    }

    private static boolean isOpeningBracket(char c) {
        switch (c) {
            case '(': // no break
            case '[': // no break
                return true;
            default:
                return false;
        }
    }

    private static boolean isClosingBracket(char c) {
        switch (c) {
            case ')': // no break
            case ']': // no break
                return true;
            default:
                return false;
        }
    }

    private static boolean isQuote(char ch) {
        return ch == '"' || ch == '\'';
    }

    private static char matching(char c) {
        switch (c) {
            case '"':
                return '"';
            case '\'':
                return '\'';
            case '(':
                return ')';
            case '[':
                return ']';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return c;
        }
    }
    
    private static String matching(String token) {
        switch (token) {
            case "{{":
                return BladeSyntax.CLOSE_ECHO;
            case "{!!":
                return BladeSyntax.CLOSE_ECHO_ESCAPED;
            case "{{--":
                return BladeSyntax.CLOSE_COMMENT;
            default:
                return token;
        }
    }

    private static boolean doNotAutoCompleteQuotesAndBrackets(char c) {
        return (isQuote(c) && !OptionsUtils.autoCompletionEchoDelimiter())
                || (isBracket(c) && !TypingHooksUtils.isInsertMatchingEnabled());
    }
    
    private static boolean isClosingBracketMissing(char close) throws BadLocationException {
        if (!isClosingBracket(close)) {
            return false;
        }
        return false;
    }

    @MimeRegistrations(value = {
        @MimeRegistration(mimeType = BladeLanguage.BLADE_MIME_TYPE, service = TypedTextInterceptor.Factory.class),
        @MimeRegistration(mimeType = "text/xhtml", service = TypedTextInterceptor.Factory.class)
    })
    public static class Factory implements TypedTextInterceptor.Factory {

        @Override
        public TypedTextInterceptor createTypedTextInterceptor(MimePath mimePath) {
            return new BladeTypedTextInterceptor(mimePath);
        }

    }

}
