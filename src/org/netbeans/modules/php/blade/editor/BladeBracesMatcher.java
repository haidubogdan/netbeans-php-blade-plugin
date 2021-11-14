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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.lexer.BladeTopLexer;
import org.netbeans.modules.php.blade.editor.lexer.BladeTopTokenId;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.spi.editor.bracesmatching.BracesMatcher;
import org.netbeans.spi.editor.bracesmatching.BracesMatcherFactory;
import org.netbeans.spi.editor.bracesmatching.MatcherContext;
import org.netbeans.spi.editor.bracesmatching.support.BracesMatcherSupport;

/**
 *
 * @author Haidu Bogdan
 */

public class BladeBracesMatcher implements BracesMatcher {

    private MatcherContext context;

    private BladeBracesMatcher(MatcherContext context) {
        this.context = context;
    }

    @Override
    public int[] findOrigin() throws InterruptedException, BadLocationException {
        int searchOffset = context.getSearchOffset();
        ((AbstractDocument) context.getDocument()).readLock();
        try {
            TokenSequence<? extends BladeTopTokenId> ts = BladeLexerUtils.getBladeTokenSequence(context.getDocument(), searchOffset);
            //TokenHierarchy<Document> th = TokenHierarchy.get(context.getDocument());

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
                Token<? extends BladeTopTokenId> t = ts.token();
                if (t.id() == BladeTopTokenId.T_BLADE){
                    String tsText = t.text().toString();
                    int toffs = ts.offset();
                    if (tsText.startsWith(BladeTopLexer.OPEN_ECHO)){
                        return new int[] {toffs, toffs + 2};
                    }
                    if (tsText.startsWith(BladeTopLexer.OPEN_ECHO_ESCAPED)){
                        return new int[] {toffs, toffs + 3};
                    }
                    
                } else if (t.id() == BladeTopTokenId.T_DIRECTIVE){
                    String tsText = t.text().toString();
                    int toffs = ts.offset();
                    if (tsText.startsWith("@if")){
                        return new int[] {toffs, toffs + 3};
                    }
                    if (tsText.startsWith("@php")){
                        return new int[] {toffs, toffs + 4};
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
        final Source source = Source.create(context.getDocument());
        if (source == null) {
            return null;
        }

        Document document = context.getDocument();
        final AtomicReference<int[]> result = new AtomicReference<>();
        document.render(new Runnable() {
            @Override
            public void run() {
                TokenSequence<? extends BladeTopTokenId> ts = BladeLexerUtils.getBladeTokenSequence(context.getDocument(), context.getSearchOffset());
                if (ts != null) {
                    int searchOffset = context.getSearchOffset();
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
                        Token<? extends BladeTopTokenId> t = ts.token();
                        if (t.id() == BladeTopTokenId.T_BLADE){
                            String tsText = t.text().toString();
                            int toffs = ts.offset();
                            if (tsText.endsWith(BladeTopLexer.CLOSE_ECHO)){
                                result.set(new int[] {toffs + tsText.length() - 2, toffs + tsText.length()});
                            } else if (tsText.endsWith(BladeTopLexer.CLOSE_ECHO_ESCAPED)){
                                result.set(new int[] {toffs + tsText.length() - 3, toffs + tsText.length()});
                            }
                        } else if (t.id() == BladeTopTokenId.T_DIRECTIVE){
                            String tsText = t.text().toString();
                            int toffs = ts.offset();
                            if (tsText.endsWith("@endif")){
                                result.set(new int[] {toffs + tsText.length() - 6, toffs + tsText.length()});
                            } else if (tsText.endsWith("@endphp")){
                                result.set(new int[] {toffs + tsText.length() - 7, toffs + tsText.length()});
                            }
                        }
                        
                        return;
                    }
                }
            }
        });
        
        if (result.get() != null) {
            return result.get();
        }
                
        return null;
    }

    //factory
    public static final class Factory implements BracesMatcherFactory {

        @Override
        public BracesMatcher createMatcher(MatcherContext context) {
            return new BladeBracesMatcher(context);
        }

    }

}
