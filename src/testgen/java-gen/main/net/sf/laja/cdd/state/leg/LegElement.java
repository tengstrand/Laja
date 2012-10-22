package net.sf.laja.cdd.state.leg;

public interface LegElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(LegStateList stateList);
    void addToList(LegStateList stateList);
}
