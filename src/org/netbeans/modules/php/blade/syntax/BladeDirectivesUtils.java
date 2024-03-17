package org.netbeans.modules.php.blade.syntax;

/**
 * TODO use the DirectiveCompletionList to compile pairing
 *
 * @author bhaidu
 */
public class BladeDirectivesUtils {

    public static String[] directiveStart2EndPair(String directive) {
        switch (directive) {
            case "@if":
            case "@hasSection":
            case "@else":
                return new String[]{"@endif", "@endIf"};
            case "@section":
                return new String[]{"@endsection", "@show", "@stop", "@append"};
            case "@push":
                return new String[]{"@endpush"};
            case "@pushIf":
                return new String[]{"@endPushIf"};
            case "@prepend":
                return new String[]{"@endprepend"};
            case "@fragment":
                return new String[]{"@endfragment"};
            case "@once":
                return new String[]{"@endonce"};
            case "@foreach":
                return new String[]{"@endforeach"};
            case "@forelse":
                return new String[]{"@endforelse"};
            case "@for":
                return new String[]{"@endfor"};
            case "@while":
                return new String[]{"@endwhile"};
            case "@php":
                return new String[]{"@endphp"};
            case "@unless":
                return new String[]{"@endunless"};
            case "@isset":
                return new String[]{"@endisset"};
            case "@empty":
                return new String[]{"@endempty"};
            case "@verbatim":
                return new String[]{"@endverbatim"};
            case "@auth":
                return new String[]{"@endauth"};
            case "@can":
                return new String[]{"@endcan"};
            case "@canany":
                return new String[]{"@endcanany"};
            case "@cannot":
                return new String[]{"@endcannot"};
            case "@guest":
                return new String[]{"@endguest"};
            case "@production":
                return new String[]{"@endproduction"};
            case "@error":
                return new String[]{"@enderror"};
            case "@switch":
                return new String[]{"@endswitch"};

        }
        return null;
    }

    public static String[] directiveEnd2StartPair(String directive) {
        switch (directive) {
            case "@endif":
                return new String[]{"@if", "@hasSection"};
            case "@endsection":
            case "@stop":
            case "@append":
            case "@show":
                return new String[]{"@section"};
            case "@endpush":
                return new String[]{"@push"};
            case "@endPushIf":
                return new String[]{"@pushIf"};
            case "@endprepend":
                return new String[]{"@prepend"};
            case "@endonce":
                return new String[]{"@once"};
            case "@endforeach":
                return new String[]{"@foreach"};
            case "@endforelse":
                return new String[]{"@forelse"};
            case "@endfor":
                return new String[]{"@for"};
            case "@endphp":
                return new String[]{"@php"};
            case "@endunless":
                return new String[]{"@unless"};
            case "@endisset":
                return new String[]{"@isset"};
            case "@endempty":
                return new String[]{"@empty"};
            case "@endverbatim":
                return new String[]{"@verbatim"};
            case "@endauth":
                return new String[]{"@auth"};
            case "@endguest":
                return new String[]{"@guest"};
            case "@endproduction":
                return new String[]{"@production"};
            case "@enderror":
                return new String[]{"@error"};
            case "@endswitch":
                return new String[]{"@switch"};
        }
        return null;
    }
}
