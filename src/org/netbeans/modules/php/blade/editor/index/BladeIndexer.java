package org.netbeans.modules.php.blade.editor.index;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.indexing.EmbeddingIndexer;
import org.netbeans.modules.parsing.spi.indexing.EmbeddingIndexerFactory;
import org.netbeans.modules.parsing.spi.indexing.Indexable;
import org.netbeans.modules.parsing.spi.indexing.support.IndexingSupport;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.parsing.spi.indexing.Context;
import org.openide.filesystems.FileObject;
import org.netbeans.modules.parsing.spi.indexing.support.IndexDocument;
import org.netbeans.modules.php.blade.editor.Utils;
import org.netbeans.modules.php.blade.editor.model.BladeModelElement;
import org.netbeans.modules.php.blade.editor.model.Model;
import org.openide.util.ChangeSupport;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.Parameters;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author bhaidu
 */
public class BladeIndexer extends EmbeddingIndexer {

    private static final Logger LOGGER = Logger.getLogger(BladeIndexer.class.getSimpleName());
    private static ChangeSupport changeSupport = new ChangeSupport(BladeIndexer.class);
    //private static final RequestProcessor RP = new RequestProcessor();
    public static final String YIELD_INDEX_KEY = "index_yields";
    public static final String YIELD_NAME = "yield_name"; //NOI18N
    public static final String YIELD_DECLARATION = "yield"; //NOI18N
    public static final String BLADE_VIEW_PATH = "blade_view_path"; //NOI18N
    public static final String BLADE_CONTENT_KEY = "bladeContent"; //NOI18N

    public static final String VALUE_SEPARATOR = ",";
    public static final String ITEMS_SEPARATOR = "/";
    //use for bladeDataIndex model
    public static final Collection<String> INDEX_KEYS = Arrays.asList(new String[]{BladeIndexer.YIELD_INDEX_KEY});

    //TODO add cancel support
    @Override
    protected void index(Indexable indxbl, Result result, Context context) {
        BladeParserResult parserResult = (BladeParserResult) result;
        final FileObject fileObject = parserResult.getSnapshot().getSource().getFileObject();
        LOGGER.log(Level.FINE, "Indexing: {0}, fullPath: {1}", new Object[]{indxbl.getRelativePath(), fileObject});

        if (parserResult.getProgram() == null) {
            LOGGER.log(Level.FINE, "Missing parser result program for : {0}", fileObject);
            return;
        }

        //get the filename as a blade path with "."
        String bladeFilePath = Utils.convertToBladePath(fileObject);

        Model model = parserResult.getModel();
        Collection<BladeModelElement> yields = model.getYields();

        try {
            IndexingSupport support = IndexingSupport.getInstance(context);
            // we need to remove old documents (document per object, not file)
            support.removeDocuments(indxbl);
            IndexDocument document = support.createDocument(indxbl);

            document.addPair(BLADE_CONTENT_KEY, Boolean.TRUE.toString(), true, true);
            document.addPair(BLADE_VIEW_PATH, bladeFilePath, true, true);

            storeYieldDeclarations(yields, document);

            /*
            //we can store values using models ... but we don't need such complexity
            Collection<BladeIndexModel> indexModels = BladeIndexModelSupport.getModels(r);
            for (BladeIndexModel indexModel : indexModels) {
                indexModel.storeToIndex(document);
            }
             */
            support.addDocument(document);
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, null, ex);
            Exceptions.printStackTrace(ex);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    private void storeYieldDeclarations(Collection<BladeModelElement> yields, IndexDocument document) {
        StringBuilder sb = new StringBuilder();
        for (BladeModelElement yield : yields) {
            //NAME IS NOT GOOD
            ElementHandle handle = yield.getHandle();
            if (handle.getName().isEmpty()) {
                //skip empty yield
                continue;
            }
            sb.append(handle.getName());
            sb.append(ITEMS_SEPARATOR);
            sb.append("Y");
            sb.append(ITEMS_SEPARATOR);

            if (yield.getRange() != null) {
                sb.append(yield.getRange().getStart());
                sb.append(ITEMS_SEPARATOR);
            }
            sb.append(VALUE_SEPARATOR);
        }
        document.addPair(YIELD_DECLARATION, sb.toString(), true, true);
    }

    public static class Factory extends EmbeddingIndexerFactory {

        public static final String NAME = "blade"; //NOI18N
        public static final int VERSION = 1;
        private static final int PRIORITY = 100;
        private static final ThreadLocal<Collection<Runnable>> postScanTasks = new ThreadLocal<Collection<Runnable>>();

        @Override
        public EmbeddingIndexer createIndexer(Indexable indexable, Snapshot snapshot) {
            if (isIndexable(snapshot)) {
                return new BladeIndexer();
            } else {
                return null;
            }
        }

        @Override
        public String getIndexerName() {
            return NAME;
        }

        @Override
        public int getIndexVersion() {
            return VERSION;
        }

        private boolean isIndexable(Snapshot snapshot) {
            return BladeLanguage.BLADE_MIME_TYPE.equals(snapshot.getMimeType());
        }

        @Override
        public void filesDeleted(Iterable<? extends Indexable> deleted, org.netbeans.modules.parsing.spi.indexing.Context cntxt) {
            try {
                IndexingSupport is = IndexingSupport.getInstance(cntxt);
                for (Indexable i : deleted) {
                    is.removeDocuments(i);
                }
            } catch (IOException ioe) {
                LOGGER.log(Level.WARNING, null, ioe);
            }
        }

        @Override
        public void filesDirty(Iterable<? extends Indexable> dirty, org.netbeans.modules.parsing.spi.indexing.Context context) {
            try {
                IndexingSupport is = IndexingSupport.getInstance(context);
                for (Indexable i : dirty) {
                    is.markDirtyDocuments(i);
                }
            } catch (IOException ioe) {
                LOGGER.log(Level.WARNING, null, ioe);
            }
            //
        }

        @Override
        public boolean scanStarted(Context context) {
            postScanTasks.set(new LinkedList<Runnable>());
            return super.scanStarted(context);
        }

        @Override
        public void scanFinished(Context context) {
            if (context.isAllFilesIndexing()) {
                IndexChangeSupport changeSupport = Lookup.getDefault().lookup(IndexChangeSupport.class);
                if (changeSupport != null) {
                    // when the scan is finished, clear the index cache
                    changeSupport.fireChange();
                }
            }
            try {
                for (Runnable task : postScanTasks.get()) {
                    task.run();
                }
            } finally {
                postScanTasks.remove();
                super.scanFinished(context);
            }
        }

        public static boolean isScannerThread() {
            return postScanTasks.get() != null;
        }

        public static void addPostScanTask(@NonNull final Runnable task) {
            Parameters.notNull("task", task);   //NOI18N
            final Collection<Runnable> tasks = postScanTasks.get();
            if (tasks == null) {
                throw new IllegalStateException("BladeIndexer.postScanTask can be called only from scanner thread.");  //NOI18N
            }
            tasks.add(task);
        }

        @Override
        public int getPriority() {
            return PRIORITY;
        }
    } //end of Factory class

    @ServiceProvider(service = IndexChangeSupport.class)
    public static final class IndexChangeSupport {

        public void addChangeListener(ChangeListener listener) {
            changeSupport.addChangeListener(listener);
        }

        public void removeChangeListener(ChangeListener listener) {
            changeSupport.removeChangeListener(listener);
        }

        public void fireChange() {
            changeSupport.fireChange();
        }
    }

    @ServiceProvider(service = PostScanProvider.class)
    public static final class PostScanProvider {

        public void addPostScanTask(Runnable task) {
            Factory.addPostScanTask(task);
        }
    }
}
