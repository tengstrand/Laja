package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class CustomerEntity implements CustomerElement {
    protected final CustomerState state;
    protected CustomerStateBuilder stateBuilder;

    public CustomerEntity(CustomerState state) {
        this.state = state;
    }

    public CustomerEntity(CustomerState state, CustomerStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(CustomerStateList stateList) {
        return stateList.contains(state);
    }

    public CustomerState getState(Certificate certificate) {
        return state;
    }

    public CustomerState getState(CustomerStateList stateList) {
        return state;
    }

    public void addToList(CustomerStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.equals(((CustomerEntity)o).state);
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
