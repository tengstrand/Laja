package net.sf.laja.example.car.state;

public interface BusElement {
    public void addToList(BusStateList stateList);
    public void addToList(BusStateListBuilder listBuilder);
    public void addToList(BusStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, BusStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, BusStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(BusStateListBuilder listBuilder, Object mutator);
}
