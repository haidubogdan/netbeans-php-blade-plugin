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

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.php.blade.editor.embeddings.BladeEmbeddingProvider;
import org.netbeans.modules.php.blade.editor.gsf.BladeLanguage;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.lexer.BladeTopTokenId;
import org.netbeans.modules.php.blade.editor.ui.options.OptionsUtils;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.spi.editor.typinghooks.DeletedTextInterceptor;


/**
 * Based on PHP editor.
 */
public class BladeDeletedTextInterceptor implements DeletedTextInterceptor {

    private final boolean isBlade;
    private final MimePath mimePath;

    private BladeDeletedTextInterceptor(MimePath mimePath) {
        this.mimePath = mimePath;
        String path = mimePath.getPath();
        isBlade = path.contains(BladeLanguage.BLADE_MIME_TYPE);
    }

    @Override
    public boolean beforeRemove(Context context) throws BadLocationException {
        if (isBlade) {
            char ch = context.getText().charAt(0);
            if (TypingHooksUtils.isOpeningDelimiterChar(ch)) {
                BaseDocument doc = (BaseDocument) context.getDocument();
                final AtomicBoolean removed = new AtomicBoolean();
                final AtomicReference<BadLocationException> ble = new AtomicReference<>();
                doc.runAtomic(() -> {
                    BeforeRemover remover = BeforeRemoverFactory.create(ch);
                    try {
                        removed.set(remover.beforeRemove(context));
                    } catch (BadLocationException ex) {
                        ble.set(ex);
                    }
                });
                if (ble.get() != null) {
                    throw ble.get();
                }
                // if true, the further processing will be stopped
                return removed.get();
            }
        }
        return false;
    }

    @Override
    public void remove(Context context) throws BadLocationException {
        if (!isBlade) {
            return;
        }
        char c = context.getText().charAt(0);
        Remover remover = RemoverFactory.create(c);
        remover.remove(context);

    }

    @Override
    public void afterRemove(Context context) throws BadLocationException {
    }

    @Override
    public void cancelled(Context context) {
    }

    private interface BeforeRemover {

        BeforeRemover NONE = (Context context) -> {
            return false;
        };

        boolean beforeRemove(Context context) throws BadLocationException;
    }

    private static final class BeforeRemoverFactory {

        public static BeforeRemover create(char c) {
            switch (c) {
                case '!':
                    return new VariableDelimiterRemover();
                case '{':
                    return new VariableDelimiterRemover();
                default:
                    assert false;
                    break;
            }
            return BeforeRemover.NONE;
        }
    }

    private abstract static class DelimiterRemover implements BeforeRemover {

        @Override
        public boolean beforeRemove(Context context) throws BadLocationException {
            if (OptionsUtils.autoCompletionEscapedEchoDelimiter()) {
                int dotPos = context.getOffset();
                Document document = context.getDocument();
                TokenSequence<? extends BladeTopTokenId> ts = BladeLexerUtils.getBladeTokenSequence(document, dotPos);
                // now support {{}} and {!!!!}, should also check whitespaces?
                if (ts != null) {
                    ts.move(dotPos);
                    if (ts.movePrevious()) {
                        if (ts.token().id() == getOpeningId()
                                && ts.offset() == dotPos - 2) {
                            ts.move(dotPos);
                            if (ts.moveNext()) {
                                if (ts.token().id() == getClosingId()
                                        && ts.offset() == dotPos) {
                                    document.remove(dotPos - 2, 4); // {{}} or {!!!!}
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        protected abstract BladeTopTokenId getOpeningId();

        protected abstract BladeTopTokenId getClosingId();
    }

    private static final class BlockDelimiterRemover extends DelimiterRemover {

        @Override
        protected BladeTopTokenId getOpeningId() {
            return BladeTopTokenId.T_BLADE_VAR;
        }

        @Override
        protected BladeTopTokenId getClosingId() {
            return BladeTopTokenId.T_BLADE_VAR;
        }

    }

    private static final class VariableDelimiterRemover extends DelimiterRemover {

        @Override
        protected BladeTopTokenId getOpeningId() {
            return BladeTopTokenId.T_BLADE_PHP;
        }

        @Override
        protected BladeTopTokenId getClosingId() {
            return BladeTopTokenId.T_BLADE_PHP;
        }

    }

    private interface Remover {

        Remover NONE = (Context context) -> {
        };

        void remove(Context context) throws BadLocationException;
    }

    private static final class RemoverFactory {

        static Remover create(char ch) {
            Remover remover;
            switch (ch) {
                case '{':
                    remover = new CurlyBracketRemover();
                    break;
                case '(':
                    remover = new RoundBracketRemover();
                    break;
                case '[':
                    remover = new SquareBracketRemover();
                    break;
                case '\"':
                    remover = new DoubleQuoteRemover();
                    break;
                case '\'':
                    remover = new SingleQuoteRemover();
                    break;
                default:
                    remover = Remover.NONE;
                    break;
            }
            return remover;
        }

    }

    private abstract static class BracketRemover implements Remover {

        @Override
        public void remove(Context context) throws BadLocationException {
            if (TypingHooksUtils.isInsertMatchingEnabled()) {
                BaseDocument doc = (BaseDocument) context.getDocument();
                int dotPos = context.getOffset() - 1;
                if (TypingHooksUtils.sameAsExistingChar(doc, getClosingBracket(), dotPos)
                        && BladeLexerUtils.getTokenBalance(doc, getOpeningBracket(), getClosingBracket(), dotPos) < 0) {
                    // opening bracket is already removed
                    doc.remove(dotPos, 1);
                }
            }
        }

        protected abstract char getOpeningBracket();

        protected abstract char getClosingBracket();

    }

    private static final class CurlyBracketRemover extends BracketRemover {

        @Override
        protected char getOpeningBracket() {
            return '{';
        }

        @Override
        protected char getClosingBracket() {
            return '}';
        }

    }

    private static final class SquareBracketRemover extends BracketRemover {

        @Override
        protected char getOpeningBracket() {
            return '[';
        }

        @Override
        protected char getClosingBracket() {
            return ']';
        }

    }

    private static final class RoundBracketRemover extends BracketRemover {

        @Override
        protected char getOpeningBracket() {
            return '(';
        }

        @Override
        protected char getClosingBracket() {
            return ')';
        }

    }

    private abstract static class QuoteRemover implements Remover {

        @Override
        public void remove(Context context) throws BadLocationException {
            if (OptionsUtils.autoCompletionEchoDelimiter()) {
                BaseDocument doc = (BaseDocument) context.getDocument();
                int dotPos = context.getOffset() - 1;
                TokenSequence<? extends TokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, dotPos);
                // check escape sequence
                // e.g. "\"" '\''
                if (ts != null) {
                    ts.move(dotPos);
                    if ((ts.moveNext() || ts.movePrevious())) {
                        TokenId id = ts.token().id();
                        if (id == BladeTokenId.T_BLADE_ECHO) {
                            if (TypingHooksUtils.isEscapeSequence(doc, dotPos)) {
                                doc.remove(dotPos - 1, 1);
                                return;
                            }
                        }
                    }
                }

                char[] match = doc.getChars(dotPos, 1);
                if ((match != null) && (match[0] == getQuote())) {
                    doc.remove(dotPos, 1);
                }
            }
        }

        protected abstract char getQuote();

    }

    private static final class SingleQuoteRemover extends QuoteRemover {

        @Override
        protected char getQuote() {
            return '\'';
        }

    }

    private static final class DoubleQuoteRemover extends QuoteRemover {

        @Override
        protected char getQuote() {
            return '"';
        }

    }

    @MimeRegistrations(value = {
        @MimeRegistration(mimeType = "text/html", service = DeletedTextInterceptor.Factory.class),
        @MimeRegistration(mimeType = BladeLanguage.BLADE_MIME_TYPE, service = DeletedTextInterceptor.Factory.class),
        @MimeRegistration(mimeType = BladeTokenId.BLADE_MIME_TYPE, service = DeletedTextInterceptor.Factory.class),
    })
    public static class Factory implements DeletedTextInterceptor.Factory {

        @Override
        public DeletedTextInterceptor createDeletedTextInterceptor(MimePath mimePath) {
            return new BladeDeletedTextInterceptor(mimePath);
        }

    }
}
