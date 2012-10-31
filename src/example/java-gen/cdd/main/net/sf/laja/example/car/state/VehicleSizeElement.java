package net.sf.laja.example.car.state;

public interface VehicleSizeElement {
    VehicleSizeState getState(VehicleSizeStateList stateList);
    boolean contains(VehicleSizeStateList stateList);
    void addToList(VehicleSizeStateList stateList);
}
