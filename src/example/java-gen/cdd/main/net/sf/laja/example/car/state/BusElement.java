package net.sf.laja.example.car.state;

public interface BusElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(BusStateList stateList);
    void addToList(BusStateList stateList);
}
