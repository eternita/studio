/*
 * Copyright (c) 2013-2014, Neuro4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neuro4j.studio.core.util;

import java.io.File;
import java.io.FileOutputStream;

public class FileLogger {

    FileOutputStream out = null;

    private static FileLogger instance = new FileLogger();

    private FileLogger()
    {
        try {
            File file = new File("");
            if (!file.exists())
            {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            // log("New Loading V: 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static FileLogger getInstance()
    // {
    // return instance;
    // }

    // public void log(String message)
    // {
    // try {
    // out.write(message.getBytes());
    // out.write("\n".getBytes());
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

}
