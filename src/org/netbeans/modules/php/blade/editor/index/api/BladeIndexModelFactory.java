package org.netbeans.modules.php.blade.editor.index.api;

import java.util.Collection;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;

/**
 *
 * @author bhaidu
 */
public abstract class BladeIndexModelFactory<T extends BladeIndexModel> {
   
    /**
     * Creates an instance of {@link BladeIndexModel} for the given {@link BladeParserResult}.
     * @param result
     * @return non null instance of the model
     */
    public abstract T getModel(BladeParserResult result);

    /**
     * Builds an instance of {@link BladeIndexModel} from the given {@link IndexResult}
     * @param result
     * @return non null instance of the model
     */
    public abstract T loadFromIndex(IndexResult result);
    
    /**
     * Gets a collection of all index keys which are stored by the {@link #loadFromIndex(org.netbeans.modules.parsing.spi.indexing.support.IndexResult) }
     * @return non null collection of index keys
     */
    public abstract Collection<String> getIndexKeys();
}
