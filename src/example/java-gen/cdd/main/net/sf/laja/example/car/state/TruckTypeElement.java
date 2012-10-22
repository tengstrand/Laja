package net.sf.laja.example.car.state;

public interface TruckTypeElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(TruckTypeStateList stateList);
    void addToList(TruckTypeStateList stateList);
}
