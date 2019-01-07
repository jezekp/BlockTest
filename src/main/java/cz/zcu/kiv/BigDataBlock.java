package cz.zcu.kiv;

import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockExecute;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockProperty;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockType;
import cz.zcu.kiv.WorkflowDesigner.Type;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
 * BigDataBlock, 2018/10/26 09:09 petr-jezek
 *
 **********************************************************************************************************************/
@BlockType(type = "BigData", family = "BigData")
public class BigDataBlock {

    @BlockProperty(name = "count", type = Type.STRING)
    private String count;

    @BlockExecute
    public void execute() {

        List<byte[] > bigData = new LinkedList<byte[]>();
        int countInt = Integer.parseInt(count);
        for (int j = 0; j < countInt; j++) {
            byte[] hundredMb = new byte[100000000];
            new Random().nextBytes(hundredMb);
            bigData.add(hundredMb);
        }
    }
}
