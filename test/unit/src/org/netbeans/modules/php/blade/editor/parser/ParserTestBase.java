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

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.swing.text.Document;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.editor.BaseDocument;
import org.netbeans.junit.MockServices;
import org.netbeans.lib.lexer.inc.DocumentInput;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.CodeCompletionHandler.QueryType;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.CslTestBase;
import org.netbeans.modules.php.blade.editor.MockMimeLookup;
import org.openide.filesystems.FileUtil;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;
import org.netbeans.modules.php.blade.editor.parser.BladeParser;
import org.openide.filesystems.FileObject;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.parsing.impl.indexing.implspi.ActiveDocumentProvider;
import org.netbeans.spi.editor.document.DocumentFactory;
import org.openide.cookies.EditorCookie;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author bogdan
 */
public abstract class ParserTestBase extends CslTestBase {

    public ParserTestBase(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        String mimeType = BladeLanguage.MIME_TYPE;

        MockMimeLookup.setInstances(
                MimePath.get(mimeType), new BladeParserErrorTest.BladeParserFactory());
        MockServices.setServices(MockMimeLookup.class, TestEnvironmentFactory.class);

        //mocking php extension to blade
        FileUtil.setMIMEType("php", mimeType);

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

    protected void checkErrors(final String relFilePath) throws Exception {
        Source testSource = getTestSource(relFilePath);

        ParserManager.parse(Collections.singleton(testSource), new UserTask() {
            public @Override
            void run(ResultIterator resultIterator) throws Exception {
                Parser.Result r = resultIterator.getParserResult();
                assertNotNull(r);
                assertTrue(r instanceof ParserResult);

                ParserResult pr = (ParserResult) r;
                List<? extends Error> diagnostics = pr.getDiagnostics();
                String annotatedSource = annotateErrors(diagnostics);
                assertDescriptionMatches(relFilePath, annotatedSource, false, ".errors");
            }
        });
    }

    protected String annotateErrors(List<? extends Error> errors) {
        List<String> descs = new ArrayList<String>();
        for (Error error : errors) {
            StringBuilder desc = new StringBuilder();
            if (error.getKey() != null) {
                desc.append("[");
                desc.append(error.getKey());
                desc.append("] ");
            }
            desc.append(error.getStartPosition());
            desc.append("-");
            desc.append(error.getEndPosition());
            desc.append(":");
            desc.append(error.getDisplayName());
            if (error.getDescription() != null) {
                desc.append(" ; ");
                desc.append(error.getDescription());
            }
            descs.add(desc.toString());
        }
        Collections.sort(descs);
        StringBuilder summary = new StringBuilder();
        for (String desc : descs) {
            summary.append(desc);
            summary.append("\n");
        }

        return summary.toString();
    }

    protected Source getTestSource(String testFile) {
        FileObject fileObj = getTestFile(testFile);
        ParsingUtils parserUtils = new ParsingUtils();
        return parserUtils.createSource(readFile(fileObj));
    }

    public void checkCompletion(final String file, final String caretLine, final boolean includeModifiers) throws Exception {
        // TODO call TestCompilationInfo.setCaretOffset!
        final QueryType type = QueryType.COMPLETION;
        final boolean caseSensitive = true;

        Source testSource = getTestSource(file);
        Snapshot snp =  testSource.createSnapshot();

        final int caretOffset;
        if (caretLine != null) {
            caretOffset = getCaretOffset(testSource.createSnapshot().getText().toString(), caretLine);
            enforceCaretOffset(testSource, caretOffset);
        } else {
            caretOffset = -1;
        }

        final String[] described = new String[1];
        UserTask task = new UserTask() {
            public @Override
            void run(ResultIterator resultIterator) throws Exception {
                Parser.Result r = caretOffset == -1 ? resultIterator.getParserResult() : resultIterator.getParserResult(caretOffset);
                assertTrue(r instanceof ParserResult);
                
                ParserResult pr = (ParserResult) r;
                Snapshot s = pr.getSnapshot();
                CodeCompletionHandler cc = getCodeCompleter();
                assertNotNull("getCodeCompleter must be implemented", cc);
                FileObject snapshotFile = pr.getSnapshot().getSource().getFileObject();
                Document doc = testSource.getDocument(false);
                Object test = DocumentInput.get(doc);
                boolean upToOffset = type == QueryType.COMPLETION;
                String prefix = null;
                try {
                    prefix = cc.getPrefix(pr, caretOffset, upToOffset);
                } catch (Exception ex) {
                    int x = 1;
                }
                if (prefix == null) {
                    if (prefix == null) {
                        int[] blk
                                = org.netbeans.editor.Utilities.getIdentifierBlock((BaseDocument) doc, caretOffset);

                        if (blk != null) {
                            int start = blk[0];
                            if (start < caretOffset) {
                                if (upToOffset) {
                                    prefix = doc.getText(start, caretOffset - start);
                                } else {
                                    prefix = doc.getText(start, blk[1] - start);
                                }
                            }
                        }
                    }
                }

                final int finalCaretOffset = caretOffset;
                final String finalPrefix = prefix;
                final ParserResult finalParserResult = pr;
                CodeCompletionContext context = new CodeCompletionContext() {

                    @Override
                    public int getCaretOffset() {
                        return finalCaretOffset;
                    }

                    @Override
                    public ParserResult getParserResult() {
                        return finalParserResult;
                    }

                    @Override
                    public String getPrefix() {
                        return finalPrefix;
                    }

                    @Override
                    public boolean isPrefixMatch() {
                        return true;
                    }

                    @Override
                    public QueryType getQueryType() {
                        return type;
                    }

                    @Override
                    public boolean isCaseSensitive() {
                        return caseSensitive;
                    }
                };

                CodeCompletionResult completionResult = cc.complete(context);
                List<CompletionProposal> proposals = completionResult.getItems();

                final boolean deprecatedHolder[] = new boolean[1];
                final HtmlFormatter formatter = new HtmlFormatter() {
                    private StringBuilder sb = new StringBuilder();

                    @Override
                    public void reset() {
                        sb.setLength(0);
                    }

                    @Override
                    public void appendHtml(String html) {
                        sb.append(html);
                    }

                    @Override
                    public void appendText(String text, int fromInclusive, int toExclusive) {
                        sb.append(text, fromInclusive, toExclusive);
                    }

                    @Override
                    public void emphasis(boolean start) {
                    }

                    @Override
                    public void active(boolean start) {
                    }

                    @Override
                    public void name(ElementKind kind, boolean start) {
                    }

                    @Override
                    public void parameters(boolean start) {
                    }

                    @Override
                    public void type(boolean start) {
                    }

                    @Override
                    public void deprecated(boolean start) {
                        deprecatedHolder[0] = true;
                    }

                    @Override
                    public String getText() {
                        return sb.toString();
                    }
                };

                described[0] = describeCompletion(caretLine, pr.getSnapshot().getSource().createSnapshot().getText().toString(), caretOffset, true, caseSensitive, type, proposals, includeModifiers, deprecatedHolder, formatter);
            }
        };
        ParserManager.parse(Collections.singleton(testSource), task);
        assertDescriptionMatches(file, described[0], true, true, ".completion", true, false);
    }

    private String getSourceLine(String s, int offset) {
        int begin = offset;
        if (begin > 0) {
            begin = s.lastIndexOf('\n', offset - 1);
            if (begin == -1) {
                begin = 0;
            } else if (begin < s.length()) {
                begin++;
            }
        }
        if (s.length() == 0) {
            return s;
        }
//        s.charAt(offset);
        int end = s.indexOf('\n', begin);
        if (end == -1) {
            end = s.length();
        }

        if (offset < end) {
            return (s.substring(begin, offset) + "|" + s.substring(offset, end)).trim();
        } else {
            return (s.substring(begin, end) + "|").trim();
        }
    }

    protected String getSourceWindow(String s, int offset) {
        int prevLineBegin;
        int nextLineEnd;
        int begin = offset;
        if (offset > 0) {
            begin = s.lastIndexOf('\n', offset);
            if (begin == -1) {
                begin = 0;
                prevLineBegin = 0;
            } else if (begin > 0) {
                prevLineBegin = s.lastIndexOf('\n', begin - 1);
                if (prevLineBegin == -1) {
                    prevLineBegin = 0;
                } else if (prevLineBegin < s.length()) {
                    prevLineBegin++;
                }
            } else {
                prevLineBegin = 0;
            }
        } else {
            prevLineBegin = 0;
        }
        int end = s.indexOf('\n', offset);
        if (end == -1) {
            end = s.length();
            nextLineEnd = end;
        } else if (end < s.length()) {
            nextLineEnd = s.indexOf('\n', end + 1);
            if (nextLineEnd == -1) {
                s.length();
            }
        } else {
            nextLineEnd = end;
        }
        return s.substring(prevLineBegin, offset) + "|" + s.substring(offset, nextLineEnd);
    }

    private String describeCompletion(String caretLine, String text, int caretOffset, boolean prefixSearch, boolean caseSensitive, QueryType type, List<CompletionProposal> proposals,
            boolean includeModifiers, boolean[] deprecatedHolder, final HtmlFormatter formatter) {
        assertTrue(deprecatedHolder != null && deprecatedHolder.length == 1);
        StringBuilder sb = new StringBuilder();
        sb.append("Code completion result for source line:\n");
        String sourceLine = getSourceLine(text, caretOffset);
        if (sourceLine.length() == 1) {
            sourceLine = getSourceWindow(text, caretOffset);
        }
        sb.append(sourceLine);
        sb.append("\n(QueryType=" + type + ", prefixSearch=" + prefixSearch + ", caseSensitive=" + caseSensitive + ")");
        sb.append("\n");

        // Sort to make test more stable
        proposals.sort(new Comparator<CompletionProposal>() {

            public int compare(CompletionProposal p1, CompletionProposal p2) {
                // Smart items first
                if (p1.isSmart() != p2.isSmart()) {
                    return p1.isSmart() ? -1 : 1;
                }

                if (p1.getKind() != p2.getKind()) {
                    return p1.getKind().compareTo(p2.getKind());
                }

                formatter.reset();
                String p1L = p1.getLhsHtml(formatter);
                formatter.reset();
                String p2L = p2.getLhsHtml(formatter);

                if (!p1L.equals(p2L)) {
                    return p1L.compareTo(p2L);
                }

                formatter.reset();
                String p1Rhs = p1.getRhsHtml(formatter);
                formatter.reset();
                String p2Rhs = p2.getRhsHtml(formatter);
                if (p1Rhs == null) {
                    p1Rhs = "";
                }
                if (p2Rhs == null) {
                    p2Rhs = "";
                }
                if (!p1Rhs.equals(p2Rhs)) {
                    return p1Rhs.compareTo(p2Rhs);
                }

                // Yuck - tostring comparison of sets!!
                if (!p1.getModifiers().toString().equals(p2.getModifiers().toString())) {
                    return p1.getModifiers().toString().compareTo(p2.getModifiers().toString());
                }

                return 0;
            }
        });

        boolean isSmart = true;
        for (CompletionProposal proposal : proposals) {
            if (isSmart && !proposal.isSmart()) {
                sb.append("------------------------------------\n");
                isSmart = false;
            }

            deprecatedHolder[0] = false;
            formatter.reset();
            proposal.getLhsHtml(formatter); // Side effect to deprecatedHolder used
            boolean strike = includeModifiers && deprecatedHolder[0];

            String n = proposal.getKind().toString();
            int MAX_KIND = 10;
            if (n.length() > MAX_KIND) {
                sb.append(n.substring(0, MAX_KIND));
            } else {
                sb.append(n);
                for (int i = n.length(); i < MAX_KIND; i++) {
                    sb.append(" ");
                }
            }

//            if (proposal.getModifiers().size() > 0) {
//                List<String> modifiers = new ArrayList<String>();
//                for (Modifier mod : proposal.getModifiers()) {
//                    modifiers.add(mod.name());
//                }
//                Collections.sort(modifiers);
//                sb.append(modifiers);
//            }
            sb.append(" ");

            formatter.reset();
            n = proposal.getLhsHtml(formatter);
            int MAX_LHS = 30;
            if (strike) {
                MAX_LHS -= 6; // Account for the --- --- strikethroughs
                sb.append("---");
            }
            if (n.length() > MAX_LHS) {
                sb.append(n.substring(0, MAX_LHS));
            } else {
                sb.append(n);
                for (int i = n.length(); i < MAX_LHS; i++) {
                    sb.append(" ");
                }
            }

            if (strike) {
                sb.append("---");
            }

            sb.append("  ");

            assertNotNull("Return Collections.emptySet() instead from getModifiers!", proposal.getModifiers());
            if (proposal.getModifiers().isEmpty()) {
                n = "";
            } else {
                n = proposal.getModifiers().toString();
            }
            int MAX_MOD = 9;
            if (n.length() > MAX_MOD) {
                sb.append(n.substring(0, MAX_MOD));
            } else {
                sb.append(n);
                for (int i = n.length(); i < MAX_MOD; i++) {
                    sb.append(" ");
                }
            }

            sb.append("  ");

            formatter.reset();
            sb.append(proposal.getRhsHtml(formatter));
            sb.append("\n");

            isSmart = proposal.isSmart();
        }

        return sb.toString();
    }

    protected final void enforceCaretOffset(Source source, int offset) {
        try {
            Method m = GsfUtilities.class.getDeclaredMethod("setLastKnowCaretOffset", Source.class, Integer.TYPE);
            m.setAccessible(true);
            m.invoke(null, source, offset);
        } catch (Exception e) {
            throw new IllegalStateException("Can't enforce caret offset on " + source, e);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // Code Completion Tests
    ////////////////////////////////////////////////////////////////////////////
    protected CodeCompletionHandler getCodeCompleter() {
        CodeCompletionHandler handler = getPreferredLanguage().getCompletionHandler();
        assertNotNull("You must override getCompletionHandler, either from your GsfLanguage or your test class", handler);
        return handler;
    }

    @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = ParserFactory.class)
    public static final class BladeParserFactory extends ParserFactory {

        @Override
        public Parser createParser(Collection<Snapshot> snapshots) {
            return new BladeParser();
        }

    }

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
}
