package org.netbeans.modules.php.blade.editor.components.annotation;

/**
 *
 * @author bhaidu
 */
public @interface Namespace {
    String path();
    String relativeFilePath() default "";
    String packageName() default "blade";
    //inside App folder
    boolean from_app() default false;
    boolean from_vendor() default true;
}
