package net.sf.laja.example.car.state;

public interface TruckElement {
    public void addToList(TruckStateList stateList);
    public void addToList(TruckStateListBuilder listBuilder);
    public void addToList(TruckStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, TruckStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, TruckStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(TruckStateListBuilder listBuilder, Object mutator);
}
