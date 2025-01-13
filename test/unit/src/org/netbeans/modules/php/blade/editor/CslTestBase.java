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

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
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
import java.nio.file.Files;
import java.nio.charset.Charset;
import javax.swing.JEditorPane;
import javax.swing.text.DefaultEditorKit;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.junit.MockServices;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.core.GsfIndentTaskFactory;
import javax.swing.text.Caret;
import javax.swing.SwingUtilities;
import org.netbeans.modules.editor.NbEditorKit;
import java.util.concurrent.Callable;
import java.util.prefs.Preferences;
import javax.swing.Action;
import org.netbeans.api.editor.settings.SimpleValueNames;
import org.netbeans.editor.BaseKit;
import org.netbeans.modules.csl.core.CslEditorKit;
import org.netbeans.modules.csl.core.GsfReformatTaskFactory;
import org.netbeans.modules.editor.indent.spi.CodeStylePreferences;
import org.openide.util.Exceptions;

/**
 *
 * @author bogdan
 */
public abstract class CslTestBase extends NbTestCase {

    public CslTestBase(String testName) {
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

    protected File getTestFolder(String relFolderPath) {
        File folder = new File(getDataDir(), relFolderPath);

        if (!folder.exists()) {
            NbTestCase.fail("File " + folder + " not found.");
        }

        return folder;
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

    protected void assertDescriptionMatches(String relFilePath,
            String description, boolean includeTestName, String ext) throws Exception {
        assertDescriptionMatches(relFilePath, description, includeTestName, ext, true);
    }

    protected void assertDescriptionMatches(String relFilePath,
            String description, boolean includeTestName, String ext, boolean checkFileExistence) throws Exception {
        assertDescriptionMatches(relFilePath, description, includeTestName, ext, checkFileExistence, false);
    }

    /**
     * A variant that accepts markers in the actual output. Markers identify
     * words in the golden file that should be ignored. Suitable for
     * postprocessed output from partial implementations, so they can be still
     * checked against full specification - otherwise a new set of goldens would
     * have to be created. Include "*-*" marker in the 'description' at a place
     * where a single word (optional) should be skipped.
     *
     * @param relFilePath relative path to golden file
     * @param description description string
     * @param includeTestName true = append test name to relative path
     * @param ext extension of the golden file
     * @param checkFileExistence check the golden file exists; false means
     * golden file will be created with 'description' as contents.
     * @param skipMarkers true to skip text that matches *-* in the actual
     * output.
     * @throws Exception
     */
    protected void assertDescriptionMatches(String relFilePath,
            String description, boolean includeTestName, String ext, boolean checkFileExistence, boolean skipMarkers) throws Exception {
        assertDescriptionMatches(relFilePath, description, includeTestName, false, ext, checkFileExistence, skipMarkers);
    }

    protected void assertDescriptionMatches(String relFilePath,
            String description, boolean includeTestName, boolean includeJavaVersion, String ext, boolean checkFileExistence, boolean skipMarkers) throws Exception {
        File rubyFile = getDataFile(relFilePath);
        if (checkFileExistence && !rubyFile.exists()) {
            NbTestCase.fail("File " + rubyFile + " not found.");
        }

        File goldenFile = null;
        if (includeJavaVersion) {
            String version = System.getProperty("java.specification.version");
            for (String variant : computeVersionVariantsFor(version)) {
                goldenFile = getDataFile(relFilePath + (includeTestName ? ("." + getName()) : "") + variant + ext);
                if (goldenFile.exists()) {
                    break;
                }
            }
        }
        if (goldenFile == null || !goldenFile.exists()) {
            goldenFile = getDataFile(relFilePath + (includeTestName ? ("." + getName()) : "") + ext);
        }
        if (!goldenFile.exists()) {
            if (!goldenFile.createNewFile()) {
                NbTestCase.fail("Cannot create file " + goldenFile);
            }
            FileWriter fw = new FileWriter(goldenFile);
            try {
                fw.write(description);
            } finally {
                fw.close();
            }
            if (failOnMissingGoldenFile()) {
                NbTestCase.fail("Created generated golden file " + goldenFile + "\nPlease re-run the test.");
            }
            return;
        }

        String expected = readFile(goldenFile);

        // Because the unit test differ is so bad...
        if (false) { // disabled
            if (!expected.equals(description)) {
                BufferedWriter fw = new BufferedWriter(new FileWriter("/tmp/expected.txt"));
                fw.write(expected);
                fw.close();
                fw = new BufferedWriter(new FileWriter("/tmp/actual.txt"));
                fw.write(description);
                fw.close();
            }
        }

        String expectedTrimmed = expected.trim();
        String actualTrimmed = description.trim();

        if (expectedTrimmed.equals(actualTrimmed)) {
            return; // Actual and expected content are equals --> Test passed
        } else {
            // We want to ignore different line separators (like \r\n against \n) because they
            // might be causing failing tests on a different operation systems like Windows :]
            String expectedUnified = expectedTrimmed.replace("\r", "");
            String actualUnified = actualTrimmed.replace("\r", "");

            // if there is '**' in the actualUnified, it may stand for whatever word of the expected
            // content in that position.
            if (skipMarkers) {
                String[] linesExpected = expectedUnified.split("\n");
                String[] linesActual = actualUnified.split("\n");
                boolean allMatch = linesExpected.length == linesActual.length;
                for (int i = 0; allMatch && i < linesExpected.length; i++) {
                    String e = linesExpected[i];
                    String a = linesActual[i];
                    Pattern pattern = markerPattern(a);
                    allMatch = pattern == null ? a.equals(e) : pattern.matcher(e).matches();
                }
                if (allMatch) {
                    return;
                }
            }

            if (expectedUnified.equals(actualUnified)) {
                return; // Only difference is in line separation --> Test passed
            }

            // There are some diffrerences between expected and actual content --> Test failed
            fail(getContentDifferences(relFilePath, ext, includeTestName, expectedUnified, actualUnified, skipMarkers));
        }
    }

    protected File getDataFile(String relFilePath) {
        File inputFile = new File(getDataSourceDir(), relFilePath);
        return inputFile;
    }

    private Pattern markerPattern(String line) {
        StringBuilder pattern = new StringBuilder();
        int start = 0;
        for (int idx = line.indexOf("*-*"); idx >= 0; start = idx + 3, idx = line.indexOf("*-*", start)) {
            pattern.append("\\s*");
            pattern.append(Pattern.quote(line.substring(start, idx).trim()));
            pattern.append("\\s*\\S*");
        }
        if (start > 0) {
            pattern.append("\\s*");
            pattern.append(Pattern.quote(line.substring(start).trim()));
            return Pattern.compile(pattern.toString());
        } else {
            return null;
        }
    }

    protected boolean failOnMissingGoldenFile() {
        return true;
    }

    private static List<String> computeVersionVariantsFor(String version) {
        int dot = version.indexOf('.');
        version = version.substring(dot + 1);
        int versionNum = Integer.parseInt(version);
        List<String> versions = new ArrayList<>();

        for (int v = versionNum; v >= 9; v--) {
            versions.add("." + v);
        }

        return versions;
    }

    private String getContentDifferences(String relFilePath, String ext, boolean includeTestName, String expected, String actual, boolean skip) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content does not match between '").append(relFilePath).append("' and '").append(relFilePath);
        if (includeTestName) {
            sb.append(getName());
        }
        sb.append(ext).append("'").append(lineSeparator(1));
        sb.append(getContentDifferences(expected, actual, skip));

        return sb.toString();
    }

    private String getContentDifferences(String expected, String actual, boolean skipMarkers) {
        StringBuilder sb = new StringBuilder();
        sb.append("Expected content is:").
                append(lineSeparator(2)).
                append(expected).
                append(lineSeparator(2)).
                append("but actual is:").
                append(lineSeparator(2)).
                append(actual).
                append(lineSeparator(2)).
                append("It differs in the following things:").
                append(lineSeparator(2));

        List<String> expectedLines = Arrays.asList(expected.split("\n"));
        List<String> actualLines = Arrays.asList(actual.split("\n"));

        if (expectedLines.size() != actualLines.size()) {
            sb.append("Number of lines: \n\tExpected: ").append(expectedLines.size()).append("\n\tActual: ").append(actualLines.size()).append("\n\n");
        }

        // Appending lines which are missing in expected content and are present in actual content
        boolean noErrorInActual = true;
        for (String actualLine : actualLines) {
            if (containsLine(expectedLines, actualLine, skipMarkers, false) == false) {
                if (noErrorInActual) {
                    sb.append("Actual content contains following lines which are missing in expected content: ").append(lineSeparator(1));
                    noErrorInActual = false;
                }
                sb.append("\t").append(actualLine).append(lineSeparator(1));
            }
        }

        // Appending lines which are missing in actual content and are present in expected content
        boolean noErrorInExpected = true;
        for (String expectedLine : expectedLines) {
            if (containsLine(actualLines, expectedLine, skipMarkers, true) == false) {
                // If at least one line missing in actual content we want to append header line
                if (noErrorInExpected) {
                    sb.append("Expected content contains following lines which are missing in actual content: ").append(lineSeparator(1));
                    noErrorInExpected = false;
                }
                sb.append("\t").append(expectedLine).append(lineSeparator(1));
            }
        }

        // If both values are true it means the content is the same, but some lines are
        // placed on a different line number in actual and expected content
        if (noErrorInActual && noErrorInExpected && expectedLines.size() == actualLines.size()) {
            for (int lineNumber = 0; lineNumber < expectedLines.size(); lineNumber++) {
                String expectedLine = expectedLines.get(lineNumber);
                String actualLine = actualLines.get(lineNumber);

                if (!expectedLine.equals(actualLine)) {
                    sb.append("Line ").
                            append(lineNumber).
                            append(" contains different content than expected: ").
                            append(lineSeparator(1)).
                            append("Expected: \t").
                            append(expectedLine).
                            append(lineSeparator(1)).
                            append("Actual:  \t").
                            append(actualLine).
                            append(lineSeparator(2));

                }
            }
        }

        return sb.toString();
    }

    private boolean containsLine(List<String> lines, String line, boolean skipMarkers, boolean inArray) {
        if (lines.contains(line)) {
            return true;
        } else if (!skipMarkers) {
            return false;
        }
        if (inArray) {
            for (String l : lines) {
                Pattern toFind = markerPattern(l);
                if (toFind == null) {
                    if (l.equals(line)) {
                        return true;
                    }
                } else {
                    if (toFind.matcher(line).matches()) {
                        return true;
                    }
                }
            }
        } else {
            Pattern toFind = markerPattern(line);
            if (toFind == null) {
                return false;
            }
            for (String l : lines) {
                if (toFind.matcher(l).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    private String lineSeparator(int number) {
        final String lineSeparator = System.getProperty("line.separator");
        if (number > 1) {
            final StringBuilder sb = new StringBuilder();

            for (int i = 0; i < number; i++) {
                sb.append(lineSeparator);
            }
            return sb.toString();
        }
        return lineSeparator;
    }

    public static String readFile(File f) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(f.toPath()), charset);
        return content;
    }

    /**
     * Return the offset of the given position, indicated by ^ in the line
     * fragment from the fuller text
     */
    public static int getCaretOffset(String text, String caretLine) {
        return getCaretOffsetInternal(text, caretLine).offset;
    }

    /**
     * Like <code>getCaretOffset</code>, but the returned
     * <code>CaretLineOffset</code> contains also the modified
     * <code>caretLine</code> param.
     *
     * @param text
     * @param caretLine
     * @return
     */
    private static CaretLineOffset getCaretOffsetInternal(String text, String caretLine) {
        int caretDelta = caretLine.indexOf('^');
        assertTrue(caretDelta != -1);
        caretLine = caretLine.substring(0, caretDelta) + caretLine.substring(caretDelta + 1);
        int lineOffset = text.indexOf(caretLine);
        assertTrue("No occurrence of caretLine " + caretLine + " in text '" + text + "'", lineOffset != -1);

        int caretOffset = lineOffset + caretDelta;

        return new CaretLineOffset(caretOffset, caretLine);
    }

    /**
     * Copy-pasted from APISupport.
     */
    protected static String slurp(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileUtil.copy(is, baos);
            return baos.toString("UTF-8");
        } finally {
            is.close();
        }
    }

    protected void insertChar(String original, char insertText, String expected, String selection, boolean codeTemplateMode) throws Exception {
        String source = original;
        String reformatted = expected;
        Formatter formatter = getFormatter(null);

        int sourcePos = source.indexOf('^');
        assertTrue("Source text must have a caret ^ marker", sourcePos != -1);
        source = source.substring(0, sourcePos) + source.substring(sourcePos + 1);

        int reformattedPos = reformatted.indexOf('^');
        assertTrue("Reformatted text must have a caret ^ marker", reformattedPos != -1);
        reformatted = reformatted.substring(0, reformattedPos) + reformatted.substring(reformattedPos + 1);

        JEditorPane ta = getPane(source);
        Caret caret = ta.getCaret();
        caret.setDot(sourcePos);
        if (selection != null) {
            int start = source.indexOf(selection);
            assertTrue(start != -1);
            assertTrue("Ambiguous selection - multiple occurrences of selection string",
                    source.indexOf(selection, start + 1) == -1);
            ta.setSelectionStart(start);
            ta.setSelectionEnd(start + selection.length());
            assertEquals(selection, ta.getSelectedText());
        }

        BaseDocument doc = (BaseDocument) ta.getDocument();

        if (codeTemplateMode) {
            // Copied from editor/codetemplates/src/org/netbeans/lib/editor/codetemplates/CodeTemplateInsertHandler.java
            String EDITING_TEMPLATE_DOC_PROPERTY = "processing-code-template"; // NOI18N
            doc.putProperty(EDITING_TEMPLATE_DOC_PROPERTY, Boolean.TRUE);
        }

        if (formatter != null) {
            configureIndenters(doc, formatter, true);
        }

        setupDocumentIndentation(doc, null);

        runKitAction(ta, DefaultEditorKit.defaultKeyTypedAction, "" + insertText);

        String formatted = doc.getText(0, doc.getLength());
        assertEquals(reformatted, formatted);

        if (reformattedPos != -1) {
            assertEquals(reformattedPos, caret.getDot());
        }
    }

    protected JEditorPane getPane(String text) throws Exception {
        if (!SwingUtilities.isEventDispatchThread()) {
            fail("You must run this test from the event dispatch thread! To do that, add @Override protected boolean runInEQ() { return true } from your testcase!");
        }
        String BEGIN = "$start$"; // NOI18N
        String END = "$end$"; // NOI18N
        int sourceStartPos = text.indexOf(BEGIN);
        int caretPos = -1;
        int sourceEndPos = -1;
        if (sourceStartPos != -1) {
            text = text.substring(0, sourceStartPos) + text.substring(sourceStartPos + BEGIN.length());
            sourceEndPos = text.indexOf(END);
            assertTrue(sourceEndPos != -1);
            text = text.substring(0, sourceEndPos) + text.substring(sourceEndPos + END.length());
        } else {
            caretPos = text.indexOf('^');
            if (caretPos != -1) {
                text = text.substring(0, caretPos) + text.substring(caretPos + 1);
            }
        }

        JEditorPane pane = new JEditorPane();
        pane.setContentType(getPreferredMimeType());
        final NbEditorKit kit = ((NbEditorKit) getEditorKit(getPreferredMimeType()));

        Thread preload = new Thread(new Runnable() {

            @Override
            public void run() {
                // Preload actions and other stuff
                if (kit instanceof Callable) {
                    try {
                        ((Callable) kit).call();
                    } catch (Exception ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
                kit.getActions();
            }
        });
        preload.start();
        preload.join();
        pane.setEditorKit(kit);
        pane.setText(text);

        BaseDocument bdoc = (BaseDocument) pane.getDocument();

        bdoc.putProperty(org.netbeans.api.lexer.Language.class, getPreferredLanguage().getLexerLanguage());
        bdoc.putProperty("mimeType", getPreferredMimeType());

        //bdoc.insertString(0, text, null);
        if (sourceStartPos != -1) {
            assertTrue(sourceEndPos != -1);
            pane.setSelectionStart(sourceStartPos);
            pane.setSelectionEnd(sourceEndPos);
        } else if (caretPos != -1) {
            pane.getCaret().setDot(caretPos);
        }
        pane.getCaret().setSelectionVisible(true);

        return pane;
    }

    protected void runKitAction(JEditorPane jt, String actionName, String cmd) {
        BaseKit kit = (BaseKit) jt.getEditorKit();
        Action a = kit.getActionByName(actionName);
        assertNotNull(a);
        a.actionPerformed(new ActionEvent(jt, 0, cmd));
    }

    protected void setupDocumentIndentation(Document doc, IndentPrefs preferences) {
        // Enforce indentprefs
        if (preferences != null) {
            assertEquals("Hanging indentation not yet supported; must be exposed through options", preferences.getIndentation(), preferences.getHangingIndentation());
            Preferences prefs = CodeStylePreferences.get(doc).getPreferences();
            prefs.putInt(SimpleValueNames.INDENT_SHIFT_WIDTH, preferences.getIndentation());
        } else {
            int preferred = 4;
            if (getPreferredLanguage().hasFormatter()) {
                preferred = getPreferredLanguage().getFormatter().indentSize();
            }
            Preferences prefs = CodeStylePreferences.get(doc).getPreferences();
            prefs.putInt(SimpleValueNames.INDENT_SHIFT_WIDTH, preferred);
        }
    }

    public void insertNewline(String source, String reformatted, IndentPrefs preferences) throws Exception {
        int sourcePos = source.indexOf('^');
        assertTrue("Source text must have a caret ^ marker", sourcePos != -1);
        source = source.substring(0, sourcePos) + source.substring(sourcePos + 1);
        Formatter formatter = getFormatter(null);

        int reformattedPos = reformatted.indexOf('^');
        assertTrue("Reformatted text must have a caret ^ marker", reformattedPos != -1);
        reformatted = reformatted.substring(0, reformattedPos) + reformatted.substring(reformattedPos + 1);

        JEditorPane ta = getPane(source);
        Caret caret = ta.getCaret();
        caret.setDot(sourcePos);
        BaseDocument doc = (BaseDocument) ta.getDocument();
        if (formatter != null) {
            configureIndenters(doc, formatter, true);
        }

        setupDocumentIndentation(doc, preferences);

        runKitAction(ta, DefaultEditorKit.insertBreakAction, "\n");

        String formatted = doc.getText(0, doc.getLength());
        assertEquals(reformatted, formatted);

        if (reformattedPos != -1) {
            assertEquals(reformattedPos, caret.getDot());
        }
    }

    protected BaseKit getEditorKit(String mimeType) {
        org.netbeans.modules.csl.core.Language language = LanguageRegistry.getInstance().getLanguageByMimeType(mimeType);
        assertNotNull(language);
        if (!language.useCustomEditorKit()) {
            return new CslEditorKit(mimeType);
        }
        fail("Must override getEditorKit() for useCustomEditorKit languages");
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Formatting Tests
    ////////////////////////////////////////////////////////////////////////////
    protected Formatter getFormatter(IndentPrefs preferences) {
        Formatter formatter = getPreferredLanguage().getFormatter();
        assertNotNull("You must override getFormatter, either from your GsfLanguage or your test class", formatter);
        return formatter;
    }

    public class IndentPrefs {

        private final int hanging;

        private final int indent;

        public IndentPrefs(int indent, int hanging) {
            super();
            this.indent = indent;
            this.hanging = hanging;
        }

        public int getIndentation() {
            return indent;
        }

        public int getHangingIndentation() {
            return hanging;
        }
    }

    protected void insertBreak(String original, String expected) throws Exception {
        insertNewline(original, expected, null);
    }

    protected void configureIndenters(Document document, Formatter formatter, boolean indentOnly) {
        configureIndenters(document, formatter, indentOnly, getPreferredMimeType());
    }

    protected void configureIndenters(Document document, Formatter formatter, boolean indentOnly, String mimeType) {

        MockServices.setServices(MockMimeLookup.class);
        if (indentOnly) {
            MockMimeLookup.setInstances(MimePath.parse(mimeType), new GsfIndentTaskFactory());
        } else {
            MockMimeLookup.setInstances(MimePath.parse(mimeType), new GsfReformatTaskFactory(), new GsfIndentTaskFactory());
        }
    }

    protected static class CaretLineOffset {

        private final int offset;
        private final String caretLine;

        public CaretLineOffset(int offset, String caretLine) {
            this.offset = offset;
            this.caretLine = caretLine;
        }

    }
}
