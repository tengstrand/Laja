package net.sf.laja.cdd.state.leg;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class LegBehaviour implements LegStateComparable {
    protected final LegState state;
    protected LegStateBuilder stateBuilder;

    public LegBehaviour(LegState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public LegBehaviour(LegState state, LegStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public LegState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LegStateComparable)) return false;
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
