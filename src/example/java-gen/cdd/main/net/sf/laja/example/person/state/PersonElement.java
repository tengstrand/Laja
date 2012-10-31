package net.sf.laja.example.person.state;

public interface PersonElement {
    PersonState getState(PersonStateList stateList);
    boolean contains(PersonStateList stateList);
    void addToList(PersonStateList stateList);
}
