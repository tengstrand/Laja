package net.sf.laja.example.car.state;

public interface TruckElement {
    TruckState getState(TruckStateList stateList);
    boolean contains(TruckStateList stateList);
    void addToList(TruckStateList stateList);
}
