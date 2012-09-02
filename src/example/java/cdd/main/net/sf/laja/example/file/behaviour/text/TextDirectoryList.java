package net.sf.laja.example.file.behaviour.text;

import net.sf.laja.example.file.state.DirectoryStateListBuilder;

import java.util.List;

public class TextDirectoryList extends TextDirectoryAbstractList {
    public TextDirectoryList(TextDirectory... list) {
        super(list);
    }

    public TextDirectoryList(List<TextDirectory> list) {
        super(list);
    }

    public TextDirectoryList(List<TextDirectory> list, DirectoryStateListBuilder stateListBuilder) {
        super(list, stateListBuilder);
    }
}
