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
import org.netbeans.modules.php.blade.editor.parser.BladeComponentTagOccurences;
import org.netbeans.modules.php.blade.editor.parser.BladePhpExpressionOccurences;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;

/**
 *
 * @author bogdan
 */
public class BladeComponentTagOccurenceListener extends BladeAntlrParserBaseListener {

    private final BladeComponentTagOccurences bladeComponentTagOccurences;

    public BladeComponentTagOccurenceListener(BladeComponentTagOccurences bladeComponentTagOccurences) {
        this.bladeComponentTagOccurences = bladeComponentTagOccurences;
    }

    @Override
    public void exitHtmlComponentOpenTag(BladeAntlrParser.HtmlComponentOpenTagContext ctx) {
        Token start = ctx.start;
        
        if (start == null) {
            return;
        }

        OffsetRange range = new OffsetRange(start.getStartIndex(), start.getStopIndex());
        bladeComponentTagOccurences.markPhpExpressionOccurence(range);
    }
}