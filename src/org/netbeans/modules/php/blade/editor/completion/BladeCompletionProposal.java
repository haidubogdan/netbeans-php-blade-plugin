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
package org.netbeans.modules.php.blade.editor.completion;

import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionContextFinder.CompletionContext;
import org.netbeans.modules.php.blade.editor.completion.Bundle;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.openide.util.NbBundle;

/**
 *
 * @author Haidu Bogdan
 */
public abstract class BladeCompletionProposal implements CompletionProposal {
    private final BladeElement element;
    private final CompletionRequest request;

    public BladeCompletionProposal(final BladeElement element, final CompletionRequest request) {
        this.element = element;
        this.request = request;
    }

    @Override
    public int getAnchorOffset() {
        return request.anchorOffset;
    }

    @Override
    public ElementHandle getElement() {
        return element;
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public String getInsertPrefix() {
        return element.getName();
    }

    @Override
    public String getSortText() {
        return element.getName();
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return element.getModifiers();
    }

    @Override
    public boolean isSmart() {
        return getName().startsWith(request.prefix);
    }

    @Override
    public int getSortPrioOverride() {
        return 0;
    }

    @Override
    public String getLhsHtml(HtmlFormatter formatter) {
        formatter.name(getKind(), true);
        formatter.appendText(getName());
        formatter.name(getKind(), false);
        element.formatParameters(formatter);
        return formatter.getText();
    }

    @Override
    public String getCustomInsertTemplate() {
        return element.getTemplate();
    }

    static class DirectiveCompletionProposal extends BladeCompletionProposal {

        public DirectiveCompletionProposal(BladeElement element, CompletionRequest request) {
            super(element, request);
        }

        @Override
        @NbBundle.Messages("TagRhs=Tag")
        public String getRhsHtml(HtmlFormatter formatter) {
            try {
                return Bundle.TagRhs();
            } catch (Exception ex) {
                //LOGGER.log(Level.FINE, null, ex);
            }
            return "";
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.TAG;
        }

    }

    public static class CompletionRequest {
        public int anchorOffset;
        public String prefix;
        public BladeParserResult parserResult;
        public CompletionContext context;
    }

}
