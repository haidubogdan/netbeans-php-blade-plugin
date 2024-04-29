package org.netbeans.modules.php.blade.editor.parser;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeParser extends org.netbeans.modules.parsing.spi.Parser {
    private static final Logger LOGGER = Logger.getLogger(BladeParser.class.getName());
    BladeParserResult lastResult;
    private static final WeakHashMap<FileObject, Reference<BladeParserResult>> CACHE = new WeakHashMap<>();

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) throws ParseException {
        if (snapshot == null) {
            return;
        }
        if (task.getClass().getName().contains("HtmlCssIndexContributor")){
            LOGGER.log(Level.INFO, "Skipped parsing for {0}", task.getClass().getName());
            return;
        }
        long startTime = System.currentTimeMillis();
        BladeParserResult parserResult = createParserResult(snapshot);

        BladeParserResult parsed = parserResult.get(task.getClass().getName());
        //cacheResult(snapshot.getSource().getFileObject(), parsed);
        lastResult = parsed;
        //LOGGER.info(String.format("Finished parsing for " + task.getClass().getName() + ". Time : %d ms", System.currentTimeMillis() - startTime));
    }
    
    private static void cacheResult(FileObject fo, BladeParserResult result) {
        synchronized (CACHE) {
            CACHE.put(fo, new WeakReference<>(result));
        }
    }
    
    @Override
    public Result getResult(Task task) throws ParseException {
        assert lastResult != null;
        return lastResult;
    }

    @Override
    public void addChangeListener(ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener(ChangeListener changeListener) {
    }

    protected BladeParserResult createParserResult(Snapshot snapshot) {
        return new BladeParserResult(snapshot);
    }

    /*
    public static BladeParserResult getParserResult(FileObject fo) {
        BladeParserResult result = null;
        java.lang.ref.Reference<BladeParserResult> ceReference;
        synchronized (CACHE) {
            ceReference = CACHE.get(fo);
        }
        if (ceReference != null) {
            result = ceReference.get();
        }

        if (result == null) {
            try {
                BladeParserResult[] parserResult = new BladeParserResult[1];
                ParserManager.parse(Collections.singleton(Source.create(fo)), new UserTask() {
                    @Override
                    public void run(ResultIterator resultIterator) throws Exception {
                        org.netbeans.modules.parsing.spi.Parser.Result result = resultIterator.getParserResult();
                        if (result instanceof BladeParserResult) {
                            parserResult[0] = (BladeParserResult) result;
                        }
                    }
                });
                if (parserResult[0] != null) {
                    result = parserResult[0];
                }
            } catch (ParseException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        return result;
    }
*/
}
