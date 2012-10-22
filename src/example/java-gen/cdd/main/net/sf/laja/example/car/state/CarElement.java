package net.sf.laja.example.car.state;

public interface CarElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(CarStateList stateList);
    void addToList(CarStateList stateList);
}
