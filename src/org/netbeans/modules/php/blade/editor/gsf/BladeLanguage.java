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
package org.netbeans.modules.php.blade.editor.gsf;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionHandler;
import org.netbeans.modules.php.blade.editor.formater.BladeFormatter;
import org.netbeans.modules.php.blade.editor.lexer.BladeTopTokenId;
import org.netbeans.modules.php.blade.editor.parsing.BladeParser;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

/**
 *
 * @author Haidu Bogdan
 */
@LanguageRegistration(mimeType = "text/x-blade", useCustomEditorKit = true)
public class BladeLanguage extends DefaultLanguageConfig {
    public BladeLanguage() {}
    public static final String BLADE_MIME_TYPE = "text/x-blade";
    
    @Override
    public Language <BladeTopTokenId> getLexerLanguage() {
        return BladeTopTokenId.language();
    }

    @Override
    public String getDisplayName() {
        return "Blade";
    }
    
    @Override
    public boolean isUsingCustomEditorKit() { return true; }
    
    @Override
    public boolean isIdentifierChar(char c) { return Character.isLetter(c); }
    
    @Override
    public Parser getParser() { return new BladeParser(); }
    
    @Override
    public boolean hasStructureScanner() { return true; }

    @Override
    public StructureScanner getStructureScanner() { return new BladeStructureScanner(); }
    
    @Override
    public boolean hasHintsProvider() { return false; }
    
    @Override
    public CodeCompletionHandler getCompletionHandler() {
        return new BladeCompletionHandler();
    }
    
    @Override
    public boolean hasFormatter() {
        return true;
    }

    @Override
    public Formatter getFormatter() {
        return new BladeFormatter();
    }

}
