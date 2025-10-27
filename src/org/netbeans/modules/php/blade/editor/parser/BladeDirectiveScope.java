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
package org.netbeans.modules.php.blade.editor.parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author bogdan
 */
public class BladeDirectiveScope {

    private final int bladeAntlrTokenType;
    private final Set<String> phpVariables = new HashSet<>();
    private final Map<String, Integer> phpDeclaredVariableNames = new TreeMap<>();
    private BladeDirectiveScope child;

    public BladeDirectiveScope(int tokenType) {
        this.bladeAntlrTokenType = tokenType;
    }

    public void addPhpVariable(String varName) {
        phpVariables.add(varName);
    }

    public Set<String> getScopeVariables() {
        return phpVariables;
    }

    public void addDeclaredPhpVariable(String varName, int offset) {
        phpDeclaredVariableNames.put(varName, offset);
    }

    public Map<String, Integer> getDeclaredVariableNames() {
        return phpDeclaredVariableNames;
    }

    public int getScopeType() {
        return bladeAntlrTokenType;
    }

    public void setChild(BladeDirectiveScope child) {
        this.child = child;
    }

    public BladeDirectiveScope getChild() {
        return child;
    }
}
