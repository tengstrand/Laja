package net.sf.laja.cdd.state.mouth;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MouthEntity implements MouthElement {
    protected final MouthState state;
    protected MouthStateBuilder stateBuilder;

    public MouthEntity(MouthState state) {
        this.state = state;
    }

    public MouthEntity(MouthState state, MouthStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(MouthStateList stateList) {
        return stateList.contains(state);
    }

    public MouthState getState(Certificate certificate) {
        return state;
    }

    public MouthState getState(MouthStateList stateList) {
        return state;
    }

    public void addToList(MouthStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.equals(((MouthEntity)o).state);
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
