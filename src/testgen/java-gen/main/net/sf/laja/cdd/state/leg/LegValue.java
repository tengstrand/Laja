package net.sf.laja.cdd.state.leg;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class LegValue implements LegElement {
    protected final LegState state;
    protected LegStateBuilder stateBuilder;

    public LegValue(LegState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public LegValue(LegState state, LegStateBuilder stateBuilder) {
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

    public LegState getState(LegStateList stateList) {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((LegValue)o).state);
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
