package net.sf.laja.example.car.state;

public interface OwnerElement {
    OwnerState getState(OwnerStateList stateList);
    boolean contains(OwnerStateList stateList);
    void addToList(OwnerStateList stateList);
}
