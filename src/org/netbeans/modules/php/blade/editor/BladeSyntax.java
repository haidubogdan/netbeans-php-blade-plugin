package org.netbeans.modules.php.blade.editor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

/**
 * list of blade syntax info
 * @link https://laravel.com/docs/blade
 *
 * @author bhaidu
 */
public class BladeSyntax {

    private static URL documentationUrl = null;

    static {
        try {
            documentationUrl = new URL("https://laravel.com/docs/blade"); //NOI18N
        } catch (MalformedURLException ex) {

        }
    }

    public static String OPEN_ECHO = "{{"; //NOI18N
    public static String CLOSE_ECHO = "}}"; //NOI18N
    public static String OPEN_ECHO_ESCAPED = "{!!"; //NOI18N
    public static String CLOSE_ECHO_ESCAPED = "!!}"; //NOI18N

    public final static Collection<String> INLINE_DIRECTIVES = Arrays.asList(
            "@extends", "@include", "@includeIf", "@includeWhen", "@includeUnless", "@includeFirst",
            "@section", "@empty", "@each"
    );

    public final static Collection<String> DIRECTIVES_WITH_VIEW_PATH = Arrays.asList(
            "@extends", "@include", "@includeIf", "@includeWhen", "@includeUnless", "@includeFirst",
            "@each"
    );

    public static Collection<String> DIRECTIVES_WITH_ENDTAGS = Arrays.asList(
            "@php",
            "@if",
            "@for",
            "@foreach",
            "@isset",
            "@empty",
            "@production",
            "@while",
            "@section",
            "@switch",
            "@env",
            "@verbatim",
            "@unless",
            "@auth",
            "@guest",
            "@once",
            "@disk",
            "@push",
            "@prepend",
            "@error",
            "@can",
            "@canany",
            "@cannot",
            "@forelse"
    );

    public static Collection<String> DIRECTIVES_WITH_EXPRESSION = Arrays.asList(
            "@if",
            "@for",
            "@foreach",
            "@while",
            "@error",
            "@can",
            "@canany",
            "@cannot",
            "@forelse",
            "@unless"
    );
    
    public static Collection<String> GENERIC_BLADE_KEYWORDS = Arrays.asList(
            "@continue",
            "@csrf",
            "@break",
            "@endfor",
            "@endif",
            "@endforeach",
            "@endsection",
            "@stop",
            "@append",
            "@empty"
    );

    public final static Collection<String> CONDITIONAL_DIRECTIVES = Arrays.asList(
            "@hasSection", "@sectionMissing"
    );

    public static URL getDocumentationUrl() {
        return documentationUrl;
    }
}
