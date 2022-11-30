/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
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
 */
package org.netbeans.modules.php.blade.editor.typinghooks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.lexer.Token;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.spi.editor.typinghooks.TypedTextInterceptor;

/**
 * auto complete for
 * '[', '(', '\'', '"'
 * 
 * and for "{{ ", "{!! ", "{{--"
 * 
 * space char (' ') is the trigger for the blade echo and comment tags
 * 
 * @author bhaidu
 */
public class BladeTypedTextInterceptor implements TypedTextInterceptor {

    private final boolean isBlade;

    static final Map<Character, Character> CHAR_PAIR = new HashMap<>();

    /**
     * auto complete char pair
     */
    static {
        CHAR_PAIR.put('(', ')');
        CHAR_PAIR.put('[', ']');
        CHAR_PAIR.put('\'', '\'');
        CHAR_PAIR.put('"', '"');
    }
    
    static BladeTokenId validTokenList[] = {
        BladeTokenId.T_BLADE_OPEN_ECHO,
        BladeTokenId.T_BLADE_OPEN_ECHO_ESCAPED,
        BladeTokenId.T_BLADE_OPEN_COMMENT
    };

    private BladeTypedTextInterceptor(MimePath mimePath) {
        String path = mimePath.getPath();
        isBlade = path.contains(BladeLanguage.BLADE_MIME_TYPE);
    }

    @Override
    public boolean beforeInsert(Context context) throws BadLocationException {
        return false;
    }

    @Override
    public void insert(MutableContext context) throws BadLocationException {
        int caretOffset = context.getOffset();

        if (caretOffset == 0 || !isBlade) {
            return;
        }

        char ch = context.getText().charAt(0);

        //simple char completion
        if (CHAR_PAIR.containsKey(ch)) {
            completePairChar(context, ch, CHAR_PAIR.get(ch));
            return;
        }

        if (ch != ' ') {
            return;
        }

        Document document = context.getDocument();

        //we are offseting the carret to -1
        Token<? extends BladeTokenId> token = BladeLexerUtils.getOffsetToken(document, caretOffset - 1);

        if (token == null) {
            return;
        }

        BladeTokenId id = token.id();
        //String tokenText = token.text().toString();
        //BaseDocument doc = (BaseDocument) document;
        
        /**
         * blade bracket completer only for echo {{ }} echo
         * escaped {!! !!} comment {{-- --}}
         *
         */

        if (!Arrays.asList(validTokenList).contains(id)) {
            return;
        }

        String pairText = id.pair.fixedText();
        
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        String completeBracket = pairText;
        sb.append(completeBracket);

        context.setText(sb.toString(), 1);
    }

    @Override
    public void afterInsert(Context context) throws BadLocationException {
        if (!isBlade) {
            return;
        }
        BaseDocument doc = (BaseDocument) context.getDocument();
        doc.runAtomicAsUser(() -> {
            //do other magic
        });
    }

    @Override
    public void cancelled(Context context) {
    }

    /**
     * simple char context completion
     * 
     * @param context
     * @param chopen
     * @param chclose 
     */
    private void completePairChar(MutableContext context, char chopen, char chclose) {
        StringBuilder sb = new StringBuilder();
        sb.append(chopen);
        sb.append(chclose);
        String text = sb.toString();
        context.setText(text, 1);
    }

    /**
     * register for HTML also
     */
    @MimeRegistrations(value = {
        @MimeRegistration(mimeType = BladeLanguage.BLADE_MIME_TYPE, service = TypedTextInterceptor.Factory.class),
        @MimeRegistration(mimeType = "text/xhtml", service = TypedTextInterceptor.Factory.class),
        @MimeRegistration(mimeType = "text/html", service = TypedTextInterceptor.Factory.class)
    })
    public static class Factory implements TypedTextInterceptor.Factory {

        @Override
        public TypedTextInterceptor createTypedTextInterceptor(MimePath mimePath) {
            return new BladeTypedTextInterceptor(mimePath);
        }

    }

}
