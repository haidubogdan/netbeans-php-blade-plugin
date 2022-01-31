package org.netbeans.modules.php.blade.editor.parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.php.blade.editor.parsing.BladeParser.Context;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTNode;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeProgram;
import org.netbeans.modules.php.editor.parser.ParserErrorHandler;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.php.api.util.StringUtils;
import org.openide.util.NbBundle;

/**
 *
 * @author bhaidu
 */
public class BladeErrorHandler implements ParserErrorHandler {

    private final List<SyntaxError> syntaxErrors;
    private final Context context;
    private volatile boolean handleErrors = true;

    public BladeErrorHandler(Context context) {
        super();
        this.context = context;
        syntaxErrors = new ArrayList<>();
    }

    @Override
    public void handleError(Type type, short[] expectedtokens, Symbol current, Symbol previous) {
        if (handleErrors) {
            if (type == ParserErrorHandler.Type.SYNTAX_ERROR) {
                SyntaxErrorLogger.log(expectedtokens, current, previous);
                SyntaxError.Type syntaxErrorType = SyntaxError.Type.POSSIBLE_ERROR;
                if (syntaxErrors.isEmpty()) {
                    syntaxErrorType = SyntaxError.Type.FIRST_VALID_ERROR;
                }
                syntaxErrors.add(new SyntaxError(expectedtokens, current, previous, syntaxErrorType));
            }
        }
    }

    public void disableHandling() {
        handleErrors = false;
    }

    public List<Error> displayFatalError() {
        return Arrays.asList((Error) new FatalError(context));
    }

    public List<Error> displaySyntaxErrors(BladeProgram program) {
        List<Error> errors = new ArrayList<>();
        for (SyntaxError syntaxError : syntaxErrors) {
            errors.add(defaultSyntaxErrorHandling(syntaxError));
        }
        return errors;
    }
    
    public boolean hasSyntaxErrors(){
        return syntaxErrors.size() > 0;
    }

    @NbBundle.Messages("SE_Expected=expected")
    private Error defaultSyntaxErrorHandling(SyntaxError syntaxError) {
        StringBuilder message = new StringBuilder();
        Symbol currentToken = syntaxError.getCurrentToken();
        message.append(syntaxError.getMessageHeader());
        message.append(TokenWrapper.create(currentToken).createUnexpectedMessage());
        if (syntaxError.generateExtraInfo()) {
            message.append(TokenWrapper.create(syntaxError.getPreviousToken()).createAfterText());
            List<String> possibleTags = getExpectedTokenNames(syntaxError);
            if (possibleTags.size() > 0) {
                message.append(createExpectedTokensText(possibleTags));
            }
        }
        return new BladeError(
                message.toString(),
                context.getSnapshot().getSource().getFileObject(),
                currentToken.left,
                currentToken.right,
                syntaxError.getSeverity(),
                new Object[]{syntaxError});
    }

    private static List<String> getExpectedTokenNames(SyntaxError syntaxError) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < syntaxError.getExpectedTokens().length; i += 2) {
            String text = TokenWrapper.getTokenTextForm(syntaxError.getExpectedTokens()[i]);
            if (text != null) {
                result.add(text);
            }
        }
        return result;
    }

    private static String createExpectedTokensText(List<String> expectedTokenNames) {
        StringBuilder message = new StringBuilder();
        message.append("\n ").append(Bundle.SE_Expected()); //NOI18N
        message.append(":\t"); //NOI18N
        boolean addOR = false;
        for (String tag : expectedTokenNames) {
            if (addOR) {
                message.append(", "); //NOI18N
            } else {
                addOR = true;
            }
            message.append(tag);
        }
        return message.toString();
    }

    public List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

    private static class SyntaxErrorLogger {

        private static final Logger LOGGER = Logger.getLogger(SyntaxErrorLogger.class.getName());

        public static void log(short[] expectedtokens, Symbol current, Symbol previous) {
            if (LOGGER.isLoggable(Level.FINEST)) {
                LOGGER.finest("Syntax error:"); //NOI18N
            }
        }

    }

    private static final class TokenWrapper {

        private final Symbol token;

        public static TokenWrapper create(Symbol token) {
            assert token != null;
            return new TokenWrapper(token);
        }

        private TokenWrapper(Symbol token) {
            this.token = token;
        }

        public boolean isCommonToken() {
            return (!(token.value instanceof List) && !(token.value instanceof ASTNode));
        }

        public boolean isNodeToken() {
            return (token.value instanceof ASTNode);
        }

        @NbBundle.Messages({
            "SE_Unexpected=unexpected",
            "SE_EOF=End of File"
        })
        public String createUnexpectedMessage() {
            String result; //NOI18N
            String unexpectedText = null;
            if (token.sym == ASTBladeSymbols.EOF) {
                unexpectedText = Bundle.SE_EOF();
            } else if (isValuableToken(token)) {
                unexpectedText = getTokenTextForm(token.sym) + " '" + String.valueOf(token.value) + "'";
            } else {
                String currentText = getTokenTextForm(token.sym);
                if (StringUtils.hasText(currentText)) {
                    unexpectedText = currentText.trim();
                }
            }
            if (unexpectedText == null) {
                result = ""; //NOI18N
            } else {
                result = "\n " + Bundle.SE_Unexpected() + ":\t" + unexpectedText; //NOI18N
            }
            return result;
        }

        @NbBundle.Messages("SE_After=after")
        public String createAfterText() {
            String result;
            String afterText = null;
            if (isValuableToken(token)) {
                afterText = getTokenTextForm(token.sym) + " '" + String.valueOf(token.value) + "'";
            } else {
                if (!isNodeToken()) {
                    String previousText = getTokenTextForm(token.sym);
                    if (StringUtils.hasText(previousText)) {
                        afterText = previousText.trim();
                    }
                }
            }
            if (afterText == null) {
                result = ""; //NOI18N
            } else {
                result = "\n " + Bundle.SE_After() + ":\t" + afterText; //NOI18N
            }
            return result;
        }

        private static boolean isValuableToken(Symbol token) {
            return (token.sym == ASTBladeSymbols.T_STRING
                    || token.sym == ASTBladeSymbols.T_VARIABLE) && !(token.value instanceof ASTNode) && !(token.value instanceof List);
        }

        public static String getTokenTextForm(int token) {
            return ASTBladeSymbolValues.getTokenTextForm(token);
        }

    }

    @org.netbeans.api.annotations.common.SuppressWarnings({"EI_EXPOSE_REP", "EI_EXPOSE_REP2"})
    public static class SyntaxError {

        @NbBundle.Messages({
            "SE_ValidMessage=Blade Syntax error",
            "SE_PossibleMessage=POSSIBLE Syntax Error (check preceding valid syntax error)"
        })
        public static enum Type {
            FIRST_VALID_ERROR() {

                @Override
                public String getMessageHeader() {
                    return Bundle.SE_ValidMessage();
                }

                @Override
                public Severity getSeverity() {
                    return Severity.ERROR;
                }

            },
            POSSIBLE_ERROR() {

                @Override
                public String getMessageHeader() {
                    return Bundle.SE_PossibleMessage();
                }

                @Override
                public Severity getSeverity() {
                    return Severity.WARNING;
                }

            };

            public abstract String getMessageHeader();

            public abstract Severity getSeverity();
        }

        private final short[] expectedTokens;
        private final Symbol currentToken;
        private final Symbol previousToken;
        private final Type type;

        public SyntaxError(short[] expectedTokens, Symbol currentToken, Symbol previousToken, Type type) {
            this.expectedTokens = expectedTokens;
            this.currentToken = currentToken;
            this.previousToken = previousToken;
            this.type = type;
        }

        public Symbol getCurrentToken() {
            return currentToken;
        }

        public Symbol getPreviousToken() {
            return previousToken;
        }

        public short[] getExpectedTokens() {
            return expectedTokens;
        }

        public String getMessageHeader() {
            return type.getMessageHeader();
        }

        public Severity getSeverity() {
            return type.getSeverity();
        }

        public boolean generateExtraInfo() {
            return getSeverity().equals(Severity.ERROR);
        }
    }

    public static class FatalError extends BladeError {

        @NbBundle.Messages("MSG_FatalError=Unable to parse the file")
        FatalError(Context context) {
            super(Bundle.MSG_FatalError(),
                    context.getSnapshot().getSource().getFileObject(),
                    0, context.getBaseSource().length(),
                    Severity.ERROR, null);
        }

        @Override
        public boolean isLineError() {
            return false;
        }
    }
}
