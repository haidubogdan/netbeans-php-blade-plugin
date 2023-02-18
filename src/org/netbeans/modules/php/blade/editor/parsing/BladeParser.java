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

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import javax.swing.text.StyledDocument;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.editor.NbEditorDocument;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.impl.indexing.RepositoryUpdater;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeProgram;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Statement;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import static org.netbeans.modules.php.blade.editor.BladeLanguage.BLADE_MIME_TYPE;
import org.openide.loaders.DataLoader;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.text.DataEditorSupport;

/**
 *
 * @author Haidu Bogdan
 */
public class BladeParser extends Parser {

    private static final Logger LOGGER = Logger.getLogger(BladeParser.class.getName());
    Snapshot snapshot;
    BladeParserResult result;

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) throws ParseException {
        this.snapshot = snapshot;
        if (checkMimeAndReload(task)) {
            return;
        }
        try {
            int caretOffset = GsfUtilities.getLastKnownCaretOffset(snapshot, event);
            Context context = new Context(snapshot, caretOffset);
            BladeErrorHandler errorHandler = new BladeErrorHandler(context);
            // calling the php ast parser itself
            ASTBladeScanner scanner = new ASTBladeScanner(new StringReader(context.getSanitizedSource()));
            scanner.setCurentFile(snapshot.getSource().getFileObject());
            ASTBladeParser parser = new ASTBladeParser(scanner);

            final FileObject fileObject = context.getSnapshot().getSource().getFileObject();
            parser.setErrorHandler(errorHandler);
            if (fileObject != null) {
                parser.setFileName(fileObject.getNameExt());
            }

            java_cup.runtime.Symbol rootSymbol = parser.parse();

            //prevent OOME
            scanner = null;

            if (rootSymbol != null) {
                BladeProgram program;
                if (rootSymbol.value instanceof BladeProgram) {
                    program = (BladeProgram) rootSymbol.value; // call the parser itself
                    result = new BladeParserResult(context.getSnapshot(), program);
                    result.setErrors(errorHandler.displaySyntaxErrors(program));
                } else {
                    //fake program
                    int end = snapshot.getText().toString().length();
                    List<Statement> statements = new ArrayList<>();
                    BladeProgram emptyProgram = new BladeProgram(0, end, statements, null);
                    result = new BladeParserResult(context.getSnapshot(), emptyProgram);
                    LOGGER.log(Level.WARNING, "program null after parsing");
                }
            } else {
                int end = snapshot.getText().toString().length();
                List<Statement> statements = new ArrayList<>();
                BladeProgram emptyProgram = new BladeProgram(0, end, statements, null);
                result.setErrors(errorHandler.displaySyntaxErrors(emptyProgram));
                LOGGER.log(Level.WARNING, "No root has been found");
                result.setErrors(errorHandler.displayFatalError());
            }

            LOGGER.log(Level.FINE, "caretOffset: {0}", caretOffset);
        } catch (Exception exception) {
            Exceptions.printStackTrace(exception);
            LOGGER.log(Level.SEVERE, "Exception during parsing: {0}", exception);
        }

    }

    private boolean checkMimeAndReload(Task task) {

        FileObject currentFile = snapshot.getSource().getFileObject();
        if (currentFile == null) {
            return false;
        }
        String fileName = currentFile.getNameExt();
        if (!fileName.endsWith(".blade.php")) {
            //no need to refresh file mime type
            return false;
        }
        if (!task.getClass().getName().startsWith("org.netbeans.modules.parsing.impl.indexing.RepositoryUpdater")) {
            return false;
        }
        if (RepositoryUpdater.getDefault().isCacheFile(currentFile)) {
            return false;
        }

        final DataObject od;
        try {
            od = DataObject.find(currentFile);
            DataEditorSupport ed = od.getLookup().lookup(DataEditorSupport.class);
            boolean docIsLoaded = ed.isDocumentLoaded();
            StyledDocument doc = ed.getDocument();
            if (doc != null) {
                String docMimeType = doc.getProperty("mimeType").toString();
                if (docMimeType.equals(BLADE_MIME_TYPE)) {
                    return false;
                }
            }

            try {
                od.setValid(false);
                //TODO we will need a syncronized task
                DataObject od2 = DataObject.find(currentFile);
                DataEditorSupport ed2 = od2.getLookup().lookup(DataEditorSupport.class);
                if (docIsLoaded) {
                    ed2.open();
                    return true;
                }
            } catch (PropertyVetoException ex) {
                Exceptions.printStackTrace(ex);
            }

        } catch (DataObjectNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
        return false;
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return result;
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }

    static public class Factory extends ParserFactory {

        @Override
        public Parser createParser(Collection<Snapshot> clctn) {
            return new BladeParser();
        }

    }

    public static class Context {

        private final Snapshot snapshot;
        private final int caretOffset;
        private SourceHolder sourceHolder;
        private SanitizedPart sanitizedPart;

        public Context(Snapshot snapshot, int caretOffset) {
            this.snapshot = snapshot;
            this.caretOffset = caretOffset;
            this.sourceHolder = new SnapshotSourceHolder(snapshot);
        }

        @Override
        public String toString() {
            return "Bladearser.Context(" + snapshot.getSource().getFileObject() + ")"; // NOI18N
        }

        public Snapshot getSnapshot() {
            return snapshot;
        }

        private void setSourceHolder(SourceHolder sourceHolder) {
            this.sourceHolder = sourceHolder;
        }

        public String getBaseSource() {
            return sourceHolder.getText();
        }

        public int getCaretOffset() {
            return caretOffset;
        }

        public void setSanitizedPart(SanitizedPart sanitizedPart) {
            this.sanitizedPart = sanitizedPart;
        }

        public SanitizedPart getSanitizedPart() {
            return sanitizedPart;
        }

        public String getSanitizedSource() {
            StringBuilder sb = new StringBuilder();
            if (sanitizedPart == null) {
                sb.append(getBaseSource());
            } else {
                OffsetRange offsetRange = sanitizedPart.getOffsetRange();
                sb.append(getBaseSource().substring(0, offsetRange.getStart()))
                        .append(sanitizedPart.getText())
                        .append(getBaseSource().substring(offsetRange.getEnd()));
            }
            return sb.toString();
        }

    }

    public interface SanitizedPart {

        SanitizedPart NONE = new SanitizedPart() {

            @Override
            public OffsetRange getOffsetRange() {
                return OffsetRange.NONE;
            }

            @Override
            public String getText() {
                return "";
            }
        };

        OffsetRange getOffsetRange();

        String getText();

    }

    public static class SanitizedPartImpl implements SanitizedPart {

        private final OffsetRange offsetRange;
        private final String text;

        public SanitizedPartImpl(OffsetRange offsetRange, String text) {
            assert offsetRange != null;
            assert text != null;
            this.offsetRange = offsetRange;
            this.text = text;
        }

        @Override
        public OffsetRange getOffsetRange() {
            return offsetRange;
        }

        @Override
        public String getText() {
            return text;
        }

    }

    private interface SourceHolder {

        String getText();

    }

    private static class StringSourceHolder implements SourceHolder {

        private final String text;

        public StringSourceHolder(String text) {
            assert text != null;
            this.text = text;
        }

        @Override
        public String getText() {
            return text;
        }

    }

    private static class SnapshotSourceHolder implements SourceHolder {

        private final Snapshot snapshot;

        public SnapshotSourceHolder(Snapshot snapshot) {
            assert snapshot != null;
            this.snapshot = snapshot;
        }

        @Override
        public String getText() {
            return snapshot.getText().toString();
        }

    }

}
