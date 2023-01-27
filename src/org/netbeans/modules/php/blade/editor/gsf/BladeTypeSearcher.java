package org.netbeans.modules.php.blade.editor.gsf;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.IndexSearcher;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport.Kind;
import org.netbeans.modules.php.blade.editor.model.api.BladePathElement;
import org.netbeans.modules.php.blade.editor.index.BladeIndexer;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.util.Exceptions;

/**
 * NOT WORKING AS IT NEEDS TO BE A BLADE PROJECT
 *
 * @author bhaidu
 */
public class BladeTypeSearcher implements IndexSearcher {
    private static final Logger LOGGER = Logger.getLogger(BladeTypeSearcher.class.getSimpleName());

    @Override
    public Set<? extends Descriptor> getTypes(Project project, String textForQuery, Kind searchType, Helper helper) {
        Set<BladeTypeDescriptor> typeResults = new HashSet<>();
        
        if (project == null) { //blade project is null
            try {
                Collection<FileObject> sourceRoots = QuerySupport.findRoots(project,
                        null /* all source roots */,
                        Collections.<String>emptyList(),
                        Collections.<String>emptyList());
                //TODO sanitaize text
                String query = "(.*)" + textForQuery.replace(")", "").replace("(", "") + "(.*)";
                //search for blade paths
                //TODO make a BladeInex static function
                //adapt elements to blade
            } catch (Exception ex) {
                LOGGER.log(Level.WARNING, null, ex);
                Exceptions.printStackTrace(ex);
            }
            return typeResults;
        }
        return null;
    }

    @Override
    public Set<? extends Descriptor> getSymbols(Project project, String textForQuery, Kind originalkind, Helper helper) {
        Set<BladeTypeDescriptor> result = new HashSet<>();
        return result;
    }

    private static class BladeTypeDescriptor extends Descriptor {

        private final Helper helper;
        private final BladePathElement element;
        private String projectName;
        private Icon projectIcon;

        public BladeTypeDescriptor(Helper helper, BladePathElement element) {
            this.helper = helper;
            this.element = element;
            this.projectName = null;
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
            if (projectName == null) {
                initProjectInfo();
            }
            return projectName;
        }

        @Override
        public Icon getIcon() {
            return helper.getIcon(element);
        }

        @Override
        public Icon getProjectIcon() {
            if (projectName == null) {
                initProjectInfo();
            }
            return projectIcon;
        }

        @Override
        public FileObject getFileObject() {
            return element.getFileObject();
        }

        @Override
        public int getOffset() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void open() {
            FileObject fileObject = element.getFileObject();
            if (fileObject != null) {
                GsfUtilities.open(fileObject, element.getOffset(), element.getName());
            }
        }

        private void initProjectInfo() {
            FileObject fo = element.getFileObject();
            if (fo != null) {
                Project p = ProjectConvertors.getNonConvertorOwner(fo);
                if (p != null) {
                    ProjectInformation pi = ProjectUtils.getInformation(p);
                    projectName = pi.getDisplayName();
                    projectIcon = pi.getIcon();
                }
            }

            if (projectName == null) {
                projectName = "";
            }
        }
    }
}
