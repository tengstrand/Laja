package net.sf.laja.example.file.behaviour.text;

import java.util.List;

public class TextFileList extends TextFileArrayList {
    public TextFileList(TextFile... list) {
        super(list);
    }

    public TextFileList(List<TextFile> list) {
        super(list);
    }
}
