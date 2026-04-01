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
package org.netbeans.modules.php.blade.editor;

import org.netbeans.modules.php.blade.editor.hints.BladeHintsProvider;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.api.HintsProvider;
import org.netbeans.modules.csl.api.SemanticAnalyzer;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.CommentHandler;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionHandler;
import org.netbeans.modules.php.blade.editor.format.BladeFormatter;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexer;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.BladeLanguageHierarchy;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureScanner;
import org.netbeans.modules.php.blade.editor.parser.BladeParser;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.declaration.BladeDeclarationFinder;
import org.netbeans.modules.php.blade.syntax.StringUtils;

/**
 *
 * @author Haidu Bogdan
 */
@LanguageRegistration(mimeType = BladeLanguage.MIME_TYPE, useCustomEditorKit = true)
public class BladeLanguage extends DefaultLanguageConfig {

    public BladeLanguage() {
        super();
    }

    public static final String MIME_TYPE = "text/x-blade"; //NOI18N

    public static final String ACTIONS = "Loaders/" + BladeLanguage.MIME_TYPE + "/Actions"; //NOI18N

    public static final String FILE_EXTENSION_SUFFIX = ".blade"; //NOI18N
    public static final String FILE_EXTENSION = "blade.php"; //NOI18N
    public static final String FILE_EXTENSION_WITH_DOT = StringUtils.DOT + FILE_EXTENSION;

    @Override
    public Language<BladeTokenId> getLexerLanguage() {
        return language;
    }

    @Override
    public String getDisplayName() {
        return "Blade"; //NOI18N
    }

    @Override
    public String getPreferredExtension() {
        return "blade.php"; // NOI18N
    }

    @Override
    public Parser getParser() {
        return new BladeParser();
    }

    //we need this to avoid lang assertion error
    @Deprecated
    @Override
    public boolean hasStructureScanner() {
        return true;
    }

    @Override
    public StructureScanner getStructureScanner() {
        return new BladeStructureScanner();
    }

    @Override
    public CodeCompletionHandler getCompletionHandler() {
        return new BladeCompletionHandler();
    }

    @Override
    public CommentHandler getCommentHandler() {
        return new BladeCommentHandler();
    }

    @Override
    public boolean hasHintsProvider() {
        return true;
    }

    @Override
    public HintsProvider getHintsProvider() {
        return new BladeHintsProvider();
    }

    @Override
    public boolean hasFormatter() {
        return true;
    }

    @Override
    public Formatter getFormatter() {
        return new BladeFormatter();
    }

    @Override
    public DeclarationFinder getDeclarationFinder() {
        return new BladeDeclarationFinder();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public SemanticAnalyzer<BladeParserResult> getSemanticAnalyzer() {
        return new BladeSemanticAnalyzer();
    }

    /**
     * dynamic flag to allow full highlight of string text containing '.'
     * separator used for blade paths ex: "layout.main" It will always reset to
     * false
     *
     * the reason for it's dynamic state is the fact that javascript uses '.'
     * for properties chain linked to
     *
     * @see
     * org.netbeans.modules.php.blade.editor.highlighting.BladeHighlightsContainer
     *
     */
    public static volatile Boolean hasQuote = false;

    @Override
    public boolean isIdentifierChar(char c) {
        //dynamic highlighting switch of the language to enable blade view paths selection
        if (c == '"' || c == '\'') {
            hasQuote = true;
        }
        return Character.isJavaIdentifierPart(c)
                || (c == '@')
                || (hasQuote && c == '.') || (c == '_');
    }

    private static final Language<BladeTokenId> language
            = new BladeLanguageHierarchy() {

                @Override
                protected String mimeType() {
                    return BladeLanguage.MIME_TYPE;
                }

                @Override
                protected Lexer<BladeTokenId> createLexer(LexerRestartInfo<BladeTokenId> info) {
                    return new BladeLexer(info);
                }

            }.language();

    public static Language<BladeTokenId> getStaticLexerLanguage() {
        return language;
    }
}
