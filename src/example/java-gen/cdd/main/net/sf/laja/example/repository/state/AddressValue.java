package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AddressValue implements AddressElement {
    protected final AddressState state;
    protected AddressStateBuilder stateBuilder;

    public AddressValue(AddressState state) {
        this.state = state;
    }

    public AddressValue(AddressState state, AddressStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(AddressStateList stateList) {
        return stateList.contains(state);
    }

    public AddressState getState(Certificate certificate) {
        return state;
    }

    public AddressState getState(AddressStateList stateList) {
        return state;
    }

    public void addToList(AddressStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((AddressValue)o).state);
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
