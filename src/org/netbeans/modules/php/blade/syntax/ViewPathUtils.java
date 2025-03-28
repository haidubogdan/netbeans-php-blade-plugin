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
 * @author bogdan
 */
public final class ViewPathUtils {

    private ViewPathUtils() {

    }

    public static int getViewPathSeparatorOffset(String pathName, int offset) {
        int lastDotPos;

        if (pathName.endsWith(StringUtils.DOT)) {
            lastDotPos = pathName.length();
        } else {
            lastDotPos = pathName.lastIndexOf(StringUtils.DOT);
        }
        int pathOffset;

        if (lastDotPos > 0) {
            int dotFix = pathName.endsWith(StringUtils.DOT) ? 0 : 1;
            pathOffset = offset - pathName.length() + lastDotPos + dotFix;
        } else {
            pathOffset = offset - pathName.length();
        }
        
        return pathOffset;
    }
}
