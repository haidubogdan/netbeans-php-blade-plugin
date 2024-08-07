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
package org.netbeans.modules.php.blade.editor;

import java.util.Collection;
import org.openide.util.Parameters;

/**
 *
 * @author bhaidu
 */
public class EditorStringUtils {

    public static String implode(Collection<String> items, String delimiter) {
        Parameters.notNull("items", items);
        Parameters.notNull("delimiter", delimiter);

        if (items.isEmpty()) {
            return ""; // NOI18N
        }

        StringBuilder buffer = new StringBuilder(200);
        boolean first = true;
        for (String s : items) {
            if (!first) {
                buffer.append(delimiter);
            }
            buffer.append(s);
            first = false;
        }
        return buffer.toString();
    }
    
    public static boolean isQuotedString(String text){
        if (text.length() < 2){
            return false;
        }
        return (text.startsWith("'") && text.endsWith("'")) 
                || (text.startsWith("\"") && text.endsWith("\""));
    }

    public static String stripSurroundingQuotes(String text){
        if (!isQuotedString(text)){
            return text;
        }
        return text.substring(1, text.length()-1);
    }
}
