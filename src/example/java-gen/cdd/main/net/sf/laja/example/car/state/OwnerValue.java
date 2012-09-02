package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class OwnerValue implements OwnerElement {
    protected final OwnerState state;
    protected OwnerStateBuilder stateBuilder;

    public OwnerValue(OwnerState state) {
        this.state = state;
    }

    public OwnerValue(OwnerState state, OwnerStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public OwnerState getState(Certificate certificate) {
        return state;
    }

    public void addToList(OwnerStateList stateList) {
        stateList.add(state);
    }

    public void addToList(OwnerStateListBuilder listBuilder) {
        listBuilder.add(state);
    }

    public void addToList(OwnerStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(state, mutator);
    }

    public void addToList(int index, OwnerStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(index, state, mutator);
    }

    public void setInList(int index, OwnerStateListBuilder listBuilder, Object accessor) {
        listBuilder.set(index, state, accessor);
    }

    public boolean removeFromList(OwnerStateListBuilder listBuilder, Object mutator) {
        return listBuilder.remove(state, mutator);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((OwnerValue)o).state);
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
