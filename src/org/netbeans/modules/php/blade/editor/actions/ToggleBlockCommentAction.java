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
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseAction;
import org.netbeans.editor.BaseDocument;
import org.netbeans.editor.Utilities;
import org.netbeans.editor.ext.ExtKit;
import org.netbeans.modules.csl.api.CslActions;
import org.netbeans.modules.php.blade.editor.BladeCommentHandler;

public class ToggleBlockCommentAction extends BaseAction {

    static final long serialVersionUID = -1L;
    private static final Logger LOGGER = Logger.getLogger(ToggleBlockCommentAction.class.getName());
    private static final String FORCE_COMMENT = "force-comment";
    private static final String FORCE_UNCOMMENT = "force-uncomment";
    private final BladeCommentHandler commentHandler = new BladeCommentHandler();

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
            commentHandler.getAdjustedBlocks(target.getDocument(), positions.getStart(), positions.getEnd());
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
        ToggleCommentType toggleCommentType = ToggleCommentType.AS_BLADE_EVERYWHERE;
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
                int x= 1;
            }
        },
        LANGUAGE_SENSITIVE {

            @Override
            void comment(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) throws BadLocationException {
                int y = 1;
            }
        };

        abstract void comment(BaseDocument baseDocument, Positions positions, AtomicBoolean processedHere) throws BadLocationException;


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

        }

    }

}
