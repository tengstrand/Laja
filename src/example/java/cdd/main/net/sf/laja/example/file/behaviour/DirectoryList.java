package net.sf.laja.example.file.behaviour;

import java.util.List;

public class DirectoryList extends DirectoryAbstractList {
    public DirectoryList(Directory... list) {
        super(list);
    }

    public DirectoryList(List<Directory> list) {
        super(list);
    }
}
