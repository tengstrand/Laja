package net.sf.laja.example.computer.state;

public interface ComputerElement {
    ComputerState getState(ComputerStateList stateList);
    boolean contains(ComputerStateList stateList);
    void addToList(ComputerStateList stateList);
}
