package cz.zcu.kiv;

import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockExecute;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockType;

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
 * ExceptionBlock, 2018/07/18 14:45 petr-jezek
 *
 **********************************************************************************************************************/
@BlockType(type = "Exception", family = "Exception")
public class ExceptionBlock {

    @BlockExecute
    public void execute() throws Exception {
        throw new Exception("Something Wrong");
    }
}
