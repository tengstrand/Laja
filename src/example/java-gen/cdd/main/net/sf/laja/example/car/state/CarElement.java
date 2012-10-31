package net.sf.laja.example.car.state;

public interface CarElement {
    CarState getState(CarStateList stateList);
    boolean contains(CarStateList stateList);
    void addToList(CarStateList stateList);
}
