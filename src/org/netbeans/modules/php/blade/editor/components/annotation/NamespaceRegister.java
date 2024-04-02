package org.netbeans.modules.php.blade.editor.components.annotation;

import org.netbeans.modules.php.blade.syntax.annotation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author bhaidu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE})
public @interface NamespaceRegister {
    public Namespace[] value();
}