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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.swing.text.Document;
import org.netbeans.api.html.lexer.HTMLTokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.lexer.TokenUtilities;
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

    public static TokenSequence<? extends BladeTokenId> getBladeMarkupTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, BladeTokenId.language());
    }

    public static TokenSequence<BladeTokenId> getBladeTokenSequence(final Document document) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return th.tokenSequence(BladeTokenId.language());
    }

    public static TokenSequence<? extends BladeTokenId> getBladeMarkupTokenSequence(final Snapshot snapshot, final int offset) {
        TokenSequence<? extends BladeTokenId> bladeBlockTokenSequence = getTokenSequence(snapshot.getTokenHierarchy(), offset, BladeTokenId.language());
        return bladeBlockTokenSequence == null ? getTokenSequence(snapshot.getTokenHierarchy(), offset, BladeTokenId.language()) : bladeBlockTokenSequence;
    }

    public static TokenSequence<? extends HTMLTokenId> getHtmlTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, HTMLTokenId.language());
    }

    public static TokenSequence<? extends PHPTokenId> getPhpTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, PHPTokenId.language());
    }

    public static TokenSequence<? extends PHPTokenId> getPhpTokenSequence(TokenHierarchy<Document> th, final int offset) {
        return getTokenSequence(th, offset, PHPTokenId.language());
    }

    public static OffsetRange findFwd(TokenSequence<? extends BladeTokenId> ts, BladeTokenId tokenDownId, String down) {
        while (ts.moveNext()) {
            Token<? extends BladeTokenId> token = ts.token();
            BladeTokenId id = token.id();
            String ttext = token.text().toString().trim();
            if (id == tokenDownId && ttext.equals(down)) {
                return new OffsetRange(ts.offset(), ts.offset() + down.length());
            }
        }

        return OffsetRange.NONE;
    }

    public static OffsetRange findFwd(TokenSequence<? extends BladeTokenId> ts, String down) {
        while (ts.moveNext()) {
            Token<? extends BladeTokenId> token = ts.token();
            String ttext = token.text().toString().trim();
            if (ttext.equals(down)) {
                return new OffsetRange(ts.offset(), ts.offset() + down.length());
            }
        }

        return OffsetRange.NONE;
    }

    public static OffsetRange findFwd(TokenSequence<? extends BladeTokenId> ts, String down, String up) {
        int blockBalance = 1;
        while (ts.moveNext()) {
            Token<? extends BladeTokenId> token = ts.token();
            String ttext = token.text().toString().trim();

            if (ttext.equals(down)) {
                blockBalance--;
                if (blockBalance == 0) {
                    return new OffsetRange(ts.offset(), ts.offset() + down.length());
                }
            } else if (ttext.equals(up)) {
                blockBalance++;
            }
        }
        return OffsetRange.NONE;
    }
    
    public static OffsetRange findFwd(TokenSequence<? extends BladeTokenId> ts, String down, String up, Collection<String> optionalMatches) {
        int blockBalance = 1;
        while (ts.moveNext()) {
            Token<? extends BladeTokenId> token = ts.token();
            String ttext = token.text().toString().trim();

            if (ttext.equals(down)) {
                blockBalance--;
                if (blockBalance == 0) {
                    return new OffsetRange(ts.offset(), ts.offset() + down.length());
                }
            } else if (ttext.equals(up) || (!optionalMatches.isEmpty() && optionalMatches.contains(ttext))) {
                blockBalance++;
            }
        }
        return OffsetRange.NONE;
    }
    
    public static OffsetRange findBack(TokenSequence<? extends BladeTokenId> ts, String down, String up, Collection<String> optionalMatches) {
        int blockBalance = 1;
        while (ts.movePrevious()) {
            Token<? extends BladeTokenId> token = ts.token();
            String ttext = token.text().toString().trim();

            if (ttext.equals(down) || (!optionalMatches.isEmpty() && optionalMatches.contains(ttext))) {
                blockBalance--;
                if (blockBalance == 0) {
                    return new OffsetRange(ts.offset(), ts.offset() + ttext.length());
                }
            } else if (ttext.equals(up)) {
                blockBalance++;
            }
        }
        return OffsetRange.NONE;
    }
    
    public static OffsetRange findBack(TokenSequence<? extends BladeTokenId> ts, BladeTokenId tokenDownId, String down) {
        while (ts.movePrevious()) {
            Token<? extends BladeTokenId> token = ts.token();
            BladeTokenId id = token.id();
            if (id == tokenDownId) {
                return new OffsetRange(ts.offset(), ts.offset() + down.length());
            }
        }

        return OffsetRange.NONE;
    }

    public static OffsetRange findEndFwd(TokenSequence<? extends BladeTokenId> ts, BladeTokenId tokenDownId, String down) {
        while (ts.moveNext()) {
            Token<? extends BladeTokenId> token = ts.token();
            BladeTokenId id = token.id();
            String ttext = token.text().toString().trim();
            if (id == tokenDownId && ttext.endsWith(down)) {
                return new OffsetRange(ts.offset(), ts.offset() + down.length());
            }
        }

        return OffsetRange.NONE;
    }

    public static List<? extends Token<BladeTokenId>> getPreceedingLineTokens(Token<BladeTokenId> token, int tokenOffset, TokenSequence<BladeTokenId> tokenSequence) {
        int orgOffset = tokenSequence.offset();
        LinkedList<Token<BladeTokenId>> tokens = new LinkedList<>();
        if (token.id() != BladeTokenId.WHITESPACE
                || TokenUtilities.indexOf(token.text().subSequence(0, Math.min(token.text().length(), tokenOffset)), '\n') == -1) { // NOI18N
            while (true) {
                if (!tokenSequence.movePrevious()) {
                    break;
                }
                Token<BladeTokenId> cToken = tokenSequence.token();
                if (cToken.id() == BladeTokenId.WHITESPACE
                        && TokenUtilities.indexOf(cToken.text(), '\n') != -1) { // NOI18N
                    break;
                }
                tokens.addLast(cToken);
            }
        }

        tokenSequence.move(orgOffset);
        tokenSequence.moveNext();

        return tokens;
    }

    public static OffsetRange findFwd(BaseDocument doc, TokenSequence<? extends BladeTokenId> ts, BladeTokenId tokenUpId, String up, BladeTokenId tokenDownId, String down) {
        int balance = 0;

        while (ts.moveNext()) {
            Token<? extends BladeTokenId> token = ts.token();

            if ((token.id() == tokenUpId && token.text().equals(up))) {
                balance++;
            } else if (token.id() == tokenDownId && token.text().equals(down)) {
                if (balance == 0) {
                    return new OffsetRange(ts.offset(), ts.offset() + token.length());
                }

                balance--;
            }
        }

        return OffsetRange.NONE;
    }

    public static <T> TokenSequence<? extends T> getTokenSequence(final TokenHierarchy<?> th, final int offset, final Language language) {
        TokenSequence<? extends T> ts = th.tokenSequence(language);
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

    public static boolean textIsStringWithQuotes(String text) {
        return ((text.startsWith("\"") && text.endsWith("\""))
                || text.startsWith("'") && text.endsWith("'"));
    }
}
