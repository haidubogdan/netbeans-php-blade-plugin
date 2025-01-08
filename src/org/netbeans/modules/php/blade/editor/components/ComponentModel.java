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
package org.netbeans.modules.php.blade.editor.components;

import java.util.HashSet;
import java.util.Set;
import org.netbeans.modules.php.editor.parser.astnodes.FormalParameter;
import org.openide.filesystems.FileObject;

/**
 * TO BE CONTINUED
 * 
 * @author bhaidu
 */
public class ComponentModel {

    private final FileObject file;
    private boolean isValid = false;
    private final Set<FormalParameter> constructorProperties = new HashSet<>();
    
    public ComponentModel(FileObject file){
        this.file = file;
    }
    
    public boolean isValid(){
        return isValid;
    }
    
    public void checkClassValidity(String className){
        isValid = className.equals("Component") || className.equals("BladeComponent"); // NOI18N
    }
    
    public void addConstructorProperty(FormalParameter property){
        constructorProperties.add(property);
    }
    
    public Set<FormalParameter> getConstructorProperties(){
        return constructorProperties;
    }
}
