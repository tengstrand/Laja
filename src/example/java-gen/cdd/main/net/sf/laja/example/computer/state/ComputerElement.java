package net.sf.laja.example.computer.state;

public interface ComputerElement {
    public void addToList(ComputerStateList stateList);
    public void addToList(ComputerStateListBuilder listBuilder);
    public void addToList(ComputerStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, ComputerStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, ComputerStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(ComputerStateListBuilder listBuilder, Object mutator);
}
