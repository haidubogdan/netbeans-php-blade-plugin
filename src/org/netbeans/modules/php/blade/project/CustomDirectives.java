package org.netbeans.modules.php.blade.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionHandler;
import org.netbeans.modules.php.blade.editor.parsing.ParsingUtils;
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
    private Map<FileObject, DirectiveNames> customDirectives = new LinkedHashMap<FileObject, DirectiveNames>();
    private final FileChangeListener fileChangeListener = new FileChangeListenerImpl();

    public static CustomDirectives getInstance(Project project) {
        int x = 3;
        if(project == null) {
            throw new NullPointerException("No project found");
        }
        synchronized (INSTANCES) {
            CustomDirectives customDirective = INSTANCES.get(project);
            if(customDirective == null) {
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
            if (path.equals("")){
                continue;
            }
            File file = new File(path);
            if (!file.exists()){
                //remove
                continue;
            }
            FileUtil.addRecursiveListener(fileChangeListener, file);
            FileObject fileObj = FileUtil.toFileObject(file);
            ParsingUtils parsingUtils = new ParsingUtils();
            parsingUtils.parseFileObject(fileObj);
            FunctionInvocationVisitor functionInvocationVisitor = new FunctionInvocationVisitor();
            if (parsingUtils.getParserResult() != null && parsingUtils.getParserResult().getProgram() != null) {
                parsingUtils.getParserResult().getProgram().accept(functionInvocationVisitor);
                List<String> directiveNames = functionInvocationVisitor.getDirectiveNames();
                if (!directiveNames.isEmpty()) {
                    customDirectives.put(fileObj, new DirectiveNames(directiveNames));
                }
            }
        }

    }
    
    private void rescanFile(FileObject file){
        DirectiveNames entry = customDirectives.get(file);
        if (entry != null){
            ParsingUtils parsingUtils = new ParsingUtils();
            parsingUtils.parseFileObject(file);
            FunctionInvocationVisitor functionInvocationVisitor = new FunctionInvocationVisitor();
            if (parsingUtils.getParserResult() != null && parsingUtils.getParserResult().getProgram() != null) {
                parsingUtils.getParserResult().getProgram().accept(functionInvocationVisitor);
                List<String> directiveNames = functionInvocationVisitor.getDirectiveNames();
                if (!directiveNames.isEmpty()) {
                    customDirectives.put(file, new DirectiveNames(directiveNames));
                }
            }
        }
    }

    public Map<FileObject, DirectiveNames> getCustomDirectives() {
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
            Iterator iter = parameters.iterator();
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
            int test = 3;
        }

        private void processFile(FileObject file) {
            assert file.isData() : file;
            CustomDirectives.getInstance(project).rescanFile(file);
        }

    }
}
