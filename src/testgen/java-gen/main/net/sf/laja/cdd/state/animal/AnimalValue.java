package net.sf.laja.cdd.state.animal;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AnimalValue implements AnimalElement {
    protected final AnimalState state;
    protected AnimalStateBuilder stateBuilder;

    public AnimalValue(AnimalState state) {
        this.state = state;
    }

    public AnimalValue(AnimalState state, AnimalStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public AnimalState getState(Certificate certificate) {
        return state;
    }

    public void addToList(AnimalStateList stateList) {
        stateList.add(state);
    }

    public void addToList(AnimalStateListBuilder listBuilder) {
        listBuilder.add(state);
    }

    public void addToList(AnimalStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(state, mutator);
    }

    public void addToList(int index, AnimalStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(index, state, mutator);
    }

    public void setInList(int index, AnimalStateListBuilder listBuilder, Object accessor) {
        listBuilder.set(index, state, accessor);
    }

    public boolean removeFromList(AnimalStateListBuilder listBuilder, Object mutator) {
        return listBuilder.remove(state, mutator);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((AnimalValue)o).state);
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
