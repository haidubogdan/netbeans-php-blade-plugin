package org.netbeans.modules.php.blade.editor.navigator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.StructureItem;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.api.StructureScanner.Configuration;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;

/**
 *
 * @author bhaidu
 */
public class BladeStructureScanner implements StructureScanner {

    @Override
    public List<? extends StructureItem> scan(ParserResult info) {
        return ((BladeParserResult)info).structure;
    }

    @Override
    public Map<String, List<OffsetRange>> folds(ParserResult info) {
        Map<String, List<OffsetRange>> ret = Collections.singletonMap("codeblocks", ((BladeParserResult)info).folds); //NOI18N
        return ret;
    }

    @Override
    public Configuration getConfiguration() {
        return new Configuration(true, false);
    }

}