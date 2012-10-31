package net.sf.laja.cdd.state.animal;

public interface AnimalElement {
    AnimalState getState(AnimalStateList stateList);
    boolean contains(AnimalStateList stateList);
    void addToList(AnimalStateList stateList);
}
