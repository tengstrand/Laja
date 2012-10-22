package net.sf.laja.example.person.state;

public interface PersonElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(PersonStateList stateList);
    void addToList(PersonStateList stateList);
}
