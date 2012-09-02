package net.sf.laja.example.file.state;

public interface DirectoryElement {
    public void addToList(DirectoryStateList stateList);
    public void addToList(DirectoryStateListBuilder listBuilder);
    public void addToList(DirectoryStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, DirectoryStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, DirectoryStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(DirectoryStateListBuilder listBuilder, Object mutator);
}
