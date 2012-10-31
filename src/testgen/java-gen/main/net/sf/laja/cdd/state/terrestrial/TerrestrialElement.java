package net.sf.laja.cdd.state.terrestrial;

public interface TerrestrialElement {
    TerrestrialState getState(TerrestrialStateList stateList);
    boolean contains(TerrestrialStateList stateList);
    void addToList(TerrestrialStateList stateList);
}
