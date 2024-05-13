package org.netbeans.modules.php.blade.syntax;

import org.netbeans.modules.php.blade.syntax.annotation.Directive;

/**
 * 
 *
 * @author bhaidu
 */
public class BladeDirectivesUtils {

    public static String[] directiveStart2EndPair(String directive){
        if (directive.equals("@section")){
            return new String[]{"@endsection", "@show", "@stop", "@append"};
        }
        DirectivesList listClass = new DirectivesList();
        for (Directive directiveEl :  listClass.getDirectives()){
            if (!directiveEl.name().equals(directive)){
                continue;
            }
            if (directiveEl.endtag().isEmpty()){
                return null;
            }
            return new String[]{directiveEl.endtag()};
        }
        return null;
    }
    
    public static String[] directiveEnd2StartPair(String directive){
        //still easier with switch
        switch (directive) {
            case "@endif":
                return new String[]{"@if", "@hasSection", "@sectionMissing"};
            case "@endsection":
            case "@stop":
            case "@append":
            case "@show":
                return new String[]{"@section"};
        }
        DirectivesList listClass = new DirectivesList();
        for (Directive directiveEl :  listClass.getDirectives()){
            if (directiveEl.endtag().isEmpty()){
                continue;
            }
            if (directiveEl.endtag().equals(directive)){
                return new String[]{directiveEl.name()};
            }
        }

        return null;
    }
}
