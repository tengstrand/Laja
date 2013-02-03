package net.sf.laja.cdd.state.eye;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class EyeBehaviour implements EyeStateComparable {
    protected final EyeState state;
    protected EyeStateBuilder stateBuilder;

    public EyeBehaviour(EyeState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public EyeBehaviour(EyeState state, EyeStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public EyeState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EyeStateComparable)) return false;
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
