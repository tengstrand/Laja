package net.sf.laja.cdd.state.mouth;

public interface MouthElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(MouthStateList stateList);
    void addToList(MouthStateList stateList);
}
