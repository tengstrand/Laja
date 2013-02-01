package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class OwnerBehaviour {
    protected final OwnerState state;
    protected OwnerStateBuilder stateBuilder;

    public OwnerBehaviour(OwnerState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public OwnerBehaviour(OwnerState state, OwnerStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public OwnerState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.equals(((OwnerBehaviour)o).state);
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