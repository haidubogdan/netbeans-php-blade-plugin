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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.text.BadLocationException;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils;
import org.netbeans.modules.php.blade.syntax.BladeTagsUtils;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.spi.editor.bracesmatching.BracesMatcher;
import org.netbeans.spi.editor.bracesmatching.BracesMatcherFactory;
import org.netbeans.spi.editor.bracesmatching.MatcherContext;

/**
 * brace matcher - block directives : @if @endif .. - output echo statements {{
 * }} {!! !!}
 *
 * @author bogdan
 */
public class BladeBracesMatcher implements BracesMatcher {

    public enum BraceDirectionType {
        END_TO_START, START_TO_END, CUSTOM_START_TO_END, CUSTOM_END_TO_START,
        CURLY_END_TO_START, CURLY_START_TO_END, STOP
    }
    private final MatcherContext context;
    private Token originToken;
    private BraceDirectionType currentDirection;

    private BladeBracesMatcher(MatcherContext context) {
        this.context = context;
    }

    @Override
    public int[] findOrigin() throws InterruptedException, BadLocationException {
        int[] result = null;
        originToken = null;
        BaseDocument document = (BaseDocument) context.getDocument();
        document.readLock();
        try {
            Token currentToken = BladeAntlrUtils.getToken(context.getDocument(), context.getSearchOffset());

            if (currentToken == null) {
                return result;
            }

            if (!shouldLookForBraceMatch(currentToken)) {
                return result;
            }

            originToken = currentToken;
            int start = currentToken.getStartIndex();
            int end = currentToken.getStopIndex();

            String tokenText = originToken.getText();

            if (!tokenText.startsWith("@")
                    && !tokenText.startsWith("{")
                    && !tokenText.endsWith("}")) {
                return result;
            }

            currentDirection = findBraceDirectionType(tokenText, currentToken);

            if (currentDirection.equals(BraceDirectionType.STOP)) {
                return result;
            }

            result = new int[]{start, end + 1};
        } finally {
            document.readUnlock();
        }
        return result;
    }

    @Override
    public int[] findMatches() throws InterruptedException, BadLocationException {
        int[] result = null;
        if (originToken == null) {
            return result;
        }
        String tokenText = originToken.getText();

        switch (currentDirection) {
            case CURLY_START_TO_END:
                return findCloseTag();
            case CURLY_END_TO_START:
                return findOpenTag();
            case START_TO_END:
                return findDirectiveEnd(tokenText);
            case CUSTOM_START_TO_END:
                return findCustomDirectiveEnd(tokenText);
            case END_TO_START:
                return findOriginForDirectiveEnd(tokenText);
            case CUSTOM_END_TO_START:
                return findCustomDirectiveStart(tokenText);
        }

        return result;
    }

    private static boolean shouldLookForBraceMatch(@NonNull Token currentToken) {
        switch (currentToken.getType()) {
            case HTML:
            case PHP_EXPRESSION:
            case AT:
            case BLADE_COMMENT:
            case ERROR:
                return false;
        }

        return true;
    }

    public BraceDirectionType findBraceDirectionType(String tokenText, Token token) {
        boolean isCloseTag = Arrays.asList(BladeTagsUtils.outputCloseTags()).indexOf(tokenText) >= 0;

        if (isCloseTag) {
            return BraceDirectionType.CURLY_END_TO_START;
        }

        boolean isStartTag = Arrays.asList(BladeTagsUtils.outputStartTags()).indexOf(tokenText) >= 0;

        if (isStartTag) {
            return BraceDirectionType.CURLY_START_TO_END;
        }

        if (tokenText.startsWith("@end") || tokenText.equals("@show")) {
            if (BladeLexerUtils.isUndefinedDirective(token)) {
                return BraceDirectionType.CUSTOM_END_TO_START;
            }
            return BraceDirectionType.END_TO_START;
        }

        if (BladeDirectivesUtils.directiveStart2EndPair(tokenText) != null) {
            return BraceDirectionType.START_TO_END;
        }

        if (BladeLexerUtils.isUndefinedDirective(token)) {
            return BraceDirectionType.CUSTOM_START_TO_END;
        }

        return BraceDirectionType.STOP;
    }

    public int[] findOpenTag() {
        int matchTokenType = BladeAntlrUtils.getTagPairTokenType(originToken.getType());
        List<Integer> skipableTokenTypes = new ArrayList<>();
        skipableTokenTypes.add(HTML);
        Token startToken = BladeAntlrUtils.findBackwardWithStop(context.getDocument(),
                originToken,
                matchTokenType,
                skipableTokenTypes);

        if (startToken != null) {
            int start = startToken.getStartIndex();
            int end = startToken.getStopIndex();
            return new int[]{start, end + 1};
        }

        return null;
    }

    public int[] findCloseTag() {
        int matchTokenType = BladeAntlrUtils.getTagPairTokenType(originToken.getType());
        List<Integer> skipableTokenTypes = new ArrayList<>();
        skipableTokenTypes.add(HTML);
        Token endToken = BladeAntlrUtils.findForwardWithStop(context.getDocument(),
                originToken,
                matchTokenType,
                skipableTokenTypes);

        if (endToken != null) {
            int start = endToken.getStartIndex();
            int end = endToken.getStopIndex();
            return new int[]{start, end + 1};
        }

        return null;
    }

    public int[] findDirectiveEnd(String directive) {
        String[] pair = BladeDirectivesUtils.directiveStart2EndPair(directive);
        if (pair == null) {
            return null;
        }
        Set<String> startDirectiveForBalance = new HashSet<>();
        Set<String> stopDirectives = new HashSet<>(Arrays.asList(pair));

        for (String endDirective : pair) {
            String[] startDirectives = BladeDirectivesUtils.directiveEnd2StartPair(endDirective);

            if (startDirectives != null) {
                startDirectiveForBalance.addAll(Arrays.asList(startDirectives));
            }
        }

        Token endToken = BladeAntlrUtils.findForward(context.getDocument(),
                originToken,
                stopDirectives,
                startDirectiveForBalance);

        if (endToken != null) {
            //String text = endToken.getText();
            int start = endToken.getStartIndex();
            int end = endToken.getStopIndex();
            return new int[]{start, end + 1};
        }

        return null;
    }

    public int[] findCustomDirectiveEnd(String directive) {
        String[] pair = new String[]{"@end" + directive.substring(1)};
        Set<String> stopDirectives = new HashSet<>( Arrays.asList(pair));
        Set<String> startDirectiveForBalance = new HashSet<>();
        startDirectiveForBalance.add(directive);

        Token endToken = BladeAntlrUtils.findForward(context.getDocument(),
                originToken,
                stopDirectives,
                startDirectiveForBalance);

        if (endToken != null) {
            int start = endToken.getStartIndex();
            int end = endToken.getStopIndex();
            return new int[]{start, end + 1};
        }

        return null;
    }
    
    public int[] findCustomDirectiveStart(String directive) {
        String[] pair = new String[]{"@" + directive.substring(4)};
        Set<String> stopDirectives = new HashSet<>(Arrays.asList(pair));
        Set<String> startDirectiveForBalance = new HashSet<>();
        startDirectiveForBalance.add(directive);

        Token endToken = BladeAntlrUtils.findBackward(context.getDocument(),
                originToken,
                stopDirectives,
                startDirectiveForBalance);

        if (endToken != null) {
            int start = endToken.getStartIndex();
            int end = endToken.getStopIndex();
            return new int[]{start, end + 1};
        }

        return null;
    }

    public int[] findOriginForDirectiveEnd(String directive) {
        String[] pair = BladeDirectivesUtils.directiveEnd2StartPair(directive);
        Set<String> endDirectivesForBalance = new HashSet();
        Set<String> openDirectives = new HashSet<>(Arrays.asList(pair));

        for (String startDirective : pair) {
            String[] endDirectives = BladeDirectivesUtils.directiveStart2EndPair(startDirective);

            if (endDirectives != null) {
                endDirectivesForBalance.addAll(new HashSet<>( new ArrayList<>(Arrays.asList(endDirectives))));
            }
        }

        Token startToken = BladeAntlrUtils.findBackward(context.getDocument(),
                originToken,
                openDirectives,
                endDirectivesForBalance);

        if (startToken != null) {
            int start = startToken.getStartIndex();
            int end = startToken.getStopIndex();
            return new int[]{start, end + 1};
        }

        return null;
    }

    @MimeRegistration(service = BracesMatcherFactory.class, mimeType = BladeLanguage.MIME_TYPE, position = 110)
    public static final class Factory implements BracesMatcherFactory {

        @Override
        public BracesMatcher createMatcher(MatcherContext context) {
            return new BladeBracesMatcher(context);
        }

    }
}
