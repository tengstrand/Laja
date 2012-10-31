package net.sf.laja.cdd.state.brow;

public interface BrowElement {
    BrowState getState(BrowStateList stateList);
    boolean contains(BrowStateList stateList);
    void addToList(BrowStateList stateList);
}
