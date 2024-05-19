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
}
