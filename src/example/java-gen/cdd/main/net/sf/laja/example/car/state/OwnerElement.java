package net.sf.laja.example.car.state;

public interface OwnerElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(OwnerStateList stateList);
    void addToList(OwnerStateList stateList);
}
