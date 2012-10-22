package net.sf.laja.example.person.state;

public interface HeightElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(HeightStateList stateList);
    void addToList(HeightStateList stateList);
}
