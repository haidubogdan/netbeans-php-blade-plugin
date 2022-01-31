package org.netbeans.modules.php.blade.editor.index.api;

import org.netbeans.modules.parsing.spi.indexing.support.IndexDocument;

/**
 *
 * @author bhaidu
 */
public abstract class BladeIndexModel {
    
    /**
     * Stores the model to the given {@link IndexDocument}
     * @param document 
     */
    public abstract void storeToIndex(IndexDocument document);
    
}
