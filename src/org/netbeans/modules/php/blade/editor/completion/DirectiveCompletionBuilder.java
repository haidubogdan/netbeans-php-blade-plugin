/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.net.URL;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.lib.editor.codetemplates.api.CodeTemplateManager;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.spi.editor.completion.CompletionDocumentation;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bogdan
 */
public class DirectiveCompletionBuilder {

    public static CompletionItem simpleItem(int startOffset, String directive,
            String description) {
        CompletionUtilities.CompletionItemBuilder builder = CompletionUtilities.newCompletionItemBuilder(directive)
                .iconResource(getReferenceIcon())
                .startOffset(startOffset)
                .leftHtmlText(directive)
                .sortText(directive);
        if (description != null && !description.isEmpty()) {
            builder.rightHtmlText(description);
        }

        return builder.build();
    }

    public static CompletionItem simpleItem(int startOffset, int carretOffset,
            String prefix, String directive, String endtag,
            String description, Document doc) {
        CompletionUtilities.CompletionItemBuilder builder = CompletionUtilities.newCompletionItemBuilder(directive)
                .iconResource(getReferenceIcon())
                .startOffset(startOffset)
                .leftHtmlText(directive + " ... " + endtag)
                .sortText(directive);

        if (description != null && !description.isEmpty()) {
            builder.rightHtmlText(description);
        }
        builder.onSelect(ctx -> {
            StringBuilder sb = new StringBuilder();
            sb.append(directive);
            sb.append("\n${cursor}\n");
            sb.append(endtag);
            try {
                doc.remove(carretOffset - prefix.length(), prefix.length());
                CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
        return builder.build();
    }

    public static CompletionItem itemWithArg(int startOffset, int carretOffset,
            String prefix, String directive,
            String description, Document doc) {
        CompletionUtilities.CompletionItemBuilder builder = CompletionUtilities.newCompletionItemBuilder(directive)
                .iconResource(getReferenceIcon())
                .startOffset(startOffset)
                .leftHtmlText(directive + "()")
                .sortText(directive);

        if (description != null && !description.isEmpty()) {
            builder.rightHtmlText(description);
        }
        builder.onSelect(ctx -> {
            StringBuilder sb = new StringBuilder();
            sb.append(directive);
            sb.append("(${cursor})");

            try {
                doc.remove(carretOffset - prefix.length(), prefix.length());
                CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
        return builder.build();
    }

    public static CompletionItem itemWithArg(int startOffset, int carretOffset,
            String prefix, String directive, String endtag,
            String description, Document doc) {
        CompletionUtilities.CompletionItemBuilder builder = CompletionUtilities.newCompletionItemBuilder(directive)
                .iconResource(getReferenceIcon())
                .startOffset(startOffset)
                .leftHtmlText(directive + "() ... " + endtag)
                .sortText(directive);

        if (description != null && !description.isEmpty()) {
            builder.rightHtmlText(description);
        }
        builder.onSelect(ctx -> {
            StringBuilder sb = new StringBuilder();
            sb.append(directive);
            sb.append("(${cursor})\n");
            sb.append("\n${cursor}");
            sb.append(endtag);
            try {
                doc.remove(carretOffset - prefix.length(), prefix.length());
                CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
        return builder.build();
    }

    public static CompletionItem itemWithArg(int startOffset, int carretOffset,
            String prefix, String directive,
            String description, Document doc,
            FileObject file) {
        CompletionUtilities.CompletionItemBuilder builder = CompletionUtilities.newCompletionItemBuilder(directive)
                .iconResource(getReferenceIcon())
                .startOffset(startOffset)
                .leftHtmlText(directive + "()")
                .rightHtmlText(description)
                .documentationTask(getDocTask(file))
                .onSelect(ctx -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(directive);
                    sb.append("(${cursor})");
                    try {
                        doc.remove(carretOffset - prefix.length(), prefix.length());
                        CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());

                    } catch (BadLocationException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                })
                .sortText(directive);
        return builder.build();
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

    private static String getReferenceIcon() {
        return ResourceUtilities.ICON_BASE + "icons/at.png"; //NOI18N
    }
}
