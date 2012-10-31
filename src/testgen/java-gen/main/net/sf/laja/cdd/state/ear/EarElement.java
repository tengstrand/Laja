package net.sf.laja.cdd.state.ear;

public interface EarElement {
    EarState getState(EarStateList stateList);
    boolean contains(EarStateList stateList);
    void addToList(EarStateList stateList);
}
