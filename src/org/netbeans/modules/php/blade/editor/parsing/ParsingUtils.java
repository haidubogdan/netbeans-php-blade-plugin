/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.editor.parsing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.text.Document;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
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

    private FileObject currentFile;

    public ParsingUtils(FileObject file) {
        this.currentFile = file;
    }

    public ParsingUtils() {
        this.currentFile = null;
    }

    private PHPParseResult phpParserResult;

    public FakeFileObject createFileObject(String phpText) {
        return new FakeFileObject(phpText);
    }

    public void parsePhpText(String phpText) {
        FakeFileObject file = new FakeFileObject(phpText);
        if (currentFile != null) {
            file.setParent(currentFile.getParent());
        }
        parseFileObject(file);
    }
    
    public void parseFileObject(FileObject file){
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
                    }
                }
            });

        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public PHPParseResult getParserResult() {
        return phpParserResult;
    }

    public Document openDocument(FileObject f) {
        try {
            DataObject dataObject = DataObject.find(f);
            EditorCookie ec = dataObject.getLookup().lookup(EditorCookie.class);
            return ec.openDocument();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static String getAstSymbolName(int symbol) {
        Field fields[] = ASTBladeSymbols.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            try {
                Object value = field.get(field);
                if (value.equals(symbol)) {
                    return fieldName;
                }
            } catch (Exception ex) {

            }
        }
        return null;
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
                return new String[]{"x.txt"};
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
