package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.php.blade.editor.model.api.BladePathElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.model.api.CustomDirectiveElement;
import org.openide.util.NbBundle;
import org.netbeans.modules.csl.api.ElementHandle;
/**
 *
 * @author bhaidu
 */
@NbBundle.Messages("BladeDocNotFound=BladeDoc not found")
final class DocRenderer {

    private static final Logger LOGGER = Logger.getLogger(BladeCompletionHandler.class.getName());

    private DocRenderer() {
    }

    static Documentation document(ParserResult info, BladePathElement element) {
        BladeDocumentation bladeDocumentation = BladeDocumentation.NONE;
        final CCDocHtmlFormatter locationHeader = new CCDocHtmlFormatter();
        CCDocHtmlFormatter header = new CCDocHtmlFormatter();
        header.appendText("yield reference - ");
        header.appendHtml("<font size=\"+1\">"); //NOI18N
        header.name(ElementKind.PARAMETER, true);
        header.appendText(element.getName());
        header.name(ElementKind.PARAMETER, false);
        header.appendHtml("</font>"); //N
        if (element.getFileObject() != null) {
            String location = element.getFileObject().getPath();
            locationHeader.appendHtml(String.format("<div align=\"right\"><font size=-1>%s</font></div>", location));  //NOI18N
        }

        bladeDocumentation = getBladeDocumentation(element, header);

        return bladeDocumentation.createDocumentation(locationHeader);
    }
    
    static Documentation document(ParserResult info, CustomDirectiveElement element) {
        BladeDocumentation bladeDocumentation = BladeDocumentation.NONE;
        final CCDocHtmlFormatter locationHeader = new CCDocHtmlFormatter();
        CCDocHtmlFormatter header = new CCDocHtmlFormatter();
        header.appendText("Custom Directive - ");
        header.appendHtml("<font size=\"+1\">"); //NOI18N
        header.name(ElementKind.PARAMETER, true);
        header.appendText(element.getName());
        header.name(ElementKind.PARAMETER, false);
        header.appendHtml("</font>"); //N
        if (element.getFileObject() != null) {
            String location = element.getFileObject().getPath();
            locationHeader.appendHtml(String.format("<div align=\"right\"><font size=-1>%s</font></div>", location));  //NOI18N
        }

        bladeDocumentation = getBladeDocumentation(element, header);

        return bladeDocumentation.createDocumentation(locationHeader);
    }

    private static BladeDocumentation getBladeDocumentation(final ElementHandle element, final CCDocHtmlFormatter header) {
        BladeDocExtractor bladeDocExtractor = new BladeDocExtractor(header, element);
        return bladeDocExtractor.getBladeDocumentation();
    }

    static final class BladeDocExtractor {

        private final CCDocHtmlFormatter header;
        private final StringBuilder phpDoc = new StringBuilder();
        ;
        private final ElementHandle element;

        public BladeDocExtractor(CCDocHtmlFormatter header, ElementHandle element) {
            this.header = header;
            this.element = element;
        }

        public BladeDocumentation getBladeDocumentation() {
            //extract();
            return BladeDocumentation.Factory.create(header, phpDoc, null);
        }
    }

    private interface BladeDocumentation {

        BladeDocumentation NONE = new BladeDocumentation() {

            @Override
            public Documentation createDocumentation(CCDocHtmlFormatter locationHeader) {
                return Documentation.create(String.format("%s%s", locationHeader.getText(), "")); //NOI18N
            }
        };

        Documentation createDocumentation(CCDocHtmlFormatter locationHeader);

        static final class Factory {

            static BladeDocumentation create(CCDocHtmlFormatter header, StringBuilder body, List<String> links) {
                URL url = null;
//                if (links.size() > 0) {
//                    try {
//                        url = new URL(links.get(0));
//                    } catch (MalformedURLException ex) {
//                        LOGGER.log(Level.INFO, null, ex);
//                    }
//                    if (links.size() > 1) {
//                        attachLinks(body, links);
//                    }
//                }
                String description = String.format("%s%s", header.getText(), ""); //NOI18N
                return new BladeDocumentationImpl(description, url);
            }

            @NbBundle.Messages("OnlineDocs=Online Documentation")
            private static void attachLinks(StringBuilder body, List<String> links) {
                assert links.size() > 1 : links.size();
                body.append("<h3>"); //NOI18N
                body.append(Bundle.OnlineDocs());
                body.append("</h3>\n"); //NOI18N
                for (String link : links) {
                    String line = String.format("<a href=\"%s\">%s</a><br>%n", link, link); //NOI18N
                    body.append(line);
                }
            }

        }

        static final class BladeDocumentationImpl implements BladeDocumentation {

            private final String description;
            private final URL url;

            private BladeDocumentationImpl(String description, URL url) {
                this.description = description;
                this.url = url;
            }

            @Override
            public Documentation createDocumentation(CCDocHtmlFormatter locationHeader) {
                assert locationHeader != null;
                return Documentation.create(String.format("%s%s", locationHeader.getText(), description), url); //NOI18N
            }

        }
    }
}
