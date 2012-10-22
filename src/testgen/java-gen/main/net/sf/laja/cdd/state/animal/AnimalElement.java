package net.sf.laja.cdd.state.animal;

public interface AnimalElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(AnimalStateList stateList);
    void addToList(AnimalStateList stateList);
}
