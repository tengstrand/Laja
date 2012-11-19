package net.sf.laja.cdd.state.toe;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ToeEntity implements ToeElement {
    protected final ToeState state;
    protected ToeStateBuilder stateBuilder;

    public ToeEntity(ToeState state) {
        this.state = state;
    }

    public ToeEntity(ToeState state, ToeStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public ToeState getState(Certificate certificate) {
        return state;
    }

    public ToeState getState(ToeStateList stateList) {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.equals(((ToeEntity)o).state);
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
