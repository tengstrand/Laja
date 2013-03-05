package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class OwnerBehaviour implements OwnerStateComparable {
    protected final OwnerState state;

    public OwnerBehaviour(OwnerState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public OwnerState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OwnerStateComparable)) return false;
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
