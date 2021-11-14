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
package org.netbeans.modules.php.blade.editor.actions;

import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseAction;
import org.netbeans.editor.BaseDocument;
import org.netbeans.editor.Utilities;
import org.netbeans.editor.ext.ExtKit;
import org.netbeans.modules.csl.api.CslActions;

import org.netbeans.modules.php.blade.editor.lexer.BladeTopLexer;
import org.netbeans.modules.php.blade.editor.lexer.BladeTopTokenId;
import org.netbeans.modules.php.blade.editor.ui.options.BladeOptions;

/**
 * 
 * @author Haidu Bogdan
 */
public class ToggleBlockCommentAction extends BaseAction {

    static final long serialVersionUID = -1L;
    private static final Logger LOGGER = Logger.getLogger(ToggleBlockCommentAction.class.getName());
    private static final String FORCE_COMMENT = "force-comment";
    private static final String FORCE_UNCOMMENT = "force-uncomment";

    public ToggleBlockCommentAction() {
        super(ExtKit.toggleCommentAction);
    }

    @Override
    public void actionPerformed(ActionEvent evt, JTextComponent target) {
        final AtomicBoolean processedHere = new AtomicBoolean(false);
        if (target != null) {
            if (!target.isEditable() || !target.isEnabled() || !(target.getDocument() instanceof BaseDocument)) {
                target.getToolkit().beep();
                return;
            }
            final Positions positions = Positions.create(target);
            final BaseDocument doc = (BaseDocument) target.getDocument();
            doc.runAtomic(new Runnable() {

                @Override
                public void run() {
                    performCustomAction(doc, positions, processedHere);
                }
            });
            if (!processedHere.get()) {
                performDefaultAction(evt, target);
            }
        }
    }

    private void performCustomAction(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) {
        ToggleCommentType toggleCommentType = BladeOptions.getInstance().getToggleCommentType();
        try {
            toggleCommentType.comment(baseDocument, positions, processedHere);
        } catch (BadLocationException ex) {
            LOGGER.log(Level.WARNING, null, ex);
        }
    }

    private void performDefaultAction(ActionEvent evt, JTextComponent target) {
        BaseAction action = (BaseAction) CslActions.createToggleBlockCommentAction();
        if (getValue(FORCE_COMMENT) != null) {
            action.putValue(FORCE_COMMENT, getValue(FORCE_COMMENT));
        }
        if (getValue(FORCE_UNCOMMENT) != null) {
            action.putValue(FORCE_UNCOMMENT, getValue(FORCE_UNCOMMENT));
        }
        action.actionPerformed(evt, target);
    }

    public static enum ToggleCommentType {
        AS_BLADE_EVERYWHERE {

            @Override
            void comment(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) throws BadLocationException {
                TokenSequence<? extends BladeTopTokenId> ts = BladeLexerUtils.getBladeTokenSequence(baseDocument, positions.getStart());
                Token<? extends BladeTopTokenId> token = null;
                if (ts != null) {
                    ts.move(positions.getStart());
                    ts.moveNext();
                    token = ts.token();
                    if (token != null && positions.getStart() == ts.offset() && !isInComment(token.id())) {
                        ts.movePrevious();
                        token = ts.token();
                    }
                }
                if (token != null && isInComment(token.id())) {
                    uncommentToken(ts, baseDocument);
                } else {
                    positions.comment(baseDocument);
                }
                processedHere.set(true);
            }
        },
        LANGUAGE_SENSITIVE {

            @Override
            void comment(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) throws BadLocationException {
                TokenSequence<? extends BladeTopTokenId> ts = BladeLexerUtils.getBladeTokenSequence(baseDocument, positions.getStart());
                if (ts == null) {
                    processedHere.set(false);
                    return;
                }
                ts.move(positions.getStart());
                ts.moveNext();
                Token<? extends BladeTopTokenId> token = ts.token();
                if (token != null && positions.getStart() == ts.offset() && token.id() == BladeTopTokenId.T_HTML) {
                    ts.movePrevious();
                    token = ts.token();
                }
                if (token != null && token.id() == BladeTopTokenId.T_HTML) {
                    processedHere.set(false);
                    return;
                } else if (token != null && isInComment(token.id())) {
                    uncommentToken(ts, baseDocument);
                } 
                processedHere.set(true);
            }
        };

        abstract void comment(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) throws BadLocationException;

        protected void uncommentToken(TokenSequence<? extends BladeTopTokenId> ts, BaseDocument baseDocument) throws BadLocationException {
            int start = ts.offset();
            int end = ts.offset() + ts.token().text().length() - BladeTopLexer.OPEN_COMMENT.length() - BladeTopLexer.CLOSE_COMMENT.length();
            baseDocument.remove(start, BladeTopLexer.OPEN_COMMENT.length());
            baseDocument.remove(end, BladeTopLexer.CLOSE_COMMENT.length());
        }

        private static boolean isInComment(BladeTopTokenId tokenId) {
            return tokenId == BladeTopTokenId.T_BLADE_COMMENT;
        }
    }

    private interface TokenInsertWrapper {

        TokenInsertWrapper NONE = new TokenInsertWrapper() {

            @Override
            public void insertBefore(BaseDocument baseDocument) throws BadLocationException {
            }

            @Override
            public void insertAfter(BaseDocument baseDocument) throws BadLocationException {
            }
        };

        void insertBefore(BaseDocument baseDocument) throws BadLocationException;

        void insertAfter(BaseDocument baseDocument) throws BadLocationException;
    }

    private static final class Positions {

        private final int start;
        private final int end;

        public static Positions create(JTextComponent target) {
            boolean isSelection = Utilities.isSelectionShowing(target);
            int start = isSelection ? target.getSelectionStart() : target.getCaretPosition();
            int end = isSelection ? target.getSelectionEnd() : target.getCaretPosition();
            return new Positions(start, end, isSelection);
        }
        private final boolean isSelection;

        private Positions(int start, int end, boolean isSelection) {
            this.start = start;
            this.end = end;
            this.isSelection = isSelection;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public void comment(BaseDocument baseDocument) throws BadLocationException {
            int offsetCommentStart;
            int offsetCommentEnd;
            if (isSelection) {
                offsetCommentStart = getStart();
                offsetCommentEnd = getEnd();
            } else {
                offsetCommentStart = Utilities.getRowStart(baseDocument, getStart());
                offsetCommentEnd = Utilities.getRowEnd(baseDocument, getEnd());
            }
            baseDocument.insertString(offsetCommentStart, BladeTopLexer.OPEN_COMMENT, null);
            baseDocument.insertString(offsetCommentEnd + BladeTopLexer.OPEN_COMMENT.length(), BladeTopLexer.CLOSE_COMMENT, null);
        }

    }

}
