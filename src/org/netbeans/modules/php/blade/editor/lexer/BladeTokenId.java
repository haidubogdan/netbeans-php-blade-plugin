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

import java.util.Collection;
import java.util.EnumSet;
import java.util.WeakHashMap;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.LanguageProvider;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.openide.util.Lookup;

/**
 *
 * @author bogdan
 */
public enum BladeTokenId implements TokenId {
    BLADE_COMMENT_START("blade_comment"),
    BLADE_COMMENT("blade_comment"),
    BLADE_COMMENT_END("blade_comment"),
    BLADE_DIRECTIVE("blade_directive"),
    BLADE_ECHO_DELIMITOR("blade_echo_delimiters"),
    HTML("html"),
    WS_D("html"),
    BLADE_DIRECTIVE_UNKNOWN("at_string"),
    PHP_BLADE_EXPRESSION("blade_php"),
    PHP_BLADE_ECHO_EXPR("blade_php"),
    PHP_BLADE_INLINE_CODE("blade_php"),
    PHP_INLINE("php"),
    OTHER("error");
    private final String category;

    BladeTokenId(String category) {
        this.category = category;
    }

    @Override
    public String primaryCategory() {
        return category;
    }

    public static abstract class BladeLanguageHierarchy extends LanguageHierarchy<BladeTokenId> {

        private final WeakHashMap<BladeTokenId, LanguageEmbedding<?>> tokenLangCache
                = new WeakHashMap<>();

        @Override
        protected Collection<BladeTokenId> createTokenIds() {
            return EnumSet.allOf(BladeTokenId.class);
        }

        @Override
        protected LanguageEmbedding<? extends TokenId> embedding(Token<BladeTokenId> token,
                LanguagePath languagePath, InputAttributes inputAttributes) {
            boolean joinHtml = true;
            switch (token.id()) {
                case PHP_INLINE:
                    Language<? extends TokenId> phpLanguageCode = PHPTokenId.language();
                    return phpLanguageCode != null ? LanguageEmbedding.create(phpLanguageCode, 0, 0, false) : null;
                case PHP_BLADE_EXPRESSION:
                case PHP_BLADE_ECHO_EXPR:
                case PHP_BLADE_INLINE_CODE:
                    Language<? extends TokenId> phpLanguage = PHPTokenId.languageInPHP();
                    return phpLanguage != null ? LanguageEmbedding.create(phpLanguage, 0, 0, false) : null;
//                    return null;
                case HTML:
                    LanguageEmbedding<?> lang;

                    if (tokenLangCache.containsKey(token.id())) {
                        lang = tokenLangCache.get(token.id());
                    } else {
                        Language<? extends TokenId> htmlLanguage = null;

                        @SuppressWarnings("unchecked")
                        Collection<LanguageProvider> providers = (Collection<LanguageProvider>) Lookup.getDefault().lookupAll(LanguageProvider.class);
                        for (LanguageProvider provider : providers) {
                            htmlLanguage = (Language<? extends TokenId>) provider.findLanguage("text/html"); //NOI18N
                            if (htmlLanguage != null) {
                                break;
                            }
                        }

                        lang = htmlLanguage != null ? LanguageEmbedding.create(htmlLanguage, 0, 0, joinHtml) : null;
                        tokenLangCache.put(token.id(), lang);
                    }

                    return lang;
                default:
                    return null;
            }
        }
    }

}
