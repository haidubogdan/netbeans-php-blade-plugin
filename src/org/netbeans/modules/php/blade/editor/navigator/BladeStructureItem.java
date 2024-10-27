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
package org.netbeans.modules.php.blade.editor.navigator;

import java.util.Collections;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.StructureItem;
import org.netbeans.modules.csl.spi.ParserResult;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public abstract class BladeStructureItem implements ElementHandle, StructureItem {

    private final String name;
    private final FileObject source;
    private final int startOffset;
    private final int stopOffset;


    public BladeStructureItem(String name, FileObject source, int startOffset, int stopOffset) {
        this.name = name;
        this.source = source;
        this.startOffset = startOffset;
        this.stopOffset = stopOffset;
    }

    @Override
    public String getSortText() {
        //the api sorting is alphabetic natural
        //using a string converted startOffset of the block item will give a good order in the navigator 
        return String.format("[%8d]", this.startOffset).replace(' ', '0'); //NOI18N
    }

    @Override
    public String getHtml(HtmlFormatter formatter) {
        formatter.appendText(name);
        return formatter.getText();
    }

    @Override
    public ElementHandle getElementHandle() {
        return this;
    }

    @Override
    public long getPosition() {
        return startOffset;
    }

    @Override
    public long getEndPosition() {
        return stopOffset;
    }

    @Override
    public ImageIcon getCustomIcon() {
        return null;
    }

    @Override
    public FileObject getFileObject() {
        return source;
    }

    @Override
    public String getMimeType() {
        return source.getMIMEType();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIn() {
        return null;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return Collections.emptySet();
    }

    @Override
    public boolean signatureEquals(ElementHandle handle) {
        return false;
    }

    @Override
    public OffsetRange getOffsetRange(ParserResult result) {
        return new OffsetRange(startOffset, stopOffset);
    }



}
