package net.sf.laja.cdd.state.fleck;

public interface FleckElement {
    FleckState getState(FleckStateList stateList);
    boolean contains(FleckStateList stateList);
    void addToList(FleckStateList stateList);
}
