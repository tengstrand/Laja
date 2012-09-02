package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ZipcodeValue {
    protected final ZipcodeState state;
    protected ZipcodeStateBuilder stateBuilder;

    public ZipcodeValue(ZipcodeState state) {
        this.state = state;
    }

    public ZipcodeValue(ZipcodeState state, ZipcodeStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public ZipcodeState getState(Certificate certificate) {
        return state;
    }

    public void addToList(ZipcodeStateList stateList) {
        stateList.add(state);
    }

    public void addToList(ZipcodeStateListBuilder listBuilder) {
        listBuilder.add(state);
    }

    public void addToList(ZipcodeStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(state, mutator);
    }

    public void addToList(int index, ZipcodeStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(index, state, mutator);
    }

    public void setInList(int index, ZipcodeStateListBuilder listBuilder, Object accessor) {
        listBuilder.set(index, state, accessor);
    }

    public boolean removeFromList(ZipcodeStateListBuilder listBuilder, Object mutator) {
        return listBuilder.remove(state, mutator);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((ZipcodeValue)o).state);
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
