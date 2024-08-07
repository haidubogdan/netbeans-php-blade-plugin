package org.netbeans.modules.php.blade.editor.highlighting;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.spi.editor.highlighting.HighlightsSequence;
import org.netbeans.spi.editor.highlighting.support.AbstractHighlightsContainer;


/**
 *
 * hack to fix the highlighting issue on javascript properties vs blade paths
 * "@include('my.path') - my.path should be fully selected on double click
 * window.test - should not be fully selected on double click
 * 
 * @author bhaidu
 */
public class BladeHighlightsContainer extends AbstractHighlightsContainer {

    private final AbstractDocument doc;
    AttributeSet attrs = null;
    private static int offset = 0;

    public BladeHighlightsContainer(AbstractDocument doc) {
        this.doc = doc;
    }

    public @Override
    HighlightsSequence getHighlights(final int startOffset, final int endOffset) {
        return new HighlightsSequence() {
            int start, end;
            final int scanStart;

            {
                scanStart = doc.getParagraphElement(startOffset).getStartOffset();
                if (offset != scanStart){
                    offset = scanStart;
                    //reset the hasQuote flag from isIdentifierChar
                    BladeLanguage.hasQuote = false;
                }
            }

            public @Override
            boolean moveNext() {

                return false;
            }

            public @Override
            int getStartOffset() {
                return start;
            }

            public @Override
            int getEndOffset() {
                return end;
            }

            public @Override
            AttributeSet getAttributes() {
                return attrs;
            }
        };
    }
}
