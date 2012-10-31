package net.sf.laja.cdd.state.arm;

public interface ArmElement {
    ArmState getState(ArmStateList stateList);
    boolean contains(ArmStateList stateList);
    void addToList(ArmStateList stateList);
}
