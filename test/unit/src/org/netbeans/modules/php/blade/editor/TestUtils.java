/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.blade.editor;

import java.beans.PropertyVetoException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.junit.Assert;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.project.Project;
import org.netbeans.junit.NbTestCase;
import org.netbeans.spi.editor.mimelookup.MimeDataProvider;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.netbeans.spi.project.support.ant.EditableProperties;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.LocalFileSystem;
import org.openide.filesystems.MultiFileSystem;
import org.openide.filesystems.Repository;
import org.openide.filesystems.URLMapper;
import org.openide.filesystems.XMLFileSystem;
import org.openide.modules.InstalledFileLocator;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
import org.openide.util.lookup.ServiceProvider;
import org.xml.sax.SAXException;

/**
 * Help set up org.netbeans.api.project.*Test.
 * @author Jesse Glick
 */
public final class TestUtils extends ProxyLookup {
    
    private static TestUtils DEFAULT;
    private static final int BUFFER = 2048;
    
    /** Do not call directly */
    public TestUtils() {
        Assert.assertNull(DEFAULT);
        DEFAULT = this;
    }
    
    private static boolean warned = false;
    /**
     * Create a scratch directory for tests.
     * Will be in /tmp or whatever, and will be empty.
     * If you just need a java.io.File use clearWorkDir + getWorkDir.
     */
    public static FileObject makeScratchDir(NbTestCase test) throws IOException {
        test.clearWorkDir();
        File root = test.getWorkDir();
        assert root.isDirectory() && root.list().length == 0;
        FileObject fo = FileUtil.toFileObject(root);
        if (fo != null) {
            return fo;
        } else {
            if (!warned) {
                warned = true;
                System.err.println("No FileObject for " + root + " found.\n" +
                                    "Maybe you need ${openide/masterfs.dir}/modules/org-netbeans-modules-masterfs.jar\n" +
                                    "in test.unit.run.cp.extra, or make sure Lookups.metaInfServices is included in Lookup.default, so that\n" +
                                    "Lookup.default<URLMapper>=" + Lookup.getDefault().lookup(new Lookup.Template(URLMapper.class)).allInstances() + " includes MasterURLMapper\n" +
                                    "e.g. by using TestUtil.setLookup(Object[]) rather than TestUtil.setLookup(Lookup).");
            }
            // For the benefit of those not using masterfs.
            LocalFileSystem lfs = new LocalFileSystem();
            try {
                lfs.setRootDirectory(root);
            } catch (PropertyVetoException e) {
                assert false : e;
            }
            Repository.getDefault().addFileSystem(lfs);
            return lfs.getRoot();
        }
    }
    
    /**
     * Create a testing project factory which recognizes directories containing
     * a subdirectory called "testproject".
     * If that subdirectory contains a file named "broken" then loading the project
     * will fail with an IOException.
     */
    public static ProjectFactory testProjectFactory() {
        return new TestProjectFactory();
    }
    
    /**
     * Try to force a GC.
     */
    public static void gc() {
        System.gc();
        System.runFinalization();
        System.gc();
    }
    
    private static final Map<FileObject,Integer> loadCount = new WeakHashMap<>();
    
    /**
     * Check how many times {@link ProjectFactory#loadProject} has been called
     * (with any outcome) on a given project directory.
     */
    public static int projectLoadCount(FileObject dir) {
        Integer i = loadCount.get(dir);
        if (i != null) {
            return i;
        } else {
            return 0;
        }
    }
    
    /**
     * Mark a test project to fail with a given error when it is next saved.
     * The error only applies to the next save, not subsequent ones.
     * @param p a test project
     * @param error an error to throw (IOException or Error or RuntimeException),
     *              or null if it should succeed
     */
    public static void setProjectSaveWillFail(Project p, Throwable error) {
        ((TestProject)p).error = error;
    }
    
    /**
     * Get the number of times a test project was successfully saved with no error.
     * @param p a test project
     * @return the save count
     */
    public static int projectSaveCount(Project p) {
        return ((TestProject)p).saveCount;
    }
    
    /**
     * Mark a test project as modified.
     * @param p a test project
     */
    public static void modify(Project p) {
        ((TestProject)p).state.markModified();
    }
    
    /**
     * Mark a test project as modified.
     * @param p a test project
     */
    public static void notifyDeleted(Project p) {
        ((TestProject)p).state.notifyDeleted();
    }

    public static void copyDir(File src,File tgt) throws IOException {
        if (src.isDirectory()) {
            if (!tgt.exists()) {
                FileUtil.createFolder(tgt);
            }
            
            String[] dirList = src.list();
            for (int i=0; i < dirList.length; i++) {
                copyDir(new File(src, dirList[i]), 
                        new File(tgt, dirList[i]));
            }
        } else {
            InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(tgt);
            byte[] buffer = new byte[3 * 1024]; // 3 KB buffer
            int len = -1;
            try {
                len = is.read(buffer) ;
                while (len  > 0) {
                    os.write(buffer, 0, len);
                    len = is.read(buffer) ;                
                }
            }finally {
                if (is != null){
                    try {
                        is.close();                        
                    } catch (Exception ex){
                        // log
                    }
                }

                if (os != null){
                    try {
                        os.close();
                    } catch (Exception ex){
                        // log
                    }
                }
            }
        }
    }    
    
    public static EditableProperties loadProjectProperties(
            final FileObject projectDir) throws IOException {
        FileObject propsFO = projectDir.getFileObject(AntProjectHelper.PROJECT_PROPERTIES_PATH);
        InputStream propsIS = propsFO.getInputStream();
        EditableProperties props = new EditableProperties(true);
        try {
            props.load(propsIS);
        } finally {
            propsIS.close();
        }
        return props;
    }
    
    public static void storeProjectProperties(FileObject projectDir, EditableProperties props) throws IOException {
        FileObject propsFO = projectDir.getFileObject(AntProjectHelper.PROJECT_PROPERTIES_PATH);
        FileLock lock = propsFO.lock();
        try {
            OutputStream os = propsFO.getOutputStream(lock);
            try {
                props.store(os);
            } finally {
                os.close();
            }
        } finally {
            lock.releaseLock();
        }
    }
    
    /**
     * If set to something non-null, loading a broken project will wait for
     * notification on this monitor before throwing an exception.
     * @see ProjectManagerTest#testLoadExceptionWithConcurrentLoad
     */
    public static Object BROKEN_PROJECT_LOAD_LOCK = null;
    
    private static final class TestProjectFactory implements ProjectFactory {
        
        TestProjectFactory() {}
        
        public Project loadProject(FileObject projectDirectory, ProjectState state) throws IOException {
            Integer i = loadCount.get(projectDirectory);
            if (i == null) {
                i = 1;
            } else {
                i++;
            }
            loadCount.put(projectDirectory, i);
            FileObject testproject = projectDirectory.getFileObject("testproject");
            if (testproject != null && testproject.isFolder()) {
                if (testproject.getFileObject("broken") != null) {
                    if (BROKEN_PROJECT_LOAD_LOCK != null) {
                        synchronized (BROKEN_PROJECT_LOAD_LOCK) {
                            try {
                                BROKEN_PROJECT_LOAD_LOCK.wait();
                            } catch (InterruptedException e) {
                                assert false : e;
                            }
                        }
                    }
                    throw new IOException("Load failed of " + projectDirectory);
                } else {
                    return new TestProject(projectDirectory, state);
                }
            } else {
                return null;
            }
        }
        
        public void saveProject(Project project) throws IOException, ClassCastException {
            TestProject p = (TestProject)project;
            Throwable t = p.error;
            if (t != null) {
                p.error = null;
                if (t instanceof IOException) {
                    throw (IOException)t;
                } else if (t instanceof Error) {
                    throw (Error)t;
                } else {
                    throw (RuntimeException)t;
                }
            }
            p.saveCount++;
        }
        
        public boolean isProject(FileObject dir) {
            FileObject testproject = dir.getFileObject("testproject");
            return testproject != null && testproject.isFolder();
        }
        
    }
    
    private static final class TestProject implements Project {
        
        private final FileObject dir;
        final ProjectState state;
        Throwable error;
        int saveCount = 0;
        
        public TestProject(FileObject dir, ProjectState state) {
            this.dir = dir;
            this.state = state;
        }
        
        public Lookup getLookup() {
            return Lookup.EMPTY;
        }
        
        public FileObject getProjectDirectory() {
            return dir;
        }
        
        public String toString() {
            return "testproject:" + getProjectDirectory().getNameExt();
        }

        /* Probably unnecessary to have a ProjectInformation here:
        public String getName() {
            return "testproject:" + getProjectDirectory().getNameExt();
        }
        
        public String getDisplayName() {
            return "Test Project in " + getProjectDirectory().getNameExt();
        }
        
        public Image getIcon() {
            return null;
        }
        
        public void addPropertyChangeListener(PropertyChangeListener listener) {}
        public void removePropertyChangeListener(PropertyChangeListener listener) {}
         */
        
    }
    
    /**
     * Open a URL of content (for example from {@link Class#getResource}) and copy it to a named file.
     * The new file can be given as a parent directory plus a relative (slash-separated) path.
     * The file may not already exist, but intermediate directories may or may not.
     * If the content URL is null, the file is just created, no more; if it already existed
     * it is touched (timestamp updated) and its contents are cleared.
     * @return the file object
     */
    public static FileObject createFileFromContent(URL content, FileObject parent, String path) throws IOException {
        if (parent == null) {
            throw new IllegalArgumentException("null parent");
        }
        Assert.assertTrue("folder", parent.isFolder());
        FileObject fo = parent;
        StringTokenizer tok = new StringTokenizer(path, "/");
        boolean touch = false;
        while (tok.hasMoreTokens()) {
            Assert.assertNotNull("fo is null (parent=" + parent + " path=" + path + ")", fo);
            String name = tok.nextToken();
            if (tok.hasMoreTokens()) {
                FileObject sub = fo.getFileObject(name);
                if (sub == null) {
                    FileObject fo2 = fo.createFolder(name);
                    Assert.assertNotNull("createFolder(" + fo + ", " + name + ") -> null", fo2);
                    fo = fo2;
                } else {
                    Assert.assertTrue("folder", sub.isFolder());
                    fo = sub;
                }
            } else {
                FileObject sub = fo.getFileObject(name);
                if (sub == null) {
                    FileObject fo2 = fo.createData(name);
                    Assert.assertNotNull("createData(" + fo + ", " + name + ") -> null", fo2);
                    fo = fo2;
                } else {
                    fo = sub;
                    touch = true;
                }
            }
        }
        assert fo.isData();
        if (content != null || touch) {
            FileLock lock = fo.lock();
            try {
                OutputStream os = fo.getOutputStream(lock);
                try {
                    if (content != null) {
                        InputStream is = content.openStream();
                        try {
                            FileUtil.copy(is, os);
                        } finally {
                            is.close();
                        }
                    }
                } finally {
                    os.close();
                }
            } finally {
                lock.releaseLock();
            }
        }
        return fo;
    }
    
    private static final class Repo extends Repository {
        
        public Repo(NbTestCase t) throws Exception {
            super(mksystem(t));
        }
        
        private static FileSystem mksystem(NbTestCase t) throws Exception {
            LocalFileSystem lfs = new LocalFileSystem();
            File systemDir = new File(t.getWorkDir(), "ud/system");
            FileUtil.createFolder(systemDir);
            lfs.setRootDirectory(systemDir);
            lfs.setReadOnly(false);
            List<FileSystem> layers = new ArrayList<FileSystem>();
            layers.add(lfs);
            /*
            //get layer for the generic server
            java.net.URL layerFile = Repo.class.getClassLoader().getResource("org/netbeans/modules/j2ee/genericserver/resources/layer.xml");
            assert layerFile != null;
            layers.add(new XMLFileSystem(layerFile));
             */
            
            // get layer for the AS/GlassFish
//            addLayer(layers, "org/netbeans/modules/j2ee/sun/ide/j2ee/layer.xml");
//            addLayer(layers, "org/netbeans/modules/tomcat5/resources/layer.xml");
            MultiFileSystem mfs = new MultiFileSystem((FileSystem[]) layers.toArray(new FileSystem[0]));
            return mfs;
        }
        
        private static void addLayer(List<FileSystem> layers, String layerRes) throws SAXException {
            URL layerFile = Repo.class.getClassLoader().getResource(layerRes);
            assert layerFile != null;
            layers.add(new XMLFileSystem(layerFile));
        }
        
    }
    
//    @ServiceProvider(service=MimeDataProvider.class)
//    public static final class JavacParserProvider implements MimeDataProvider {
//
//        private Lookup javaLookup = Lookups.fixed(new JavacParserFactory());
//
//        public Lookup getLookup(MimePath mimePath) {
//            if (mimePath.getPath().endsWith(JavacParser.MIME_TYPE)) {
//                return javaLookup;
//            }
//
//            return Lookup.EMPTY;
//        }
//
//    }
}
