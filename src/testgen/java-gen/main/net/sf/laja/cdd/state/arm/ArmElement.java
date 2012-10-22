package net.sf.laja.cdd.state.arm;

public interface ArmElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(ArmStateList stateList);
    void addToList(ArmStateList stateList);
}
