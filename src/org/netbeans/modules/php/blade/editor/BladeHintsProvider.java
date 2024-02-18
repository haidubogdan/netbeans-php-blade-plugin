package org.netbeans.modules.php.blade.editor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.Hint;
import org.netbeans.modules.csl.api.HintSeverity;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.Rule;
import org.netbeans.modules.csl.api.Rule.ErrorRule;
import org.netbeans.modules.csl.api.RuleContext;
import org.netbeans.modules.csl.api.HintsProvider;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import static org.netbeans.modules.php.blade.editor.indexing.BladeIndexer.INCLUDE_PATH;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class BladeHintsProvider implements HintsProvider {

    /**
     * Compute hints applicable to the given compilation info and add to the
     * given result list.
     * @param manager
     * @param context
     * @param hints
     */
    @Override
    public void computeHints(HintsManager manager, RuleContext context, List<Hint> hints) {
        if (context.parserResult instanceof BladeParserResult) {
            BladeParserResult parserResult = (BladeParserResult) context.parserResult;
            FileObject fo = EditorDocumentUtils.getFileObject(context.doc);
            Project project = ProjectUtils.getMainOwner(fo);
            CustomDirectives ct = CustomDirectives.getInstance(project);
            for (Object setentry : parserResult.customDirectivesReferences.entrySet()) {
                Map.Entry<OffsetRange, BladeParserResult.Reference> entry = (Map.Entry<OffsetRange, BladeParserResult.Reference>) setentry;
                if (ct.customDirectiveNames.contains(entry.getValue().name)) {
                    continue;
                }
                hints.add(new Hint(new BladeRule(HintSeverity.WARNING),
                        "unknown directive",
                        context.parserResult.getSnapshot().getSource().getFileObject(),
                        entry.getKey(),
                        Collections.emptyList(),
                        10));
            }

            //validate path config
            for (Map.Entry<String, List<OffsetRange>> entry : parserResult.includeBladeOccurences.entrySet()) {
                FileObject realFile = PathUtils.findFileObjectForBladePath(parserResult.getFileObject(),
                        entry.getKey());
                if (realFile != null) {
                    continue;
                }
                for (OffsetRange range : entry.getValue()) {
                    OffsetRange hintRange = new OffsetRange(range.getStart(), range.getEnd() + 1);
                    hints.add(new Hint(new BladeRule(HintSeverity.WARNING),
                            "Blade path not found.\nFor custom blade context you can try to set the root folder using:\nProject -> Properties -> Laravel Blade -> Views Folder",
                            context.parserResult.getSnapshot().getSource().getFileObject(),
                            hintRange,
                            Collections.emptyList(),
                            10));
                }
            }
        }

    }

    /**
     * Compute any suggestions applicable to the given caret offset, and add to
     * the given suggestion list.
     */
    @Override
    public void computeSuggestions(HintsManager manager, RuleContext context, List<Hint> suggestions, int caretOffset) {
    }

    /**
     * Compute any suggestions applicable to the given caret offset, and add to
     * the given suggestion list.
     */
    @Override
    public void computeSelectionHints(HintsManager manager, RuleContext context, List<Hint> suggestions, int start, int end) {
    }

    /**
     * Process the errors for the given compilation info, and add errors and
     * warning descriptions into the provided hint list. Return any errors that
     * were not added as error descriptions (e.g. had no applicable error rule)
     */
    @Override
    public void computeErrors(HintsManager manager, RuleContext context, List<Hint> hints, List<Error> unhandled) {
        BladeParserResult parserResult = (BladeParserResult) context.parserResult;

        unhandled.addAll(parserResult.getDiagnostics());
    }

    /**
     * Cancel in-progress processing of hints.
     */
    @Override
    public void cancel() {
        //todo implement
    }

    /**
     * <p>
     * Optional builtin Rules. Typically you don't use this; you register your
     * rules in your filesystem layer in the gsf-hints/mimetype1/mimetype2
     * folder, for example gsf-hints/text/x-ruby/. Error hints should go in the
     * "errors" folder, selection hints should go in the "selection" folder, and
     * all other hints should go in the "hints" folder (but note that you can
     * create localized folders and organize them under hints; these categories
     * are shown in the hints options panel. Hints returned from this method
     * will be placed in the "general" folder.
     * </p>
     * <p>
     * This method is primarily intended for rules that should be added
     * dynamically, for example for Rules that have a many different flavors yet
     * a single implementation class (such as JavaScript's StrictWarning rule
     * which wraps a number of builtin parser warnings.)
     *
     * @return A list of rules that are builtin, or null or an empty list when
     * there are no builtins
     */
    @Override
    public List<Rule> getBuiltinRules() {
        return null;
    }

    /**
     * Create a RuleContext object specific to this HintsProvider. This lets
     * implementations of this interface created subclasses of the RuleContext
     * that can be passed around to all the executed rules.
     *
     * @return A new instance of a RuleContext object
     */
    @Override
    public RuleContext createRuleContext() {
        return new RuleContext();
    }

    private static final class BladeRule implements ErrorRule {

        private final HintSeverity severity;

        private BladeRule(HintSeverity severity) {
            this.severity = severity;
        }

        @Override
        public Set<?> getCodes() {
            return Collections.emptySet();
        }

        @Override
        public boolean appliesTo(RuleContext context) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "blade"; //NOI18N
        }

        @Override
        public boolean showInTasklist() {
            return true;
        }

        @Override
        public HintSeverity getDefaultSeverity() {
            return severity;
        }
    }

}
