package cz.zcu.kiv;

import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockExecute;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockOutput;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockProperty;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockType;
import cz.zcu.kiv.WorkflowDesigner.Type;

import java.io.File;

/**
 * Created by petr on 17.7.18.
 */
@BlockType(type = "Delete", family = "Delete")
public class DeleteBlock {

    @BlockOutput(name = "status", type = "boolean")
    private boolean status;

    @BlockProperty(name="path",type = Type.STRING)
    private String path;

    @BlockExecute
    public String execute() {
        File f = new File(path);
        status = deleteDirectory(f);
        System.out.println(status);
        return String.valueOf(status);

    }

    boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
