package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.EarState;

public class TheEar extends TheEarFactory {
    public TheEar(EarState state) {
        super(state);
        state.setSize(10, this); // Hidden field
    }

    // (factory)
    public TheEar asTheEar() {
        return new TheEar(state);
    }

    public int getWeight() {
        return state.getWeight();
    }

    @Override
    public String toString() {
        return "Ear{state = " + state.toString() + ", hashCode=" + hashCode() + "}";
    }
}
