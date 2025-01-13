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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.text.Document;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.lexer.Language;
import org.netbeans.editor.BaseDocument;
import org.netbeans.junit.MockServices;
import org.netbeans.junit.NbTestCase;
import org.netbeans.lib.lexer.LanguageManager;
import org.netbeans.modules.csl.api.GsfLanguage;
import org.netbeans.modules.csl.core.LanguageRegistry;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.impl.indexing.PathRegistry;
import org.netbeans.modules.parsing.impl.indexing.implspi.ActiveDocumentProvider;
import org.netbeans.modules.parsing.spi.indexing.PathRecognizer;
import static org.netbeans.modules.php.blade.editor.MockLookup.setLookup;
import org.netbeans.modules.php.blade.editor.parser.TestEnvironmentFactory;
import org.netbeans.spi.editor.document.DocumentFactory;
import org.netbeans.spi.java.classpath.ClassPathProvider;
import org.openide.ErrorManager;
import org.openide.cookies.EditorCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.MultiFileSystem;
import org.openide.filesystems.Repository;
import org.openide.filesystems.XMLFileSystem;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ServiceProvider;
import org.netbeans.modules.parsing.impl.Utilities;

/**
 *
 * @author bogdan
 */
public abstract class BladeTestBase extends NbTestCase {

    static {
        // testing performance: set scanner update delay to 0
        System.setProperty(PathRegistry.class.getName() + ".FIRER_EVT_COLLAPSE_WINDOW", "0");
    }
    private Map<String, ClassPath> classPathsForTest;
    private Object[] extraLookupContent = null;

    public BladeTestBase(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        parserSetup();

        List<URL> layers = new LinkedList<URL>();
        String[] additionalLayers = new String[]{"META-INF/generated-layer.xml"};
        Object[] additionalLookupContent = new Object[0];
        if (additionalLookupContent == null) {
            additionalLookupContent = new Object[0];
        }

        for (int cntr = 0; cntr < additionalLayers.length; cntr++) {
            boolean found = false;

            for (Enumeration<URL> en = Thread.currentThread().getContextClassLoader().getResources(additionalLayers[cntr]); en.hasMoreElements();) {
                found = true;
                layers.add(en.nextElement());
            }

            assertTrue(additionalLayers[cntr], found);
        }

        XMLFileSystem xmlFS = new XMLFileSystem();
        xmlFS.setXmlUrls(layers.toArray(new URL[0]));

        FileSystem system = new MultiFileSystem(new FileSystem[]{FileUtil.createMemoryFileSystem(), xmlFS});

        Repository repository = new Repository(system);

        extraLookupContent = new Object[additionalLookupContent.length + 2];
        int at = 0;
        System.arraycopy(additionalLookupContent, 0, extraLookupContent, at, additionalLookupContent.length);
        at += additionalLookupContent.length;
        // act as a fallback: if no other Repository is found.
        extraLookupContent[at++] = new TestClassPathProvider();
        extraLookupContent[at++] = new TestPathRecognizer();

        ClassLoader l = MockLookup.class.getClassLoader();
        setLookup(Lookups.fixed(extraLookupContent), Lookups.metaInfServices(l), Lookups.singleton(l), Lookups.singleton(repository));

    }

    @Override
    protected void tearDown() throws Exception {
    }

    protected FileObject touch(final String dir, final String path) throws IOException {
        return touch(new File(dir), path);
    }

    protected FileObject touch(final File dir, final String path) throws IOException {
        if (!dir.isDirectory()) {
            assertTrue("success to create " + dir, dir.mkdirs());
        }
        FileObject dirFO = FileUtil.toFileObject(FileUtil.normalizeFile(dir));
        return touch(dirFO, path);
    }

    protected FileObject touch(final FileObject dir, final String path) throws IOException {
        return FileUtil.createData(dir, path);
    }

    public static final FileObject copyStringToFileObject(FileObject fo, String content) throws IOException {
        OutputStream os = fo.getOutputStream();
        try {
            InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            try {
                FileUtil.copy(is, os);
                return fo;
            } finally {
                is.close();
            }
        } finally {
            os.close();
        }
    }

    protected FileObject getTestFile(String relFilePath) {
        File wholeInputFile = new File(getDataDir(), relFilePath);
        if (!wholeInputFile.exists()) {
            NbTestCase.fail("File " + wholeInputFile + " not found.");
        }
        FileObject fo = FileUtil.toFileObject(wholeInputFile);
        assertNotNull(fo);

        return fo;
    }

    protected File getDataSourceDir() {
        // Check whether token dump file exists
        // Try to remove "/build/" from the dump file name if it exists.
        // Otherwise give a warning.
        File inputFile = getDataDir();
        String inputFilePath = inputFile.getAbsolutePath();
        boolean replaced = false;
        if (inputFilePath.indexOf(pathJoin("build", "test")) != -1) {
            inputFilePath = inputFilePath.replace(pathJoin("build", "test"), pathJoin("test"));
            replaced = true;
        }
        if (!replaced && inputFilePath.indexOf(pathJoin("test", "work", "sys")) != -1) {
            inputFilePath = inputFilePath.replace(pathJoin("test", "work", "sys"), pathJoin("test", "unit"));
            replaced = true;
        }
        if (!replaced) {
            System.err.println("Warning: Attempt to use dump file "
                    + "from sources instead of the generated test files failed.\n"
                    + "Patterns '/build/test/' or '/test/work/sys/' not found in " + inputFilePath
            );
        }
        inputFile = new File(inputFilePath);
        assertTrue(inputFile.exists());

        return inputFile;
    }

    private static String pathJoin(String... chunks) {
        StringBuilder result = new StringBuilder(File.separator);
        for (String chunk : chunks) {
            result.append(chunk).append(File.separatorChar);
        }
        return result.toString();
    }

    protected DefaultLanguageConfig getPreferredLanguage() {
        return new BladeLanguage();
    }

    protected String getPreferredMimeType() {
        return BladeLanguage.MIME_TYPE;
    }

    protected BaseDocument getDocument(String s) {
        String mimeType = getPreferredMimeType();
        assertNotNull("You must implement " + getClass().getName() + ".getPreferredMimeType()", mimeType);

        GsfLanguage language = getPreferredLanguage();
        assertNotNull("You must implement " + getClass().getName() + ".getPreferredLanguage()", language);

        return getDocument(s, mimeType, language.getLexerLanguage());
    }

    protected BaseDocument getDocument(FileObject fo) {
        return getDocument(fo, getPreferredMimeType(), getPreferredLanguage().getLexerLanguage());
    }

    protected BaseDocument getDocument(FileObject fo, String mimeType, Language language) {
        try {
            BaseDocument doc = getDocument(readFile(fo), mimeType, language);
            try {
                DataObject dobj = DataObject.find(fo);
                doc.putProperty(Document.StreamDescriptionProperty, dobj);
            } catch (DataObjectNotFoundException dnfe) {
                fail(dnfe.toString());
            }

            return doc;
        } catch (Exception ex) {
            fail(ex.toString());
            return null;
        }
    }

    public BaseDocument getDocument(String s, final String mimeType, final Language language) {
        try {
            BaseDocument doc = new BaseDocument(true, mimeType) {
                @Override
                public boolean isIdentifierPart(char ch) {
                    if (mimeType != null) {
                        org.netbeans.modules.csl.core.Language l = LanguageRegistry.getInstance().getLanguageByMimeType(mimeType);
                        if (l != null) {
                            GsfLanguage gsfLanguage = l.getGsfLanguage();
                            if (gsfLanguage != null) {
                                return gsfLanguage.isIdentifierChar(ch);
                            }
                        }
                    }

                    return super.isIdentifierPart(ch);
                }
            };

            doc.putProperty(org.netbeans.api.lexer.Language.class, language);
            doc.insertString(0, s, null);

            return doc;
        } catch (Exception ex) {
            fail(ex.toString());
            return null;
        }
    }

    public BaseDocument getDocument(String s, String mimeType) {
        Language<?> language = LanguageManager.getInstance().findLanguage(mimeType);
        assertNotNull(language);

        return getDocument(s, mimeType, language);
    }

    protected String readFile(final FileObject fo) {
        return read(fo);
    }

    public static String read(final FileObject fo) {
        try {
            final StringBuilder sb = new StringBuilder(5000);
            fo.getFileSystem().runAtomicAction(new FileSystem.AtomicAction() {

                public void run() throws IOException {

                    if (fo == null) {
                        return;
                    }

                    InputStream is = fo.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

                    while (true) {
                        String line = reader.readLine();

                        if (line == null) {
                            break;
                        }

                        sb.append(line);
                        sb.append('\n');
                    }
                }
            });

            if (sb.length() > 0) {
                return sb.toString();
            } else {
                return null;
            }
        } catch (IOException ioe) {
            ErrorManager.getDefault().notify(ioe);

            return null;
        }
    }

    /**
     * Gets the <code>Source</code> for a file. This method makes sure that a
     * <code>Document</code> is loaded from the file and accessible through the
     * returned <code>Source</code> instance. Many language-specific feature
     * implementations rely on that.
     *
     * @param relFilePath The file path relative to <code>getDataDir()</code>.
     *
     * @return The <code>Source</code> instance with a the <code>Document</code>
     * loaded from the specified file.
     */
    protected Source getTestSource(FileObject f) {
        Document doc = getDocument(f);
        FileObject fileObject = Utilities.getFileObject(doc);
    return Source.create(doc);
    }

    private class TestClassPathProvider implements ClassPathProvider {

        public TestClassPathProvider() {

        }

        public ClassPath findClassPath(FileObject file, String type) {
            Map<String, ClassPath> map = classPathsForTest;

            if (map != null) {
                return map.get(type);
            } else {
                return null;
            }
        }
    } // End of TestClassPathProvider class

    private class TestPathRecognizer extends PathRecognizer {

        @Override
        public Set<String> getSourcePathIds() {
            return BladeTestBase.this.getPreferredLanguage().getSourcePathIds();
        }

        @Override
        public Set<String> getLibraryPathIds() {
            return BladeTestBase.this.getPreferredLanguage().getLibraryPathIds();
        }

        @Override
        public Set<String> getBinaryLibraryPathIds() {
            return BladeTestBase.this.getPreferredLanguage().getBinaryLibraryPathIds();
        }

        @Override
        public Set<String> getMimeTypes() {
            return Collections.singleton(BladeTestBase.this.getPreferredMimeType());
        }

    } // End of TestPathRecognizer class

    @ServiceProvider(service = ActiveDocumentProvider.class)
    public static class ActiveDocumentProviderImpl implements ActiveDocumentProvider {

        @Override
        public Document getActiveDocument() {
            return null;
        }

        @Override
        public Set<? extends Document> getActiveDocuments() {
            return Collections.emptySet();
        }

        @Override
        public void addActiveDocumentListener(ActiveDocumentProvider.ActiveDocumentListener listener) {
        }

        @Override
        public void removeActiveDocumentListener(ActiveDocumentProvider.ActiveDocumentListener listener) {
        }

    }

    private void parserSetup() {
        Class[] services = getServices();
        List<Class> classes = new ArrayList<Class>(4);
        if (services != null) {
            classes.addAll(Arrays.asList(services));
        }
        services = getMockServices();
        if (services != null) {
            classes.addAll(Arrays.asList(services));
        }
        MockServices.setServices(classes.toArray(new Class[0]));
//        MockLookup.setLookup(
//                Lookups.metaInfServices(getClass().getClassLoader()),
//                createTestServices());
        MockMimeLookup.setInstances(
                MimePath.EMPTY,
                new DocumentFactory() {
            @Override
            public Document createDocument(String mimeType) {
                return new BaseDocument(false, mimeType);
            }

            @Override
            public Document getDocument(FileObject file) {
                try {
                    final DataObject dobj = DataObject.find(file);
                    final EditorCookie ec = dobj.getLookup().lookup(EditorCookie.class);
                    return ec == null
                            ? null
                            : ec.openDocument();
                } catch (DataObjectNotFoundException e) {
                    return null;
                } catch (IOException ioe) {
                    Exceptions.printStackTrace(ioe);
                    return null;
                }
            }

            @Override
            public FileObject getFileObject(Document document) {
                Object sdp = document.getProperty(Document.StreamDescriptionProperty);
                if (sdp instanceof FileObject) {
                    return (FileObject) sdp;
                }
                if (sdp instanceof DataObject) {
                    return ((DataObject) sdp).getPrimaryFile();
                }
                return null;
            }
        });
    }

    protected Class[] getMockServices() {
        return new Class[]{MockMimeLookup.class, TestEnvironmentFactory.class};
    }

    protected Class[] getServices() {
        return null;
    }

    protected Lookup createTestServices() {
        return Lookups.fixed(new TestEnvironmentFactory());
    }
}
