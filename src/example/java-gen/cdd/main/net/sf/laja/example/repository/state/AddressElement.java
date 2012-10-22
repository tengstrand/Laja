package net.sf.laja.example.repository.state;

public interface AddressElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(AddressStateList stateList);
    void addToList(AddressStateList stateList);
}
