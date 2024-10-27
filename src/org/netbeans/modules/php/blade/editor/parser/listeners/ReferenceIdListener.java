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
import org.netbeans.modules.php.blade.editor.EditorStringUtils;
import static org.netbeans.modules.php.blade.editor.parser.BladeParserResult.ReferenceType;
import org.netbeans.modules.php.blade.editor.parser.BladeReferenceIdsCollection;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;

/**
 *
 * @author bogdan
 */
public class ReferenceIdListener extends BladeAntlrParserBaseListener {

    private final BladeReferenceIdsCollection referenceIdsCollection;

    public ReferenceIdListener(BladeReferenceIdsCollection referenceIdsCollection) {
        this.referenceIdsCollection = referenceIdsCollection;
    }

    @Override
    public void exitIdentifiableArgDirective(BladeAntlrParser.IdentifiableArgDirectiveContext ctx) {
        int tokenType = ctx.getStart().getType();
        ReferenceType type = ReferenceType.getReferenceType(tokenType);

        if (type == null || ctx.IDENTIFIABLE_STRING() == null) {
            //not treatable
            return;
        }

        if (ctx.IDENTIFIABLE_STRING().getSymbol() == null) {
            return;
        }

        Token token = ctx.IDENTIFIABLE_STRING().getSymbol();
        String identifier = referenceIdsCollection.extractIdentifier(token);
        OffsetRange range = referenceIdsCollection.extractOffset(token);

        referenceIdsCollection.addReferenceId(type, identifier, range);

        switch (type) {
            case EXTENDS:
            case INCLUDE: {
                referenceIdsCollection.markIncludeBladeOccurrence(identifier, range);
                break;
            }
            case YIELD: {
                referenceIdsCollection.addYieldOccurence(identifier, range);
                break;
            }
            case STACK: {
                referenceIdsCollection.addStackOccurence(identifier, range);
                break;
            }
        }
    }
}
