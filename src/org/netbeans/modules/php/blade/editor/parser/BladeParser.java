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

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class BladeParser extends org.netbeans.modules.parsing.spi.Parser {
    private static final Logger LOGGER = Logger.getLogger(BladeParser.class.getName());
    BladeParserResult lastResult;
    private static final WeakHashMap<FileObject, Reference<BladeParserResult>> CACHE = new WeakHashMap<>();

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) throws ParseException {
        if (snapshot == null) {
            return;
        }
        LOGGER.info(String.format("Parsing request for for " + task.getClass().getName() + " event changed : " + event.sourceChanged()));
        if (task.getClass().getName().contains("HtmlCssIndexContributor")){
            LOGGER.log(Level.INFO, "Skipped parsing for {0}", task.getClass().getName());
            return;
        }
        long startTime = System.currentTimeMillis();
        BladeParserResult parserResult = createParserResult(snapshot);

        BladeParserResult parsed = parserResult.get(task.getClass().getName());
        //cacheResult(snapshot.getSource().getFileObject(), parsed);
        lastResult = parsed;
        //LOGGER.info(String.format("Finished parsing for " + task.getClass().getName() + ". Time : %d ms", System.currentTimeMillis() - startTime));
    }
    
    private static void cacheResult(FileObject fo, BladeParserResult result) {
        synchronized (CACHE) {
            CACHE.put(fo, new WeakReference<>(result));
        }
    }
    
    @Override
    public Result getResult(Task task) throws ParseException {
        assert lastResult != null;
        return lastResult;
    }

    @Override
    public void addChangeListener(ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener(ChangeListener changeListener) {
    }

    protected BladeParserResult createParserResult(Snapshot snapshot) {
        return new BladeParserResult(snapshot);
    }

}
