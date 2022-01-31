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

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexer;
import org.netbeans.spi.editor.bracesmatching.BracesMatcher;
import org.netbeans.spi.editor.bracesmatching.BracesMatcherFactory;
import org.netbeans.spi.editor.bracesmatching.MatcherContext;

/**
 * highlight block tags directives
 * TODO do bi-directional highlighting
 * TODO maybe use a block scope impl
 * 
 * @author Haidu Bogdan
 */
public class BladeBracesMatcher implements BracesMatcher {

    private final MatcherContext context;
    
    private static Collection<BladeTokenId> TOKENS_WITH_ENDTAGS = Arrays.asList(
            BladeTokenId.T_BLADE_PHP_OPEN,
            BladeTokenId.T_BLADE_IF,
            BladeTokenId.T_BLADE_FOR,
            BladeTokenId.T_BLADE_FOREACH,
            BladeTokenId.T_BLADE_SECTION
    );
    
    private BladeBracesMatcher(MatcherContext context) {
        this.context = context;
    }

    @Override
    public int[] findOrigin() throws InterruptedException, BadLocationException {
        int searchOffset = context.getSearchOffset();
        ((AbstractDocument) context.getDocument()).readLock();
        try {
            TokenSequence<BladeTokenId> ts = BladeLexerUtils.getBladeTokenSequence(context.getDocument());

            while (searchOffset != context.getLimitOffset()) {
                int diff = ts.move(searchOffset);
                searchOffset = searchOffset + (context.isSearchingBackward() ? -1 : +1);

                if (diff == 0 && context.isSearchingBackward()) {
                    //we are searching backward and the offset is at the token boundary
                    if (!ts.movePrevious()) {
                        continue;
                    }
                } else {
                    if (!ts.moveNext()) {
                        continue;
                    }
                }
                Token<? extends BladeTokenId> t = ts.token();
                int toffs = ts.offset();
                String tText = t.text().toString();
                BladeTokenId id = t.id();
                if (id == BladeTokenId.T_BLADE_OPEN_ECHO) {
                    return new int[]{toffs, toffs + tText.length()};
                } else if (id == BladeTokenId.T_BLADE_OPEN_ECHO_ESCAPED) {
                    return new int[]{toffs, toffs + tText.length()};
                } else if (id == BladeTokenId.T_BLADE_COMMENT && tText.equals(BladeLexer.OPEN_COMMENT)) {
                    return new int[]{toffs, toffs + tText.length()};
                } else if (TOKENS_WITH_ENDTAGS.contains(id)) {
                    return new int[]{toffs, toffs + tText.trim().length()};
                } else if (BladeSyntax.DIRECTIVES_WITH_ENDTAGS.contains(tText.trim())) {
                    return new int[]{toffs, toffs + tText.trim().length()};
                } else if (id == BladeTokenId.BLADE_PHP_TOKEN && tText.trim().equals("(")){
                    ts.move(searchOffset - 1);
                    if (!ts.movePrevious()) {
                        continue;
                    }
                    Token<? extends BladeTokenId> dToken = ts.token();
                    int directiveOffs = ts.offset();
                    String dText = dToken.text().toString();
                    if (TOKENS_WITH_ENDTAGS.contains(dToken.id())) {
                        return new int[]{directiveOffs, directiveOffs + dText.trim().length()};
                    }
                }
            }
            return null;
        } finally {
            ((AbstractDocument) context.getDocument()).readUnlock();
        }
    }

    @Override
    public int[] findMatches() throws InterruptedException, BadLocationException {
        int searchOffset = context.getSearchOffset();
        ((AbstractDocument) context.getDocument()).readLock();
        try {
            TokenSequence<BladeTokenId> ts = BladeLexerUtils.getBladeTokenSequence(context.getDocument());

            while (searchOffset != context.getLimitOffset()) {
                int diff = ts.move(searchOffset);
                searchOffset = searchOffset + (context.isSearchingBackward() ? -1 : +1);

                if (diff == 0 && context.isSearchingBackward()) {
                    //we are searching backward and the offset is at the token boundary
                    if (!ts.movePrevious()) {
                        continue;
                    }
                } else {
                    if (!ts.moveNext()) {
                        continue;
                    }
                }
                OffsetRange r;
                Token<? extends BladeTokenId> t = ts.token();
                String tText = t.text().toString();
                if (t.id() == BladeTokenId.T_BLADE_OPEN_ECHO) {
                    r = BladeLexerUtils.findFwd(ts, BladeTokenId.T_BLADE_CLOSE_ECHO, "}}");
                    return new int[]{r.getStart(), r.getEnd()};
                } else if (t.id() == BladeTokenId.T_BLADE_OPEN_ECHO_ESCAPED) {
                    r = BladeLexerUtils.findFwd(ts, BladeTokenId.T_BLADE_CLOSE_ECHO_ESCAPED, "!!}");
                    return new int[]{r.getStart(), r.getEnd()};
                } else if (t.id() == BladeTokenId.T_BLADE_COMMENT && tText.equals(BladeLexer.OPEN_COMMENT)) {
                    //we just need the end token occurence
                    r = BladeLexerUtils.findEndFwd(ts, BladeTokenId.T_BLADE_COMMENT, BladeLexer.CLOSE_COMMENT);
                    return new int[]{r.getStart(), r.getEnd()};
                } else if (TOKENS_WITH_ENDTAGS.contains(t.id()) || BladeSyntax.DIRECTIVES_WITH_ENDTAGS.contains(tText.trim())) {
                    String name = tText.trim().substring(1);
                    r = BladeLexerUtils.findFwd(ts, "@end" + name, tText.trim());
                    return new int[]{r.getStart(), r.getEnd()};
                } 
            }
            return null;
        } finally {
            ((AbstractDocument) context.getDocument()).readUnlock();
        }
    }

    //factory
    public static final class Factory implements BracesMatcherFactory {

        @Override
        public BracesMatcher createMatcher(MatcherContext context) {
            return new BladeBracesMatcher(context);
        }

    }

}
