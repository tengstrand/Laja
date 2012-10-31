package net.sf.laja.example.file.state;

public interface FileElement {
    FileState getState(FileStateList stateList);
    boolean contains(FileStateList stateList);
    void addToList(FileStateList stateList);
}
