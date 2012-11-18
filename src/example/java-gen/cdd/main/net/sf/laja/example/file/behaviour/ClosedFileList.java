package net.sf.laja.example.file.behaviour;

import java.util.List;

import net.sf.laja.example.file.behaviour.text.TextFile;
import net.sf.laja.example.file.behaviour.text.TextFileList;
import net.sf.laja.example.file.behaviour.text.TextFileArrayList;

public interface ClosedFileList extends List<ClosedFile> {
    WritableFileList asWritableFileList(Directory directory, boolean createIfNotExists);
    TextFileList asTextFileList();
}
