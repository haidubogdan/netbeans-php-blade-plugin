package org.netbeans.modules.php.blade.editor.model;

import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeExtendsStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeIncludeStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeSectionStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeYieldStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveWithPath;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class ModelBuilder {

    private final FileObject fileObject;

    ModelBuilder(FileObject file) {
        this.fileObject = file;
    }

    void build(BladeSectionStatement node, OccurrenceBuilder occurencesBuilder) {
        DirectiveOccurence directive = ModelElementFactory.create((DirectiveWithPath) node, this);
        occurencesBuilder.prepareSections(directive);
    }

    void build(BladeYieldStatement node, OccurrenceBuilder occurencesBuilder) {
        DirectiveOccurence directive = ModelElementFactory.create((DirectiveWithPath) node, this);
        occurencesBuilder.prepareYields(directive);
    }
    
    void build(BladeIncludeStatement node, OccurrenceBuilder occurencesBuilder) {
        DirectiveOccurence directive = ModelElementFactory.create((DirectiveWithPath) node, this);
        occurencesBuilder.prepareIncludes(directive);
    }
    
    void build(BladeExtendsStatement node, OccurrenceBuilder occurencesBuilder) {
        DirectiveOccurence directive = ModelElementFactory.create((DirectiveWithPath) node, this);
        //use it as an include
        occurencesBuilder.prepareIncludes(directive);
    }

    public FileObject getFileObject() {
        return fileObject;
    }

    private static final class ModelElementFactory {

        private ModelElementFactory() {
        }
        
        static DirectiveOccurence create(DirectiveWithPath node, ModelBuilder context) {
            return new DirectiveOccurence(node, context.getFileObject());
        }
    }
}
