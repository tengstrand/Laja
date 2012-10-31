package net.sf.laja.cdd.state.mouth;

public interface MouthElement {
    MouthState getState(MouthStateList stateList);
    boolean contains(MouthStateList stateList);
    void addToList(MouthStateList stateList);
}
