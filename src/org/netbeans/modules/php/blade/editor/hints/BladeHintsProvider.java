/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.blade.editor.hints;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.options.OptionsDisplayer;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.Hint;
import org.netbeans.modules.csl.api.HintFix;
import org.netbeans.modules.csl.api.HintSeverity;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.Rule;
import org.netbeans.modules.csl.api.Rule.ErrorRule;
import org.netbeans.modules.csl.api.RuleContext;
import org.netbeans.modules.csl.api.HintsProvider;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import static org.netbeans.modules.php.blade.editor.hints.PhpDirectiveSyntaxErrorRule.PHP_SYNTAX_ERROR_HINT_ID;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.path.BladePathUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.spi.project.ui.CustomizerProvider;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;

/**
 *
 * @author bhaidu
 */
public class BladeHintsProvider implements HintsProvider {

    /**
     * Compute hints applicable to the given compilation info and add to the
     * given result list.
     *
     * @param manager
     * @param context
     * @param hints
     */
    @Override
    public void computeHints(HintsManager manager, RuleContext context, List<Hint> hints) {
        if (!(context.parserResult instanceof BladeParserResult)) {
            return;
        }
        Map<?, List<? extends Rule.AstRule>> allHints = manager.getHints(false, context);
        List<? extends Rule.AstRule> directiveHints = allHints.get("blade.option.directive.hints"); //NOI18N

        BladeParserResult parserResult = (BladeParserResult) context.parserResult;
        FileObject fo = EditorDocumentUtils.getFileObject(context.doc);
        Project project = ProjectUtils.getMainOwner(fo);
        CustomDirectives ct = CustomDirectives.forProject(project);

        if (directiveHints != null) {
            for (Rule.AstRule astRule : directiveHints) {
                if (!manager.isEnabled(astRule)) {
                    continue;
                }
                if (astRule instanceof UnknownDirective) {
                    for (Map.Entry<OffsetRange, String> entry : parserResult.getBladeCustomDirectiveOccurences().getAll().entrySet()) {
                        if (ct.customDirectiveConfigured(entry.getValue())) {
                            continue;
                        }
                        hints.add(new Hint(astRule,
                                NbBundle.getMessage(BladeHintsProvider.class, "UnknownDirectiveHintMsg"), //NOI18N
                                context.parserResult.getSnapshot().getSource().getFileObject(),
                                entry.getKey(),
                                generateSetProjectConfigHints(project),
                                10));
                    }
                }
            }
        }

        //validate path config
        for (Map.Entry<String, List<OffsetRange>> entry : parserResult.getBladeReferenceIdsCollection().getIncludePathsOccurences().entrySet()) {
            FileObject realFile = BladePathUtils.findFileObjectForBladeViewPath(parserResult.getFileObject(),
                    entry.getKey());
            if (realFile != null) {
                continue;
            }
            for (OffsetRange range : entry.getValue()) {
                OffsetRange hintRange = new OffsetRange(range.getStart(), range.getEnd() + 1);
                hints.add(new Hint(new BladeRule(HintSeverity.WARNING),
                        NbBundle.getMessage(BladeHintsProvider.class, "BladeViewNotFound"), //NOI18N
                        context.parserResult.getSnapshot().getSource().getFileObject(),
                        hintRange,
                        generateSetProjectConfigHints(project),
                        10));
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
        return new BladeRuleContext();
    }
    
    private List<HintFix> generateSetProjectConfigHints(Project project){
        List<HintFix> fixes = new LinkedList<>();
        if (project == null) {
            return fixes;
        }
        
        fixes.add(new OpneProjectPropertiesFix(project));
        fixes.add(new ConfigHintFix());

        return fixes;
    }

    public static boolean phpSyntaxErrorsDisplayEnabled() {
        HintsManager bladeHintsManager = HintsProvider.HintsManager.getManagerForMimeType(BladeLanguage.MIME_TYPE);
        Map<?, List<? extends Rule.AstRule>> allHints = bladeHintsManager.getHints();
        List<? extends Rule.AstRule> phpSyntaxHints = allHints.get(PHP_SYNTAX_ERROR_HINT_ID); //NOI18N
        if (phpSyntaxHints == null || phpSyntaxHints.isEmpty()) {
            return false;
        }
        Rule.AstRule rule = phpSyntaxHints.get(0);
        return bladeHintsManager.isEnabled(rule);
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

    public class BladeRuleContext extends RuleContext {

        public boolean isCancelled() {
            return false;
        }

    }
    
    private static class OpneProjectPropertiesFix implements HintFix {

        private final Project project;

        public OpneProjectPropertiesFix(Project project) {
            this.project = project;
        }

        @Override
        public String getDescription() {
            return "Configure Project Properties"; //NOI18N
        }

        @Override
        public void implement() throws Exception {
            CustomizerProvider projectCustomizer = project.getLookup().lookup(CustomizerProvider.class);
            projectCustomizer.showCustomizer();
        }

        @Override
        public boolean isSafe() {
            return true;
        }

        @Override
        public boolean isInteractive() {
            return false;
        }
    }

    private static class ConfigHintFix implements HintFix {

        public ConfigHintFix() {}

        @Override
        public String getDescription() {
            return "Configure Hints"; //NOI18N
        }

        @Override
        public void implement() throws Exception {
            OptionsDisplayer displayer = OptionsDisplayer.getDefault();
            displayer.open("Editor/Hints/" + BladeLanguage.MIME_TYPE); //NOI18N
        }

        @Override
        public boolean isSafe() {
            return true;
        }

        @Override
        public boolean isInteractive() {
            return false;
        }
    }
}
