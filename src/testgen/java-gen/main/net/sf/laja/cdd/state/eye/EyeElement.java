package net.sf.laja.cdd.state.eye;

public interface EyeElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(EyeStateList stateList);
    void addToList(EyeStateList stateList);
}
