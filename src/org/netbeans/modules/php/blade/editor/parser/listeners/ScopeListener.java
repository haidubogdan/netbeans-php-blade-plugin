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

import java.util.Map;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.editor.parser.BladeDirectiveScope;
import org.netbeans.modules.php.blade.editor.parser.BladePhpSnippetParser;
import org.netbeans.modules.php.blade.editor.parser.BladeScope;
import org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.utils.BaseBladeAntlrUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;

/**
 *
 * generates scope information. Used for foreach and php block directives to
 * extract variables
 */
public class ScopeListener extends BladeAntlrParserBaseListener {

    private final BladeScope bladeScope;
    private BladeDirectiveScope bufferScope;
    private int bladeScopeBalance = 0;
    private final Snapshot snapshot;

    public ScopeListener(BladeScope bladeScope, Snapshot snapshot) {
        this.bladeScope = bladeScope;
        this.snapshot = snapshot;
    }

    @Override
    public void enterForeachStatement(BladeAntlrParser.ForeachStatementContext ctx) {
        if (bufferScope == null) {
            bufferScope = new BladeDirectiveScope(ctx.start.getType());
        } else {
            bufferScope.setChild(new BladeDirectiveScope(ctx.start.getType()));
        }
        bladeScopeBalance++;
    }

    @Override
    public void exitForeachLoopArguments(BladeAntlrParser.ForeachLoopArgumentsContext ctx) {
        if (bufferScope == null) {
            return;
        }
        if (ctx.LPAREN() == null || ctx.RPAREN() == null) {
            return;
        }

        Token leftParen = ctx.LPAREN().getSymbol();
        Token rightParen = ctx.RPAREN().getSymbol();

        if (leftParen.getStartIndex() + 1 >= rightParen.getStopIndex()) {
            return;
        }

        if (ctx.main_array != null) {
            bufferScope.addPhpVariable(ctx.main_array.getText());
        }

        if (ctx.array_item != null) {
            bufferScope.addPhpVariable(ctx.array_item.getText());
        }

        if (ctx.array_value != null) {
            bufferScope.addPhpVariable(ctx.array_value.getText());
        }
    }

    @Override
    public void exitForeachStatement(BladeAntlrParser.ForeachStatementContext ctx) {
        Token start = ctx.start;
        Token stop = ctx.stop;

        OffsetRange range = new OffsetRange(start.getStartIndex(),
                stop.getStopIndex() + 1);

        bladeScopeBalance--;
        if (bufferScope != null && bladeScopeBalance == 0) {
            bladeScope.markScope(range, bufferScope);
            bufferScope = null;
        }
    }

    @Override
    public void exitBladePhpBlock(BladeAntlrParser.BladePhpBlockContext ctx) {
        Token openTag = ctx.start;
        Token closeTag = ctx.stop;

        if (bufferScope == null) {
            bufferScope = new BladeDirectiveScope(ctx.start.getType());
        } else {
            bufferScope.setChild(new BladeDirectiveScope(ctx.start.getType()));
        }

        String prefix = BladePhpSnippetParser.PHP_START;
        int startOffset = openTag.getStopIndex() + 1;
        int endOffset = closeTag.getStartIndex();
        CharSequence snapshotExpr = snapshot.getText().subSequence(startOffset, endOffset);
        int start = startOffset + prefix.length() - BladeDirectivesUtils.DIRECTIVE_PHP.length();
        String snippetText = prefix + snapshotExpr.toString() + BladePhpSnippetParser.PHP_END;
        BladePhpSnippetParser phpSnippetParser = new BladePhpSnippetParser(snippetText, start);
        phpSnippetParser.extractVariables();

        for (Map.Entry<String, Integer> entry : phpSnippetParser.getOffsetPhpVariables().entrySet()) {
            bufferScope.addDeclaredPhpVariable(entry.getKey(), entry.getValue() + start);
        }

        OffsetRange range = new OffsetRange(openTag.getStartIndex(),
                closeTag.getStopIndex() + 1);

        bladeScope.markScope(range, bufferScope);
        bufferScope = null;
    }

    @Override
    public void exitPropsDirective(BladeAntlrParser.PropsDirectiveContext ctx) {
        for (TerminalNode identifierNode : ctx.IDENTIFIABLE_STRING()) {
            Token identifierToken = identifierNode.getSymbol();
            if (identifierToken != null) {
                String identifier = BaseBladeAntlrUtils.sanitizeIdentifier(identifierToken);
                OffsetRange range = BaseBladeAntlrUtils.extractOffset(identifierToken);
                if (bufferScope == null) {
                    bufferScope = new BladeDirectiveScope(ctx.start.getType());
                }
                //force association
                bufferScope.addDeclaredPhpVariable("$" + identifier, range.getStart()); //NOI18N
            }
        }

        if (bladeScope != null) {
            OffsetRange range = new OffsetRange(ctx.start.getStartIndex(),
                    ctx.stop.getStopIndex() + 1);
            bladeScope.markScope(range, bufferScope);
            bufferScope = null;
        }
    }
}
