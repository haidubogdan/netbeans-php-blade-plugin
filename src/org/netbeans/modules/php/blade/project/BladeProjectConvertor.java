package org.netbeans.modules.php.blade.project;

import java.io.Closeable;
import java.util.concurrent.Callable;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.ProjectConvertor;
import org.netbeans.spi.project.ui.ProjectProblemsProvider;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author bhaidu
 */
//@ProjectConvertor.Registration(requiredPattern = ".*\\.blade.php", position = 700)
public class BladeProjectConvertor implements ProjectConvertor {

    @StaticResource
    private static final String PROJECT_ICON = "org/netbeans/modules/php/blade/resources/icons/layout.png"; // NOI18N

    @Override
    public Result isProject(FileObject projectDirectory) {
        assert projectDirectory != null;
        String name = projectDirectory.getName();
        if (projectDirectory.isFolder() && projectDirectory.getName().equals("views")) {
            final Lookup transientLkp = ProjectConvertors.createDelegateToOwnerLookup(projectDirectory);
            return new Result(
                    Lookups.exclude(transientLkp, ProjectProblemsProvider.class),
                    new Factory(projectDirectory, name, (Closeable) transientLkp),
                    name,
                    ImageUtilities.image2Icon(ImageUtilities.loadImage(PROJECT_ICON)));
        }
//        FileObject file = projectDirectory.getFileObject(COMPOSER_JSON_FILENAME);
        return null;
    }

    private static final class Factory implements Callable<Project> {

        private final FileObject projectDirectory;
        private final String displayName;
        private final Closeable transientLkp;

        Factory(FileObject projectDirectory, String displayName, Closeable transientLkp) {
            assert projectDirectory != null;
            assert displayName != null : projectDirectory;
            assert transientLkp != null : projectDirectory;
            this.projectDirectory = projectDirectory;
            this.displayName = displayName;
            this.transientLkp = transientLkp;
        }

        @Override
        public Project call() throws Exception {
            transientLkp.close();
//            PROJECT_CONVERTOR_USAGE_LOGGER.log("composer.json"); // NOI18N
            //deleteNbProject();
//            PhpModuleGenerator phpModuleGenerator = Lookup.getDefault().lookup(PhpModuleGenerator.class);
//            assert phpModuleGenerator != null;
//            phpModuleGenerator.createModule(new PhpModuleGenerator.CreateProperties()
//                    .setName(displayName)
//                    .setProjectDirectory(FileUtil.toFile(projectDirectory))
//                    .setSourcesDirectory(FileUtil.toFile(detectSourceRoot()))
//                    .setPhpVersion(PhpVersion.getDefault())
//                    .setCharset(StandardCharsets.UTF_8)
//                    .setAutoconfigured(true));
            Project project = FileOwnerQuery.getOwner(projectDirectory);
            assert project != null : projectDirectory;
            return project;
        }

    }
}
