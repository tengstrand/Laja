package net.sf.laja.cdd.state.nose;

public interface NoseElement {
    NoseState getState(NoseStateList stateList);
    boolean contains(NoseStateList stateList);
    void addToList(NoseStateList stateList);
}
