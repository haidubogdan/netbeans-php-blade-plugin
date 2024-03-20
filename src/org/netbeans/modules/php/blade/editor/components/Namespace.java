package org.netbeans.modules.php.blade.editor.components;

import org.netbeans.modules.php.blade.syntax.annotation.*;

/**
 *
 * @author bhaidu
 */
public @interface Namespace {
    String path();
    String packageName() default "blade";
}
