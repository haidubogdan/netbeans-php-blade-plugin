package org.netbeans.modules.php.blade.editor.model.api;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.OffsetRange;

/**
 *
 * @author bhaidu
 */
public interface BladeElement extends ElementHandle {

    public enum Kind {
        OTHER(0),
        YIELD(1),
        EXTEND(2),
        SECTION(3),
        INCLUDE(4),
        VIEW_PATH(5);
        private final int id;
        private static final Map<Integer, Kind> LOOKUP = new HashMap<Integer, Kind>();

        static {
            for (Kind kind : EnumSet.allOf(Kind.class)) {
                LOOKUP.put(kind.getId(), kind);
            }
        }

        private Kind(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static Kind fromId(int id) {
            return LOOKUP.get(id);
        }

    }

    int getOffset();

    OffsetRange getOffsetRange();

    Kind getBladeKind();
}
