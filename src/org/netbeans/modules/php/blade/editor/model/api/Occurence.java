package org.netbeans.modules.php.blade.editor.model.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.netbeans.modules.csl.api.OffsetRange;

/**
 *
 * @author bhaidu
 */
public interface Occurence {

    public static enum Accuracy {
        NO,
        UNIQUE,
        EXACT,
        EXACT_TYPE,
        MORE_TYPES,
        MORE_MEMBERS,
        MORE,
    }

    /**
     * makes sense just for type members for calls with unknown types on left side (else EXACT).
     */
    Accuracy degreeOfAccuracy();
    /**mostly the same as getDeclaration. In case of __constructor are different*/
    //PhpElementKind getKind();
    Collection<? extends BladeElement> getAllDeclarations();
    Map<BladeElement.Kind, List<Occurence>> getAllOccurences();
    OffsetRange getOccurenceRange();

}
