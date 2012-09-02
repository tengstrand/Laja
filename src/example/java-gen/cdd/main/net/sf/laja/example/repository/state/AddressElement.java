package net.sf.laja.example.repository.state;

public interface AddressElement {
    public void addToList(AddressStateList stateList);
    public void addToList(AddressStateListBuilder listBuilder);
    public void addToList(AddressStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, AddressStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, AddressStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(AddressStateListBuilder listBuilder, Object mutator);
}
