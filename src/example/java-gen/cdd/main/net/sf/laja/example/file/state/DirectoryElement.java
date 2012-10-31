package net.sf.laja.example.file.state;

public interface DirectoryElement {
    DirectoryState getState(DirectoryStateList stateList);
    boolean contains(DirectoryStateList stateList);
    void addToList(DirectoryStateList stateList);
}
