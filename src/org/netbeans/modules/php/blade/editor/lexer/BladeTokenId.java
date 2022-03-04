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
import org.netbeans.api.html.lexer.HTMLTokenId;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
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
    //coloring values
    T_BLADE_PHP_VAR(null, "blade_php_var"), //TODO rename with expression
    T_BLADE_FOREACH_ARG(null, "blade_php_var"),
    T_BLADE_COMMENT( null, "blade_comment" ),
    T_BLADE_DIRECTIVE(null, "blade_directive"),
    T_BLADE_OTHER( null, "blade_other" ),
    T_BLADE_OPEN_ECHO( null, "blade_echo" ),
    T_BLADE_OPEN_ECHO_ESCAPED( null, "blade_echo" ),
    T_BLADE_CLOSE_ECHO( null, "blade_echo" ),
    T_BLADE_CLOSE_ECHO_ESCAPED( null, "blade_echo" ),
    T_BLADE_PHP_OPEN(null, "blade_directive"),
    T_BLADE_YIELD(null, "blade_directive"),
    T_BLADE_PARENT(null, "blade_directive"),
    T_BLADE_EXTENDS(null, "blade_directive"),
    T_BLADE_SECTION(null, "blade_directive"),
    T_BLADE_INCLUDE(null, "blade_directive"),
    T_BLADE_FOREACH(null, "blade_directive"),
    T_BLADE_IF(null, "blade_directive"),
    T_BLADE_ELSE(null, "blade_directive"),
    T_BLADE_ELSEIF(null, "blade_directive"),
    T_BLADE_ENDPHP(null, "blade_directive"),
    T_BLADE_ENDFOREACH(null, "blade_directive"),
    T_BLADE_ENDSECTION(null, "blade_directive"),
    T_BLADE_STOP(null, "blade_directive"),
    T_BLADE_FOR(null, "blade_directive"),
    T_BLADE_COMMA(null, "html"),
    T_DIRECTIVE_ARG(null, "blade_directive_arg"),
    T_BLADE_ENDFOR(null, "blade_directive"),
    T_BLADE_ENDIF(null, "blade_directive"),
    BLADE_PHP_TOKEN(null, "token"),
    BLADE_PHP_STRING(null, "string"),
    T_PHP(null, "php"),
    T_PHP_ECHO(null, "php"),
    T_BLADE_PHP(null, "php"),
    T_BLADE_PHP_ECHO(null, "blade_php_echo"),
    T_BLADE_PHP_LOOP_PARAM(null, "php"),
    T_BLADE_PHP_COND(null, "php"),
    T_HTML( null, "html" ),
    T_XML( null, "html" ),
    T_OPEN_PHP(null, "html"),
    T_CLOSE_PHP(null, "html"),
    T_PHP_OPEN_ECHO(null, "html"),
    T_BLADE_DIRECTIVE_PREFIX( null, "blade_directive" ),
    NEWLINE(null, "whitespace"),
    WHITESPACE(null, "whitespace");
    
    private final String fixedText;
    private final String primaryCategory;

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
    
   private static final Language<BladeTokenId> LANGUAGE =
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
                   // return BladeLexer.create(info);
                    return new BladeLexer(info);
                }

                @Override
                protected String mimeType() {
                    return BladeLanguage.BLADE_MIME_TYPE;
                }

                @Override
                protected LanguageEmbedding<?> embedding(Token<BladeTokenId> token,
                        LanguagePath languagePath, InputAttributes inputAttributes) {
                    Language<?> lang = null;
                    boolean join_sections = false;
                    BladeTokenId id = token.id();

                    switch (id){
                        case T_HTML:
                        case NEWLINE:    
                           //html embedding not working well
                           lang = HTMLTokenId.language();
                           join_sections = true;
                           break;
                        case T_PHP:
                            lang = PHPTokenId.languageInPHP();
                            join_sections = true;
                            break;
                        case T_BLADE_PHP:  
                            lang = PHPTokenId.languageInPHP();
                            join_sections = true;
                            break;
                        case T_PHP_ECHO:
                            //no break    
                        case T_BLADE_PHP_VAR:
                            //no break
                        case T_BLADE_PHP_ECHO:
                            //no break
                        case T_DIRECTIVE_ARG:
                            //no break
                        case T_BLADE_PHP_COND:
                            //no break
                        case T_BLADE_PHP_LOOP_PARAM:    
                            //affects inline tokens ? maybe use top lexer ?
                            lang = PHPTokenId.languageInPHP();
                            join_sections = true;
                            break;
                    }
                    
                    if (lang != null){
                        return LanguageEmbedding.create( lang, 0, 0, join_sections );
                    }
 
                    return null;

                }
            }.language();

    public static Language<BladeTokenId> language() {
        return LANGUAGE;
    }
}