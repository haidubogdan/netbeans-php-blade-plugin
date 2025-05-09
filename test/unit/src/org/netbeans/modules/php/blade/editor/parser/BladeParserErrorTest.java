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

/**
 *
 * @author bogdan
 */
public class BladeParserErrorTest extends ParserTestBase {

    public BladeParserErrorTest(String testName) {
        super(testName);
    }

    public void testUnopendSetError_01() throws Exception {
        checkErrors("testfiles/parser/errors/unopend_if_block_error_01.blade.php");
    }

    public void testUclosedSectionError_01() throws Exception {
        checkErrors("testfiles/parser/errors/unclosed_section_error_01.blade.php");
    }

    public void testInlineSectionNoError_01() throws Exception {
        checkErrors("testfiles/parser/errors/inline_section_noerror_01.blade.php");
    }
    
    public void testUnclosedDirectiveBracketError_01() throws Exception {
        checkErrors("testfiles/parser/errors/unclosed_directive_bracket_error_01.blade.php");
    }
    
    public void testIssue54() throws Exception {
        checkErrors("testfiles/parser/errors/issue_54_noerror_on_php_directive.blade.php");
    }
    
    public void testWrongForeachSyntaxError() throws Exception {
        checkErrors("testfiles/parser/errors/wrong_foreach_syntax_error.blade.php");
    }

    public void testWrongEmptySyntaxError() throws Exception {
        checkErrors("testfiles/parser/errors/wrong_empty_syntax_error.blade.php");
    }
}
