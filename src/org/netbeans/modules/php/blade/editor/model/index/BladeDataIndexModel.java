package org.netbeans.modules.php.blade.editor.model.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.spi.indexing.support.IndexDocument;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.php.blade.editor.index.BladeIndexer;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndexModel;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndexModelFactory;
import org.netbeans.modules.php.blade.editor.index.api.IndexedElement;
import org.netbeans.modules.php.blade.editor.model.BladeModelElement;
import org.netbeans.modules.php.blade.editor.model.BladeElementType;
import org.netbeans.modules.php.blade.editor.model.Model;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 * not used this is just a sample of how we can implement indexing with model
 * 
 * @author bhaidu
 */
public class BladeDataIndexModel extends BladeIndexModel {
    
    private static final String VALUE_SEPARATOR = ",";
    private static final String ITEMS_SEPARATOR = "/";
    private Collection<IndexedElement> yields;
    
    public BladeDataIndexModel(Collection<IndexedElement> yields) {
        this.yields = yields;
    }
    
    public Collection<IndexedElement> getYields() {
        return yields;
    }

    @Override
    public void storeToIndex(IndexDocument document) {
        storeItems(yields, document, BladeIndexer.YIELD_INDEX_KEY);
    }

    private void storeItems(Collection<? extends IndexedElement> items, IndexDocument document, String key) {
        Iterator<? extends IndexedElement> i = items.iterator();
        StringBuilder sb = new StringBuilder();
        while (i.hasNext()) {
            IndexedElement handle = i.next();
            sb.append(handle.getName());
            sb.append(ITEMS_SEPARATOR);
            sb.append(handle.getType().getIndexCode());
            sb.append(ITEMS_SEPARATOR);
            if (handle.getOffsetRange() != null){
                sb.append(handle.getOffsetRange().getStart());
                sb.append(ITEMS_SEPARATOR);
            }
            if (i.hasNext()) {
                sb.append(VALUE_SEPARATOR); //NOI18N
            }
        }
        document.addPair(key, sb.toString(), true, true);
    }

    @ServiceProvider(service = BladeIndexModelFactory.class)
    public static final class Factory extends BladeIndexModelFactory {
        @Override
        public BladeDataIndexModel getModel(BladeParserResult result) {
            Model model = Model.getModel(result);
            Collection<BladeModelElement> yields = model.getYields();
            return new BladeDataIndexModel(
                    BladeModelElement.toHandles(yields));
        }

        @Override
        public BladeIndexModel loadFromIndex(IndexResult result) {
            String yields = result.getValue(BladeIndexer.YIELD_INDEX_KEY);
            return new BladeDataIndexModel(
                    parseItems(yields, result.getFile()));
        }

        @Override
        public Collection getIndexKeys() {
            return BladeIndexer.INDEX_KEYS;
        }

        private Collection<IndexedElement> parseItems(String value, FileObject file) {
            if (value == null || value.isEmpty()) {
                return Collections.emptyList();
            }
            String[] items = value.split(VALUE_SEPARATOR);
            Collection<IndexedElement> handles = new ArrayList<>(items.length);
            for (String item : items) {
                OffsetRange range = null;
                String[] split = item.split(ITEMS_SEPARATOR);
                String name = split[0];
                String typeIndexCode = split[1];
                if (split.length > 2){
                    int start = Integer.parseInt(split[2]);
                    range = new OffsetRange(start, start + name.length());
                }
                BladeElementType type = BladeElementType.forIndexCode(typeIndexCode);
                if (type.getIndexCode().equals("yield")){
                    IndexedElement handle = IndexedElement.create(file, name, org.netbeans.modules.php.blade.editor.model.api.BladeElement.Kind.YIELD, range);
                    handles.add(handle);
                }
            }
            return handles;
        }
    }
}
