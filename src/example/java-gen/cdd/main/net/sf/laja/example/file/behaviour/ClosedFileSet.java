package net.sf.laja.example.file.behaviour;

import java.util.Set;

import net.sf.laja.example.file.behaviour.text.TextFile;
import net.sf.laja.example.file.behaviour.text.TextFileSet;
import net.sf.laja.example.file.behaviour.text.TextFileHashSet;

public interface ClosedFileSet extends Set<ClosedFile> {
    WritableFileSet asWritableFileSet(Directory directory, boolean createIfNotExists);
    TextFileSet asTextFileSet();
}
