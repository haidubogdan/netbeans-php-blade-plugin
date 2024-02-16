package org.netbeans.modules.php.blade.syntax;

/**
 *
 * @author bhaidu
 */
public class BladeTagsUtils {

    public static String[] outputCloseTags() {
        return new String[]{"}}", "!!}"}; //NOI18N
    }

    public static String[] outputStartTags() {
        return new String[]{"{{", "{!!"}; //NOI18N
    }

    public static String tagStart2EndPair(String tag) {
        switch (tag) {
            case "{{": //NOI18N
                return "}}"; //NOI18N
            case "{!!": //NOI18N
                return "!!}"; //NOI18N
        }
        return null;
    }

    public static String tagEnd2StartPair(String tag) {
        switch (tag) {
            case "}}": //NOI18N
                return "{{"; //NOI18N
            case "!!}": //NOI18N
                return "{!!"; //NOI18N
        }
        return null;
    }
}
