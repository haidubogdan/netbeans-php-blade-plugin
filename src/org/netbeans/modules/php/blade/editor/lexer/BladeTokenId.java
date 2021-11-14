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
import java.util.HashMap;
import java.util.Map;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Haidu Bogdan
 */
public enum BladeTokenId implements TokenId {

    T_BLADE_PHP_VAR(null, "blade_php_var"),
    T_BLADE_ECHO(null, "blade_echo"),
    T_BLADE_COMMENT( null, "blade_comment" ),
    T_BLADE_DIRECTIVE(null, "blade_directive"),
    T_BLADE_OTHER( null, "blade_other" );
    
    private final String fixedText;
    private final String primaryCategory;
    public static final String BLADE_MIME_TYPE = "text/blade-markup";
    public static final String BLADE_MIME_SHORT = "blade-markup";

    BladeTokenId( String fixedText, String primaryCategory ) {
        this.fixedText = fixedText;
        this.primaryCategory = primaryCategory;
    }

    public String fixedText() {
        return fixedText;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }
    
    private static final Language<BladeTokenId> language =
            new LanguageHierarchy<BladeTokenId>() {
                @Override
                protected Collection<BladeTokenId> createTokenIds() {
                    return EnumSet.allOf(BladeTokenId.class);
                }

                @Override
                protected Map<String, Collection<BladeTokenId>> createTokenCategories() {
                    Map<String, Collection<BladeTokenId>> cats = new HashMap<String, Collection<BladeTokenId>>();
                    return cats;
                }

                @Override
                protected Lexer<BladeTokenId> createLexer(LexerRestartInfo<BladeTokenId> info) {
                    return BladeLexer.create(info);
                }

                @Override
                protected String mimeType() {
                    return BladeTokenId.BLADE_MIME_TYPE;
                }

                @Override
                protected LanguageEmbedding<?> embedding(Token<BladeTokenId> token,
                        LanguagePath languagePath, InputAttributes inputAttributes) {
                    BladeTokenId id = token.id();
                    if (id == T_BLADE_PHP_VAR){
                        return LanguageEmbedding.create( PHPTokenId.languageInPHP(), 0, 0, true );
                    }
                    return null;

                }
            }.language();

    public static Language<BladeTokenId> language() {
        return language;
    }
}