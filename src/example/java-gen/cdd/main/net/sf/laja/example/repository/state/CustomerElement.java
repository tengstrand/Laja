package net.sf.laja.example.repository.state;

public interface CustomerElement {
    CustomerState getState(CustomerStateList stateList);
    boolean contains(CustomerStateList stateList);
    void addToList(CustomerStateList stateList);
}
