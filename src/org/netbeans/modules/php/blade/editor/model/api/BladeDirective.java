package org.netbeans.modules.php.blade.editor.model.api;

import java.util.List;
import java.util.Map;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.types.api.DeclarationScope;
import org.netbeans.modules.php.blade.editor.types.api.DirectiveName;

/**
 *
 * @author bhaidu
 */
public interface BladeDirective extends BladeElement{
    public String getDirectiveName();
    public void addOccurrence(OffsetRange offsetRange);
    List<Occurrence> getOccurrences();
}
