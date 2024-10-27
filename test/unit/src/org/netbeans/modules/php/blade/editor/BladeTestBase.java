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
import java.nio.charset.StandardCharsets;
import javax.swing.text.Document;
import org.netbeans.api.lexer.Language;
import org.netbeans.editor.BaseDocument;
import org.netbeans.junit.NbTestCase;
import org.netbeans.lib.lexer.LanguageManager;
import org.netbeans.modules.csl.api.GsfLanguage;
import org.netbeans.modules.csl.core.LanguageRegistry;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.openide.ErrorManager;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;

/**
 *
 * @author bogdan
 */
public abstract class BladeTestBase extends NbTestCase {

    public BladeTestBase(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
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
    
}
