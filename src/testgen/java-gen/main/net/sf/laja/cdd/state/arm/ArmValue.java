package net.sf.laja.cdd.state.arm;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ArmValue implements ArmElement {
    protected final ArmState state;
    protected ArmStateBuilder stateBuilder;

    public ArmValue(ArmState state) {
        this.state = state;
    }

    public ArmValue(ArmState state, ArmStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(ArmStateList stateList) {
        return stateList.contains(state);
    }

    public ArmState getState(Certificate certificate) {
        return state;
    }

    public ArmState getState(ArmStateList stateList) {
        return state;
    }

    public void addToList(ArmStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((ArmValue)o).state);
    }

    @Override
    public int hashCode() {
        return state.valueHashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + state;
    }
}
