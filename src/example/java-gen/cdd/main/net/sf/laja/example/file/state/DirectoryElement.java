package net.sf.laja.example.file.state;

public interface DirectoryElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(DirectoryStateList stateList);
    void addToList(DirectoryStateList stateList);
}
