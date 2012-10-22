package net.sf.laja.example.car.state;

public interface TruckElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(TruckStateList stateList);
    void addToList(TruckStateList stateList);
}
