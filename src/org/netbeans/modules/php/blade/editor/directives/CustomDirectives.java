package org.netbeans.modules.php.blade.editor.directives;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.editor.parser.astnodes.Expression;
import org.netbeans.modules.php.editor.parser.astnodes.FunctionInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.Scalar;
import org.openide.filesystems.FileChangeAdapter;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bhaidu
 */
public final class CustomDirectives {

    private final Project project;
    private static final Map<Project, CustomDirectives> INSTANCES = new WeakHashMap<>();
    private final Map<FileObject, List<String>> customDirectives = new LinkedHashMap<>();

    public List<String> customDirectiveNames = new ArrayList<>();

    private final FileChangeListener fileChangeListener = new FileChangeListenerImpl();

    public static CustomDirectives getInstance(Project project) {
        if (project == null) {
            return new CustomDirectives();
        }
        synchronized (INSTANCES) {
            CustomDirectives customDirective = INSTANCES.get(project);
            if (customDirective == null) {
                customDirective = new CustomDirectives(project);
                INSTANCES.put(project, customDirective);
            }
            return customDirective;
        }
    }

    public static CustomDirectives resetInstance(Project project) {
        CustomDirectives customDirective = new CustomDirectives(project);
        INSTANCES.put(project, customDirective);
        return customDirective;
    }

    private CustomDirectives() {
        this.project = null;
    }

    private CustomDirectives(Project project) {
        this.project = project;
        extractCustomDirectives();
    }

    private void extractCustomDirectives() {
        String[] compilerPathList = BladeProjectProperties.getInstance(project).getCompilerPathList();

        if (compilerPathList.length == 0) {
            return;
        }
        for (String path : compilerPathList) {
            if (path.equals("")) {
                continue;
            }
            File file = new File(path);
            if (!file.exists()) {
                //remove
                continue;
            }
            FileUtil.addRecursiveListener(fileChangeListener, file);
            FileObject fileObj = FileUtil.toFileObject(file);
            addDirectiveNamesFromFile(fileObj);
        }

    }

    private void rescanFile(FileObject file) {
        List<String> entry = customDirectives.get(file);
        if (!entry.isEmpty()) {
            addDirectiveNamesFromFile(file);
        }
    }

    public void addDirectiveNamesFromFile(FileObject file) {
        ParsingUtils parsingUtils = new ParsingUtils();
        parsingUtils.parseFileObject(file);
        FunctionInvocationVisitor functionInvocationVisitor = new FunctionInvocationVisitor();
        if (parsingUtils.getParserResult() != null && parsingUtils.getParserResult().getProgram() != null) {
            parsingUtils.getParserResult().getProgram().accept(functionInvocationVisitor);
            //TODO add parameters list
            customDirectiveNames = functionInvocationVisitor.getDirectiveNames();

            if (customDirectiveNames.isEmpty()) {
                return;
            }

            customDirectives.put(file, customDirectiveNames);
        }
    }

    public Map<FileObject, List<String>> getCustomDirectives() {
        return customDirectives;
    }

    public class DirectiveNames {

        private final List<String> directiveNames;

        public DirectiveNames(List<String> directiveNames) {
            this.directiveNames = directiveNames;
        }

        public List<String> getList() {
            return directiveNames;
        }
    }

    /**
     * we are scanning the php ast nodes to search for the use of directive
     * method the first parameter of the called method will be the custom
     * directive name
     */
    private class FunctionInvocationVisitor extends org.netbeans.modules.php.editor.parser.astnodes.visitors.DefaultVisitor {

        private final List<String> directiveNames;

        public FunctionInvocationVisitor() {
            this.directiveNames = new ArrayList<>();
        }

        @Override
        public void scan(org.netbeans.modules.php.editor.parser.astnodes.ASTNode node) {
            if (node != null) {
                super.scan(node);
            }
        }

        @Override
        public void visit(FunctionInvocation node) {
            String functionName = node.getFunctionName().toString();
            if (!functionName.equals("directive")) {
                return;
            }
            List<Expression> parameters = node.getParameters();
            Iterator<?> iter = parameters.iterator();
            Expression directiveName = (Expression) iter.next();
            if (directiveName != null && directiveName instanceof Scalar) {
                Scalar name = (Scalar) directiveName;
                directiveNames.add("@" + name.getStringValue().replaceAll("^[\"|\']|[\"|[\']]$", ""));
            }
        }

        public List<String> getDirectiveNames() {
            return directiveNames;
        }
    }

    private final class FileChangeListenerImpl extends FileChangeAdapter {

        @Override
        public void fileFolderCreated(FileEvent fe) {

        }

        @Override
        public void fileChanged(FileEvent fe) {
            processFile(fe.getFile());
        }

        @Override
        public void fileDataCreated(FileEvent fe) {

        }

        private void processFile(FileObject file) {
            assert file.isData() : file;
            CustomDirectives.getInstance(project).rescanFile(file);
        }

    }

    public void filterAction(FilterCallback callback) {
        for (Map.Entry<FileObject, List<String>> entry : customDirectives.entrySet()) {
            if (!entry.getKey().isValid()) {
                continue;
            }

            for (String directiveName : entry.getValue()) {
                 callback.filterDirectiveName(directiveName, entry.getKey());
            }
           
        }
    }
    
    public void filterAction(FilterCallbackDeclaration callback) {
        for (Map.Entry<FileObject, List<String>> entry : customDirectives.entrySet()) {
            if (!entry.getKey().isValid()) {
                continue;
            }

            for (String directiveName : entry.getValue()) {
                 callback.filterDirectiveName(directiveName, entry.getKey());
            }
           
        }
    }

    public static interface FilterCallback {

        public void filterDirectiveName(String directiveName, FileObject file);
    }
    
    public static abstract class FilterCallbackDeclaration {
        protected DeclarationFinder.DeclarationLocation location ;
        
        public FilterCallbackDeclaration(DeclarationFinder.DeclarationLocation location){
            this.location = location;
        }

        public void filterDirectiveName(String directiveName, FileObject file){
            
        }
    }
}
