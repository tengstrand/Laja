package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckTypeBehaviour implements TruckTypeStateComparable {
    protected final TruckTypeState state;
    protected TruckTypeStateBuilder stateBuilder;

    public TruckTypeBehaviour(TruckTypeState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public TruckTypeBehaviour(TruckTypeState state, TruckTypeStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public TruckTypeState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TruckTypeStateComparable)) return false;
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
