/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionProposal.CompletionRequest;
import org.netbeans.modules.php.blade.editor.completion.BladeDocumentationFactory.DirectiveDocumentationFactory;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.lexer.BladeTopTokenId;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler2;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ParameterInfo;
import org.netbeans.modules.csl.spi.DefaultCompletionResult;
import org.netbeans.modules.csl.spi.ParserResult;

public class BladeCompletionHandler implements CodeCompletionHandler2 {
    private static URL documentationUrl = null;
        static {
            try {
                documentationUrl = new URL("https://laravel.com/docs/8.x/blade"); //NOI18N
            } catch (MalformedURLException ex) {
                //LOGGER.log(Level.FINE, null, ex);
            }
    }
        
    private static final Set<BladeElement> DIRECTIVES = new HashSet<>();   
    static {
        BladeDocumentationFactory documentationFactory = DirectiveDocumentationFactory.getInstance();
        DIRECTIVES.add(BladeElement.Factory.create("for", documentationFactory, "for(${$i}; ${$i} < 10; ${$i}++)\n\n@endfor")); //NOI18N
        DIRECTIVES.add(BladeElement.Factory.create("foreach", documentationFactory, "foreach(${$array} as ${$item})\n\n@endforeach")); //NOI18N
        DIRECTIVES.add(BladeElement.Factory.create("if", documentationFactory, "if(${$test})\n\n@endif")); //NOI18N
        DIRECTIVES.add(BladeElement.Factory.create("extends", documentationFactory, "extends('${template}')")); //NOI18N
        DIRECTIVES.add(BladeElement.Factory.create("section", documentationFactory, "section('${content}')\n\n@endsection")); //NOI18N
        DIRECTIVES.add(BladeElement.Factory.create("section_inline", documentationFactory, "section('${content}', '${value}')")); //NOI18N
    }
    @Override
    public CodeCompletionResult complete(CodeCompletionContext codeCompletionContext) {
        final List<CompletionProposal> completionProposals = new ArrayList<>();
        ParserResult parserResult = codeCompletionContext.getParserResult();
        if (parserResult instanceof BladeParserResult) {
            BladeParserResult bladeParserResult = (BladeParserResult) parserResult;
            CompletionRequest request = new CompletionRequest();
            request.prefix = codeCompletionContext.getPrefix();
            int caretOffset = codeCompletionContext.getCaretOffset();
            String properPrefix = getPrefix(bladeParserResult, caretOffset, true);
            request.anchorOffset = caretOffset - (properPrefix == null ? 0 : properPrefix.length());
            request.parserResult = bladeParserResult;
            request.context = BladeCompletionContextFinder.find(request.parserResult, caretOffset);
            doCompletion(completionProposals, request);
        }
        return new DefaultCompletionResult(completionProposals, false);
    }

    private void doCompletion(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        switch (request.context) {
//            case FILTER:
//                completeFilters(completionProposals, request);
//                break;
//            case BLOCK:
//                completeAll(completionProposals, request);
//                break;
//            case VARIABLE:
//                completeFilters(completionProposals, request);
//                completeFunctions(completionProposals, request);
//                completeTests(completionProposals, request);
//                completeOperators(completionProposals, request);
//                break;
            case ALL:
                completeAll(completionProposals, request);
                break;
            case NONE:
                break;
            default:
                completeAll(completionProposals, request);
        }
    }
    
    private void completeAll(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        completeDirectives(completionProposals, request);
    }
    
    private void completeDirectives(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        for (BladeElement directive : DIRECTIVES) {
            if (startsWith(directive.getName(), request.prefix)) {
                completionProposals.add(new BladeCompletionProposal.DirectiveCompletionProposal(directive, request));
            }
        }
    }
    
    private static boolean startsWith(String theString, String prefix) {
        return prefix.length() == 0 ? true : theString.toLowerCase().startsWith(prefix.toLowerCase());
    }
    
    @Override
    public String document(ParserResult pr, ElementHandle eh) {
        return "";
    }

    @Override
    public ElementHandle resolveLink(String string, ElementHandle eh) {
        return null;
    }

    @Override
    public String getPrefix(ParserResult info, int offset, boolean upToOffset) {
        return PrefixResolver.create(info, offset, upToOffset).resolve();
    }

    @Override
    public QueryType getAutoQuery( JTextComponent jtc, String string ) {
        return QueryType.ALL_COMPLETION;
    }

    @Override
    public String resolveTemplateVariable(String string, ParserResult pr, int i, String string1, Map map) {
        return null;
    }

    @Override
    public Set<String> getApplicableTemplates(Document dcmnt, int i, int i1) {
        return Collections.emptySet();
    }

    @Override
    public ParameterInfo parameters(ParserResult pr, int i, CompletionProposal cp) {
        return new ParameterInfo( new ArrayList<String>(), 0, 0 );
    }
    
    @Override
    public Documentation documentElement(ParserResult parserResult, ElementHandle elementHandle, Callable<Boolean> cancel) {
        Documentation result = null;
        if (elementHandle instanceof BladeElement) {
            result = Documentation.create(((BladeElement) elementHandle).getDocumentation().asText(), documentationUrl);
        }
        return result;
    }
    
    private static final class PrefixResolver {
        private final ParserResult info;
        private final int offset;
        private final boolean upToOffset;
        private String result = "";

        static PrefixResolver create(ParserResult info, int offset, boolean upToOffset) {
            return new PrefixResolver(info, offset, upToOffset);
        }

        private PrefixResolver(ParserResult info, int offset, boolean upToOffset) {
            this.info = info;
            this.offset = offset;
            this.upToOffset = upToOffset;
        }

        String resolve() {
            TokenHierarchy<?> th = info.getSnapshot().getTokenHierarchy();
            if (th != null) {
                processHierarchy(th);
            }
            return result;
        }

        private void processHierarchy(TokenHierarchy<?> th) {
            TokenSequence<BladeTopTokenId> tts = th.tokenSequence(BladeTopTokenId.language());
            if (tts != null) {
                processTopSequence(tts);
            }
        }

        private void processTopSequence(TokenSequence<BladeTopTokenId> tts) {
            tts.move(offset);
            if (tts.moveNext() || tts.movePrevious()) {
                TokenSequence<? extends TokenId> ts = tts.embedded(BladeTokenId.language());

                processSequence(ts);
            }
        }

        private void processSequence(TokenSequence<? extends TokenId> ts) {
            if (ts != null) {
                processValidSequence(ts);
            }
        }

        private void processValidSequence(TokenSequence<? extends TokenId> ts) {
            ts.move(offset);
            if (ts.moveNext() || ts.movePrevious()) {
                processToken(ts);
            }
        }

        private void processToken(TokenSequence<? extends TokenId> ts) {
            if (ts.offset() == offset) {
                ts.movePrevious();
            }
            Token<?> token = ts.token();
            if (token != null) {
                processSelectedToken(ts);
            }
        }

        private void processSelectedToken(TokenSequence<? extends TokenId> ts) {
            TokenId id = ts.token().id();
            if (isValidTokenId(id)) {
                createResult(ts);
            }
        }

        private void createResult(TokenSequence<? extends TokenId> ts) {
            if (upToOffset) {
                String text = ts.token().text().toString();
                result = text.substring(0, offset - ts.offset());
            }
        }

        private static boolean isValidTokenId(TokenId id) {
            return BladeTopTokenId.T_DIRECTIVE.equals(id);
        }

    }
    
}
