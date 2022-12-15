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

import org.netbeans.modules.php.blade.editor.BladeLanguage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.lib.editor.util.CharSequenceUtilities;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.StructureItem;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTErrorExpression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeConstDirectiveStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveExpressionBlock;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeProgram;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Block;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.InLineBladePhp;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Statement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.StructureModelItem;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeExtendsStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveWithPath;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Expression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.InlineDirectiveStatement;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;

/**
 *
 * @author Haidu Bogdan
 */
public class BladeStructureScanner implements StructureScanner {

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/"; //NOI18N
    List<OffsetRange> ranges = new ArrayList<>();

    @Override
    public List<? extends StructureItem> scan(ParserResult info) {
        BladeParserResult result = (BladeParserResult) info;
        List<BaseBladeStructureItem> items = new ArrayList<>();

        BladeProgram program = result.getProgram();

        if (program != null) {
            List<Statement> statements = program.getStatements();
            for (Statement statement : statements) {
                if (statement instanceof StructureModelItem) {
                    if (statement instanceof BladeExtendsStatement) {
                        Expression label = ((BladeExtendsStatement) statement).getLabel();
                        if (!(label instanceof ASTErrorExpression)) {
                            items.add(new ExtendsBladeStructureItem(statement, result.getSnapshot()));
                        }
                    } else if (statement instanceof InLineBladePhp) {
                        items.add(new BaseBladeStructureItem(statement, result.getSnapshot(), "php"));
                    } else if (statement instanceof DirectiveExpressionBlock) {
                        Block body = ((DirectiveExpressionBlock) statement).getBody();
                        items.add(new BaseBladeStructureItem(statement, result.getSnapshot(), body, "bl"));
                    } else if (statement instanceof InlineDirectiveStatement) {
                        Expression label = ((InlineDirectiveStatement) statement).getLabel();
                        if (!(label instanceof ASTErrorExpression)) {
                            items.add(new InlineBladeStructureItem(statement, result.getSnapshot()));
                        }
                    } else if (statement instanceof BladeConstDirectiveStatement) {
                        items.add(new InlineBladeStructureItem(statement, result.getSnapshot()));
                    }
                }
            }
        }

        return items;
    }

    @Override
    public Map<String, List<OffsetRange>> folds(ParserResult info) {
        BladeParserResult result = (BladeParserResult) info;
        ranges = new ArrayList<OffsetRange>();
        BladeProgram program = result.getProgram();

        if (program != null) {
            List<Statement> statements = program.getStatements();
            addFolds(statements);
        }

        return Collections.singletonMap("tags", ranges);
    }

    public void addFolds(List<Statement> statements) {
        for (Statement statement : statements) {
            if (statement instanceof StructureModelItem) {
                if (statement instanceof InLineBladePhp) {
                    ranges.add(new OffsetRange(
                            statement.getStartOffset(), statement.getEndOffset()
                    ));
                } else if (statement instanceof DirectiveExpressionBlock) {
                    Block body = ((DirectiveExpressionBlock) statement).getBody();
                    ranges.add(new OffsetRange(
                            body.getStartOffset(), body.getEndOffset()
                    ));
                    if (!body.getStatements().isEmpty()) {
                        addFolds(body.getStatements());
                    }
                }
            }
        }
    }

    @Override
    public Configuration getConfiguration() {
        return null;
    }

    private class BaseBladeStructureItem implements StructureItem {

        private final Statement statement;
        private final List<? extends StructureItem> children;
        private final String sortPrefix;
        Snapshot snapshot;

        public BaseBladeStructureItem(Statement elementHandle, Snapshot snapshot, String sortPrefix) {
            this.statement = elementHandle;
            this.sortPrefix = sortPrefix;
            this.children = Collections.emptyList();
            this.snapshot = snapshot;
        }

        public BaseBladeStructureItem(Statement elementHandle, Snapshot snapshot, Block body, String sortPrefix) {
            this.statement = elementHandle;
            this.sortPrefix = sortPrefix;
            this.snapshot = snapshot;

            if (body != null) {
                List<StructureItem> items = new ArrayList<>();
                for (Statement st : body.getStatements()) {
                    if (st instanceof InLineBladePhp) {
                        items.add(new BaseBladeStructureItem(st, snapshot, "php"));
                    } else if (st instanceof DirectiveExpressionBlock) {
                        Block block = ((DirectiveExpressionBlock) st).getBody();
                        items.add(new BaseBladeStructureItem(st, snapshot, block, "bl"));
                    } else if (st instanceof InlineDirectiveStatement) {
                        items.add(new BaseBladeStructureItem(st, snapshot, "inl"));
                    }
                }
                this.children = items;
            } else {
                this.children = Collections.emptyList();
            }
        }

        @Override
        public String getName() {
            return statement.toString();
        }

        public String getLabel() {
            return ((DirectiveWithPath) statement).getLabel().toString();
        }

        @Override
        public String getSortText() {
            return getPosition() + sortPrefix + getName();
        }

        @Override
        public String getHtml(HtmlFormatter hf) {
            return "- " + getName();
        }

        @Override
        public BladeElementHandle getElementHandle() {
            return new BladeElementHandle(statement, snapshot);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.TAG;
        }

        @Override
        public Set<Modifier> getModifiers() {
            return Collections.emptySet();
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public List<? extends StructureItem> getNestedItems() {
            return children;
        }

        @Override
        public long getPosition() {
            return statement.getStartOffset();
        }

        @Override
        public long getEndPosition() {
            return statement.getEndOffset();
        }

        @Override
        public ImageIcon getCustomIcon() {
            return ImageUtilities.loadImageIcon(ICON_BASE + "icons/at.png", false);
        }

        @Override
        public int hashCode() {
            int hashCode = 11;
            if (getName() != null) {
                hashCode = 31 * getName().hashCode() + hashCode;
            }
            hashCode = (int) (31 * getPosition() + hashCode);
            return hashCode;
        }

    }

    private class InlineBladeStructureItem extends BaseBladeStructureItem {

        public InlineBladeStructureItem(Statement elementHandle, Snapshot snapshot) {
            super(elementHandle, snapshot, "inl");
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.TAG;
        }
    }

    private class ExtendsBladeStructureItem extends BaseBladeStructureItem {

        public ExtendsBladeStructureItem(Statement elementHandle, Snapshot snapshot) {
            super(elementHandle, snapshot, "ext");
        }

        public ExtendsBladeStructureItem(Statement elementHandle, Snapshot snapshot, Block body) {
            super(elementHandle, snapshot, body, "ext");
        }

        @Override
        public ImageIcon getCustomIcon() {
            return ImageUtilities.loadImageIcon(ICON_BASE + "icons/layout.png", false);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.PACKAGE;
        }

        @Override
        public String getHtml(HtmlFormatter hf) {
            return "- layout <em>" + getLabel() + "</em>";
        }
    }

    class BladeElementHandle implements ElementHandle {

        Statement statement;
        Snapshot snapshot;

        public BladeElementHandle(Statement item, Snapshot snapshot) {
            this.statement = item;
            this.snapshot = snapshot;
        }

        @Override
        public FileObject getFileObject() {
            return snapshot.getSource().getFileObject();
        }

        @Override
        public String getMimeType() {
            return BladeLanguage.BLADE_MIME_TYPE;
        }

        @Override
        public String getName() {
            return statement.toString();
        }

        @Override
        public String getIn() {
            return "Directive ";
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.ATTRIBUTE;
        }

        @Override
        public Set<Modifier> getModifiers() {
            if (CharSequenceUtilities.startsWith(statement.toString(), "*")) {
                return Collections.singleton(Modifier.STATIC);
            }
            return Collections.emptySet();
        }

        @Override
        public boolean signatureEquals(ElementHandle eh) {
            if (!(eh instanceof BladeElementHandle)) {
                return false;
            }
            return eh.getName().equals(this.getName());
        }

        @Override
        public OffsetRange getOffsetRange(ParserResult pr) {
            return new OffsetRange(statement.getStartOffset(), statement.getEndOffset());
        }

    }
}
