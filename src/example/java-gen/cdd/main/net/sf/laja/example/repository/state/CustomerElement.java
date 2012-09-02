package net.sf.laja.example.repository.state;

public interface CustomerElement {
    public void addToList(CustomerStateList stateList);
    public void addToList(CustomerStateListBuilder listBuilder);
    public void addToList(CustomerStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, CustomerStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, CustomerStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(CustomerStateListBuilder listBuilder, Object mutator);
}
