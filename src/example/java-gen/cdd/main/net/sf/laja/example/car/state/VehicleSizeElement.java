package net.sf.laja.example.car.state;

public interface VehicleSizeElement {
    public void addToList(VehicleSizeStateList stateList);
    public void addToList(VehicleSizeStateListBuilder listBuilder);
    public void addToList(VehicleSizeStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, VehicleSizeStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, VehicleSizeStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(VehicleSizeStateListBuilder listBuilder, Object mutator);
}
