package net.sf.laja.example.repository.state;

public interface AddressElement {
    AddressState getState(AddressStateList stateList);
    boolean contains(AddressStateList stateList);
    void addToList(AddressStateList stateList);
}
