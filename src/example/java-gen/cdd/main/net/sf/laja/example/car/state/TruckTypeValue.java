package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckTypeValue {
    protected final TruckTypeState state;
    protected TruckTypeStateBuilder stateBuilder;

    public TruckTypeValue(TruckTypeState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public TruckTypeValue(TruckTypeState state, TruckTypeStateBuilder stateBuilder) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((TruckTypeValue)o).state);
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
