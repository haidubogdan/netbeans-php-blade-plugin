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
package org.netbeans.modules.php.blade.editor.formatter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.formatter.IndentationCounter.Indentation;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.openide.filesystems.FileObject;

/**
 *
 * @author Haidu Bogdan
 */
public class BladeFormatter implements Formatter {

    private static final Logger LOGGER = Logger.getLogger(BladeFormatter.class.getName());

    public BladeFormatter() {
        LOGGER.log(Level.FINE, "BLADE Formatter: {0}", this.toString()); //NOI18N
    }

    @Override
    public void reformat(Context context, ParserResult info) {
        FileObject file = info.getSnapshot().getSource().getFileObject();
        if (file == null){
            return;
        }
        Project project = FileOwnerQuery.getOwner (file);
        if (project == null){
            return;
        }
        String projectName = project.getClass().getSimpleName();
        if (!(projectName.equals("PhpProject"))){
            FileObject parent = project.getProjectDirectory().getParent();
            project = FileOwnerQuery.getOwner(parent); //getting the parent project
            if (project == null || !(project.getClass().getSimpleName().equals("PhpProject"))) {
                LOGGER.log(Level.WARNING, "project for blade file not found {0}", file.getPath());
                return;
            }
        }
        boolean reformattingEnabled = BladeProjectProperties.getInstance(project).isAutoFormattingEnabled();
        if (!reformattingEnabled){
            return;
        }
        
        long start = System.currentTimeMillis();
        Runnable rn = new Runnable() {
            @Override
            public void run() {
                (new TokenFormatter()).reformat(context, info);
            }
        };
        //wait until html indent is finished
        SwingUtilities.invokeLater(rn);
        if (LOGGER.isLoggable(Level.FINE)) {
            long end = System.currentTimeMillis();
            LOGGER.log(Level.FINE, "Reformat took: {0} ms", (end - start)); //NOI18N
        }
    }

    @Override
    public void reindent(Context context) {
        String mimeType = getMimeTypeAtOffset(context.document(), context.startOffset());
        String mimePath = context.mimePath(); // avoid to call twice
        if (BladeLanguage.BLADE_MIME_TYPE.equals(mimeType) && mimePath.startsWith(BladeLanguage.BLADE_MIME_TYPE)) {
            Indentation indent = new IndentationCounter((BaseDocument) context.document()).count(context.caretOffset());
            indent.modify(context);
        }
    }

    @Override
    public boolean needsParserResult() {
        return true;
    }

    @Override
    public int indentSize() {
        return 4;
    }

    @Override
    public int hangingIndentSize() {
        return 8;
    }

    private static String getMimeTypeAtOffset(Document doc, int offset) {
        TokenHierarchy<?> th = TokenHierarchy.get(doc);
        List<TokenSequence<?>> tsl = th.embeddedTokenSequences(offset, false);
        if (tsl != null && tsl.size() > 0) {
            TokenSequence<?> tokenSequence = tsl.get(tsl.size() - 1);
            return tokenSequence.language().mimeType();
        }
        return null;
    }
}
