package org.netbeans.modules.php.blade.editor.index.api;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import org.netbeans.api.project.Project;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.index.BladeIndexer;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.openide.filesystems.FileObject;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.netbeans.modules.php.blade.editor.index.BladeIndexer.IndexChangeSupport;
import org.openide.util.Lookup;

/**
 * TODO implement cache size
 * inspired by JSIndex
 *
 * @author bhaidu
 */
public class BladeIndex {

    public enum MatchType {
        PREFIX,
        EXACT,
        ALL
    }

    private static final Logger LOGGER = Logger.getLogger(BladeIndex.class.getSimpleName());

    private static final Map<Project, BladeIndex> INDEXES = new WeakHashMap<>();

    /**
     * Creates a new instance of {@link BladeIndex}.
     *
     * @param project The project for which you want to get the index for.
     * @return non null instance of the {@link BladeIndex}
     * @throws IOException
     */
    public static BladeIndex create(Project project) throws IOException {
        return new BladeIndex(project);
    }

    /**
     * Gets an instance of {@link BladeIndex}. The instance may be cached.
     *
     * @since 1.34
     * @param project The project for which you want to get the index for.
     * @return non null instance of the {@link BladeIndex}
     * @throws IOException
     */
    public static BladeIndex get(Project project) throws IOException {
        if (project == null) {
            throw new NullPointerException();
        }
        synchronized (INDEXES) {
            BladeIndex index = INDEXES.get(project);
            if (index == null) {
                index = create(project);
                INDEXES.put(project, index);
            }
            return index;
        }
    }

    private final QuerySupport querySupport;
    private final Collection<FileObject> sourceRoots;

    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

    private static final Lock READ_LOCK = LOCK.readLock();

    private static final Lock WRITE_LOCK = LOCK.writeLock();
    private static final int MAX_ENTRIES_CACHE_INDEX_RESULT = 2000;

    private static final int MAX_CACHE_VALUE_SIZE = 1000000;

    private static final int AVERAGE_BASIC_INFO_SIZE = 60;

    private static final WeakHashMap<FileObject, BladeIndex> INDEX_CACHE = new WeakHashMap<FileObject, BladeIndex>();
    /* GuardedBy(LOCK) */
    private static final Map<CacheKey, SoftReference<CacheValue>> CACHE_INDEX_RESULT_SMALL = new LinkedHashMap<CacheKey, SoftReference<CacheValue>>(
            MAX_ENTRIES_CACHE_INDEX_RESULT + 1, 0.75F, true) {
        @Override
        public boolean removeEldestEntry(Map.Entry<CacheKey,SoftReference<CacheValue>> eldest) {
            return size() > MAX_ENTRIES_CACHE_INDEX_RESULT;
        }
    };

    /* GuardedBy(LOCK) */
    private static final Map<CacheKey, SoftReference<CacheValue>> CACHE_INDEX_RESULT_LARGE = new LinkedHashMap<CacheKey, SoftReference<CacheValue>>(
            (MAX_ENTRIES_CACHE_INDEX_RESULT / 4) + 1, 0.75F, true) {
        @Override
        public boolean removeEldestEntry(Map.Entry<CacheKey,SoftReference<CacheValue>> eldest) {
            return size() > (MAX_ENTRIES_CACHE_INDEX_RESULT / 4);
        }
    };

    private static final Map<StatsKey, StatsValue> QUERY_STATS = new HashMap<StatsKey, StatsValue>();
    private static final ChangeListener INVALIDATE_LISTENER = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            WRITE_LOCK.lock();
            try {
                CACHE_INDEX_RESULT_SMALL.clear();
                CACHE_INDEX_RESULT_LARGE.clear();
                INDEX_CACHE.clear();
                LOGGER.log(Level.FINEST, "Cache cleared");
            } finally {
                WRITE_LOCK.unlock();
            }
        }
    };

    static {
         //FIXME listen for lookup changes ?
        IndexChangeSupport changeSupport = Lookup.getDefault().lookup(IndexChangeSupport.class);
        if (changeSupport != null) {
            changeSupport.addChangeListener(INVALIDATE_LISTENER);
        }
    }

    /**
     * Creates a new instance of BladeIndex
     */
    private BladeIndex(Project project) throws IOException {
        //QuerySupport now refreshes the roots indexes so it can held until the source roots are valid
        sourceRoots = QuerySupport.findRoots(project,
                null /* all source roots */,
                Collections.<String>emptyList(),
                Collections.<String>emptyList());
        this.querySupport = QuerySupport.forRoots(BladeIndexer.Factory.NAME, BladeIndexer.Factory.VERSION, sourceRoots.toArray(new FileObject[]{}));
    }

    public Collection<IndexedElement> findYieldsByPrefix(String prefix, MatchType matchType) {
        return findByPrefix(BladeIndexer.YIELD_DECLARATION, prefix, BladeElement.Kind.YIELD, matchType);
    }

    public Collection<IndexedElement> findAllYields() {
        return findAll(BladeIndexer.YIELD_DECLARATION, BladeElement.Kind.YIELD);
    }

    /**
     * TODO refactor to query or Name
     *
     * @param keyName
     * @param prefix
     * @param type
     * @return
     */
    public Collection<IndexedElement> findByPrefix(String keyName, String prefix, BladeElement.Kind type, MatchType matchType) {
        Collection<IndexedElement> result = new ArrayList<IndexedElement>();
        //this query will help us find a index name from all the indexed file
        String query = "(.*)" + prefix.replace(")", "").replace("(", "") + "(.*)";
        QuerySupport.Kind queryType = QuerySupport.Kind.REGEXP;
        Collection<? extends IndexResult> indexResults = query(keyName, query, queryType);
        for (IndexResult indexResult : indexResults) {
            FileObject file = indexResult.getFile();
            String value = indexResult.getValue(keyName);
            String[] items = value.split(BladeIndexer.VALUE_SEPARATOR);
            for (String item : items) {
                OffsetRange range = OffsetRange.NONE;
                String name = item;
                if (item.indexOf(BladeIndexer.ITEMS_SEPARATOR) > -1){
                    String[] split = item.split(BladeIndexer.ITEMS_SEPARATOR);
                    name = split[0];
                    if (split.length > 2) {
                        int start = Integer.parseInt(split[2]);
                        range = new OffsetRange(start, start + name.length());
                    }
                }        

                if ((matchType.equals(MatchType.EXACT) && name.equals(prefix))){
                    //ok
                } else if(matchType.equals(MatchType.PREFIX) && (name.startsWith(prefix) || name.endsWith(prefix))) {
                    //ok
                } else {
                    continue;
                }

                IndexedElement indexedElement = IndexedElement.create(file, name, type, range);
                result.add(indexedElement);
            }

        }

        return result;
    }

    public Collection<IndexedElement> findByPrefix(String keyName, String prefix, BladeElement.Kind type, String searchKeys) {
        Collection<IndexedElement> result = new ArrayList<IndexedElement>();
        Collection<? extends IndexResult> indexResults = query(keyName, prefix, QuerySupport.Kind.PREFIX);
        for (IndexResult indexResult : indexResults) {
            IndexedElement indexedElement = IndexedElement.create(indexResult, keyName, type);
            result.add(indexedElement);
        }

        return result;
    }

    /**
     * TO WORK on types
     *
     * @param keyName
     * @return
     */
    private Collection<IndexedElement> findAll(String keyName, BladeElement.Kind type) {
        return findByPrefix(keyName, "", type, MatchType.ALL);
    }

    /**
     * Get all indexed blade files from the project.
     *
     * @return
     */
    public Collection<FileObject> getAllIndexedFiles() {
        Collection<? extends IndexResult> results = query(BladeIndexer.BLADE_CONTENT_KEY, "", QuerySupport.Kind.PREFIX);
        Collection<FileObject> bladeFiles = new LinkedList<>();
        for (IndexResult result : filterDeletedFiles(results)) {
            if (result.getFile().getMIMEType().equals(BladeLanguage.BLADE_MIME_TYPE)) {
                bladeFiles.add(result.getFile());
            }
        }
        return bladeFiles;
    }

    /**
     *
     * @param keyName
     * @param indexPrefix
     * @param kind
     * @return
     */
    public Collection<? extends IndexResult> query(final String keyName, final String indexPrefix,
            final QuerySupport.Kind kind) {
        if (querySupport == null) {
            return Collections.<IndexResult>emptySet();
        }

        try {
            //TODO implement a cache system
            //no need to load or the fields
            String fieldsToLoad = keyName;
            Collection<? extends IndexResult> result = querySupport.query(
                    keyName, indexPrefix, kind, fieldsToLoad);
            return result;
        } catch (IOException ioe) {
            LOGGER.log(Level.WARNING, null, ioe);
        }
        return Collections.<IndexResult>emptySet();
    }

    //if an indexed file is delete and IndexerFactory.filesDeleted() hasn't removed
    //the entris from index yet, then we may receive IndexResult-s with null file.
    //Please note that the IndexResult.getFile() result is cached, so the IndexResult.getFile()
    //won't become null after the query is run, but the file will simply become invalid.
    private Collection<? extends IndexResult> filterDeletedFiles(Collection<? extends IndexResult> queryResult) {
        Collection<IndexResult> filtered = new ArrayList<>();
        for (IndexResult result : queryResult) {
            if (result.getFile() != null) {
                filtered.add(result);
            }
        }
        return filtered;
    }

    private static final String REGEXP_CHARS_TO_ENCODE = ".\\?*+&:{}[]()^$";

    static String encodeValueForRegexp(String value) {
        StringBuilder encoded = new StringBuilder();

        out:
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            for (int j = 0; j < REGEXP_CHARS_TO_ENCODE.length(); j++) {
                if (c == REGEXP_CHARS_TO_ENCODE.charAt(j)) {
                    encoded.append('\\');
                    encoded.append(c);
                    continue out;
                }
            }
            encoded.append(c);
        }
        return encoded.toString();
    }

    private static class CacheKey {

        private final BladeIndex index;

        private final String fieldName;

        private final String fieldValue;

        private final QuerySupport.Kind kind;

        public CacheKey(BladeIndex index, String fieldName, String fieldValue, QuerySupport.Kind kind) {
            this.index = index;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
            this.kind = kind;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 41 * hash + (this.index != null ? this.index.hashCode() : 0);
            hash = 41 * hash + (this.fieldName != null ? this.fieldName.hashCode() : 0);
            hash = 41 * hash + (this.fieldValue != null ? this.fieldValue.hashCode() : 0);
            hash = 41 * hash + (this.kind != null ? this.kind.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final CacheKey other = (CacheKey) obj;
            if (this.index != other.index && (this.index == null || !this.index.equals(other.index))) {
                return false;
            }
            if ((this.fieldName == null) ? (other.fieldName != null) : !this.fieldName.equals(other.fieldName)) {
                return false;
            }
            if ((this.fieldValue == null) ? (other.fieldValue != null) : !this.fieldValue.equals(other.fieldValue)) {
                return false;
            }
            if (this.kind != other.kind) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "CacheKey{" + "index=" + index + ", fieldName=" + fieldName + ", fieldValue=" + fieldValue + ", kind=" + kind + '}';
        }
    }

    private static class CacheValue {

        private final Set<String> fields;

        private final Collection<? extends IndexResult> result;

        public CacheValue(String[] fields, Collection<? extends IndexResult> result) {
            this.fields = new HashSet<String>(Arrays.asList(fields));
            this.result = result;
        }

        public Collection<? extends IndexResult> getResult() {
            return result;
        }

        public boolean contains(String... fieldsToLoad) {
            return fields.containsAll(Arrays.asList(fieldsToLoad));
        }
    }

    private static class StatsKey {

        private final String[] fields;

        public StatsKey(String[] fields) {
            this.fields = fields.clone();
            Arrays.sort(this.fields);
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + Arrays.deepHashCode(this.fields);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final StatsKey other = (StatsKey) obj;
            if (!Arrays.deepEquals(this.fields, other.fields)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return Arrays.deepToString(fields);
        }
    }

    private static class StatsValue {

        private final int requests;

        private final int count;

        private final long size;

        public StatsValue(int requests, int count, long size) {
            this.requests = requests;
            this.count = count;
            this.size = size;
        }

        public int getRequests() {
            return requests;
        }

        public int getCount() {
            return count;
        }

        public long getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "StatsValue{" + "requests=" + requests + ", average=" + (count != 0 ? (size / count) : 0)
                    + ", count=" + count + ", size=" + size + '}';
        }

    }

}
