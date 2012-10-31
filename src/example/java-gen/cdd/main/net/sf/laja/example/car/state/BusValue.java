package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BusValue implements BusElement {
    protected final BusState state;
    protected BusStateBuilder stateBuilder;

    public BusValue(BusState state) {
        this.state = state;
    }

    public BusValue(BusState state, BusStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(BusStateList stateList) {
        return stateList.contains(state);
    }

    public BusState getState(Certificate certificate) {
        return state;
    }

    public BusState getState(BusStateList stateList) {
        return state;
    }

    public void addToList(BusStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((BusValue)o).state);
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
