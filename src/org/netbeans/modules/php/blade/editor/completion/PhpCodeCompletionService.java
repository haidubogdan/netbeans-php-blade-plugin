package org.netbeans.modules.php.blade.editor.completion;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.editor.csl.PHPLanguage;

/**
 *
 * @author bogdan
 */
public class PhpCodeCompletionService {

    public String prefix  = "";

    public List<CompletionProposal> getCompletionProposal(int offset, Token currentToken) {
        List<CompletionProposal> proposals = new ArrayList<>();
        String phpSnippet = currentToken.getText();
        String phpStart = "<?php ";
        if (phpSnippet.length() < 1 || currentToken.getStartIndex() < phpStart.length()) {
            return proposals;
        }
        int previousSpace = currentToken.getStartIndex() - phpStart.length();
        ParsingUtils parsingUtils = new ParsingUtils();
        String whitespaceFill = new String(new char[previousSpace]).replace("\0", " ");
        String phpSnippetText = whitespaceFill + phpStart + currentToken.getText();
        parsingUtils.parsePhpText(phpSnippetText);
        ParserResult phpParserResult = parsingUtils.getParserResult();
        if (phpParserResult == null) {
            return proposals;
        }
        CodeCompletionHandler cc = (new PHPLanguage()).getCompletionHandler();
        prefix = cc.getPrefix(phpParserResult, offset, true);

        if (prefix == null) {
            return proposals;
        }

        if (prefix.length() == 0) {
            prefix = cc.getPrefix(phpParserResult, offset - 1, true);
        }

        if (prefix == null || prefix.length() == 0) {
            return proposals;
        }

        String phpPrefix = prefix;

        CodeCompletionContext context = PhpCodeCompletionContext.completionContext(offset,
                phpParserResult, phpPrefix);

        CodeCompletionResult completionResult = cc.complete(context);
        return completionResult.getItems();
    }
}
