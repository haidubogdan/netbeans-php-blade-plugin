package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.tree.MutableTreeNode;
import org.netbeans.api.editor.*;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.lib.editor.hyperlink.spi.HyperlinkProviderExt;
import org.netbeans.lib.editor.hyperlink.spi.HyperlinkType;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.editor.hyperlink.DeclarationPopup;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.netbeans.modules.php.blade.csl.elements.PathElement;
import org.netbeans.modules.php.blade.editor.lexer.EditorUtils;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.text.DataEditorSupport;
import org.openide.text.Line;
import org.openide.text.NbDocument;
import org.openide.util.Exceptions;

/**
 * Similar to a declaration finder
 *
 * @author bhaidu
 */
@MimeRegistration(mimeType = "text/x-php5", service = HyperlinkProviderExt.class)
public class HyperlinkProviderImpl implements HyperlinkProviderExt {

    String methodName;
    String identifiableText;
    String tooltipText = "";
    FileObject goToFile;
    int goToOffset = 0;
    int triggeredEvent = 0;

    public enum DeclarationType {
        VIEW_PATH;
    }

    @Override
    public Set<HyperlinkType> getSupportedHyperlinkTypes() {
        return EnumSet.of(HyperlinkType.GO_TO_DECLARATION, HyperlinkType.ALT_HYPERLINK);
    }

    @Override
    public boolean isHyperlinkPoint(Document doc, int offset, HyperlinkType type) {
//        if (!isInLaravelModule(doc)) {
//            return false;
//        }
        return getHyperlinkSpan(doc, offset, type) != null;
    }

    @Override
    public int[] getHyperlinkSpan(Document doc, int offset, HyperlinkType type) {
        if (!isInLaravelModule(doc)) {
            return null;
        }
        if (!type.equals(HyperlinkType.GO_TO_DECLARATION)) {
            //not handled by a LSP handler
            return null;
        }

        BaseDocument baseDoc = (BaseDocument) doc;
        int lineStart = LineDocumentUtils.getLineStart(baseDoc, offset);
        TokenSequence<PHPTokenId> tokensq = EditorUtils.getTokenSequence(doc, offset);

        if (tokensq == null) {
            return null;
        }

        Token<PHPTokenId> currentToken = tokensq.token();
        int startOffset = tokensq.offset();

        if (currentToken == null) {
            return null;
        }

        String focusedText = currentToken.text().toString();

        //2 char config are not that relevant
        if (focusedText.length() < 5 || !StringUtils.isQuotedString(focusedText)) {
            return null;
        }

        identifiableText = focusedText.substring(1, focusedText.length() - 1);
        PHPTokenId prevTokenId = null;

        while (tokensq.movePrevious() && tokensq.offset() >= lineStart) {
            Token<PHPTokenId> token = tokensq.token();
            if (token == null) {
                break;
            }
            String text = token.text().toString();
            PHPTokenId id = token.id();

            if (prevTokenId != null && id.equals(PHPTokenId.PHP_STRING)) {
                methodName = text;
                //tooltip text
                switch (methodName) {
                    case "view":
                    case "make":
                    case "render":
                        FileObject currentFile = getFileObjectFromDoc(doc);

                        if (currentFile == null) {
                            return null;
                        }
                        List<FileObject> includedFiles = PathUtils.findFileObjectsForBladeViewPath(currentFile, identifiableText);
                        String viewPath = "resources/views/" + identifiableText.replace(".", "/") + ".blade.php";
                        for (FileObject includedFile : includedFiles) {
                            goToFile = includedFile;
                            tooltipText = "Blade Template File : <b>" + viewPath
                                    + "</b><br><br><i style='margin-left:20px;'>" + identifiableText + "</i>";
                            goToOffset = 0;
                            break;
                        }
//                        DeclarationPopup test;
//                        FileObject dir = module.getSourceDirectory();
//                        if (dir != null) {
//                            String viewPath = "resources/views/" + identifiableText.replace(".", "/") + ".blade.php";
//                            //FileObject views = dir.getFileObject("resources/views");
//                            FileObject viewFile = dir.getFileObject(viewPath);
//                            goToFile = viewFile;
//                            tooltipText = "Blade Template File : <b>" + viewPath
//                                    + "</b><br><br><i style='margin-left:20px;'>" + identifiableText + "</i>";
//                            goToOffset = 0;
//                        }
                        return new int[]{startOffset, startOffset + currentToken.length()};
                    default:
                        return null;
                }
            }

            if (id.equals(PHPTokenId.PHP_TOKEN) && text.equals("(")) {
                prevTokenId = id;
            }
        }
        return null;
    }

    private FileObject getFileObjectFromDoc(Document doc) {
        DataObject dObject = NbEditorUtilities.getDataObject(doc);
        if (dObject != null) {
            return dObject.getPrimaryFile().getParent();
        }
        return null;
    }

    @Override
    public void performClickAction(Document doc, int offset, HyperlinkType type) {
        switch (type) {
            case GO_TO_DECLARATION:
                switch (methodName) {
                    case "view":
                    case "make":
                    case "render":
                        if (goToFile != null) {
                            openDocument(goToFile, goToOffset);
                            triggeredEvent++;
                        }
                        break;
                }

            case ALT_HYPERLINK:
                JTextComponent focused = EditorRegistry.focusedComponent();
                if (focused != null && focused.getDocument() == doc) {
                    focused.setCaretPosition(offset);
                    //GoToImplementation.goToImplementation(focused);
                }
                break;
        }
    }

    private void openDocument(FileObject f, int offset) {
        try {
            DataObject dob = DataObject.find(f);
            NbDocument.openDocument(dob, offset, Line.ShowOpenType.OPEN, Line.ShowVisibilityType.FOCUS);

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    //TODO complete
    private boolean isInLaravelModule(Document doc) {
        return true;
    }

    @Override
    public String getTooltipText(Document doc, int offset, HyperlinkType type) {
        return "<html><body>" + tooltipText + "</body></html>";
    }

}
