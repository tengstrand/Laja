package net.sf.laja.cdd.state.fleck;

public interface FleckElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(FleckStateList stateList);
    void addToList(FleckStateList stateList);
}
