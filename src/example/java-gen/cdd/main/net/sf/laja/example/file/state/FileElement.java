package net.sf.laja.example.file.state;

public interface FileElement {
    public void addToList(FileStateList stateList);
    public void addToList(FileStateListBuilder listBuilder);
    public void addToList(FileStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, FileStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, FileStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(FileStateListBuilder listBuilder, Object mutator);
}
