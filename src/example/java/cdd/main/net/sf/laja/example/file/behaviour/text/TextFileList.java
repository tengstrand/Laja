package net.sf.laja.example.file.behaviour.text;

import net.sf.laja.example.file.state.FileStateListBuilder;

import java.util.List;

public class TextFileList extends TextFileAbstractList {
    public TextFileList(TextFile... list) {
        super(list);
    }

    public TextFileList(List<TextFile> list) {
        super(list);
    }

    public TextFileList(List<TextFile> list, FileStateListBuilder stateListBuilder) {
        super(list, stateListBuilder);
    }
}
