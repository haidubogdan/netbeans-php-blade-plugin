package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.php.blade.syntax.annotation.Directive;
import org.netbeans.modules.php.blade.syntax.annotation.DirectiveRegister;

/**
 * 
 * the since values are taken from https://github.com/onecentlin/laravel-blade-snippets-vscode
 * 
 *
 * @author bhaidu
 */
@DirectiveRegister({
    //conditionals
    @Directive(name = "@if", params = true, endtag = "@endif"),
    @Directive(name = "@elseif", params = true),
    @Directive(name = "@else"),
    @Directive(name = "@endif"),
    @Directive(name="@empty", since="5.4"),
    @Directive(name="@empty", params=true, endtag = "@endempty", since="5.4"),
    @Directive(name="@isset", params=true, endtag="@endisset"),
    @Directive(name="@unless", params=true, endtag="@endunless"),
    //loops
    @Directive(name = "@for", params = true, endtag = "@endfor"),
    @Directive(name = "@foreach", params = true, endtag = "@endforeach"),
    @Directive(name = "@forelse", params = true, endtag = "@endforelse"),
    @Directive(name = "@break"),
    @Directive(name = "@continue"),
    @Directive(name = "@endfor"),
    @Directive(name = "@endforeach"),
    @Directive(name = "@endforelse"),
    //layout
    @Directive(name = "@extends", params = true, endtag = "@endfor"),
    @Directive(name = "@section", params = true, endtag = "@endsection"),
    @Directive(name = "@endsection"),
    @Directive(name = "@stop"),
    @Directive(name = "@append"),
    @Directive(name = "@once"),
    @Directive(name = "@endonce"),
    @Directive(name = "@overwrite"),
    @Directive(name = "@yield", params = true),
    @Directive(name = "@hasSection", params = true, endtag = "@endif"),
    @Directive(name = "@include", params = true),
    @Directive(name = "@includeFirst", params = true),
    @Directive(name = "@includeIf", params = true),
    @Directive(name = "@includeWhen", params = true),
    @Directive(name = "@includeUnless", params = true),
    @Directive(name = "@each", params = true),
    //statement
    @Directive(name="@switch", params=true, endtag = "@endswitch"),
    @Directive(name="@case", params=true),
    @Directive(name="@default"),
    //stack
    @Directive(name = "@stack", params = true),
    @Directive(name = "@push", params = true, endtag = "@endpush"),
    @Directive(name = "@endpush"),
    @Directive(name = "@prepend", params = true, endtag = "@endprepend"),
    @Directive(name = "@endprepend"),
    @Directive(name = "@pushIf", params = true, endtag = "@endPushIf"),
    @Directive(name = "@endPushIf"),
    //
    @Directive(name = "@fragment", params = true, endtag = "@endfragment"),
    @Directive(name = "@endfragment"),
    //form
    @Directive(name = "@csrf"),
    @Directive(name = "@method", params = true),
    @Directive(name = "@error", params = true, endtag = "@enderror"),
    //env
    @Directive(name = "@env", params = true, endtag = "@endenv"),
    //auth
    @Directive(name = "@auth", params = true, endtag = "@endauth"),
    @Directive(name = "@guest", params = true, endtag = "@endguest"),
    @Directive(name = "@can", params = true, endtag = "@endcan", since="5.1"),
    @Directive(name = "@canany", params = true, endtag = "@endcanany", since="5.8"),
    @Directive(name = "@cannot", params = true, endtag = "@endcannot", since="5.3"),
    //php
    @Directive(name = "@php", endtag = "@endphp"),
    @Directive(name = "@use", params = true),
    @Directive(name = "@inject", params = true),
    //utils
    @Directive(name="@session", params = true, endtag="@endsession", since="10"),
    @Directive(name = "@dump", params = true),
    @Directive(name = "@dd", params = true),
    @Directive(name = "@json", params = true),
})
public final class DirectiveCompletionList {

    public Directive[] getDirectives() {
        DirectiveRegister directiveRegister = this.getClass().getAnnotation(DirectiveRegister.class);
        return directiveRegister.value();
    }
}
