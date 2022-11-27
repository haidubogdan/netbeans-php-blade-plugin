package org.netbeans.modules.php.blade.editor.completion;

import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import static org.netbeans.modules.php.blade.editor.BladeLanguage.BLADE_MIME_TYPE;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;

/**
 *
 * @author bhaidu
 */
//@MimeRegistration(mimeType = BLADE_MIME_TYPE, service = CompletionProvider.class)
public class BladeCompletionProvider implements CompletionProvider {

    @Override
    public CompletionTask createTask(int queryType, JTextComponent jtc) {
        return new AsyncCompletionTask(new AsyncCompletionQuery() {

            @Override
            protected void query(CompletionResultSet completionResultSet, Document document, int caretOffset) {
                //test
                completionResultSet.finish();
            }

        }, jtc);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        if (typedText.length() > 2){
            return 3;
        }
        return 3;
    }
}
