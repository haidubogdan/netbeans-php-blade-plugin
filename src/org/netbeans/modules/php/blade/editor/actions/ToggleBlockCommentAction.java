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
package org.netbeans.modules.php.blade.editor.actions;

import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseAction;
import org.netbeans.editor.BaseDocument;
import org.netbeans.editor.Utilities;
import org.netbeans.editor.ext.ExtKit;
import org.netbeans.modules.csl.api.CslActions;
import org.netbeans.modules.php.blade.editor.BladeCommentHandler;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.BLADE_COMMENT;
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.BLADE_COMMENT_START;
import org.netbeans.modules.php.blade.editor.preferences.GeneralPreferencesUtils;

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
            
            if (GeneralPreferencesUtils.bladeCommentsEverywhere()) {
                final Positions positions = Positions.create(target);

                final BaseDocument doc = (BaseDocument) target.getDocument();
                doc.runAtomic(new Runnable() {

                    @Override
                    public void run() {
                        performCustomAction(doc, positions, processedHere);
                    }
                });
            }
            if (!processedHere.get()) {
                performDefaultAction(evt, target);
            }
        }
    }

    private void performCustomAction(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) {
        try {
            comment(baseDocument, positions, processedHere);
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

    private void comment(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) throws BadLocationException {
        try {
            TokenSequence<BladeTokenId> ts = BladeLexerUtils.getTokenSequence(baseDocument, positions.getStart());
            Token<BladeTokenId> token = null;
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
                if (token.id().equals(BLADE_COMMENT)) {
                    uncommentToken(ts, baseDocument);
                } else {
                    //let default comment handler handle
                    return;
                }
            } else {
                positions.comment(baseDocument);
            }
            processedHere.set(true);
        } catch (BadLocationException ex) {
            LOGGER.log(Level.WARNING, "Invalid offset: {0}", ex.offsetRequested()); // NOI18N
        }
    }

    protected void uncommentToken(TokenSequence<BladeTokenId> ts, BaseDocument baseDocument) throws BadLocationException {
        int commentTokenOffset = ts.offset();
        Token<BladeTokenId> commentToken = ts.token();
        Token<BladeTokenId> prevToken = null;
        if (ts.movePrevious()) {
            prevToken = ts.token();
        }

        if (prevToken == null || !prevToken.id().equals(BLADE_COMMENT_START)) {
            return;
        }
        int start = ts.offset();
        int end = commentTokenOffset + commentToken.length() - BladeCommentHandler.COMMENT_END_DELIMITER.length();
        baseDocument.remove(start, BladeCommentHandler.COMMENT_START_DELIMITER.length());
        baseDocument.remove(end, BladeCommentHandler.COMMENT_END_DELIMITER.length());
    }

    private static boolean isInComment(BladeTokenId tokenId) {
        boolean isInComment = false;
        switch (tokenId) {
            case BLADE_COMMENT_START:
            case BLADE_COMMENT:
            case BLADE_COMMENT_END:
                isInComment = true;
                break;

        }
        return isInComment;
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
                offsetCommentStart = LineDocumentUtils.getPreviousWhitespace(baseDocument, getStart());
                offsetCommentEnd = LineDocumentUtils.getLineEndOffset(baseDocument, getEnd());
            }
            baseDocument.insertString(offsetCommentStart, BladeCommentHandler.COMMENT_START_DELIMITER, null);
            baseDocument.insertString(offsetCommentEnd + BladeCommentHandler.COMMENT_START_DELIMITER.length(), BladeCommentHandler.COMMENT_END_DELIMITER, null);
        }

    }

}
