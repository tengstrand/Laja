package net.sf.laja.cdd.state.arm;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ArmBehaviour implements ArmStateComparable {
    protected final ArmState state;
    protected ArmStateBuilder stateBuilder;

    public ArmBehaviour(ArmState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public ArmBehaviour(ArmState state, ArmStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public ArmState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArmStateComparable)) return false;
        return state.equals(obj);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + state;
    }
}
