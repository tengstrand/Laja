package net.sf.laja.cdd.state.arm;

public interface ArmElement {
    public void addToList(ArmStateList stateList);
    public void addToList(ArmStateListBuilder listBuilder);
    public void addToList(ArmStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, ArmStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, ArmStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(ArmStateListBuilder listBuilder, Object mutator);
}
