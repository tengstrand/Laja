package net.sf.laja.example.car.state;

public interface OwnerElement {
    public void addToList(OwnerStateList stateList);
    public void addToList(OwnerStateListBuilder listBuilder);
    public void addToList(OwnerStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, OwnerStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, OwnerStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(OwnerStateListBuilder listBuilder, Object mutator);
}
