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

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.netbeans.editor.BaseDocument;
import static org.netbeans.junit.NbTestCase.assertFile;
import static org.netbeans.modules.php.blade.editor.BladeTestBase.copyStringToFileObject;
import org.netbeans.spi.editor.bracesmatching.BracesMatcher;
import org.netbeans.spi.editor.bracesmatching.BracesMatcherFactory;
import org.netbeans.spi.editor.bracesmatching.MatcherContext;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bogdan
 */
public class BladeBracesMatcherTest extends BladeTestBase {

    public BladeBracesMatcherTest(String testName) {
        super(testName);
    }

    public void testClosedIfDirective_01() throws Exception {
        testMatches("<html>\n"
                + "@if($x)\n"
                + "text\n"
                + "@end^if\n"
                + "</html>");
    }
    
    public void testClosedSectionDirective_01() throws Exception {
        testMatches("<html>\n"
                + "@sec^tion($x)\n"
                + "text\n"
                + "@endsection\n"
                + "</html>");
    }
    
    public void testClosedSectionDirective_02() throws Exception {
        testMatches("<html>\n"
                + "@sec^tion($x)\n"
                + "text\n"
                + "@show\n"
                + "</html>");
    }
    
    public void testUnclosedSectionDirective_01() throws Exception {
        testMatches("<html>\n"
                + "@sec^tion($x)\n"
                + "text\n"
                + "@endsec\n"
                + "</html>");
    }
    
    public void testRawEcho_01() throws Exception {
        testMatches("<html>\n"
                + "{!^!"
                + " $test"
                + "!!}\n"
                + "</html>");
    }

    private void testMatches(String original) throws Exception {
        BracesMatcherFactory factory = new BladeBracesMatcher.Factory();
        int caretPosition = original.indexOf('^');
        assert caretPosition != -1;
        original = original.substring(0, caretPosition) + original.substring(caretPosition + 1);

        BaseDocument doc = getDocument(original);

        MatcherContext context = BracesMatchingTestUtils.createMatcherContext(doc, caretPosition, false, 1);
        BracesMatcher matcher = factory.createMatcher(context);
        int[] origin = null, matches = null;
        try {
            origin = matcher.findOrigin();
            matches = matcher.findMatches();
        } catch (InterruptedException ex) {
        }

        assertNotNull("Did not find origin", origin);
        assertEquals("Wrong origin length", 2, origin.length);

        int matchesLength = 0;
        if (matches != null) {
            matchesLength = matches.length;
        }
        int[] boundaries = new int[origin.length + matchesLength];
        System.arraycopy(origin, 0, boundaries, 0, origin.length);
        if (matchesLength != 0) {
            System.arraycopy(matches, 0, boundaries, origin.length, matches.length);
        }

        Integer[] boundariesIntegers = new Integer[boundaries.length];
        for (int i = 0; i < boundaries.length; i++) {
            boundariesIntegers[i] = boundaries[i];
        }
        Arrays.sort(boundariesIntegers, Collections.reverseOrder());
        String expected = original;
        boolean caretInserted = false;
        for (int i : boundariesIntegers) {
            if (i <= caretPosition && !caretInserted) {
                expected = expected.substring(0, caretPosition) + "^" + expected.substring(caretPosition);
                caretInserted = true;
            }
            expected = expected.substring(0, i) + "*" + expected.substring(i);
        }
        
        int x = 1;
        assertFileContent(expected);
    }
    
    protected void assertFileContent(String expected) throws IOException{
//        String fullClassName = this.getClass().getName();
        // try to find golden file
        String goldenFolder = getDataSourceDir().getAbsolutePath() + "/testfiles/braces/";
        File goldenFile = new File(goldenFolder +  getName() + ".braces");
        if (!goldenFile.exists()) {
            // if doesn't exist, create it
            FileObject goldenFO = touch(goldenFolder,  getName() + ".braces");
            copyStringToFileObject(goldenFO, expected);
        } else {
            // if exist, compare it.
            FileObject resultFO = touch(getWorkDir(),  getName() + ".result");
            copyStringToFileObject(resultFO, expected);
            assertFile(FileUtil.toFile(resultFO), goldenFile, getWorkDir());
        }
    }
}
