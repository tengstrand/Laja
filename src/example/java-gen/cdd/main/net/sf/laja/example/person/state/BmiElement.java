package net.sf.laja.example.person.state;

public interface BmiElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(BmiStateList stateList);
    void addToList(BmiStateList stateList);
}
