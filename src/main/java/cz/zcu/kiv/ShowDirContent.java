package cz.zcu.kiv;

import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockExecute;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockOutput;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockProperty;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockType;
import cz.zcu.kiv.WorkflowDesigner.Type;

import java.io.File;

/***********************************************************************************************************************
 *
 * This file is part of the BlockTest project

 * ==========================================
 *
 * Copyright (C) 2018 by University of West Bohemia (http://www.zcu.cz/en/)
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
 * ShowDirContent, 2018/08/17 15:27 petr-jezek
 *
 **********************************************************************************************************************/
@BlockType(type = "ShowDirContent", family = "ShowDirContent")
public class ShowDirContent {




    @BlockProperty(name="path",type = Type.STRING)
    private String path;

    @BlockExecute
    public String execute() {
        String result = "";
        File f = new File(path);
        File[] files = f.listFiles();

        for (File file : files
             ) {
            result += file.getAbsolutePath() + "\n";
        }
        return result;
    }

}
