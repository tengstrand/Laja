package net.sf.laja.example.computer.state;

public interface ComputerElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(ComputerStateList stateList);
    void addToList(ComputerStateList stateList);
}
