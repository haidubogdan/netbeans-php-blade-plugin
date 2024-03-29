package org.netbeans.modules.php.blade.editor.components.annotation;

import org.netbeans.modules.php.blade.syntax.annotation.*;

/**
 *
 * @author bhaidu
 */
public @interface Namespace {
    String path();
    String relativeFilePath() default "";
    String packageName() default "blade";
    boolean from_app() default false;
    boolean from_vendor() default true;
}
