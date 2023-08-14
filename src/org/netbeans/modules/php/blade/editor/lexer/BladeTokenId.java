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

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.netbeans.api.html.lexer.HTMLTokenId;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.TokenType.TAG_CLOSE_DIRECTIVE;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.TokenType.TAG_OPEN_DIRECTIVE;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * Blade token Id
 * 
 * 
 * @author Haidu Bogdan
 */
public enum BladeTokenId implements TokenId {
    T_BLADE_OPEN_ECHO( "{{", "blade_echo" , TAG_OPEN_DIRECTIVE),
    T_BLADE_CLOSE_ECHO( "}}", "blade_echo", TAG_CLOSE_DIRECTIVE),
    T_BLADE_OPEN_ECHO_ESCAPED( "{!!", "blade_echo", TAG_OPEN_DIRECTIVE ),
    T_BLADE_CLOSE_ECHO_ESCAPED( "!!}", "blade_echo", TAG_CLOSE_DIRECTIVE),
    T_BLADE_OPEN_COMMENT( "{{--", "blade_comment", TAG_OPEN_DIRECTIVE ),
    T_BLADE_CLOSE_COMMENT( "--}}", "blade_comment", TAG_CLOSE_DIRECTIVE),

    //DIRECTIVES
    T_BLADE_PHP_OPEN("@php", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_ENDPHP("@endphp", "blade_directive", TAG_CLOSE_DIRECTIVE),
    T_BLADE_SECTION("@section", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_ENDSECTION("@endsection", "blade_directive", TAG_CLOSE_DIRECTIVE),
    T_BLADE_STOP("@stop", "blade_directive", TAG_CLOSE_DIRECTIVE),//equivalent to endsection
    T_BLADE_SHOW("@show", "blade_directive", TAG_CLOSE_DIRECTIVE),//use for section
    T_BLADE_FOREACH("@foreach", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_ENDFOREACH("@endforeach", "blade_directive", TAG_CLOSE_DIRECTIVE),
    T_BLADE_FOR("@for", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_ENDFOR("@endfor", "blade_directive", TAG_CLOSE_DIRECTIVE),
        
    T_BLADE_IF("@if", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_ELSE("@else", "blade_directive"),
    T_BLADE_ELSEIF("@elseif", "blade_directive"),
    T_BLADE_HAS_SECTION("@hasSection", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_SECTION_MISSING("@sectionMissing", "blade_directive", TAG_OPEN_DIRECTIVE),
    T_BLADE_ENDIF("@endif", "blade_directive", TAG_CLOSE_DIRECTIVE),

    T_BLADE_YIELD("@yield", "blade_directive"),
    T_BLADE_PARENT("@parent", "blade_directive"),
    T_BLADE_EXTENDS("@extends", "blade_directive"),
    T_BLADE_INCLUDE("@include", "blade_directive"),
    T_BLADE_EACH("@each", "blade_directive"),
    
    //DEFAULT SYNTAX ELEMENTS
    T_BLADE_LPAREN("(", "token"),
    T_BLADE_RPAREN(")", "token"),
    T_EMPTY_EXPRESSION(null, "token"),
    T_OPEN_PHP_SCRIPT("<?php", "html"),
    T_CLOSE_PHP("?>", "html"),
    T_PHP_OPEN_ECHO("<?=", "html"),
    
    T_BLADE_COMMENT( null, "blade_comment" ),
    T_BLADE_DIRECTIVE(null, "blade_directive"),
    //embeded texts token
    T_PHP(null, "php"),
    T_BLADE_PHP_EXPRESSION(null, "blade_php_var"), //TODO rename with expression
    T_PHP_ECHO(null, "php"),
    T_BLADE_PHP(null, "php"),
    T_BLADE_PHP_ECHO(null, "blade_php_echo"),
    T_BLADE_PHP_LOOP_PARAM(null, "php"),
    T_BLADE_PHP_COND(null, "php"),
    T_BLADE_ERROR(null, "error"),
    T_PHP_STRING(null, "php_string"),
    T_HTML( null, "html" ),
    T_XML( null, "html" ),
    NEWLINE("\n", "whitespace"),
    WHITESPACE(null, "whitespace"), 
    UNKNOWN_TOKEN(null, "other")
    ;
    
    private final String fixedText;
    private final String primaryCategory;
    public TokenType tokenType;
    
    /**
     * pairing tags for braces
     */
    static final Map<BladeTokenId, BladeTokenId> BLADE_PAIR_TOKENS = new HashMap<>();
    
    static {
        BLADE_PAIR_TOKENS.put(T_BLADE_OPEN_ECHO, T_BLADE_CLOSE_ECHO);
        BLADE_PAIR_TOKENS.put(T_BLADE_OPEN_ECHO_ESCAPED, T_BLADE_CLOSE_ECHO_ESCAPED);
        BLADE_PAIR_TOKENS.put(T_BLADE_OPEN_COMMENT, T_BLADE_CLOSE_COMMENT);
        BLADE_PAIR_TOKENS.put(T_BLADE_PHP_OPEN, T_BLADE_ENDPHP);
        BLADE_PAIR_TOKENS.put(T_BLADE_SECTION, T_BLADE_ENDSECTION);
        BLADE_PAIR_TOKENS.put(T_BLADE_FOREACH, T_BLADE_ENDFOREACH);
        BLADE_PAIR_TOKENS.put(T_BLADE_FOR, T_BLADE_ENDFOR);
        BLADE_PAIR_TOKENS.put(T_BLADE_IF, T_BLADE_ENDIF);
    }
    
    public static Collection<BladeTokenId> BLADE_PHP_EMBEDDED_TOKEN = Arrays.asList(
        BladeTokenId.T_BLADE_PHP_EXPRESSION,
        BladeTokenId.T_BLADE_PHP_ECHO
    );
    
    /*
    * reversed pairing
    */
    static final Map<BladeTokenId, BladeTokenId> REVERSED_BLADE_PAIR_TOKENS = BLADE_PAIR_TOKENS.entrySet()
       .stream()
       .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    //additional closing tag possiblities
    static {
        REVERSED_BLADE_PAIR_TOKENS.put(T_BLADE_STOP, T_BLADE_SECTION);
        REVERSED_BLADE_PAIR_TOKENS.put(T_BLADE_SHOW, T_BLADE_SECTION);
    }
    
    public static enum TokenType{
        TAG_OPEN_DIRECTIVE,
        TAG_CLOSE_DIRECTIVE
    }

    BladeTokenId( String fixedText, String primaryCategory ) {
        this.fixedText = fixedText;
        this.primaryCategory = primaryCategory;
        this.tokenType = null;
    }

    BladeTokenId( String fixedText, String primaryCategory, TokenType pair ) {
        this.fixedText = fixedText;
        this.primaryCategory = primaryCategory;
        this.tokenType = pair;
    }
    
    public String fixedText() {
        return fixedText;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }
        
    public BladeTokenId getPairStart(BladeTokenId token){
        return REVERSED_BLADE_PAIR_TOKENS.get(token);
    }
    
    public BladeTokenId getPairClose(BladeTokenId token){
        return BLADE_PAIR_TOKENS.get(token);
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
                        case WHITESPACE:    
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
                        case T_BLADE_PHP_EXPRESSION:
                            //no break
                        case T_BLADE_PHP_ECHO:
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