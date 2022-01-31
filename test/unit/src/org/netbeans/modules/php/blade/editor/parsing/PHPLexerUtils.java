package org.netbeans.modules.php.blade.editor.parsing;

/**
 *
 * @author bhaidu
 */
public class PHPLexerUtils {
   
    public static String getXmlStringValue(String input) {
        String escapedString = input;
        escapedString = escapedString.replaceAll("&", "&amp;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = escapedString.replaceAll(">", "&gt;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = escapedString.replaceAll("<", "&lt;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = escapedString.replaceAll("'", "&apos;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = replaceLinesAndTabs(escapedString);
        return escapedString;
    }
    
    public static String replaceLinesAndTabs(String input) {
        String escapedString = input;
        escapedString = escapedString.replaceAll("\n","\\\\n");
        escapedString = escapedString.replaceAll("\r","\\\\r");
        escapedString = escapedString.replaceAll("\t","\\\\t");
        return escapedString;
    } 
}
