package net.sf.laja.cdd.state.forehead;

public interface ForeheadElement {
    ForeheadState getState(ForeheadStateList stateList);
    boolean contains(ForeheadStateList stateList);
    void addToList(ForeheadStateList stateList);
}
