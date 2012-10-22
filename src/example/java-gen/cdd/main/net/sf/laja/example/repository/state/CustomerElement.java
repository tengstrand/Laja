package net.sf.laja.example.repository.state;

public interface CustomerElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(CustomerStateList stateList);
    void addToList(CustomerStateList stateList);
}
