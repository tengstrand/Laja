package net.sf.laja.example.file.state;

public interface FileElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(FileStateList stateList);
    void addToList(FileStateList stateList);
}
