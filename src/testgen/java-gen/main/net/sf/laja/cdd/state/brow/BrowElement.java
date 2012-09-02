package net.sf.laja.cdd.state.brow;

public interface BrowElement {
    public void addToList(BrowStateList stateList);
    public void addToList(BrowStateListBuilder listBuilder);
    public void addToList(BrowStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, BrowStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, BrowStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(BrowStateListBuilder listBuilder, Object mutator);
}
