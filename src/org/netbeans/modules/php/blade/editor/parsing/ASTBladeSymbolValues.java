package org.netbeans.modules.php.blade.editor.parsing;

/**
 *
 * @author bhaidu
 */
public class ASTBladeSymbolValues {

    public static String getTokenTextForm(int token) {
        String text;
        switch (token) {
            case ASTBladeSymbols.T_STRING:
                text = "string";
                break; //NOI18N
            case ASTBladeSymbols.T_VARIABLE:
                text = "variable";
                break; //NOI18N
            case ASTBladeSymbols.T_COMMA:
                text = ",";
                break; //NOI18N
            case ASTBladeSymbols.T_NEKUDA:
                text = ":";
                break; //NOI18N        
            case ASTBladeSymbols.T_OPEN_PARENTHESE:
                text = "(";
                break; //NOI18N
            case ASTBladeSymbols.T_CLOSE_PARENTHESE:
                text = ")";
                break; //NOI18N    
            case ASTBladeSymbols.T_INLINE_HTML:
                text = "inline html";
                break; //NOI18N
            case ASTBladeSymbols.T_PHP_LOOP_EXPRESSION:
                text = "() loop expr";
                break; //NOI18N       
            case ASTBladeSymbols.T_BLADE_OPEN_ECHO:
                text = "{{";
                break; //NOI18N 
            case ASTBladeSymbols.T_BLADE_PHP_ECHO:
                text = "}}";
                break; //NOI18N 
            case ASTBladeSymbols.T_BLADE_INLINE_PHP:
                text = "inline php";
                break; //NOI18N        
            case ASTBladeSymbols.T_PHP_CONDITION_EXPRESSION:
                text = "() condition expr";
                break; //NOI18N        
            case ASTBladeSymbols.T_BLADE_DIRECTIVE:
                text = "@ directive";
                break; //NOI18N       
            case ASTBladeSymbols.T_BLADE_INCLUDE:
                text = "@include";
                break; //NOI18N   
            case ASTBladeSymbols.T_BLADE_EXTENDS:
                text = "@extends";
                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_FOREACH:
                text = "@foreach";
                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_FOR:
                text = "@for";
                break; //NOI18N    
            case ASTBladeSymbols.T_BLADE_ENDFOREACH:
                text = "@endforeach";
                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_SECTION:
                text = "@section";
                break; //NOI18N 
            case ASTBladeSymbols.T_BLADE_SHOW:
                text = "@show";
                break; //NOI18N        
            case ASTBladeSymbols.T_BLADE_ENDSECTION:
                text = "@endsection";
                break; //NOI18N      
            case ASTBladeSymbols.T_BLADE_YIELD:
                text = "@yield";
                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_IF:
                text = "@if";
                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_ELSEIF:
                text = "@elseif";
                break; //NOI18N
//            case ASTBladeSymbols.T_BLADE_ELSE:
//                text = "@else";
//                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_ENDIF:
                text = "@endif";
                break; //NOI18N
            case ASTBladeSymbols.T_BLADE_ENDFOR:
                text = "@endfor";
                break; //NOI18N   
            case ASTBladeSymbols.error:
                text= null;
                break;
            default:
                text = ParsingUtils.getAstSymbolName(token);
        }

        return text;
    }
}
