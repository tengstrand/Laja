package net.sf.laja.cdd.state.eye;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class EyeValue implements EyeElement {
    protected final EyeState state;
    protected EyeStateBuilder stateBuilder;

    public EyeValue(EyeState state) {
        this.state = state;
    }

    public EyeValue(EyeState state, EyeStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public EyeState getState(Certificate certificate) {
        return state;
    }

    public void addToList(EyeStateList stateList) {
        stateList.add(state);
    }

    public void addToList(EyeStateListBuilder listBuilder) {
        listBuilder.add(state);
    }

    public void addToList(EyeStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(state, mutator);
    }

    public void addToList(int index, EyeStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(index, state, mutator);
    }

    public void setInList(int index, EyeStateListBuilder listBuilder, Object accessor) {
        listBuilder.set(index, state, accessor);
    }

    public boolean removeFromList(EyeStateListBuilder listBuilder, Object mutator) {
        return listBuilder.remove(state, mutator);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((EyeValue)o).state);
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
