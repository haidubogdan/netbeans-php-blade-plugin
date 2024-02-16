package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.spi.ParserResult;

/**
 *
 * @author bhaidu
 */
public class PhpCodeCompletionContext {

    public static CodeCompletionContext completionContext(int carretOffset,
            ParserResult phpParserResult,
            String phpPrefix) {
        return new CodeCompletionContext() {
            @Override
            public int getCaretOffset() {
                //the offset should be taken from compiler
                return carretOffset;
            }

            @Override
            public ParserResult getParserResult() {
                return phpParserResult;
            }

            @Override
            public String getPrefix() {
                return phpPrefix;
            }

            @Override
            public boolean isPrefixMatch() {
                return true;
            }

            @Override
            public CodeCompletionHandler.QueryType getQueryType() {
                return CodeCompletionHandler.QueryType.COMPLETION;
            }

            @Override
            public boolean isCaseSensitive() {
                return true;
            }
        };
    }
}
