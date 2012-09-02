package net.sf.laja.cdd.state.head;

public interface HeadElement {
    public void addToList(HeadStateList stateList);
    public void addToList(HeadStateListBuilder listBuilder);
    public void addToList(HeadStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, HeadStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, HeadStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(HeadStateListBuilder listBuilder, Object mutator);
}
