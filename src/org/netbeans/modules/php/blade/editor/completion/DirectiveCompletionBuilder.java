/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.net.URL;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.text.Document;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.spi.editor.completion.CompletionDocumentation;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class DirectiveCompletionBuilder {

    public static CompletionItem simpleItem(int startOffset, String directive,
            String description) {

        return BladeCompletionItem.createInlineDirective(directive, startOffset, description);
    }

    public static CompletionItem simpleItem(int startOffset, int carretOffset,
            String prefix, String directive, String endtag,
            String description, Document doc) {

        return BladeCompletionItem.createBlockDirective(
                directive, endtag, startOffset, description);
    }

    public static CompletionItem itemWithArg(int startOffset, int carretOffset,
            String prefix, String directive,
            String description, Document doc) {

        return BladeCompletionItem.createDirectiveWithArg(directive, startOffset, description);
    }

    public static CompletionItem itemWithArg(int startOffset, int carretOffset,
            String prefix, String directive, String endtag,
            String description, Document doc) {

        return BladeCompletionItem.createBlockDirectiveWithArg(
                directive, endtag, startOffset, description);
    }

    public static CompletionItem itemWithArg(int startOffset, int carretOffset,
            String prefix, String directive,
            String description, Document doc,
            FileObject file) {
        return BladeCompletionItem.createDirectiveWithArg(directive, startOffset, description);
    }

    private static Supplier<CompletionTask> getDocTask(FileObject fo) {
        return () -> {
            return new AsyncCompletionTask(new AsyncCompletionQuery() {
                @Override
                protected void query(CompletionResultSet resultSet, Document doc, int caretOffset) {
                    CompletionDocumentation docInfo = new CompletionDocumentation() {
                        @Override
                        public String getText() {
                            return "From " + fo.getNameExt();
                        }

                        @Override
                        public URL getURL() {
                            return null;
                        }

                        @Override
                        public CompletionDocumentation resolveLink(String string) {
                            return null;
                        }

                        @Override
                        public Action getGotoSourceAction() {
                            return null;
                        }

                    };
                    resultSet.setDocumentation(docInfo);
                    resultSet.finish();
                }
            });
        };
    }

}
