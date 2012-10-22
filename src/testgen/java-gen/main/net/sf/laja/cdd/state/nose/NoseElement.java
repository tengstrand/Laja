package net.sf.laja.cdd.state.nose;

public interface NoseElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(NoseStateList stateList);
    void addToList(NoseStateList stateList);
}
