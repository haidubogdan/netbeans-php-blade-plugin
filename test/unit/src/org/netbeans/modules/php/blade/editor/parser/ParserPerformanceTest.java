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

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.parser.BladeParser;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class ParserPerformanceTest extends ParserTestBase {

    public ParserPerformanceTest(String testName) {
        super(testName);
    }

    public void testFile_01() throws Exception {
        testGoodFile("testfiles/parser/performance/perf_test_01.blade.php", 500);
    }

    private void testGoodFile(String filePath, int expectedTime) throws Exception {
        FileObject fileObj = getTestFile(filePath);
        ParsingUtils parserUtils = new ParsingUtils();
        Source testSource = parserUtils.createSource(readFile(fileObj));
        Date start = new Date();
        ParserManager.parse(Collections.singletonList(testSource), new UserTask() {

            @Override
            public void run(ResultIterator resultIterator) throws Exception {
                Parser.Result result = resultIterator.getParserResult();
                assertNotNull(result);
                ParserResult parserResult = (ParserResult) result;
                List<? extends org.netbeans.modules.csl.api.Error> diagnostics = parserResult.getDiagnostics();
                assertTrue(diagnostics.isEmpty());
            }
        });

        Date end = new Date();

        long time = end.getTime() - start.getTime();
        long fileSize = fileObj.getSize() / 1024;
        String output = String.format(
                "Parsing of file(%s: %sKB) takes: %sms",
                fileObj.getName(),
                fileSize,
                time
        );

        System.out.println(output);
        assertTrue("Parsing time should be below 500. It took " + time + "ms", time < expectedTime);
    }

    @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = ParserFactory.class)
    public static final class BladeParserFactory extends ParserFactory {

        @Override
        public Parser createParser(Collection<Snapshot> snapshots) {
            return new BladeParser();
        }

    }
}
