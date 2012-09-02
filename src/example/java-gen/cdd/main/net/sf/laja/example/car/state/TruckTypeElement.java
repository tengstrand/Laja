package net.sf.laja.example.car.state;

public interface TruckTypeElement {
    public void addToList(TruckTypeStateList stateList);
    public void addToList(TruckTypeStateListBuilder listBuilder);
    public void addToList(TruckTypeStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, TruckTypeStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, TruckTypeStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(TruckTypeStateListBuilder listBuilder, Object mutator);
}
