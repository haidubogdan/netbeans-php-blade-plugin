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

import org.antlr.v4.runtime.Token;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.parser.BladePhpExpressionOccurences;
import org.netbeans.modules.php.blade.editor.parser.BladeReferenceIdsCollection;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;

/**
 *
 * @author bogdan
 */
public class PhpExpressionOccurenceListener extends BladeAntlrParserBaseListener {

    private final BladePhpExpressionOccurences phpExprOccurences;

    public PhpExpressionOccurenceListener(BladePhpExpressionOccurences phpExprOccurences) {
        this.phpExprOccurences = phpExprOccurences;
    }

    @Override
    public void exitIdentifiableArgDirective(BladeAntlrParser.IdentifiableArgDirectiveContext ctx) {
        Token leftParen = ctx.LPAREN().getSymbol();
        Token rightParen = ctx.RPAREN().getSymbol();

        if (leftParen.getStartIndex() + 1 >= rightParen.getStopIndex()) {
            return;
        }

        OffsetRange range = new OffsetRange(leftParen.getStartIndex() + 1, rightParen.getStopIndex());
        phpExprOccurences.markPhpExpressionOccurence(range);
    }

    @Override
    public void exitDirectiveArguments(BladeAntlrParser.DirectiveArgumentsContext ctx) {
        if (ctx.LPAREN() == null || ctx.RPAREN() == null){
            return;
        }
        Token leftParen = ctx.LPAREN().getSymbol();
        Token rightParen = ctx.RPAREN().getSymbol();
        OffsetRange range = new OffsetRange(leftParen.getStartIndex() + 1, rightParen.getStopIndex());
        phpExprOccurences.markPhpExpressionOccurence(range);
    }
    
    @Override
    public void exitBladeContentTags(BladeAntlrParser.BladeContentTagsContext ctx) {
        if (ctx.BLADE_CONTENT_OPEN_TAG() == null || ctx.BLADE_CONTENT_CLOSE_TAG() == null){
            return;
        }
        Token openTag = ctx.BLADE_CONTENT_OPEN_TAG().getSymbol();
        Token closeTag = ctx.BLADE_CONTENT_CLOSE_TAG().getSymbol();
        OffsetRange range = new OffsetRange(openTag.getStopIndex(), closeTag.getStartIndex());
        phpExprOccurences.markPhpExpressionOccurence(range);
    }
    
    @Override
    public void exitBladeRawTags(BladeAntlrParser.BladeRawTagsContext ctx) {
        if (ctx.BLADE_RAW_OPEN_TAG() == null || ctx.BLADE_RAW_CLOSE_TAG() == null){
            return;
        }
        Token openTag = ctx.BLADE_RAW_OPEN_TAG().getSymbol();
        Token closeTag = ctx.BLADE_RAW_CLOSE_TAG().getSymbol();
        OffsetRange range = new OffsetRange(openTag.getStopIndex(), closeTag.getStartIndex());
        phpExprOccurences.markPhpExpressionOccurence(range);
    }
}
