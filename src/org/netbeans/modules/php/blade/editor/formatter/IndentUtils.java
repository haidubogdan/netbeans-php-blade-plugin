package org.netbeans.modules.php.blade.editor.formatter;

import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.lexer.TokenUtilities;
import org.netbeans.editor.BaseDocument;
import org.netbeans.lib.editor.util.ArrayUtilities;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;

public final class IndentUtils {
    private static final int MAX_CACHED_INDENT = 80;

    private static final String[] CACHED_SPACES_STRINGS = new String[MAX_CACHED_INDENT + 1];
    static {
        CACHED_SPACES_STRINGS[0] = ""; //NOI18N
    }

    private static final int MAX_CACHED_TAB_SIZE = 8; // Should mostly be <= 8

    /**
     * Cached indentation string containing tabs.
     * <br/>
     * The cache does not contain indents smaller than the particular tabSize
     * since they are only spaces contained in cachedSpacesStrings.
     */
    private static final String[][] CACHED_TAB_INDENTS = new String[MAX_CACHED_TAB_SIZE + 1][];

    private IndentUtils() {
    }

    static String cachedOrCreatedIndentString(int indent, boolean expandTabs, int tabSize) {
        String indentString;
        if (expandTabs || (indent < tabSize)) {
            if (indent <= MAX_CACHED_INDENT) {
                synchronized (CACHED_SPACES_STRINGS) {
                    indentString = CACHED_SPACES_STRINGS[indent];
                    if (indentString == null) {
                        // Create string with MAX_CACHED_SPACES spaces first if not cached yet
                        indentString = CACHED_SPACES_STRINGS[MAX_CACHED_INDENT];
                        if (indentString == null) {
                            indentString = createSpacesString(MAX_CACHED_INDENT);
                            CACHED_SPACES_STRINGS[MAX_CACHED_INDENT] = indentString;
                        }
                        indentString = indentString.substring(0, indent);
                        CACHED_SPACES_STRINGS[indent] = indentString;
                    }
                }
            } else {
                indentString = createSpacesString(indent);
            }

        } else { // Do not expand tabs
            if (indent <= MAX_CACHED_INDENT && tabSize <= MAX_CACHED_TAB_SIZE) {
                synchronized (CACHED_TAB_INDENTS) {
                    String[] tabIndents = CACHED_TAB_INDENTS[tabSize];
                    if (tabIndents == null) {
                        // Do not cache spaces-only strings
                        tabIndents = new String[MAX_CACHED_INDENT - tabSize + 1];
                        CACHED_TAB_INDENTS[tabSize] = tabIndents;
                    }
                    indentString = tabIndents[indent - tabSize];
                    if (indentString == null) {
                        indentString = createTabIndentString(indent, tabSize);
                        tabIndents[indent - tabSize] = indentString;
                    }
                }
            } else {
                indentString = createTabIndentString(indent, tabSize);
            }
        }
        return indentString;
    }

    private static String createSpacesString(int spaceCount) {
        StringBuilder sb = new StringBuilder(spaceCount);
        ArrayUtilities.appendSpaces(sb, spaceCount);
        return sb.toString();
    }

    private static String createTabIndentString(int indent, int tabSize) {
        StringBuilder sb = new StringBuilder();
        while (indent >= tabSize) {
            sb.append('\t'); //NOI18N
            indent -= tabSize;
        }
        ArrayUtilities.appendSpaces(sb, indent);
        return sb.toString();
    }


    /**
     * This method count new indent ofr braces and parent
     *
     * @param doc
     * @param offset - the original offset, where is cursor
     * @param currentIndent - the indnet that should be modified
     * @param previousIndent - indent of the line abot
     * @return
     */
    public static int countIndent(BaseDocument doc, int offset, int previousIndent) {
        int value = previousIndent;
        TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, offset);
        if (ts != null) {
            ts.move(offset);
            if (!ts.movePrevious() || !ts.moveNext()) {
                return previousIndent;
            }
            Token<? extends BladeTokenId> token = ts.token();
            while (!(token.id() == BladeTokenId.T_BLADE_LPAREN
                    && (TokenUtilities.textEquals(token.text(), "(") // NOI18N
                    || TokenUtilities.textEquals(token.text(), "["))) // NOI18N
                    && ts.movePrevious()) {
                token = ts.token();
            }
            if (token.id() == BladeTokenId.T_BLADE_LPAREN) {
                while (token.id() != BladeTokenId.T_BLADE_SECTION
                        && token.id() != BladeTokenId.T_BLADE_IF
                        && token.id() != BladeTokenId.T_BLADE_ELSEIF
                        && token.id() != BladeTokenId.T_BLADE_FOR
                        && token.id() != BladeTokenId.T_BLADE_FOREACH
                        && ts.movePrevious()) {
                    token = ts.token();
                }
                CodeStyle codeStyle = CodeStyle.get(doc);
//                CodeStyle.BracePlacement bracePlacement = codeStyle.getOtherBracePlacement();
//                if (token.id() == BladeTokenId.PHP_CLASS) {
//                    bracePlacement = codeStyle.getClassDeclBracePlacement();
//                } else if (token.id() == BladeTokenId.PHP_FUNCTION) {
//                    bracePlacement = codeStyle.getMethodDeclBracePlacement();
//                } else if (token.id() == BladeTokenId.PHP_IF || token.id() == BladeTokenId.PHP_ELSE || token.id() == BladeTokenId.PHP_ELSEIF) {
//                    bracePlacement = codeStyle.getIfBracePlacement();
//                } else if (token.id() == BladeTokenId.PHP_FOR || token.id() == BladeTokenId.PHP_FOREACH) {
//                    bracePlacement = codeStyle.getForBracePlacement();
//                } else if (token.id() == BladeTokenId.PHP_WHILE || token.id() == BladeTokenId.PHP_DO) {
//                    bracePlacement = codeStyle.getWhileBracePlacement();
//                } else if (token.id() == BladeTokenId.PHP_SWITCH) {
//                    bracePlacement = codeStyle.getSwitchBracePlacement();
//                }
//                value = bracePlacement == CodeStyle.BracePlacement.NEW_LINE_INDENTED ? previousIndent + codeStyle.getIndentSize() : previousIndent;
            }
        }
        return value;
    }
}