package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BmiValue implements BmiElement {
    protected final BmiState state;
    protected BmiStateBuilder stateBuilder;

    public BmiValue(BmiState state) {
        this.state = state;
    }

    public BmiValue(BmiState state, BmiStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(BmiStateList stateList) {
        return stateList.contains(state);
    }

    public BmiState getState(Certificate certificate) {
        return state;
    }

    public BmiState getState(BmiStateList stateList) {
        return state;
    }

    public void addToList(BmiStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((BmiValue)o).state);
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
