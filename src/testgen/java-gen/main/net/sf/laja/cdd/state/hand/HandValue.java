package net.sf.laja.cdd.state.hand;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HandValue implements HandElement {
    protected final HandState state;
    protected HandStateBuilder stateBuilder;

    public HandValue(HandState state) {
        this.state = state;
    }

    public HandValue(HandState state, HandStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public HandState getState(Certificate certificate) {
        return state;
    }

    public HandState getState(HandStateList stateList) {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((HandValue)o).state);
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
