package org.netbeans.modules.php.blade.editor.parsing.astnodes;

import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.editor.parser.PHPParseResult;

/**
 *
 * @author bhaidu
 */
public class ParsedInLinePhp extends Statement implements StructureModelItem{
    private final PHPParseResult parseResult;
    private String phpCode = "";
    private OffsetRange offsetRange = OffsetRange.NONE;

    public ParsedInLinePhp(int start, int end, String phpCode, PHPParseResult parseResult) {
        super(start, end);
        this.phpCode = phpCode;
        this.parseResult = parseResult;
        this.offsetRange = new OffsetRange(start, end);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "@php"; //NOI18N
    }
    
    public String getPhpCode(){
        return phpCode;
    }
    
    public PHPParseResult getParsedResult (){
        return parseResult;
    }
    
    public OffsetRange getOffsetRange(){
        return offsetRange;
    }
}
