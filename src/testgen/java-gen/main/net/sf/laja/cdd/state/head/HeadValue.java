package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HeadValue implements HeadElement {
    protected final HeadState state;
    protected HeadStateBuilder stateBuilder;

    public HeadValue(HeadState state) {
        this.state = state;
    }

    public HeadValue(HeadState state, HeadStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(HeadStateList stateList) {
        return stateList.contains(state);
    }

    public HeadState getState(Certificate certificate) {
        return state;
    }

    public HeadState getState(HeadStateList stateList) {
        return state;
    }

    public void addToList(HeadStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((HeadValue)o).state);
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
