package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckBehaviour implements TruckStateComparable {
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
    public boolean equals(Object obj) {
        if (!(obj instanceof TruckStateComparable)) return false;
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
