package org.netbeans.modules.php.blade.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.common.WebUtils;
import org.netbeans.modules.php.blade.editor.index.api.IndexedElement;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class Model {
    private static final Logger LOGGER = Logger.getLogger(Model.class.getSimpleName());
    private final Snapshot snapshot;
    private ModelVisitor modelVisitor;
    private final BladeParserResult info;
    private final Collection<BladeModelElement> yields;
    private OccurencesSupport occurencesSupport;

    Model(BladeParserResult result) {
        snapshot = result.getSnapshot();
        yields = getYields(result);
        info = result;
    }

    public static Model getModel(BladeParserResult result) {
        Model curr = result.getModel();
        return curr;
    }

    public FileObject getFile() {
        return snapshot.getSource().getFileObject();
    }

    public static Model getModel(FileObject file) throws ParseException {
        final AtomicReference<Model> model_ref = new AtomicReference<>();
        Source source = Source.create(file);
        ParserManager.parse(Collections.singleton(source), new UserTask() {
            @Override
            public void run(ResultIterator resultIterator) throws Exception {
                ResultIterator cssRI = WebUtils.getResultIterator(resultIterator, BladeLanguage.BLADE_MIME_TYPE);
                if (cssRI != null) {
                    BladeParserResult result = (BladeParserResult) cssRI.getParserResult();
                    if (result != null) {
                        model_ref.set(Model.getModel(result));
                    }
                }
            }
        });

        return model_ref.get();
    }

    private Collection<BladeModelElement> getYields(BladeParserResult result) {
        ModelVisitor visitor = getModelVisitor(result);
        Collection<DirectiveOccurence> foundYields = visitor.getYields();
        final Collection<BladeModelElement> items = new ArrayList<>();
        
        for (DirectiveOccurence yield : foundYields){
            String label = yield.getLabel();
            OffsetRange variableRange = yield.getOffsetRange();
            IndexedElement handle = IndexedElement.create(getFile(),
                    label,
                    BladeElement.Kind.YIELD,
                    variableRange
            );

            OffsetRange scope = null; //TODO implement
            BladeModelElement element = new BladeModelElement(handle, variableRange, scope);
            items.add(element);
        }

        return items;
    }

    public Collection<BladeModelElement> getElements() {
        Collection<BladeModelElement> all = new ArrayList<>();
        all.addAll(getYields());
        return all;
    }

    public Collection<BladeModelElement> getYields(int offset) {
        Collection<BladeModelElement> visible = new ArrayList<>();
        for (BladeModelElement var : getYields()) {
            OffsetRange context = var.getScope();
            if (context == null || context.containsInclusive(offset)) {
                visible.add(var);
            }
        }
        return visible;
    }

    public Collection<BladeModelElement> getYields() {
        return yields;
    }

    public synchronized OccurencesSupport getOccurencesSupport(BladeParserResult result, final int offset) {
        ModelVisitor visitor = getModelVisitor(result);

        if (occurencesSupport == null || occurencesSupport.offset != offset) {
            occurencesSupport = new OccurencesSupport(visitor, offset);
        }
        return occurencesSupport;
    }
    
    synchronized ModelVisitor getModelVisitor() {
        if (modelVisitor == null) {
            long start = System.currentTimeMillis();
            //??occurence builder
            OccurrenceBuilder occurenceBuilder = new OccurrenceBuilder(info);
            modelVisitor = new ModelVisitor(info, occurenceBuilder);
            modelVisitor.init();
            long end = System.currentTimeMillis();
            LOGGER.log(Level.FINE, "Building model took: {0}", (end - start));
        }
        return modelVisitor;
    }
    
    /**
     * something got wrong
     * @param result
     * @return 
     */
    synchronized ModelVisitor getModelVisitor(BladeParserResult result) {
        if (modelVisitor == null) {
            long start = System.currentTimeMillis();
            //??occurence builder
            OccurrenceBuilder occurenceBuilder = new OccurrenceBuilder(result);
            modelVisitor = new ModelVisitor(result, occurenceBuilder);
            modelVisitor.init();
            long end = System.currentTimeMillis();
            LOGGER.log(Level.FINE, "Building model took: {0}", (end - start));
        }
        return modelVisitor;
    }
}
