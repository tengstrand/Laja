package net.sf.laja.cdd.state.leg;

public interface LegElement {
    LegState getState(LegStateList stateList);
    boolean contains(LegStateList stateList);
    void addToList(LegStateList stateList);
}
