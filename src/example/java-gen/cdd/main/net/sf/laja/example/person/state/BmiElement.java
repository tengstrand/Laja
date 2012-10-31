package net.sf.laja.example.person.state;

public interface BmiElement {
    BmiState getState(BmiStateList stateList);
    boolean contains(BmiStateList stateList);
    void addToList(BmiStateList stateList);
}
