package org.netbeans.modules.php.blade.editor.model;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.netbeans.modules.php.blade.editor.model.api.Occurence;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.visitors.DefaultPathVisitor;
import org.openide.filesystems.FileObject;
import javax.swing.text.Document;
import org.openide.util.RequestProcessor;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.BadLocationException;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author bhaidu
 */
public class ModelVisitor extends DefaultPathVisitor {

    private boolean lazyScan = true;
    private static final Logger LOGGER = Logger.getLogger(ModelVisitor.class.getName());
    private final ModelBuilder modelBuilder;
    private final OccurrenceBuilder occurencesBuilder;

    private final BladeParserResult parserResult;
    private static final RequestProcessor RP = new RequestProcessor(ModelVisitor.class);

    public ModelVisitor(BladeParserResult parserResult, OccurrenceBuilder occurrenceBuilder) {
        FileObject file = parserResult.getSnapshot().getSource().getFileObject();
        this.modelBuilder = new ModelBuilder(file);
        this.occurencesBuilder = occurrenceBuilder;
        this.parserResult = parserResult;
    }

    public ModelVisitor(BladeParserResult parserResult) {
        FileObject file = parserResult.getSnapshot().getSource().getFileObject();
        this.parserResult = parserResult;
        this.modelBuilder = new ModelBuilder(file);
        occurencesBuilder = new OccurrenceBuilder();
    }

    public void init() {
        final BladeProgram root = parserResult.getProgram();
        if (root != null) {
            root.accept(this);
        }
    }

    @Override
    public void scan(ASTNode node) {
        super.scan(node);
    }

    @Override
    public void visit(BladeProgram program) {
        lazyScan = true;
        super.visit(program);
    }

    @Override
    public void visit(BladeSectionStatement node) {
        modelBuilder.build(node, occurencesBuilder);
        super.visit(node);
    }

    @Override
    public void visit(BladeYieldStatement node) {
        modelBuilder.build(node, occurencesBuilder);
        super.visit(node);
    }
    
    @Override
    public void visit(BladeIncludeStatement node) {
        modelBuilder.build(node, occurencesBuilder);
        super.visit(node);
    }
    
    @Override
    public void visit(BladeExtendsStatement node) {
        modelBuilder.build(node, occurencesBuilder);
        super.visit(node);
    }

    @Override
    public void visit(InLinePhp node) {

    }
    
    public Collection<DirectiveOccurence> getYields() {
        if (occurencesBuilder != null) {
            return occurencesBuilder.getYields();
        }
        return null;
    }

    @CheckForNull
    public Occurence getOccurence(BladeElement.Kind kind, int offset) {
        if (occurencesBuilder != null) {
            return occurencesBuilder.build(kind, offset);
        }
        return null;
    }

    @CheckForNull
    public Map<BladeElement.Kind, List<Occurence>> getOccurence(BladeElement element) {
        if (occurencesBuilder != null) {
            return occurencesBuilder.build(element);
        }
        return Collections.emptyMap();
    }

    private Document createDocument(String mimeType, String contents) {
        Document doc = new DefaultStyledDocument();
        //doc.putProperty(Language.class, PHP.language());
        doc.putProperty("mimeType", mimeType);
        doc.putProperty(Document.StreamDescriptionProperty, parserResult.getSnapshot().getSource().getFileObject());
//        doc.putProperty("")
        try {
            doc.insertString(0, contents, null);
            return doc;
        } catch (BadLocationException ble) {
            throw new IllegalStateException(ble);
        }
    }
}
