package org.netbeans.php.blade.api.test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import javax.swing.text.Document;

import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.junit.NbTestCase;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;


/**
 *
 * @author bhaidu
 */
public class BladeTestBase extends NbTestCase {

    public BladeTestBase(String testName) {
        super(testName);
    }

    private Map<String, ClassPath> classPathsForTest;
    private Object[] extraLookupContent = null;

    @Override
    protected void setUp() throws Exception {
        /*
        MockLookup.init();
        MockServices.setServices(new Class[] {FileBasedURLMapper.class});
        MockLookup.setInstances(
                new SimpleFileOwnerQueryImplementation(),
                new TestLanguageProvider());

        assert Lookup.getDefault().lookup(TestLanguageProvider.class) != null;

        try {
            TestLanguageProvider.register(PHPTokenId.language());
            TestLanguageProvider.register(BladeTokenId.language());
        } catch (IllegalStateException ise) {
            // Ignore -- we've already registered this either via layers or other means
        }*/
        super.setUp();
    }

    public File getDataDir() {
        URL codebase = getClass().getProtectionDomain().getCodeSource().getLocation();
        File dataDir = null;
        try {
            dataDir = new File(new File(codebase.toURI()), "data");
        } catch (URISyntaxException x) {
            throw new Error(x);
        }
        return dataDir;
    }

}
