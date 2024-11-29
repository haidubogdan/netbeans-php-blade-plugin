/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.utils;

import java.util.List;
import java.util.Set;
import javax.swing.text.Document;
import org.antlr.v4.runtime.Token;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;

/**
 *
 * @author bogdan
 */
public abstract class BladeAntlrUtils {

    public static Token getToken(AntlrTokenSequence tokens, int offset) {
        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(offset);

        if (!tokens.hasNext()) {
            return null;
        }

        Token token = tokens.next().get();

        //need to move back
        if (token != null && tokens.hasPrevious() && token.getStartIndex() > offset && token.getStopIndex() > offset) {
            token = tokens.previous().get();
        }

        return token;
    }

    public static Token findForward(AntlrTokenSequence tokens, int startOffset,
            Set<String> stopTokensText, Set<String> openTokensText) {
        if (tokens == null || tokens.isEmpty()) {
            return null;
        }
        tokens.seekTo(startOffset);

        return findForward(tokens, stopTokensText, openTokensText);
    }

    public static Token findForward(AntlrTokenSequence tokens, Token start,
            Set<String> stopTokensText, Set<String> openTokensText) {
        
        
        if (tokens == null || tokens.isEmpty()) {
            return null;
        }
        tokens.seekTo(start.getStopIndex() + 1);

        return findForward(tokens, stopTokensText, openTokensText);
    }

    private static Token findForward(AntlrTokenSequence tokens,
            Set<String> stopTokenText, Set<String> openTokensText) {

        int openTokenBalance = 0;

        while (tokens.hasNext()) {
            Token nt = tokens.next().get();
            if (nt == null) {
                continue;
            }

            String tokenText = nt.getText().trim();

            if (openTokensText.contains(tokenText)) {
                openTokenBalance++;
                continue;
            }
            if (stopTokenText.contains(tokenText)) {
                if (openTokenBalance > 0) {
                    openTokenBalance--;
                } else {
                    return nt;
                }
            }
        }
        return null;
    }

    public static Token findBackward(AntlrTokenSequence tokens, Token start,
            Set<String> stopTokenText, Set<String> balanceTokensText) {

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(start.getStartIndex() - 1);

        return findBackward(tokens, stopTokenText, balanceTokensText);
    }

    public static Token findBackward(AntlrTokenSequence tokens, int offset,
            Set<String> stopTokenText, Set<String> balanceTokensText) {

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(offset);

        return findBackward(tokens, stopTokenText, balanceTokensText);
    }
    
    private static Token findBackward(AntlrTokenSequence tokens,
            Set<String> stopTokenText, Set<String> balanceTokensText) {

        int openTokenBalance = 0;

        while (tokens.hasPrevious()) {
            Token pt = tokens.previous().get();
            if (pt == null) {
                continue;
            }

            String tokenText = pt.getText().trim();

            if (balanceTokensText.contains(tokenText)) {
                openTokenBalance++;
                continue;
            }
            if (stopTokenText.contains(tokenText)) {
                if (openTokenBalance > 0) {
                    openTokenBalance--;
                } else {
                    return pt;
                }
            }
        }

        return null;
    }

    public static Token findForwardWithStop(AntlrTokenSequence tokens, Token start,
            int tokensMatch, Set<Integer> stopTokens) {

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(start.getStopIndex() + 1);

        while (tokens.hasNext()) {
            Token pt = tokens.next().get();
            if (pt == null) {
                continue;
            }

            if (pt.getType() == tokensMatch) {
                return pt;
            }

            if (stopTokens.contains(pt.getType())) {
                return null;
            }
        }

        return null;

    }

    public static Token findBackward(AntlrTokenSequence tokens, Token start,
            int tokensMatch, List<Integer> skipableTokens) {

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(start.getStartIndex() - 1);

        while (tokens.hasPrevious()) {
            Token pt = tokens.previous().get();
            if (pt == null) {
                continue;
            }

            if (pt.getType() == tokensMatch) {
                return pt;
            }

            if (skipableTokens.contains(pt.getType())) {
                continue;
            }

            return null;
        }

        return null;

    }

    public static Token findBackwardWithStop(
            AntlrTokenSequence tokens, Token start, int tokenMatch, Set<Integer> stopTokens) {
        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(start.getStartIndex() - 1);

        while (tokens.hasPrevious()) {
            Token pt = tokens.previous().get();
            if (pt == null) {
                continue;
            }

            if (pt.getType() == tokenMatch) {
                return pt;
            }

            if (stopTokens.contains(pt.getType())) {
                return null;
            }
        }

        return null;
    }
}
