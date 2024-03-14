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

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.spi.editor.typinghooks.TypedTextInterceptor;

/**
 * auto complete for '[', '(', '\'', '"'
 *
 * @author bhaidu
 */
public class BladeTypedTextInterceptor implements TypedTextInterceptor {

    static final Map<Character, Character> CHAR_PAIR = new WeakHashMap<>();

    /**
     * auto complete char pair
     */
    static {
        CHAR_PAIR.put('(', ')');
        CHAR_PAIR.put('[', ']');
        CHAR_PAIR.put('\'', '\'');
        CHAR_PAIR.put('"', '"');
    }

    @Override
    public boolean beforeInsert(Context cntxt) throws BadLocationException {
        return false;
    }

    @Override
    public void insert(MutableContext context) throws BadLocationException {
        if (context.getReplacedText().length() != 0) {
            return;
        }

        char ch = context.getText().charAt(0);

        if (CHAR_PAIR.containsKey(ch)) {
            completePairChar(context, ch, CHAR_PAIR.get(ch));
          }
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

    @Override
    public void afterInsert(Context cntxt) throws BadLocationException {

    }

    @Override
    public void cancelled(Context cntxt) {

    }

    /**
     * register for HTML also
     */
    @MimeRegistrations(value = {
        @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = TypedTextInterceptor.Factory.class),
        @MimeRegistration(mimeType = "text/html", service = TypedTextInterceptor.Factory.class)
    })
    public static class Factory implements TypedTextInterceptor.Factory {

        @Override
        public TypedTextInterceptor createTypedTextInterceptor(MimePath mimePath) {
            return new BladeTypedTextInterceptor();
        }

    }

}
