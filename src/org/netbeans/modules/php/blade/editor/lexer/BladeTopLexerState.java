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
package org.netbeans.modules.php.blade.editor.lexer;

import org.netbeans.lib.editor.util.CharSequenceUtilities;

/**
 *
 * @author Haidu Bogdan
 */
public class BladeTopLexerState {

    public enum Main {
        INIT,
        HTML,
        OPEN,
        BLADE,
        CLOSE,
        RAW,
        PHP,
        DIRECTIVE,
        DIRECTIVE_START,
        DIRECTIVE_PHP_OPEN,
        DIRECTIVE_ARGUMENTS
    };

    public enum Type {
        NONE, ECHO, ECHO_ESCAPED, COMMENT, PHP, DIRECTIVE_FUNCTION, DIRECTIVE, CLOSE_PHP_DIRECTIVE, CLOSE_ARG_BRACKET
    };

    Main main;
    Type type;

    public BladeTopLexerState() {
        main = Main.INIT;
        type = type.NONE;
    }

    public BladeTopLexerState(BladeTopLexerState copy) {
        main = copy.main;
        type = copy.type;
    }

    public BladeTopLexerState(Main main, Type type) {
        this.main = main;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.main != null ? this.main.hashCode() : 0);
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        BladeTopLexerState compare = (BladeTopLexerState) object;
        if (main != compare.main) {
            return false;
        }
        if (type != compare.type) {
            return false;
        }
        return true;
    }
    
    public static boolean sequenceStateEndsWith(BladeTopLexerState.Type currentState,
            String type,
            CharSequence text, String snippetToCheck){
            return (currentState == getType(type) && 
                    CharSequenceUtilities.endsWith(text, snippetToCheck));
    }
    
    public static Type getType(String content) {
        for (Type constant : Type.values()) {
            if (constant.name().equals(content)) {
                return constant;
            }
        }
        return null; //default value
    }
}
