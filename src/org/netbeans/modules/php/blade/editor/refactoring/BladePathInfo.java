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
package org.netbeans.modules.php.blade.editor.refactoring;


import java.util.Objects;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class BladePathInfo {

    private final FileObject sourceFile;
    private final String bladePath;

    public BladePathInfo(FileObject sourceFile, String bladePath) {
        this.sourceFile = sourceFile;
        this.bladePath = bladePath;
    }

    public FileObject getSourceFile() {
        return sourceFile;
    }

    public String getBladePath() {
        return bladePath;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.sourceFile);
        hash = 53 * hash + Objects.hashCode(this.bladePath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BladePathInfo other = (BladePathInfo) obj;
        if (!Objects.equals(this.bladePath, other.bladePath)) {
            return false;
        }
        return Objects.equals(this.sourceFile, other.sourceFile);
    }

}
