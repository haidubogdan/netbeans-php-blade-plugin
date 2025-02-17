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
package org.netbeans.modules.php.blade.editor.navigator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.netbeans.junit.NbTestCase.assertFile;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.StructureItem;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import static org.netbeans.modules.php.blade.editor.CslTestBase.copyStringToFileObject;
import org.netbeans.modules.php.blade.editor.TestHtmlFormatter;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.ParserTestBase;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bogdan
 */
public abstract class BladeNavigatorTestBase extends ParserTestBase {

    public BladeNavigatorTestBase(String testName) {
        super(testName);
    }

    protected String getTestResult(String filename) throws Exception {
        StringBuilder sb = new StringBuilder();

        Source testSource = getTestSource("testfiles/" + filename + ".php");

        final BladeStructureScanner instance = new BladeStructureScanner();
        final List<StructureItem> result = new ArrayList<>();
        UserTask task = new UserTask() {
            @Override
            public void run(ResultIterator resultIterator) throws Exception {
                BladeParserResult info = (BladeParserResult) resultIterator.getParserResult();
                if (info != null) {
                    result.addAll(instance.scan(info));
                }
            }
        };

        ParserManager.parse(Collections.singleton(testSource), task);

        for (StructureItem structureItem : result) {
            structureItem.getNestedItems();
            sb.append(printStructureItem(structureItem, 0));
            sb.append("\n");
        }
        return sb.toString();
    }

    private String printStructureItem(StructureItem structureItem, int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(indent));
        if (structureItem instanceof StructureItem.InheritedItem) {
            if (((StructureItem.InheritedItem) structureItem).isInherited()) {
                sb.append("(Inherited) ");
            }
        }
        sb.append(structureItem.getName());
        sb.append(" [");
        sb.append(structureItem.getPosition());
        sb.append(", ");
        sb.append(structureItem.getEndPosition());
        sb.append("] : ");
        HtmlFormatter formatter = new TestHtmlFormatter();
        sb.append(structureItem.getHtml(formatter));
        List<? extends StructureItem> nestedItems = structureItem.getNestedItems();

        for (StructureItem item : nestedItems) {
            sb.append("\n");
            sb.append(printStructureItem(item, indent + 1));
        }
        return sb.toString();
    }

    private String indent(int indent) {
        String text = "|-";
        for (int i = 0; i < indent; i++) {
            text = text + "-";
        }
        return text;
    }

    protected void performTest(String filename) throws Exception {
        // parse the file
        String result = getTestResult(filename);
        String fullClassName = this.getClass().getName();
        String goldenFileDir = fullClassName.replace('.', '/');
        // try to find golden file
        String goldenFolder = getDataSourceDir().getAbsolutePath() + "/goldenfiles/" + goldenFileDir + "/";
        File goldenFile = new File(goldenFolder + filename + ".pass");
        if (!goldenFile.exists()) {
            // if doesn't exist, create it
            FileObject goldenFO = touch(goldenFolder, filename + ".pass");
            copyStringToFileObject(goldenFO, result);
        } else {
            // if exist, compare it.
            FileObject resultFO = touch(getWorkDir(), filename + ".result");
            copyStringToFileObject(resultFO, result);
            assertFile(FileUtil.toFile(resultFO), goldenFile, getWorkDir());
        }
    }
}
