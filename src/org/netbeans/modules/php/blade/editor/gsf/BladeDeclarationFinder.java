package org.netbeans.modules.php.blade.editor.gsf;

import java.util.Collection;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import java.util.Collections;
import java.util.Set;
import javax.swing.text.Document;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.BladeProjectSupport;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndex;
import org.netbeans.modules.php.blade.editor.index.api.IndexedElement;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.model.Model;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.netbeans.modules.php.blade.editor.model.api.BladePathElement;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.php.editor.CodeUtils;
import org.netbeans.modules.php.editor.api.ElementQuery;
import org.netbeans.modules.php.editor.api.ElementQueryFactory;
import org.netbeans.modules.php.editor.api.NameKind;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.netbeans.modules.php.editor.api.elements.ClassElement;
import org.netbeans.modules.php.editor.api.elements.ElementFilter;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bhaidu
 */
public class BladeDeclarationFinder implements DeclarationFinder {

    static enum DeclarationType {
        INCLUDE, SECTION, PHP, NONE
    }

    @Override
    public OffsetRange getReferenceSpan(Document doc, int caretOffset) {
        final BaseDocument docx = (BaseDocument) doc;
        TokenHierarchy<Document> th = TokenHierarchy.get(doc);
        docx.readLock();
        OffsetRange range = OffsetRange.NONE;
        try {
            //BaseDocument doc = (BaseDocument)document;
            TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, caretOffset);

            if (ts == null) {
                return OffsetRange.NONE;
            }

            ts.move(caretOffset);

            if (!ts.moveNext() && !ts.movePrevious()) {
                return OffsetRange.NONE;
            }

            // Determine whether the caret position is right between two tokens
            boolean isBetween = (caretOffset == ts.offset());

            range = getReferenceSpan(ts, th, caretOffset);

            if ((range == OffsetRange.NONE) && isBetween) {
                // The caret is between two tokens, and the token on the right
                // wasn't linkable. Try on the left instead.
                if (ts.movePrevious()) {
                    range = getReferenceSpan(ts, th, caretOffset);
                }
            }
        } finally {
            docx.readUnlock();
        }

        return range;
    }

    private OffsetRange getReferenceSpan(TokenSequence<?> ts,
            TokenHierarchy<Document> th, int lexOffset) {
        Token<?> token = ts.token();
        TokenId id = token.id();
        String text = token.text().toString().trim();
        int tokeLength = ts.offset() + token.length();

        if (BladeTokenId.BLADE_PHP_STRING == id) {
            return new OffsetRange(ts.offset(), tokeLength);
        } else if (BladeTokenId.T_PHP == id || BladeTokenId.T_BLADE_PHP == id) {
            TokenSequence<? extends PHPTokenId> tsPhp = BladeLexerUtils.getPhpTokenSequence(th, lexOffset);
            Token<?> tokenPhp = tsPhp.token();
            if (tokenPhp != null) {
                /**
                 * TODO simulate occurence builder from php
                 */
                TokenId phpId = tokenPhp.id();
                String textPhp = tokenPhp.text().toString().trim();
                if (phpId.equals(PHPTokenId.PHP_STRING) || phpId.equals(PHPTokenId.PHP_VARIABLE)) {
                    return new OffsetRange(tsPhp.offset(), tsPhp.offset() + tokenPhp.length());
                }
            }
        }

        return OffsetRange.NONE;
    }

    @Override
    public DeclarationLocation findDeclaration(ParserResult info, int carretOffset) {
        final Document document = info.getSnapshot().getSource().getDocument(false);
        if (document == null) {
            return DeclarationLocation.NONE;
        }
        final BaseDocument doc = (BaseDocument) document;
        BladeParserResult parseResult = (BladeParserResult) info;
        doc.readLock();
        try {
            //have a occurence support
            DeclarationContext context = getContext(carretOffset, doc);
            if (context == null || context.getPathValue().isEmpty()) {
                return DeclarationLocation.NONE;
            }
            DeclarationLocation locations = DeclarationLocation.NONE;

            switch (context.getDeclarationType()) {
                case INCLUDE: {
                    locations = findBladeViewsLocation(parseResult, context.getPathValue(), carretOffset);
                    break;
                }
                case SECTION: {
                    locations = findYieldPathLocation(parseResult, context.getPathValue(), carretOffset);
                    break;
                }
                case PHP: {
                    FileObject fo = parseResult.getSnapshot().getSource().getFileObject();
                    locations = PhpTypeCompletionProvider.getInstance().getItems(fo, context.getPathValue());
                    break;
                }
            }

            if (locations != DeclarationLocation.NONE) {
                return locations;
            }
        } finally {
            doc.readUnlock();
        }

        return DeclarationLocation.NONE;
    }

    private DeclarationContext getContext(int carretOffset, BaseDocument doc) {
        TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, carretOffset);
        String pathValue = "";
        if (ts != null) {
            ts.move(carretOffset);
            if (!ts.moveNext()) {
                ts.movePrevious();
            }
            do {
                Token<? extends TokenId> token = ts.token();
                if (token == null) {
                    break;
                }
                TokenId tokenId = token.id();
                String ttText = token.text().toString().trim();
                if (BladeTokenId.BLADE_PHP_STRING.equals(tokenId)) {
                    pathValue = token.text().toString().trim();
                    pathValue = pathValue.substring(1, pathValue.length() - 1);
                } else if (BladeTokenId.T_BLADE_PHP_VAR.equals(tokenId) && BladeLexerUtils.textIsStringWithQuotes(ttText)) {
                    pathValue = token.text().toString().trim();
                    pathValue = pathValue.substring(1, pathValue.length() - 1);
                } else if (BladeTokenId.T_PHP == tokenId || BladeTokenId.T_BLADE_PHP == tokenId) {
                    TokenHierarchy<Document> th = TokenHierarchy.get(doc);
                    TokenSequence<? extends PHPTokenId> tsPhp = BladeLexerUtils.getPhpTokenSequence(th, carretOffset);
                    Token<?> tokenPhp = tsPhp.token();
                    if (tokenPhp != null) {
                        //TODO test request processor flow @link https://github.com/apache/netbeans/blob/master/php/php.editor/src/org/netbeans/modules/php/editor/csl/DeclarationFinderImpl.java
                        TokenId phpId = tokenPhp.id();
                        String textPhp = tokenPhp.text().toString().trim();
                        if (phpId.equals(PHPTokenId.PHP_STRING) || phpId.equals(PHPTokenId.PHP_VARIABLE)) {
                            return new DeclarationContext(textPhp, DeclarationType.PHP);
                        }
                    }
                } else if (ttText.equals("@include") || ttText.equals("@extends") || ttText.equals("@includeIf")) {
                    //TODO use maybe BladeSyntax for category
                    return new DeclarationContext(pathValue, DeclarationType.INCLUDE);
                } else if (ttText.equals("@section")) {
                    return new DeclarationContext(pathValue, DeclarationType.SECTION);
                } else if (BladeTokenId.T_BLADE_DIRECTIVE.equals(tokenId)) {
                    //stop statements
                    break;
                }
            } while (ts.movePrevious());
        }
        return null;
    }

    public static final class PhpTypeCompletionProvider {

        private static final PhpTypeCompletionProvider INSTANCE = new PhpTypeCompletionProvider();
        private Set<ClassElement> cachedElements;

        private PhpTypeCompletionProvider() {
        }

        public static PhpTypeCompletionProvider getInstance() {
            return INSTANCE;
        }

        public DeclarationLocation getItems(FileObject sourceFile, String prefix) {
            DeclarationLocation alternatives = DeclarationLocation.NONE;
            //TODO adapt for different usecase using occurence
            for (ClassElement classElement : ElementFilter.forName(NameKind.prefix(prefix)).filter(getElements(sourceFile))) {
                if (!CodeUtils.isSyntheticTypeName(classElement.getName())) {
                    FileObject fo = classElement.getFileObject();
                    DeclarationLocation declLocation = new DeclarationLocation(
                            fo, classElement.getOffset());

                    AlternativeLocation al = new BladeAlternativeLocation(classElement, declLocation);
                    if (alternatives == DeclarationLocation.NONE) {
                        alternatives = al.getLocation();
                    }
                    alternatives.addAlternative(al);
                }
            }
            return alternatives;
        }

        private synchronized Set<ClassElement> getElements(FileObject fileObject) {
            if (cachedElements == null) {
                ElementQuery.Index indexQuery = ElementQueryFactory.createIndexQuery(QuerySupportFactory.get(fileObject));
                cachedElements = indexQuery.getClasses(NameKind.empty());
            }
            return cachedElements;
        }

        public synchronized void clearCache() {
            cachedElements = null;
        }

    }

    private DeclarationLocation findYieldPathLocation(BladeParserResult info, String pathValue, int carretOffset) {
        Model model = info.getModel();

        if (model != null) {
            org.netbeans.modules.php.blade.editor.model.OccurencesSupport occurencesSupport = model.getOccurencesSupport(info, carretOffset);
            org.netbeans.modules.php.blade.editor.model.api.Occurence underCaret = occurencesSupport.getOccurence();
            if (underCaret != null) {
                DeclarationLocation alternatives = DeclarationLocation.NONE;
                for (BladeElement element : underCaret.getAllDeclarations()) {
                    int offset = element.getOffsetRange() != null ? element.getOffsetRange().getStart() : 0;
                    DeclarationLocation declLocation = new DeclarationLocation(
                            element.getFileObject(), offset);
                    YieldElement elem = new YieldElement(pathValue);
                    AlternativeLocation al = new BladeAlternativeLocation(elem, declLocation);
                    if (alternatives == DeclarationLocation.NONE) {
                        alternatives = al.getLocation();
                    }
                    alternatives.addAlternative(al);
                }
                return alternatives;
            }

        }

        return DeclarationLocation.NONE;
    }

    private DeclarationLocation findBladeViewsLocation(BladeParserResult info, String pathValue, int carretOffset) {
        Model model = info.getModel();
        PathElement elem = new PathElement(pathValue);
        DeclarationLocation alternatives = DeclarationLocation.NONE;
        if (model != null) {
            org.netbeans.modules.php.blade.editor.model.OccurencesSupport occurencesSupport = model.getOccurencesSupport(info, carretOffset);
            org.netbeans.modules.php.blade.editor.model.api.Occurence underCaret = occurencesSupport.getOccurence();
            if (underCaret != null) {
                for (BladeElement element : underCaret.getAllDeclarations()) {
                    DeclarationLocation declLocation = new DeclarationLocation(
                            element.getFileObject(), 0);
                    AlternativeLocation al = new BladeAlternativeLocation(elem, declLocation);
                    if (alternatives == DeclarationLocation.NONE) {
                        alternatives = al.getLocation();
                    }
                    alternatives.addAlternative(al);
                }
                return alternatives;
            } else {
                //TODO check if there is an alternative using occurence here also ?
                BladeProjectSupport sup = BladeProjectSupport.findFor(info.getSnapshot().getSource().getFileObject());
                if (sup != null) {
                    BladeIndex index = sup.getIndex();
                    Collection<IndexedElement> bladeViews;
                    bladeViews = index.findBladePathsByPrefix(pathValue, BladeIndex.MatchType.PREFIX);
                    for (IndexedElement bladeView : bladeViews) {
                        String bladeName = bladeView.getName();
                        FileObject file = bladeView.getFileObject();
                        if (bladeName.endsWith(pathValue) || bladeName.startsWith(pathValue)){
                            //all good;
                        } else {
                            continue;
                        }
                        DeclarationLocation declLocation = new DeclarationLocation(
                                file, 0);
                        AlternativeLocation al = new BladeAlternativeLocation(elem, declLocation);
                        if (alternatives == DeclarationLocation.NONE) {
                            alternatives = al.getLocation();
                        }
                        alternatives.addAlternative(al);
                    }
                    return alternatives;
                }
            }
        }

        return DeclarationLocation.NONE;
    }

    public static class BladeAlternativeLocation implements AlternativeLocation {

        private ElementHandle modelElement;
        private DeclarationLocation declaration;

        public BladeAlternativeLocation(ElementHandle modelElement, DeclarationLocation declaration) {
            this.modelElement = modelElement;
            this.declaration = declaration;
        }

        @Override
        public ElementHandle getElement() {
            return modelElement;
        }

        @Override
        public String getDisplayHtml(HtmlFormatter formatter) {
            formatter.reset();
            //ElementKind ek = modelElement.getKind();
            formatter.appendText(modelElement.getName());

            if (declaration.getFileObject() != null) {
                formatter.appendText(" in ");
                formatter.appendText(FileUtil.getFileDisplayName(declaration.getFileObject()));
            }

            return formatter.getText();
        }

        @Override
        public DeclarationLocation getLocation() {
            return declaration;
        }

        @Override
        public int compareTo(AlternativeLocation o) {
            BladeAlternativeLocation i = (BladeAlternativeLocation) o;
            return this.modelElement.getName().compareTo(i.modelElement.getName());
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 89 * hash + (this.modelElement != null ? this.modelElement.hashCode() : 0);
            hash = 89 * hash + (this.declaration != null ? this.declaration.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BladeAlternativeLocation other = (BladeAlternativeLocation) obj;
            if (this.modelElement != other.modelElement && (this.modelElement == null || !this.modelElement.equals(other.modelElement))) {
                return false;
            }
            if (this.declaration != other.declaration && (this.declaration == null || !this.declaration.equals(other.declaration))) {
                return false;
            }
            return true;
        }
    }

    public class PathElement implements ElementHandle {

        private final String name;

        public PathElement(String name) {
            //we can add a file object from element
            this.name = name;
        }

        @Override
        public FileObject getFileObject() {
            return null;
        }

        @Override
        public String getMimeType() {
            return BladeLanguage.BLADE_MIME_TYPE;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getIn() {
            return "";
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.FILE;
        }

        @Override
        public Set<Modifier> getModifiers() {
            return Collections.EMPTY_SET;
        }

        @Override
        public boolean signatureEquals(ElementHandle eh) {
            return false;
        }

        @Override
        public OffsetRange getOffsetRange(ParserResult pr) {
            return OffsetRange.NONE;
        }
    }

    public class YieldElement implements ElementHandle {

        private final String name;

        public YieldElement(String name) {
            //we can add a file object from element
            this.name = name;
        }

        @Override
        public FileObject getFileObject() {
            return null;
        }

        @Override
        public String getMimeType() {
            return BladeLanguage.BLADE_MIME_TYPE;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getIn() {
            return "";
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.TAG;
        }

        @Override
        public Set<Modifier> getModifiers() {
            return Collections.EMPTY_SET;
        }

        @Override
        public boolean signatureEquals(ElementHandle eh) {
            return false;
        }

        @Override
        public OffsetRange getOffsetRange(ParserResult pr) {
            return OffsetRange.NONE;
        }
    }

    public class DeclarationContext {

        private DeclarationType declarationType = DeclarationType.NONE;
        private String pathValue = "";

        DeclarationContext(String pathValue, DeclarationType type) {
            this.pathValue = pathValue;
            this.declarationType = type;
        }

        public String getPathValue() {
            return pathValue;
        }

        public DeclarationType getDeclarationType() {
            return declarationType;
        }
    }
}
