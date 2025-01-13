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
package org.netbeans.modules.php.blade.editor.parser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import static junit.framework.TestCase.fail;
import org.netbeans.api.lexer.Language;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.GsfLanguage;
import org.netbeans.modules.csl.core.LanguageRegistry;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.lexer.LexerUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.openide.ErrorManager;
import org.openide.filesystems.AbstractFileSystem;
import org.openide.filesystems.DefaultAttributes;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.filesystems.FileSystem;
import org.openide.util.Exceptions;
import org.openide.cookies.EditorCookie;
import org.openide.loaders.DataObject;

/**
 *
 * @author bogdan
 */
public class ParsingUtils {

    public ParsingUtils() {
    }

    private PHPParseResult phpParserResult;
    private BladeParserResult bladeParserResult;

    public FakeFileObject createFileObject(String phpText) {
        return new FakeFileObject(phpText);
    }

    public void parsePhpText(String phpText) {
        FakeFileObject file = new FakeFileObject(phpText);
        parseFileObject(file);
    }

    public Source createSource(String phpText) {
        FakeFileObject file = new FakeFileObject(phpText);
        Document doc = openDocument(file);
        return Source.create(doc);
    }

    public void parseFileObject(FileObject file) {
        Document doc = openDocument(file);

        try {
            Source source = Source.create(doc);
            Document sourceDoc = source.getDocument(false);

            if (source == null || sourceDoc == null) {
                return;
            }

            source.createSnapshot();
            ParserManager.parse(Collections.singletonList(source), new UserTask() {

                @Override
                public void run(ResultIterator resultIterator) throws Exception {
                    Parser.Result parserResult = resultIterator.getParserResult();
                    if (parserResult instanceof PHPParseResult) {
                        phpParserResult = (PHPParseResult) parserResult;
                    } else if (parserResult instanceof BladeParserResult) {
                        bladeParserResult = (BladeParserResult) parserResult;
                    }
                }
            });

        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public PHPParseResult getPhpParserResult() {
        return phpParserResult;
    }

    public BladeParserResult getBladeParserResult() {
        return bladeParserResult;
    }

    public Document openDocument(FileObject f) {
        
        String mimeType = BladeLanguage.MIME_TYPE;
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

            doc.putProperty("mimeType", mimeType);

            doc.putProperty(Language.class, LexerUtils.getBladeLexerLanguage());
            doc.insertString(0,readFile(f), null);

            return doc;
        } catch (BadLocationException ex) {
            return null;
        }
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

    public class FakeFileObject extends FileObject {

        InputStream stream;
        FileObject parent;

        public FakeFileObject(String text) {
            stream = new ByteArrayInputStream(text.getBytes());
        }

        @Override
        public String getName() {
            return "test";
        }

        @Override
        public String getExt() {
            return "php";
        }

        @Override
        public void rename(FileLock fl, String string, String string1) throws IOException {
            //
        }

        @Override
        public FileSystem getFileSystem() throws FileStateInvalidException {
            return new FakeFileSystem();
        }

        public void setParent(FileObject parent) {
            this.parent = parent;
        }

        @Override
        public FileObject getParent() {
            return parent;
        }

        @Override
        public boolean isFolder() {
            return false;
        }

        @Override
        public Date lastModified() {
            return new Date();
        }

        @Override
        public boolean isRoot() {
            return false;
        }

        @Override
        public boolean isData() {
            return false;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public void delete(FileLock fl) throws IOException {
            //
        }

        @Override
        public Object getAttribute(String string) {
            return null;
        }

        @Override
        public void setAttribute(String string, Object o) throws IOException {
            //
        }

        @Override
        public Enumeration<String> getAttributes() {
            return null;
        }

        @Override
        public void addFileChangeListener(FileChangeListener fl) {
            //
        }

        @Override
        public void removeFileChangeListener(FileChangeListener fl) {
            //
        }

        @Override
        public long getSize() {
            return 1;
        }

        @Override
        public InputStream getInputStream() throws FileNotFoundException {
            return stream;
        }

        @Override
        public OutputStream getOutputStream(FileLock fl) throws IOException {
            return null;
        }

        @Override
        public FileLock lock() throws IOException {
            return null;
        }

        //deprecated
        @Override
        public void setImportant(boolean bln) {
            //
        }

        @Override
        public FileObject[] getChildren() {
            return new FileObject[0];
        }

        @Override
        public FileObject getFileObject(String string, String string1) {
            return null;
        }

        @Override
        public FileObject createFolder(String string) throws IOException {
            return null;
        }

        @Override
        public FileObject createData(String string, String string1) throws IOException {
            return null;
        }

        //deprecated
        @Override
        public boolean isReadOnly() {
            return true;
        }

    }

    class FakeFileSystem extends AbstractFileSystem
            implements AbstractFileSystem.Info, AbstractFileSystem.List, AbstractFileSystem.Change {

        String dir = "dir";

        @SuppressWarnings(value = "LeakingThisInConstructor")
        public FakeFileSystem() {
            this.info = this;
            this.list = this;
            this.change = this;
            this.attr = new DefaultAttributes(info, change, list);
        }

        @Override
        public String getDisplayName() {
            return "Fake FS";
        }

        @Override
        public boolean isReadOnly() {
            return true;
        }

        @Override
        public Date lastModified(String name) {
            return new Date(5000L);
        }

        @Override
        public boolean folder(String name) {
            return dir.equals(name);
        }

        @Override
        public boolean readOnly(String name) {
            return false;
        }

        @Override
        public String mimeType(String name) {
            return "text/x-php5";
        }

        @Override
        public long size(String name) {
            return 0;
        }

        @Override
        public InputStream inputStream(String name) throws FileNotFoundException {
            return new ByteArrayInputStream(new byte[0]);
        }

        @Override
        public OutputStream outputStream(String name) throws IOException {
            return new ByteArrayOutputStream();
        }

        @Override
        public void lock(String name) throws IOException {
        }

        @Override
        public void unlock(String name) {
        }

        @Override
        public void markUnimportant(String name) {
        }

        @Override
        public String[] children(String f) {
            if ("".equals(f)) {
                return new String[]{dir};
            } else {
                return new String[0];
            }
        }

        @Override
        public void createFolder(String name) throws IOException {
            throw new IOException();
        }

        @Override
        public void createData(String name) throws IOException {
            throw new IOException();
        }

        @Override
        public void rename(String oldName, String newName) throws IOException {
        }

        @Override
        public void delete(String name) throws IOException {
            throw new IOException();
        }

    }
}
