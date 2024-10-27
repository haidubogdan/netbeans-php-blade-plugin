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

import java.util.Arrays;
import java.util.List;
import javax.swing.text.Document;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;

/**
 *
 * @author bogdan
 */
public final class BladeLexerUtils {

    private BladeLexerUtils() {

    }

    public static TokenSequence<? extends PHPTokenId> getPhpTokenSequence(TokenHierarchy<Document> th, final int offset) {
        return getTokenSequence(th, offset, PHPTokenId.language());
    }

    public static TokenSequence<? extends PHPTokenId> getPhpTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, PHPTokenId.language());
    }

    public static TokenSequence<BladeTokenId> getTokenSequence(final Document document, final int offset) {
        final BaseDocument baseDocument = document instanceof BaseDocument ? (BaseDocument) document : null;
        try {
            if (baseDocument != null) {
                baseDocument.readLock();
            }
            return getBladeTokenSequence(TokenHierarchy.get(document), offset);
        } finally {
            if (baseDocument != null) {
                baseDocument.readUnlock();
            }
        }
    }

    public static TokenSequence<BladeTokenId> getBladeTokenSequence(TokenHierarchy<Document> th, int offset) {
        BladeLanguage lang = new BladeLanguage();
        TokenSequence<BladeTokenId> ts = th.tokenSequence(lang.getLexerLanguage());

        return ts;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> TokenSequence<? extends T> getTokenSequence(final TokenHierarchy<?> th,
            final int offset, final Language language) {
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

    public static List<Integer> tokensWithIdentifiableParam() {
        return Arrays.asList(new Integer[]{D_EXTENDS, D_INCLUDE, D_SECTION, D_YIELD});
    }

    public static boolean isUndefinedDirective(Token token) {
        return false;
    }
}
