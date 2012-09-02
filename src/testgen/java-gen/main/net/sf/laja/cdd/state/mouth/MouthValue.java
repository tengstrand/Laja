package net.sf.laja.cdd.state.mouth;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MouthValue implements MouthElement {
    protected final MouthState state;
    protected MouthStateBuilder stateBuilder;

    public MouthValue(MouthState state) {
        this.state = state;
    }

    public MouthValue(MouthState state, MouthStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public MouthState getState(Certificate certificate) {
        return state;
    }

    public void addToList(MouthStateList stateList) {
        stateList.add(state);
    }

    public void addToList(MouthStateListBuilder listBuilder) {
        listBuilder.add(state);
    }

    public void addToList(MouthStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(state, mutator);
    }

    public void addToList(int index, MouthStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(index, state, mutator);
    }

    public void setInList(int index, MouthStateListBuilder listBuilder, Object accessor) {
        listBuilder.set(index, state, accessor);
    }

    public boolean removeFromList(MouthStateListBuilder listBuilder, Object mutator) {
        return listBuilder.remove(state, mutator);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((MouthValue)o).state);
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
