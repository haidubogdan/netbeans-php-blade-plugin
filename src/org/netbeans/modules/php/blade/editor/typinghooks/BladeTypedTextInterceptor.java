/*
Licensed to the Apache Software Foundation (ASF)
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
import static org.netbeans.modules.php.blade.editor.lexer.BladeTokenId.PHP_BLADE_ECHO_EXPR;
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
        TagParts.put("{", TagType.CONTENT);
        TagParts.put("!", TagType.RAW);
        TagParts.put("-", TagType.CONTENT);
        
        TagType tagType = TagParts.get(typedText);
        
        if (tagType == null){
            return;
        }
        
        int offset = context.getOffset();
        
        if (offset < 2){
            return;
        }
        
        Document document = context.getDocument();
        TokenHierarchy th = TokenHierarchy.get(document);
        TokenSequence<?> ts = th.tokenSequence();
        ts.move(context.getOffset() - 1);
        ts.moveNext();

        Token<?> token = ts.token();
        
        if (token == null || !(token.id() instanceof BladeTokenId)){
            return;
        }
        
        BladeTokenId bladeToken = (BladeTokenId) token.id();
        
        String tokenText = token.text().toString();
        
        switch (bladeToken) {
            case HTML:
                if (tokenText.equals("{") && tagType == TagType.CONTENT){
                    context.setText("{ }}", 1);
                } else if (tokenText.equals("{!")  && tagType == TagType.RAW ){
                    context.setText("! !!}", 1);
                } else if (tokenText.equals("{{-")  && tagType == TagType.COMMENT ){
                    context.setText("- --}}", 1);
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
