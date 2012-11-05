package net.sf.laja.example.file.behaviour.text;

import java.util.List;

public class TextDirectoryList extends TextDirectoryArrayList {
    public TextDirectoryList(TextDirectory... list) {
        super(list);
    }

    public TextDirectoryList(List<TextDirectory> list) {
        super(list);
    }
}
