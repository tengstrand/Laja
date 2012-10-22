package net.sf.laja.cdd.state.ear;

public interface EarElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(EarStateList stateList);
    void addToList(EarStateList stateList);
}
