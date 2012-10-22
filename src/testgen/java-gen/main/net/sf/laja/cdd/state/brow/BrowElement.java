package net.sf.laja.cdd.state.brow;

public interface BrowElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(BrowStateList stateList);
    void addToList(BrowStateList stateList);
}
