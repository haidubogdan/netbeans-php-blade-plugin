package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.php.blade.syntax.annotation.Directive;
import org.netbeans.modules.php.blade.syntax.annotation.DirectiveRegister;

/**
 *
 * @author bhaidu
 */
@DirectiveRegister({
    //conditionals
    @Directive(name = "@if", params = true, endtag = "@endif"),
    @Directive(name = "@elseif", params = true),
    @Directive(name = "@else"),
    @Directive(name = "@endif"),
    //loops
    @Directive(name = "@for", params = true, endtag = "@endfor"),
    @Directive(name = "@foreach", params = true, endtag = "@endforeach"),
    @Directive(name = "@forelse", params = true, endtag = "@endforelse"),
    @Directive(name = "@break"),
    @Directive(name = "@continue"),
    //layout
    @Directive(name = "@extends", params = true, endtag = "@endfor"),
    @Directive(name = "@section", params = true, endtag = "@endsection"),
    @Directive(name = "@endsection"),
    @Directive(name = "@stop"),
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
    @Directive(name = "@stack", params = true),
    @Directive(name = "@push", params = true, endtag = "@endpush"),
    @Directive(name = "@endpush", params = true),
    //form
    @Directive(name = "@csrf"),
    @Directive(name = "@method"),
    @Directive(name = "@error", params = true, endtag = "@enderror"),
    //env
    @Directive(name = "@env", params = true, endtag = "@endenv"),
    //auth
    @Directive(name = "@auth", params = true),
    //php
    @Directive(name = "@php", endtag = "@endphp"),
    @Directive(name = "@use", params = true),
    @Directive(name = "@inject", params = true),
    //utils
    @Directive(name = "@dd", params = true),})
public class DirectiveCompletionList {

    public Directive[] getDirectives() {
        DirectiveRegister directiveRegister = this.getClass().getAnnotation(DirectiveRegister.class);
        return directiveRegister.value();
    }
}
