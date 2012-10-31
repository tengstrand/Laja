package net.sf.laja.cdd.state.eye;

public interface EyeElement {
    EyeState getState(EyeStateList stateList);
    boolean contains(EyeStateList stateList);
    void addToList(EyeStateList stateList);
}
