/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2012 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2012 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.editor.lexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.api.html.lexer.HTMLTokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;

/**
 *
 * @author Haidu Bogdan
 */
public final class BladeLexerUtils {

    private BladeLexerUtils() {
    }
    
    public static TokenSequence<? extends BladeTopTokenId> getBladeTokenSequence(final Snapshot snapshot, final int offset) {
        return getTokenSequence(snapshot.getTokenHierarchy(), offset, BladeTopTokenId.language());
    }

    public static TokenSequence<? extends BladeTopTokenId> getBladeTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, BladeTopTokenId.language());
    }
    
    public static TokenSequence<? extends BladeTokenId> getBladeMarkupTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, BladeTokenId.language());
    }
    
    public static TokenSequence<? extends BladeTokenId> getBladeMarkupTokenSequence(final Snapshot snapshot, final int offset) {
        TokenSequence<? extends BladeTokenId> bladeBlockTokenSequence = getTokenSequence(snapshot.getTokenHierarchy(), offset, BladeTokenId.language());
        return bladeBlockTokenSequence == null ? getTokenSequence(snapshot.getTokenHierarchy(), offset, BladeTokenId.language()) : bladeBlockTokenSequence;
    }
    
    public static TokenSequence<? extends HTMLTokenId> getHtmlTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, HTMLTokenId.language());
    }

    public static <L> TokenSequence<? extends L> getTokenSequence(final TokenHierarchy<?> th, final int offset, final Language<? extends L> language) {
        TokenSequence<? extends L> ts = th.tokenSequence(language);
        if (ts == null) {
            List<TokenSequence<?>> list = th.embeddedTokenSequences(offset, true);
            for (TokenSequence t : list) {
                if (t.language() == language) {
                    ts = t;
                    break;
                }
            }
            if (ts == null) {
                list = th.embeddedTokenSequences(offset, false);
                for (TokenSequence t : list) {
                    if (t.language() == language) {
                        ts = t;
                        break;
                    }
                }
            }
        }
        return ts;
    }

    public static List<OffsetRange> findForwardMatching(TokenSequence<? extends BladeTopTokenId> topTs, BladeTokenText start, BladeTokenText end) {
        return findForwardMatching(topTs, start, end, Collections.<BladeTokenText>emptyList());
    }

    public static List<OffsetRange> findForwardMatching(
            TokenSequence<? extends BladeTopTokenId> topTs,
            BladeTokenText start,
            BladeTokenText end,
            List<BladeTokenText> middle) {
        List<OffsetRange> result = new ArrayList<>();
        topTs.moveNext();
        int originalOffset = topTs.offset();
        int balance = 1;
        while (topTs.moveNext()) {
            Token<? extends BladeTopTokenId> token = topTs.token();
        }
        topTs.move(originalOffset);
        return result;
    }

    private static boolean matchesToken(List<BladeTokenText> middle, Token<?  extends BladeTokenId> markupToken) {
        boolean result = false;
        for (BladeTokenText bladeTokenText : middle) {
            if (bladeTokenText.matches(markupToken)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static List<OffsetRange> findBackwardMatching(
            TokenSequence<? extends BladeTopTokenId> topTs,
            BladeTokenText start,
            BladeTokenText end,
            List<BladeTokenText> middle) {
        List<OffsetRange> result = new ArrayList<>();
        topTs.movePrevious();
        int originalOffset = topTs.offset();
        int balance = 1;
        while (topTs.movePrevious()) {
            Token<? extends BladeTopTokenId> token = topTs.token();
        }
        topTs.move(originalOffset);
        return result;
    }

    public static List<OffsetRange> findBackwardMatching(TokenSequence<? extends BladeTopTokenId> topTs, BladeTokenText start, BladeTokenText end) {
        return findBackwardMatching(topTs, start, end, Collections.<BladeTokenText>emptyList());
    }

    public static boolean textEquals(CharSequence text1, char... text2) {
        int len = text1.length();
        if (len == text2.length) {
            for (int i = len - 1; i >= 0; i--) {
                if (text1.charAt(i) != text2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean textStartWith(CharSequence text1, char text2) {
        int len = text1.length();
        if (len > 0) {
            return text1.charAt(0) == text2;
        }
        return false;
    }

    public static int getTokenBalance(BaseDocument doc, char open, char close, int offset) throws BadLocationException {
        TokenSequence<? extends TokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, offset);
        if (ts == null) {
            return 0;
        }

        int balance = 0;
        ts.move(offset);
        // check next tokens
        while (ts.moveNext()) {
            TokenId id = ts.token().id();
//            if (id == BladeVariableTokenId.T_BLADE_PUNCTUATION || id == BladeTopTokenId.T_BLADE_PUNCTUATION) {
//                if (BladeLexerUtils.textEquals(ts.token().text(), close)) {
//                    balance--;
//                } else if (BladeLexerUtils.textEquals(ts.token().text(), open)) {
//                    break;
//                }
//            }
        }

        // check previous tokens
        ts.move(offset);
        while (ts.movePrevious()) {
            TokenId id = ts.token().id();
//            if (id == BladeVariableTokenId.T_BLADE_PUNCTUATION || id == BladeTopTokenId.T_BLADE_PUNCTUATION) {
//                if (BladeLexerUtils.textEquals(ts.token().text(), close)) {
//                    balance--;
//                } else if (BladeLexerUtils.textEquals(ts.token().text(), open)) {
//                    balance++;
//                }
//                if (balance > 0) {
//                    break;
//                }
//            }
        }
        return balance;
    }

    public interface BladeTokenText {
        BladeTokenText NONE = new BladeTokenText() {

            @Override
            public boolean matches(Token<? extends BladeTokenId> token) {
                return false;
            }
        };

        boolean matches(Token<? extends BladeTokenId> token);
    }
    

    public static final class BladeTokenTextImpl implements BladeTokenText {
        private final BladeTokenId tokenId;
        private final String tokenText;

        public static BladeTokenText create(BladeTokenId tokenId, String tokenText) {
            return new BladeTokenTextImpl(tokenId, tokenText);
        }

        private BladeTokenTextImpl(BladeTokenId tokenId, String tokenText) {
            this.tokenId = tokenId;
            this.tokenText = tokenText;
        }

        @Override
        public boolean matches(Token<? extends BladeTokenId> token) {
            return token != null && token.id() == tokenId && tokenText.equals(token.text().toString());
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 71 * hash + Objects.hashCode(this.tokenId);
            hash = 71 * hash + Objects.hashCode(this.tokenText);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BladeTokenTextImpl other = (BladeTokenTextImpl) obj;
            if (this.tokenId != other.tokenId) {
                return false;
            }
            return Objects.equals(this.tokenText, other.tokenText);
        }

        @Override
        public String toString() {
            return "BladeTokenText{" + "tokenId=" + tokenId + ", tokenText=" + tokenText + '}';
        }

    }

}
