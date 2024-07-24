package org.netbeans.modules.php.blade.editor.components;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bhaidu
 */
public class ComponentElement {
    public String name;
    public String qualifiedClassName;
    
    public Set<String> properties = new HashSet<>();
}
