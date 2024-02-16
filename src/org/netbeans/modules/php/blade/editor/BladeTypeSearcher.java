package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.IndexSearcher;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport.Kind;
import org.netbeans.modules.php.blade.csl.elements.PathElement;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 * we will not have a valid project as it requires blade to have it's own
 * project so we need to do a hack and load an instance of Project
 *
 * @author bhaidu
 */
public class BladeTypeSearcher implements IndexSearcher {
//    private static final Logger LOGGER = Logger.getLogger(BladeTypeSearcher.class.getSimpleName());

    @Override
    public Set<? extends Descriptor> getTypes(Project project, String textForQuery, Kind searchType, Helper helper) {
        Set<BladeTypeDescriptor> typeResults = new HashSet<>();
        if (project == null) {
            //project = BladeProjectProperties.getInstance().project;
            return typeResults;
        }
        if (project != null) {
            try {
                ProjectInformation pi = ProjectUtils.getInformation(project);
                String projectName = pi.getDisplayName();
                BladeIndex index = BladeIndex.get(project);
                List<BladeIndex.IndexedReferenceId> results = index.getBladePaths(textForQuery);
                for (BladeIndex.IndexedReferenceId reference : results) {
                    PathElement path = new PathElement(reference.getIdenfiier(), reference.getOriginFile());
                    typeResults.add(new BladeTypeDescriptor(helper, path, projectName));
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return typeResults;
    }

    @Override
    public Set<? extends Descriptor> getSymbols(Project project, String textForQuery, Kind originalkind, Helper helper) {
        Set<BladeTypeDescriptor> result = new HashSet<>();
        return result;
    }

    private static class BladeTypeDescriptor extends Descriptor {

        private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/"; //NOI18N
        private final Helper helper;
        private final PathElement element;
        private final String projectName;

        public BladeTypeDescriptor(Helper helper, PathElement element, String projectName) {
            this.helper = helper;
            this.element = element;
            this.projectName = projectName;
        }

        @Override
        public ElementHandle getElement() {
            return element;

        }

        @Override
        public String getSimpleName() {
            return element.getName();
        }

        @Override
        public String getOuterName() {
            return null;
        }

        @Override
        public String getTypeName() {
            return element.getName();
        }

        @Override
        public String getContextName() {
            StringBuilder sb = new StringBuilder();

            FileObject file = getFileObject();
            if (file != null) {
                sb.append(FileUtil.getFileDisplayName(file));
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }

        @Override
        public String getProjectName() {
            return projectName;
        }

        @Override
        public Icon getIcon() {
            return helper.getIcon(element);
        }

        @Override
        public Icon getProjectIcon() {
            return ResourceUtilities.loadResourceIcon("icons/file.png");
        }

        @Override
        public FileObject getFileObject() {
            return element.getFileObject();
        }

        @Override
        public int getOffset() {
            return 0;
        }

        @Override
        public void open() {
            FileObject fileObject = element.getFileObject();
            if (fileObject != null) {
                GsfUtilities.open(fileObject, 0, element.getName());
            }
        }

    }
}
