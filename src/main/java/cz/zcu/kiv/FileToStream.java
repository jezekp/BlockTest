package cz.zcu.kiv;

import cz.zcu.kiv.WorkflowDesigner.Annotations.*;

import java.io.*;

/***********************************************************************************************************************
 *
 * This file is part of the BlockTest project

 * ==========================================
 *
 * Copyright (C) 2019 by University of West Bohemia (http://www.zcu.cz/en/)
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************
 *
 * FileToStream, 2019/06/19 11:12 petr-jezek
 *
 **********************************************************************************************************************/
@BlockType(type = "FileToStream", family = "STREAM")
public class FileToStream {


    @BlockOutput(name = "Output", type = "STREAM")
    private InputStream in;

    @BlockProperty(name = "file", type = "String")
    private String fileName;

    @BlockExecute
    public void process() throws Exception {

        File inputFile = new File(fileName);
        in = new FileInputStream(inputFile);

    }
}
