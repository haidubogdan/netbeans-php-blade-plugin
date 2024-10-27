package org.netbeans.modules.php.blade.syntax.annotation;

/**
 *
 * @author bhaidu
 */
public @interface PhpKeyword {
    String name();
    boolean params() default false;
    boolean parenExpr() default false;
    String description() default "";
    String category() default "";
}
