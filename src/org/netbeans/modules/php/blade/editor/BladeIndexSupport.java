package org.netbeans.modules.php.blade.editor;


import java.io.IOException;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.DataLoadersBridge;

import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndex;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
/**
 *
 * @author bhaidu
 */
@NbBundle.Messages("BladeResolver=Blade Files")
@MIMEResolver.ExtensionRegistration(
    mimeType=BladeLanguage.BLADE_MIME_TYPE,
    position=300,
    displayName="#BladeResolver",
    extension={ "blade.php" }
)
public class BladeIndexSupport {
    private static final Logger LOGGER = Logger.getLogger(BladeIndex.class.getSimpleName());
    private static final WeakHashMap<Project, BladeIndexSupport> INSTANCIES = new WeakHashMap<>();

    /**
     * 
     * @param source
     * @return 
     */
    public static BladeIndexSupport findFor(Source source) {
	FileObject fo = source.getFileObject();
	if (fo == null) {
	    return null;
	} else {
	    return findFor(fo);
	}
    }

    public static BladeIndexSupport findFor(Document doc) {
	return findFor(DataLoadersBridge.getDefault().getFileObject(doc));
    }

    /**
     * 
     * the blade project support enables us to get the saved index
     * triggered by codeCompletion, DelcarationFinder
     * 
     * @param fo
     * @return 
     */
    public static BladeIndexSupport findFor(FileObject fo) {
	try {
	    Project p = FileOwnerQuery.getOwner(fo);
            //Sources sources = ProjectUtils.getSources(p);
            //SourceGroup[] sgs = sources.getSourceGroups(Sources.TYPE_GENERIC); // org.netbeans.api.java.project.JavaProjectConstants.SOURCES_TYPE_JAVA
            if (p == null) {
		return null;
	    }
            String projectName = p.getClass().getSimpleName();
            //might be an internal project from a composer file detection
            if (!(projectName.equals("PhpProject"))){
                FileObject parent = p.getProjectDirectory().getParent();
                p = FileOwnerQuery.getOwner(parent); //getting the parent project
                if (p == null || !(p.getClass().getSimpleName().equals("PhpProject"))) {
                    LOGGER.log(Level.WARNING, "project for blade file not found {0}", fo.getPath());
                    return null;
                }
            }
            synchronized (INSTANCIES) {
		BladeIndexSupport instance = INSTANCIES.get(p);
		if (instance == null) {
		    instance = new BladeIndexSupport(p);
		    INSTANCIES.put(p, instance);
		}
                return instance;
	    }
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}

	return null;
    }
    private final Project project;
    private final BladeIndex index;

    public BladeIndexSupport(Project project) throws IOException {
	this.project = project;
	this.index = BladeIndex.create(project);
    }

    public BladeIndex getIndex() {
	return index;
    }

    public Project getProject() {
	return project;
    }
}