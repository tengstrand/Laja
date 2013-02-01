package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckBehaviour {
    protected final TruckState state;
    protected TruckStateBuilder stateBuilder;

    public TruckBehaviour(TruckState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public TruckBehaviour(TruckState state, TruckStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public TruckState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.equals(((TruckBehaviour)o).state);
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