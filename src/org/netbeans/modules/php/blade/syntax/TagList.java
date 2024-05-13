package org.netbeans.modules.php.blade.syntax;

import org.netbeans.modules.php.blade.syntax.annotation.Tag;
import org.netbeans.modules.php.blade.syntax.annotation.TagRegister;

/**
 *
 * @author bhaidu
 */
@TagRegister({
    @Tag(openTag = "{{", closeTag = "}}", description = "regular echo", position=0),
    @Tag(openTag = "{!!", closeTag = "!!}", description = "raw echo", position=1),
    @Tag(openTag = "{{--", closeTag = "--}}", description = "comment", position=2)
})
public class TagList {

    public Tag[] getTags() {
        TagRegister tagRegister = this.getClass().getAnnotation(TagRegister.class);
        return tagRegister.value();
    }
}
