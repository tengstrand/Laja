package net.sf.laja.cdd.state.foot;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class FootValue implements FootElement {
    protected final FootState state;
    protected FootStateBuilder stateBuilder;

    public FootValue(FootState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public FootValue(FootState state, FootStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public FootState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }

    public FootState getState(FootStateList stateList) {
        if (stateList == null) {
            throw new IllegalArgumentException("FootStateList can not be null!");
        }
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((FootValue)o).state);
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
