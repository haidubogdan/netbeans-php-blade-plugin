package org.netbeans.modules.php.blade.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.openide.filesystems.FileObject;

/**
 * 
 * for the moment nothing implemented here
 * 
 * this might be a way to find the blade version and possible blade directives definitions
 * 
 * @author bhaidu
 */
public class BladeCompilerPath {
    private static final Logger LOGGER = Logger.getLogger(BladeCompilerPath.class.getName());
    private static List<FileObject> compilerFiles = null;

    public static class Item {

        private String filePath;

        public Item(String filePath) {
            this.filePath = filePath;
        }

        public String getFilePath() {
            return filePath;
        }
    }

    public static synchronized List<FileObject> getInternalPath() {
        if (compilerFiles == null) {
            compilerFiles = getInternalFolders();
        }
        return compilerFiles;
    }

    private static List<FileObject> getInternalFolders() {
        assert Thread.holdsLock(BladeCompilerPath.class);

       // List<FileObject> preindexedFolders = PhpSourcePath.getPreindexedFolders();
        //assert !preindexedFolders.contains(null) : "Preindexed folders contains null";
        //FileObject sfsFolder = FileUtil.getConfigFile("PHP/RuntimeLibraries"); // NOI18N
        //List<FileObject> folders = new ArrayList<>(preindexedFolders.size() + 1);
        List<FileObject> folders = new ArrayList<>(
        );
        // #210578
//        if (sfsFolder != null) {
//            folders.add(sfsFolder);
//        } else {
//            LOGGER.info("SFS folder PHP/RuntimeLibraries not found");
//        }
        //folders.addAll(preindexedFolders);
        return folders;
    }
}
