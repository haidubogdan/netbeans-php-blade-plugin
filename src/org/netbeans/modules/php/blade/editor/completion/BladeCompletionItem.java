package org.netbeans.modules.php.blade.editor.completion;

import java.util.Collections;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.php.blade.editor.BladeSyntax;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionContextFinder.KeywordCompletionType;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndex;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;

/**
 *
 * @author bhaidu
 */
public class BladeCompletionItem implements CompletionProposal {

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/";
    //@StaticResource
    final CompletionRequest request;
    private final ElementHandle element;
    final String previewValue;

    BladeCompletionItem(ElementHandle element, CompletionRequest request, String previewValue) {
        this.element = element;
        this.request = request;
        this.previewValue = previewValue;
    }

    @Override
    public int getAnchorOffset() {
        return request.anchorOffset;
    }

    @Override
    public ElementHandle getElement() {
        return element;
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public String getSortText() {
        return getName();
    }

    @Override
    public int getSortPrioOverride() {
        return 0;
    }

    @Override
    public String getLhsHtml(HtmlFormatter formatter) {
        formatter.name(getKind(), true);
        formatter.appendHtml("<font>");
        formatter.appendHtml("<b>");
        formatter.appendText(previewValue);
        formatter.appendHtml("</b>");
        formatter.appendHtml("</font>");
        formatter.name(getKind(), false);
        return formatter.getText();
    }

    @Override
    public ImageIcon getIcon() {
        return ImageUtilities.loadImageIcon(ICON_BASE + "icons/at.png", false);
    }

    @Override
    public Set<Modifier> getModifiers() {
        return Collections.emptySet();
    }

    @Override
    public String getCustomInsertTemplate() {
        return null;
    }

    @Override
    public String getInsertPrefix() {
        StringBuilder template = new StringBuilder();
        template.append(getName());
        return template.toString();

    }

    @Override
    public String getRhsHtml(HtmlFormatter formatter) {
        FileObject file = null;
        if (element != null) {
            file = element.getFileObject();
        }
        if (file != null) {
            formatter.reset();
            formatter.appendText(" ");
            formatter.appendText(file.getName());
        }
        return formatter.getText();
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.CONSTRUCTOR;
    }

    @Override
    public boolean isSmart() {
        return true;
    }

    public static class KeywordItem extends BladeCompletionItem {

        private final String name;

        public KeywordItem(String keyword, CompletionRequest request) {
            super(null, request, keyword);
            this.name = keyword;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.KEYWORD;
        }

        @Override
        public String getLhsHtml(HtmlFormatter formatter) {
            formatter.appendHtml("<b>" + getName() + "</b>");
            formatter.appendText("               ");

            return formatter.getText();
        }

        @Override
        public String getRhsHtml(HtmlFormatter formatter) {
            return "BLADE keyword";
        }
    }

    /**
     * item with directive template code completion
     */
    public static class DirectiveItem extends BladeCompletionItem {

        public DirectiveItem(ElementHandle element, CompletionRequest request) {
            super(element, request, element.getName());
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.TAG;
        }

        @Override
        public String getCustomInsertTemplate() {
            StringBuilder builder = new StringBuilder();
            KeywordCompletionType type = BladeCompletionHandler.BLADE_DIRECTIVES.get(getName());
            if (type == null) {
                return getName();
            }
            //TODO have use codestyle for some indenting
            //CodeStyle codeStyle = CodeStyle.get(EditorRegistry.lastFocusedComponent().getDocument());
            String name;
            switch (type) {
                case SIMPLE:
                    return null;
                case WITH_ARG:
                    name = getName();
                    builder.append(name);
                    builder.append("(${cursor})"); //NOI18N
                    break;
                case WITH_ARG_AND_ENDTAG:
                    name = getName();
                    builder.append(name);
                    if (BladeSyntax.INLINE_DIRECTIVES.contains(name)) {
                        builder.append("(\"${cursor}\")");
                    } else {
                        builder.append("(${cursor})");
                    }
                    builder.append("\n");
                    builder.append("\n@end");
                    builder.append(name.substring(1));
                    break;
                case WITH_ENDTAG:
                    name = getName();
                    builder.append(name);
                    builder.append("\n${cursor}");
                    builder.append("\n@end");
                    builder.append(name.substring(1));
                    break;
            }
            return builder.toString();
        }

        @Override
        public ImageIcon getIcon() {
            return ImageUtilities.loadImageIcon(ICON_BASE + "icons/at2.png", false);
        }

        @Override
        public String getRhsHtml(HtmlFormatter formatter) {
            return "         BLADE directive";
        }
    }

    public static class SectionCompletionItem extends BladeCompletionItem {

        public SectionCompletionItem(ElementHandle element, CompletionRequest request) {
            super(element, request, element.getName());
        }

        @Override
        public String getLhsHtml(HtmlFormatter formatter) {
            formatter.name(getKind(), true);
            String name = getName();
            formatter.appendText(name);
            formatter.name(getKind(), false);
            return formatter.getText();
        }

        @Override
        public String getInsertPrefix() {
            StringBuilder template = new StringBuilder();
            template.append(getName());
            return template.toString();

        }

        @Override
        public String getRhsHtml(HtmlFormatter formatter) {
            return "    BLADE directive";
        }
    }

    public static class CompletionRequest {

        public int anchorOffset;
        public int carretOffset;
        public String prefix;
        public BladeParserResult parserResult;
        public BladeCompletionContextFinder.CompletionContext context;
        public BladeIndex index;
    }
}
