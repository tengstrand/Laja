package net.sf.laja.cdd.state.terrestrial;

public interface TerrestrialElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(TerrestrialStateList stateList);
    void addToList(TerrestrialStateList stateList);
}
