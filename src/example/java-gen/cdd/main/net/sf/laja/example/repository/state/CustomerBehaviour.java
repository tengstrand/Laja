package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerBehaviour implements CustomerStateComparable {
    protected final CustomerState state;
    protected CustomerStateBuilder stateBuilder;

    public CustomerBehaviour(CustomerState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public CustomerBehaviour(CustomerState state, CustomerStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public CustomerState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomerStateComparable)) return false;
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
