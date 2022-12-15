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
package org.netbeans.modules.php.blade.editor;

import java.util.ArrayList;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.spi.editor.bracesmatching.BracesMatcher;
import org.netbeans.spi.editor.bracesmatching.BracesMatcherFactory;
import org.netbeans.spi.editor.bracesmatching.MatcherContext;

/**
 * highlight block tags directives using just the coloring token id
 *
 * @author Haidu Bogdan
 */
public class BladeBracesMatcher implements BracesMatcher {

    private final MatcherContext context;

    private BladeBracesMatcher(MatcherContext context) {
        this.context = context;
    }

    @Override
    public int[] findOrigin() throws InterruptedException, BadLocationException {
        ((AbstractDocument) context.getDocument()).readLock();
        try {
            TokenSequence<BladeTokenId> ts = BladeLexerUtils.getBladeTokenSequence(context.getDocument());
            ts.move(context.getSearchOffset());
            if (!ts.moveNext()) {
                return null;
            }
            Token<? extends BladeTokenId> currentToken = ts.token();
            if (currentToken == null) {
                return null;
            }
            int toffs = ts.offset();
            String tText = currentToken.text().toString();
            BladeTokenId id = currentToken.id();

            if (id.getPairStart(id) != null || id.getPairClose(id) != null) {
                //tag with pair tokenId configured
                return new int[]{toffs, toffs + tText.length()};
            } else if (BladeSyntax.DIRECTIVES_WITH_ENDTAGS.contains(tText.trim())) {
                //tag with end tag which is not treated by BladeTokenId
                return new int[]{toffs, toffs + tText.trim().length()};
            }

            return null;
        } finally {
            ((AbstractDocument) context.getDocument()).readUnlock();
        }
    }

    /**
     * searching for end tag | open tag
     *
     * @return
     * @throws InterruptedException
     * @throws BadLocationException
     */
    @Override
    public int[] findMatches() throws InterruptedException, BadLocationException {
        ((AbstractDocument) context.getDocument()).readLock();
        try {
            TokenSequence<BladeTokenId> ts = BladeLexerUtils.getBladeTokenSequence(context.getDocument());
            ts.move(context.getSearchOffset());
            if (!ts.moveNext()) {
                return null;
            }
            Token<? extends BladeTokenId> currentToken = ts.token();
            if (currentToken == null) {
                return null;
            }
            OffsetRange r;
            String tText = currentToken.text().toString();
            BladeTokenId id = currentToken.id();

            BladeTokenId closeToken = null;
            BladeTokenId openToken = null;

            switch (id.tokenType) {
                case TAG_OPEN_DIRECTIVE:
                    closeToken = id.getPairClose(id);
                    break;
                case TAG_CLOSE_DIRECTIVE:
                    openToken = id.getPairStart(id);
                    break;
            }

            if (closeToken != null) {
                if (id.equals(BladeTokenId.T_BLADE_SECTION)) {
                    //we can have multiple brackets for @section
                    BladeTokenId[] tokenDownIds = {closeToken, BladeTokenId.T_BLADE_SHOW, BladeTokenId.T_BLADE_STOP};
                    String[] endTagsText = {closeToken.fixedText(), "@show", "@stop"};
                    r = BladeLexerUtils.findFwd(ts, tokenDownIds, endTagsText);
                    return new int[]{r.getStart(), r.getEnd()};
                }
                r = BladeLexerUtils.findFwd(ts, closeToken, closeToken.fixedText());
                return new int[]{r.getStart(), r.getEnd()};
            } else if (openToken != null) {
                r = BladeLexerUtils.findBack(ts, openToken, openToken.fixedText());
                return new int[]{r.getStart(), r.getEnd()};
            } else if (BladeSyntax.DIRECTIVES_WITH_ENDTAGS.contains(tText.trim())) {
                //from @{tag} to @end{tag}
                String name = tText.trim().substring(1);
                r = BladeLexerUtils.findFwd(ts, "@end" + name, tText.trim());
                return new int[]{r.getStart(), r.getEnd()};
            } else if (tText.trim().startsWith("@end")) {
                //reverse from @end{tag} to @{tag}
                String tagOpen = "@" + tText.trim().substring(4);
                if (BladeSyntax.DIRECTIVES_WITH_ENDTAGS.contains(tagOpen)) {
                    r = BladeLexerUtils.findBack(ts, tagOpen, tText.trim(), new ArrayList<String>() {
                    });
                    return new int[]{r.getStart(), r.getEnd()};
                }
                return null;
            }
            return null;
        } finally {
            ((AbstractDocument) context.getDocument()).readUnlock();
        }
    }

    /**
     * BracesMatcherFactory
     */
    public static final class Factory implements BracesMatcherFactory {

        @Override
        public BracesMatcher createMatcher(MatcherContext context) {
            return new BladeBracesMatcher(context);
        }

    }

}
