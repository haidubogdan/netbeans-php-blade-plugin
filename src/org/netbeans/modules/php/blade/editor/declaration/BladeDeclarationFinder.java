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
package org.netbeans.modules.php.blade.editor.declaration;

import java.util.Collection;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.php.blade.csl.elements.ElementType;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.csl.elements.PathElement;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexFunctionResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.indexing.QueryUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.BLADE_PAREN;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.PHP_BLADE_ECHO_EXPR;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.PHP_BLADE_EXPRESSION;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.BladeStringReference;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import org.netbeans.modules.php.blade.editor.path.BladePathUtils;
import static org.netbeans.modules.php.blade.syntax.antlr4.php.BladePhpAntlrParser.IDENTIFIER;
import org.netbeans.modules.php.blade.syntax.antlr4.php.BladePhpAntlrUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.php.BladePhpSnippetParser.PhpReference;
import org.openide.filesystems.FileObject;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.RequestProcessor;
import static org.netbeans.modules.php.blade.syntax.antlr4.php.BladePhpSnippetParser.PhpReferenceType.PHP_FUNCTION;

/**
 * focuses mainly on string inputs
 *
 * ?? TODO implement a Extension module
 *
 * @author bhaidu
 */
public class BladeDeclarationFinder implements DeclarationFinder {

    private static final RequestProcessor RP = new RequestProcessor(BladeDeclarationFinder.class);
    private static final int RESOLVING_TIMEOUT = 300;

    @Override
    public OffsetRange getReferenceSpan(Document document, int caretOffset) {
        OffsetRange offsetRange = OffsetRange.NONE;

        TokenSequence<BladeTokenId> ts = BladeLexerUtils.getTokenSequence(document, caretOffset);

        if (ts == null) {
            return offsetRange;
        }

        ts.move(caretOffset);

        if (!ts.moveNext() && !ts.movePrevious()) {
            return offsetRange;
        }

        Token<BladeTokenId> token = ts.token();
        String caretTokenText = token.text().toString();
        BladeTokenId id = token.id();
        int phpExprStart = ts.offset();

        switch (id) {
            case BLADE_CUSTOM_DIRECTIVE: {
                return new OffsetRange(phpExprStart, phpExprStart + caretTokenText.length());
            }
            case PHP_BLADE_EXPRESSION: {
                return this.getReferenceSpanInsidePhpExpr(document, ts, token, caretOffset);
            }
            case PHP_BLADE_ECHO_EXPR: {
                return getPhpReferenceSpan(caretTokenText, caretOffset, phpExprStart);
            }
        }

        return offsetRange;
    }

    public OffsetRange getReferenceSpanInsidePhpExpr(Document document,
            TokenSequence<BladeTokenId> ts,
            Token<BladeTokenId> token, int caretOffset) {

        OffsetRange offsetRange = OffsetRange.NONE;
        int phpExprStart = ts.offset();
        ts.movePrevious();

        boolean prevTokenIsParenthesis = ts.token().id().equals(BLADE_PAREN);

        if (prevTokenIsParenthesis && !ts.movePrevious()) {
            //move before the parenthesis
            return offsetRange;
        }

        Token<BladeTokenId> prevToken = ts.token();
        int start = ts.offset();
        int snippetLength = prevToken.length() + token.length() + 2;
        int end = ts.offset() + snippetLength;

        boolean isBetween = start <= caretOffset && caretOffset <= end;

        if (!isBetween) {
            return offsetRange;
        }

        if (snippetLength >= document.getLength()) {
            return offsetRange;
        }

        try {
            String snippet = document.getText(start, snippetLength);
            int parenPos = snippet.indexOf("("); // NOI18N
            String directive = snippet.startsWith("@") && parenPos != -1 ? snippet.substring(0, parenPos) : null; // NOI18N
            int referencedOffset = caretOffset - start;

            if (directive != null) {//we can filter for identifiable directives here
                org.antlr.v4.runtime.Token targetetToken = BladeAntlrUtils.getToken(snippet, referencedOffset);
                if (targetetToken.getType() == IDENTIFIABLE_STRING) {
                    offsetRange = new OffsetRange(targetetToken.getStartIndex() + start, start + targetetToken.getStopIndex() + 1);
                    return offsetRange;
                }
            }
            //php context
            return getPhpReferenceSpan(token.text().toString(), caretOffset, phpExprStart);
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
        return offsetRange;
    }

    @Override
    public DeclarationLocation findDeclaration(ParserResult info, int caretOffset) {
        BladeParserResult parserResult = (BladeParserResult) info;

        FileObject currentFile = parserResult.getFileObject();
        DeclarationLocation location = DeclarationLocation.NONE;

        //we can have string or php reference
        BladeStringReference bladeReference = parserResult.getBladeReferenceIdsCollection().findOccuredRefrence(caretOffset);
        OffsetRange phpExprRange;

        if (bladeReference != null) {
            String referenceIdentifier = bladeReference.identifier;

            switch (bladeReference.antlrTokentype) {
                case D_SECTION:
                case D_HAS_SECTION:
                case D_SECTION_MISSING: {
                    String yieldId = referenceIdentifier;
                    List<BladeIndex.IndexedReference> yields = QueryUtils.findYieldReferences(yieldId, currentFile);
                    if (yields == null) {
                        return DeclarationLocation.NONE;
                    }

                    for (BladeIndex.IndexedReference yieldReference : yields) {
                        location = buildDeclarationLocationFromIndex(location, yieldReference, ElementType.YIELD_ID);
                    }

                    return location;
                }
                case D_EXTENDS:
                case D_INCLUDE:
                case D_INCLUDE_IF:
                case D_INCLUDE_WHEN:
                case D_EACH: {
                    String viewPath = referenceIdentifier;
                    List<FileObject> includedFiles = BladePathUtils.findFileObjectsForBladeViewPath(currentFile, viewPath);

                    if (includedFiles.isEmpty()) {
                        return DeclarationLocation.NONE;
                    }

                    for (FileObject includedFile : includedFiles) {
                        PathElement elHandle = new PathElement(referenceIdentifier, includedFile);
                        DeclarationLocation dln = new DeclarationFinder.DeclarationLocation(includedFile, 0, elHandle);
                        if (location.equals(DeclarationLocation.NONE)) {
                            location = dln;
                        }
                        location.addAlternative(new AlternativeLocationImpl(dln));
                    }
                    return location;
                }
                case D_PUSH:
                case D_PUSH_IF:
                case D_PREPEND: {
                    String stackId = referenceIdentifier;
                    List<BladeIndex.IndexedReference> stacks = QueryUtils.findStacksReferences(stackId, currentFile);

                    if (stacks == null) {
                        return DeclarationLocation.NONE;
                    }

                    for (BladeIndex.IndexedReference stackReference : stacks) {
                        String stackReferenceId = stackReference.getReference().identifier;
                        NamedElement yieldIdHandle = new NamedElement(stackReferenceId, stackReference.getOriginFile(), ElementType.STACK_ID);
                        int startOccurence = stackReference.getReference().defOffset.getStart();
                        DeclarationLocation dlstack = new DeclarationFinder.DeclarationLocation(stackReference.getOriginFile(), startOccurence, yieldIdHandle);
                        if (location.equals(DeclarationLocation.NONE)) {
                            location = dlstack;
                        }
                        location.addAlternative(new AlternativeLocationImpl(dlstack));
                    }

                    return location;
                }
            }
        } else if ((phpExprRange = parserResult.getBladePhpExpressionOccurences().findPhpExpressionLocation(caretOffset)) != null) {
            int referenceOffset = caretOffset - phpExprRange.getStart();
            PhpElementsDeclarationService phpDeclService = new PhpElementsDeclarationService();
            PhpReference phpRef = phpDeclService.findReferenceAtCaret(info, phpExprRange, referenceOffset);

            if (phpRef == null) {
                return location;
            }

            switch (phpRef.type) {
                case PHP_FUNCTION: {
                    Collection<PhpIndexFunctionResult> functionResults = PhpIndexUtils.queryExactFunctions(currentFile, phpRef.identifier);
                    return phpDeclService.buildFunctionDeclLocation(phpRef, functionResults);
                }
                case PHP_CLASS: {
                    Collection<PhpIndexResult> results;
                    if (phpRef.namespace != null) {
                        results = PhpIndexUtils.queryExactNamespaceClasses(phpRef.identifier, phpRef.namespace, currentFile);
                    } else {
                        results = PhpIndexUtils.queryExactClass(phpRef.identifier, currentFile);
                    }

                    if (results != null && !results.isEmpty()) {
                        return phpDeclService.buildDeclLocation(phpRef.identifier, ElementType.PHP_CLASS, results);
                    }

                    return location;
                }
            }
        }

        return DeclarationLocation.NONE;
    }

    public static class AlternativeLocationImpl implements AlternativeLocation {

        private final DeclarationLocation location;

        public AlternativeLocationImpl(DeclarationLocation location) {
            this.location = location;
        }

        @Override
        public ElementHandle getElement() {
            return getLocation().getElement();
        }

        @Override
        public String getDisplayHtml(HtmlFormatter formatter) {
            ElementHandle el = getLocation().getElement();
            if (el != null) {
                formatter.appendText(el.getName());
                if (el.getFileObject() != null) {
                    formatter.appendText(" in "); // NOI18N
                    formatter.appendText(FileUtil.getFileDisplayName(el.getFileObject()));
                }
                return formatter.getText();
            }
            return getLocation().toString();
        }

        @Override
        public DeclarationFinder.DeclarationLocation getLocation() {
            return location;
        }

        @Override
        public int compareTo(DeclarationFinder.AlternativeLocation o) {
            return 0;
        }

    }

    //php context
    public OffsetRange getPhpReferenceSpan(String phpExpr, int caretOffset, int phpExprStart) {
        OffsetRange offsetRange = OffsetRange.NONE;

        int referencedOffset = caretOffset - phpExprStart;
        org.antlr.v4.runtime.Token targetetToken = BladePhpAntlrUtils.getToken(phpExpr, referencedOffset);
        if (targetetToken.getType() == IDENTIFIER) {
            offsetRange = new OffsetRange(targetetToken.getStartIndex() + phpExprStart, phpExprStart + targetetToken.getStopIndex() + 1);
            return offsetRange;
        }

        return offsetRange;
    }

    private DeclarationLocation buildDeclarationLocationFromIndex(DeclarationLocation location,
            BladeIndex.IndexedReference indexedReference, ElementType type) {
        Reference reference = indexedReference.getReference();
        String referenceId = reference.identifier;
        FileObject originFile = indexedReference.getOriginFile();
        NamedElement referenceHandle = new NamedElement(referenceId, originFile, type);
        int startOccurence = reference.defOffset.getStart();
        DeclarationLocation declItem = new DeclarationFinder.DeclarationLocation(originFile, startOccurence, referenceHandle);

        if (location.equals(DeclarationLocation.NONE)) {
            location = declItem;
        }

        location.addAlternative(new AlternativeLocationImpl(declItem));
        return location;
    }
}
