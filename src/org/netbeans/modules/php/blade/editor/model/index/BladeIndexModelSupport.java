package org.netbeans.modules.php.blade.editor.model.index;

import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndexModel;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndexModelFactory;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.openide.util.Lookup;

/**
 * factory for BladeDataIndexModel
 * 
 * @author bhaidu
 */
public class BladeIndexModelSupport {

    public static Collection<BladeIndexModel> getModels(BladeParserResult result) {
        Collection<BladeIndexModel> models = new ArrayList<>();
        Collection<? extends BladeIndexModelFactory> factories = Lookup.getDefault().lookupAll(BladeIndexModelFactory.class);

        for (BladeIndexModelFactory factory : factories) {
            BladeIndexModel model = factory.getModel(result);
            if (model != null) {
                models.add(model);
            }
        }
        return models;
    }

    public static BladeIndexModelFactory getFactory(Class modelFactoryClass) {
        Collection<? extends BladeIndexModelFactory> factories = Lookup.getDefault().lookupAll(BladeIndexModelFactory.class);
        for (BladeIndexModelFactory factory : factories) {
            if (factory.getClass().equals(modelFactoryClass)) {
                return factory;
            }
        }
        return null;
    }
    
}
