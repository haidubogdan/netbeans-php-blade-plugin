package org.netbeans.modules.php.blade.editor.hints;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.prefs.Preferences;
import javax.swing.JComponent;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.csl.api.Hint;
import org.netbeans.modules.csl.api.HintSeverity;
import org.netbeans.modules.csl.api.HintsProvider;
import org.netbeans.modules.csl.api.Rule;
import org.netbeans.modules.csl.api.RuleContext;

/**
 *
 * @author bogdan
 */
public class UnknownDirective implements Rule.AstRule {

    public void computeHints(RuleContext context, List<Hint> hints, int offset, HintsProvider.HintsManager manager) throws BadLocationException {
        
    }

    @Override
    public boolean getDefaultEnabled() {
        return true;
    }

    @Override
    public JComponent getCustomizer(Preferences node) {
        return null;
    }

    @Override
    public boolean appliesTo(RuleContext context) {
        return context instanceof BladeHintsProvider.BladeRuleContext;
    }

    @Override
    public boolean showInTasklist() {
        return true;
    }

    @Override
    public HintSeverity getDefaultSeverity() {
        return HintSeverity.WARNING;
    }

    @Override
    public Set<?> getKinds() {
        return Collections.singleton("blade.option.directive.hints");
    }

    @Override
    public String getId() {
        return "blade.hint.unknown_directive";
    }

    @Override
    public String getDescription() {
       return "Unknown Directive. The directive my not be in the base laravel blade compiler and was not found in the custom list.";
    }

    @Override
    public String getDisplayName() {
        return "Unknown Directive";
    }

}
