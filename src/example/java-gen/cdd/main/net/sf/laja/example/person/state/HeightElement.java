package net.sf.laja.example.person.state;

public interface HeightElement {
    HeightState getState(HeightStateList stateList);
    boolean contains(HeightStateList stateList);
    void addToList(HeightStateList stateList);
}
