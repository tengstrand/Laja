package net.sf.laja.cdd.state.forehead;

public interface ForeheadElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(ForeheadStateList stateList);
    void addToList(ForeheadStateList stateList);
}
