package net.sf.laja.cdd.state.eye;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class EyeValue implements EyeElement {
    protected final EyeState state;
    protected EyeStateBuilder stateBuilder;

    public EyeValue(EyeState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public EyeValue(EyeState state, EyeStateBuilder stateBuilder) {
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

    public EyeState getState(EyeStateList stateList) {
        if (stateList == null) {
            throw new IllegalArgumentException("EyeStateList can not be null!");
        }
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((EyeValue)o).state);
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
