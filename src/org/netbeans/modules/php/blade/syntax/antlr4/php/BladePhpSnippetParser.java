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
package org.netbeans.modules.php.blade.syntax.antlr4.php;

import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils.FieldAccessType;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;

/**
 *
 * @author bogdan
 */
public class BladePhpSnippetParser {

    private final String snippet;
    private final Map<OffsetRange, PhpReference> identifierReference = new TreeMap<>();
    private final Map<OffsetRange, FieldAcces> fieldAccessReference = new TreeMap<>();

    public enum PhpReferenceType {
        PHP_NAMESPACE,
        PHP_CLASS,
        PHP_FUNCTION,
        PHP_METHOD,
        PHP_CONSTANT
    }

    public BladePhpSnippetParser(String snippet) {
        this.snippet = snippet;
    }

    public void parse() {
        CharStream cs = CharStreams.fromString(snippet);
        BladePhpAntlrLexer lexer = new BladePhpAntlrLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladePhpAntlrParser parser = new BladePhpAntlrParser(tokens);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        //parser.setBuildParseTree(false);
        parser.addParseListener(createIdentifiablePhpElementReferences());
        parser.expression();
    }

    private ParseTreeListener createIdentifiablePhpElementReferences() {
        return new BladePhpAntlrParserBaseListener() {
            @Override
            public void exitFunctionExpr(BladePhpAntlrParser.FunctionExprContext ctx) {
                Token token = ctx.IDENTIFIER().getSymbol();
                String functionName = ctx.IDENTIFIER().getText();
                OffsetRange range = new OffsetRange(token.getStartIndex(), token.getStopIndex() + 1);
                PhpReference reference = new PhpReference(PhpReferenceType.PHP_FUNCTION, functionName);
                identifierReference.put(range, reference);
            }

            @Override
            public void exitStaticFieldAccess(BladePhpAntlrParser.StaticFieldAccessContext ctx) {
                String namespace = null;

                if (ctx.namespace() != null) {
                    namespace = ctx.namespace().getText();
                    namespace = namespace.substring(0, namespace.length() - 1);
                    OffsetRange namespaceRange = new OffsetRange(ctx.namespace().getStart().getStartIndex(),
                            ctx.namespace().getStop().getStopIndex());
                    PhpReference reference = new PhpReference(PhpReferenceType.PHP_NAMESPACE, namespace, null);
                    identifierReference.put(namespaceRange, reference);
                }
                Token classToken = ctx.className;
                OffsetRange range = new OffsetRange(classToken.getStartIndex(), classToken.getStopIndex() + 1);
                PhpReference reference = new PhpReference(PhpReferenceType.PHP_CLASS, classToken.getText(), namespace);
                identifierReference.put(range, reference);

                if (ctx.const_ != null) {
                    PhpReference methodReference = new PhpReference(PhpReferenceType.PHP_CONSTANT, ctx.const_.getText(), namespace);
                    OffsetRange accessRange = new OffsetRange(ctx.const_.getStartIndex(), ctx.const_.getStopIndex() + 1);
                    identifierReference.put(accessRange, methodReference);
                    FieldAcces fieldAccess = new FieldAcces(FieldAccessType.STATIC, methodReference, reference);
                    fieldAccessReference.put(accessRange, fieldAccess);
                }
            }

            @Override
            public void exitStaticMethodAccess(BladePhpAntlrParser.StaticMethodAccessContext ctx) {
                String namespace = null;

                if (ctx.namespace() != null) {
                    namespace = ctx.namespace().getText();
                    namespace = namespace.substring(0, namespace.length() - 1);
                    OffsetRange namespaceRange = new OffsetRange(ctx.namespace().getStart().getStartIndex(),
                            ctx.namespace().getStop().getStopIndex());
                    PhpReference reference = new PhpReference(PhpReferenceType.PHP_NAMESPACE, namespace, null);
                    identifierReference.put(namespaceRange, reference);
                }
                Token classToken = ctx.className;
                OffsetRange range = new OffsetRange(classToken.getStartIndex(), classToken.getStopIndex() + 1);

                PhpReference reference = new PhpReference(PhpReferenceType.PHP_CLASS, classToken.getText(), namespace);
                identifierReference.put(range, reference);

                if (ctx.method != null) {
                    PhpReference methodReference = new PhpReference(PhpReferenceType.PHP_METHOD, ctx.method.getText(), namespace);
                    OffsetRange accessRange = new OffsetRange(ctx.method.getStartIndex(), ctx.method.getStopIndex() + 1);
                    identifierReference.put(accessRange, methodReference);
                    FieldAcces fieldAccess = new FieldAcces(FieldAccessType.STATIC, methodReference, reference);
                    fieldAccessReference.put(accessRange, fieldAccess);
                }
            }
            
            @Override public void exitStaticAccess(BladePhpAntlrParser.StaticAccessContext ctx) { 
                    String namespace = null;

                if (ctx.namespace() != null) {
                    namespace = ctx.namespace().getText();
                    namespace = namespace.substring(0, namespace.length() - 1);
                    OffsetRange namespaceRange = new OffsetRange(ctx.namespace().getStart().getStartIndex(),
                            ctx.namespace().getStop().getStopIndex());
                    PhpReference reference = new PhpReference(PhpReferenceType.PHP_NAMESPACE, namespace, null);
                    identifierReference.put(namespaceRange, reference);
                }
                Token classToken = ctx.className;
                OffsetRange range = new OffsetRange(classToken.getStartIndex(), classToken.getStopIndex() + 1);
                PhpReference reference = new PhpReference(PhpReferenceType.PHP_CLASS, classToken.getText(), namespace);
                identifierReference.put(range, reference);

                if (ctx.DOUBLE_COLON() != null && ctx.DOUBLE_COLON().getSymbol() != null){
                    Token dbColon = ctx.DOUBLE_COLON().getSymbol();
                    PhpReference methodReference = new PhpReference(PhpReferenceType.PHP_CONSTANT, "", namespace);
                    OffsetRange accessRange = new OffsetRange(dbColon.getStopIndex(), dbColon.getStopIndex() + 1);
                    identifierReference.put(accessRange, methodReference);
                    FieldAcces fieldAccess = new FieldAcces(FieldAccessType.STATIC, methodReference, reference);
                    fieldAccessReference.put(accessRange, fieldAccess);
                }
            }
        };
    }

    public PhpReference findIdentifierReference(int offset) {
        for (Map.Entry<OffsetRange, PhpReference> entry : identifierReference.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public FieldAcces findFieldAccessReference(int offset) {
        for (Map.Entry<OffsetRange, FieldAcces> entry : fieldAccessReference.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public static class PhpReference {

        public final PhpReferenceType type;
        public final String identifier;
        public final PhpReference ownerClass;
        public final String namespace;

        public PhpReference(PhpReferenceType type, String name) {
            this.type = type;
            this.identifier = name;
            this.namespace = null;
            this.ownerClass = null;
        }

        public PhpReference(PhpReferenceType type, String name, String namespace) {
            this.type = type;
            this.identifier = name;
            this.namespace = namespace;
            this.ownerClass = null;
        }

        public PhpReference(PhpReferenceType type, String name, String namespace, PhpReference ownerClass) {
            this.type = type;
            this.identifier = name;
            this.namespace = namespace;
            this.ownerClass = ownerClass;
        }
    }

    public static class FieldAcces {

        public final FieldAccessType type;
        public final PhpReference field;
        public final PhpReference owner;

        public FieldAcces(FieldAccessType type, PhpReference field, PhpReference owner) {
            this.type = type;
            this.field = field;
            this.owner = owner;
        }

    }
}
