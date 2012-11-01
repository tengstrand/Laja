package net.sf.laja.cdd.state.toe;

public interface ToeElement {
    ToeState getState(ToeStateList stateList);
    boolean contains(ToeStateList stateList);
    void addToList(ToeStateList stateList);
}
