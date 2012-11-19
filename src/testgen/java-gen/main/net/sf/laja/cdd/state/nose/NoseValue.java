package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class NoseValue implements NoseElement {
    protected final NoseState state;
    protected NoseStateBuilder stateBuilder;

    public NoseValue(NoseState state) {
        this.state = state;
    }

    public NoseValue(NoseState state, NoseStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public NoseState getState(Certificate certificate) {
        return state;
    }

    public NoseState getState(NoseStateList stateList) {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((NoseValue)o).state);
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
