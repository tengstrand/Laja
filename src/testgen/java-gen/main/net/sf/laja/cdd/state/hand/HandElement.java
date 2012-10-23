package net.sf.laja.cdd.state.hand;

public interface HandElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(HandStateList stateList);
    void addToList(HandStateList stateList);
}
