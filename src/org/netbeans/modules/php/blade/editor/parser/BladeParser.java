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

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author bhaidu
 */
public class BladeParser extends org.netbeans.modules.parsing.spi.Parser {
    private static final Logger LOGGER = Logger.getLogger(BladeParser.class.getName());
    BladeParserResult lastResult;

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) throws ParseException {
        if (snapshot == null) {
            return;
        }

        String taskName = task.getClass().getName();

        if (taskName.contains("HtmlCssIndexContributor")){ //NOI18N
            LOGGER.log(Level.INFO, "Skipped parsing for {0}", taskName); //NOI18N
            return;
        }

        long startTime = System.currentTimeMillis();
        BladeParserResult parserResult = createParserResult(snapshot);

        BladeParserResult parsed = parserResult.get(taskName);
        lastResult = parsed;
        
        long time = System.currentTimeMillis() - startTime;

        if (time > 2000) {
            LOGGER.info(String.format("blade parser for " + taskName + " took %d ms", time)); //NOI18N
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
