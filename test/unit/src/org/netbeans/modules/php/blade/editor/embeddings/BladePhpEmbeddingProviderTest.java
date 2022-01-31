package org.netbeans.modules.php.blade.editor.embeddings;

import java.util.List;
import org.junit.Test;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.parsing.api.Embedding;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.spi.EmbeddingProvider;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.php.blade.api.test.BladeTestBase;

/**
 * embedding test can't work because the test classes can't be loaded
 * 
 * @author bhaidu
 */
public class BladePhpEmbeddingProviderTest extends BladeTestBase {

    public BladePhpEmbeddingProviderTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private void checkPhpEmbedding(final String relFilePath) throws Exception {
        checkEmbedding(relFilePath, new BladePhpEmbeddingProvider());
    }

    private void checkEmbedding(final String relFilePath, EmbeddingProvider embeddingProvider) throws Exception {
        assertNotNull(embeddingProvider);
        String testedFilePath = "testfiles/embedding/" + relFilePath + ".php";
        //Source testSource = getTestSource(getTestFile(testedFilePath));
        //List<Embedding> embeddings = embeddingProvider.getEmbeddings(testSource.createSnapshot());
        //System.out.print(serializableEmbeddings(embeddings));
    }

    private String serializableEmbeddings(List<Embedding> embeddings) {
        StringBuilder sb = new StringBuilder();
        for (Embedding embedding : embeddings) {
            sb.append(embedding.getSnapshot().getText());
        }
        return sb.toString();
    }

    @Test
    public void testIf() throws Exception {
        checkPhpEmbedding("if.blade");
    }
}
