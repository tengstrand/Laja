package net.sf.laja.example.car.state;

public interface VehicleSizeElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(VehicleSizeStateList stateList);
    void addToList(VehicleSizeStateList stateList);
}
