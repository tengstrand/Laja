package net.sf.laja.example.car.state;

public interface BusElement {
    BusState getState(BusStateList stateList);
    boolean contains(BusStateList stateList);
    void addToList(BusStateList stateList);
}
