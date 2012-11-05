package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileStateList;

import java.util.List;

public class ClosedFileList extends ClosedFileArrayList {
    public ClosedFileList(ClosedFile... list) {
        super(list);
    }

    public ClosedFileList(List<ClosedFile> list) {
        super(list);
    }

    public ClosedFileList(FileStateList stateList, Directory directory) {
        super(stateList, directory);
    }
}
