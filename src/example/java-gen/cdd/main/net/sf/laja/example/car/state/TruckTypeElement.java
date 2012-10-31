package net.sf.laja.example.car.state;

public interface TruckTypeElement {
    TruckTypeState getState(TruckTypeStateList stateList);
    boolean contains(TruckTypeStateList stateList);
    void addToList(TruckTypeStateList stateList);
}
