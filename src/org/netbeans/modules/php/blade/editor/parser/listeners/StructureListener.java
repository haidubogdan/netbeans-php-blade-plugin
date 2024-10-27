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
package org.netbeans.modules.php.blade.editor.parser.listeners;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.EditorStringUtils;
import org.netbeans.modules.php.blade.editor.structure.BladeStructureItem;
import org.netbeans.modules.php.blade.editor.structure.BladeStructureItem.DirectiveBlockStructureItem;
import org.netbeans.modules.php.blade.editor.structure.BladeStructureItem.DirectiveInlineStructureItem;
import org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class StructureListener extends BladeAntlrParserBaseListener {

    public final List<BladeStructureItem> structure;
    public final List<OffsetRange> folds;
    private final FileObject file;

    private final List<BladeStructureItem> lexerStructure = new ArrayList<>();
    private int blockBalance = 0;
    private String identifier;

    public StructureListener(final List<BladeStructureItem> structure, final List<OffsetRange> folds, FileObject file) {
        this.structure = structure;
        this.folds = folds;
        this.file = file;
    }

    @Override
    public void enterBlockDirective(BladeAntlrParser.BlockDirectiveContext ctx) {
        identifier = null;
        blockBalance++;
    }

    @Override
    public void enterBlockIdentifiableArgDirective(BladeAntlrParser.BlockIdentifiableArgDirectiveContext ctx) {
        identifier = null;
        blockBalance++;
    }

    @Override
    public void exitBlockDirective(BladeAntlrParser.BlockDirectiveContext ctx) {
        blockBalance--;

        Token directiveToken = ctx.getStart();
        Token endToken = ctx.getStop();
        addBlockDirective(directiveToken, endToken);
    }

    @Override
    public void exitBlockIdentifiableArgDirective(BladeAntlrParser.BlockIdentifiableArgDirectiveContext ctx) {
        blockBalance--;

        Token directiveToken = ctx.getStart();
        Token endToken = ctx.getStop();
        markIdentifier(ctx.IDENTIFIABLE_STRING());
        addBlockDirective(directiveToken, endToken);
    }

    @Override
    public void exitIdentifiableArgDirective(BladeAntlrParser.IdentifiableArgDirectiveContext ctx) {
        Token directiveToken = ctx.getStart();

        if (directiveToken == null) {
            return;
        }

        markIdentifier(ctx.IDENTIFIABLE_STRING());
        addInlineDirective(directiveToken);
    }

    @Override
    public void exitInlineDirective(BladeAntlrParser.InlineDirectiveContext ctx) {
        Token directiveToken = ctx.getStart();

        if (directiveToken == null) {
            return;
        }

        identifier = null;
        addInlineDirective(directiveToken);
    }

    private void addInlineDirective(Token directiveToken) {
        DirectiveInlineStructureItem inlineElement;
        String directiveName = directiveToken.getText();

        inlineElement = new DirectiveInlineStructureItem(directiveName, identifier,
                file, directiveToken.getStartIndex(), directiveToken.getStopIndex() + 1);

        if (blockBalance > 0) {
            lexerStructure.add(inlineElement);
        } else {
            structure.add(inlineElement);
        }
    }

    private void markIdentifier(TerminalNode identifierNode) {
        identifier = null;
        if (identifierNode != null) {
            Token identifiableStringToken = identifierNode.getSymbol();

            if (identifiableStringToken != null && identifiableStringToken.getText().length() >= 3) {
                String bladeParamText = identifiableStringToken.getText();
                identifier = EditorStringUtils.stripSurroundingQuotes(bladeParamText);
            }
        }
    }

    private void addBlockDirective(Token directiveToken, Token endToken) {

        if (directiveToken == null) {
            return;
        }

        String directiveName = directiveToken.getText();
        DirectiveBlockStructureItem blockItem = new DirectiveBlockStructureItem(directiveName, identifier,
                file, directiveToken.getStartIndex(), endToken.getStopIndex() + 1);

        blockItem.nestedItems.addAll(lexerStructure);
        lexerStructure.clear();
        if (blockBalance > 0 && !directiveName.startsWith(BladeDirectivesUtils.DIRECTIVE_ELSE)) {
            lexerStructure.add(blockItem);
        } else {
            structure.add(blockItem);
        }
        //folds
        int start = directiveToken.getStartIndex() + 1 + directiveName.length();
        int end = endToken.getStartIndex();//the start of the close directive

        if (start > end) {
            return;
        }
        OffsetRange range = new OffsetRange(start, end);
        if (!folds.contains(range)) {
            folds.add(range);
        }
    }
}
