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
package org.netbeans.modules.php.blade.editor.typinghooks;

import java.util.Map;
import java.util.WeakHashMap;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.preferences.ModulePreferences;
import org.netbeans.spi.editor.typinghooks.TypedTextInterceptor;

/**
 * auto complete for '[', '(', '\'', '"'
 *
 * @author bhaidu
 */
public class BladeTypedTextInterceptor implements TypedTextInterceptor {

    static final Map<Character, Character> CHAR_PAIR = new WeakHashMap<>();

    public static enum TagType {
        CONTENT,
        RAW,
        COMMENT
    }
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
            return;
        }

        if (!isAutoTagCompletionEnabled()){
            return;
        }
        
        String typedText =  context.getText();
        
        Map<String, TagType> TagParts = new WeakHashMap<>();
        TagParts.put("{", TagType.CONTENT); //NOI18N
        TagParts.put("!", TagType.RAW); //NOI18N
        TagParts.put("-", TagType.COMMENT); //NOI18N
        
        TagType tagType = TagParts.get(typedText);
        
        if (tagType == null){
            return;
        }
        
        int offset = context.getOffset();
        
        switch(tagType) {
            case CONTENT: {
                if (offset < 1) {
                    return;
                }
                break;
            }
            case RAW:
            case COMMENT:{
                if (offset < 2) {
                    return;
                }
                break;
            }
        }
        
        Document document = context.getDocument();
        TokenHierarchy<?> th = TokenHierarchy.get(document);
        TokenSequence<?> ts = th.tokenSequence();
        ts.move(offset - 1);
        ts.moveNext();

        Token<?> token = ts.token();
        
        if (token == null || !(token.id() instanceof BladeTokenId)){
            return;
        }
        
        BladeTokenId bladeTokenId = (BladeTokenId) token.id();
        
        String tokenText = token.text().toString().trim();
        
        switch (bladeTokenId) {
            case HTML:
                int startOffset = Math.min(tokenText.length(), 3);
                String snippet = document.getText(offset - startOffset, startOffset);
                if (snippet.endsWith("{") && tagType.equals(TagType.CONTENT)){ //NOI18N
                    context.setText("{ }}", 1); //NOI18N
                } else if (snippet.endsWith("{!")  && tagType.equals(TagType.RAW )){ //NOI18N
                    context.setText("! !!}", 1); //NOI18N
                } else if (snippet.endsWith("{{-")  && tagType.equals(TagType.COMMENT)){ //NOI18N
                    context.setText("- --}}", 1); //NOI18N
                }
                break;
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
    
    public boolean isAutoTagCompletionEnabled(){
        return ModulePreferences.isAutoTagCompletionEnabled();
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