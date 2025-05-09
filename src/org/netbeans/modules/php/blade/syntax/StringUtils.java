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
package org.netbeans.modules.php.blade.syntax;

/**
 *
 * @author bhaidu
 */
public final class StringUtils {

    public static final String DOT = "."; //NOI18N
    public static final String ESCAPED_DOT = "\\."; //NOI18N
    public static final String BACK_DASH = "\\"; //NOI18N
    public static final String FORWARD_SLASH = "/"; //NOI18N

    private StringUtils() {

    }

    public static boolean isUpperCase(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }

        return true;
    }

    public static String capitalize(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String toKebabCase(String str) {
        return str.replaceAll("([A-Z])", "-$1").toLowerCase().substring(1); //NOI18N
    }

    public static String kebabToCamel(String str) {
        str = str.toLowerCase();
        String[] words = str.split("-"); //NOI18N
        String camelCase = words[0];
        for (int i = 1; i < words.length; i++) {
            camelCase += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return capitalize(camelCase);
    }

    public static boolean isWhitespace(String text) {
        return text.replaceAll(" ", "").isEmpty(); //NOI18N
    }

    public static String replaceLinesAndTabs(String input) {
        String escapedString = input;
        escapedString = escapedString.replaceAll("\n", "\\\\n"); // NOI18N
        escapedString = escapedString.replaceAll("\r", "\\\\r"); // NOI18N
        escapedString = escapedString.replaceAll("\t", "\\\\t"); // NOI18N
        return escapedString;
    }
}
