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
package org.netbeans.modules.php.blade.editor;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bhaidu
 */
public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getSimpleName());
    /**
     * used for debugin | test to have the constant property name of a
     * enumeration class
     *
     * @param fields
     * @param symbol
     * @return
     */
    public static String fieldsIndexOf(Field[] fields, int symbol) {
        for (Field field : fields) {
            String fieldName = field.getName();
            try {
                Object value = field.get(field);
                if (value.equals(symbol)) {
                    return fieldName;
                }
            } catch (Exception ex) {

            }
        }
        return null;
    }

    /**
     * get the file path in form of a blade path with "."
     * 
     * @param fileObject
     * @return 
     */
    public static String convertToBladePath(FileObject fileObject) {
        Project project = FileOwnerQuery.getOwner(fileObject);
        FileObject projectRoot = project.getProjectDirectory();
        String sp = "/";
        String relativeFilePath = fileObject.getPath().replace(projectRoot.getPath() + sp, "");
        
        String[] views = BladeProjectProperties.getInstance(project).getViewsPathList();
        Arrays.sort(views, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null || s2 == null){
                    return 0;
                }
                return s2.length() - s1.length();// comparision
            }
        });
        if (views.length > 0){
            String filePath = fileObject.getPath();
            //should sort by length
            for (String view : views){
                if (view.length() == 0){
                    continue;
                }
                File viewPath = new File(view);
                if (!viewPath.exists()){
                    continue;
                }
                //TODO find a way to have the same path format
                FileObject viewFileObj = FileUtil.toFileObject(viewPath);
                String viewFilePath = viewFileObj.getPath() + sp;
                if (filePath.startsWith(viewFilePath)){
                    relativeFilePath = filePath.substring(viewFilePath.length());
                    break;
                }
            }
        } else {
            int firstViewFolderIndex = relativeFilePath.indexOf("views" + sp);
            if (firstViewFolderIndex >= 0) {
                relativeFilePath = relativeFilePath.substring(firstViewFolderIndex + ("views" + sp).length());
            } else {
                LOGGER.log(Level.FINE, "blade file is outside the views direcotry {0}", fileObject.getPath());
            }
        }

        relativeFilePath = relativeFilePath.substring(0, relativeFilePath.length() - (".blade.php".length()));
        relativeFilePath = relativeFilePath.replace(sp, ".");
        return relativeFilePath;
    }
}
