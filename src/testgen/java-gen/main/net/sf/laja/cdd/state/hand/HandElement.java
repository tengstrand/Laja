package net.sf.laja.cdd.state.hand;

public interface HandElement {
    HandState getState(HandStateList stateList);
    boolean contains(HandStateList stateList);
    void addToList(HandStateList stateList);
}
