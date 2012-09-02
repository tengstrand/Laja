package net.sf.laja.example.car.state;

public interface CarElement {
    public void addToList(CarStateList stateList);
    public void addToList(CarStateListBuilder listBuilder);
    public void addToList(CarStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, CarStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, CarStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(CarStateListBuilder listBuilder, Object mutator);
}
