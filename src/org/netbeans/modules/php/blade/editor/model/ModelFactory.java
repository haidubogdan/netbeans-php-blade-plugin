package org.netbeans.modules.php.blade.editor.model;

import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;

/**
 *
 * @author bhaidu
 */
public final class ModelFactory {

    private ModelFactory() {
    }

    @NonNull
    public static Model getModel(BladeParserResult info) {
        return new Model(info);
    }
}
