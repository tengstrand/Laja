package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.EarState;

public class Ear extends EarFactory {
    public Ear(EarState state) {
        super(state);
        state.setSize(10, this); // Hidden field
    }

    // (factory)
    public Ear asEar() {
        return new Ear(state);
    }

    public int getWeight() {
        return state.getWeight();
    }

    @Override
    public String toString() {
        return "Ear{state = " + state.toString() + ", hashCode=" + hashCode() + "}";
    }
}
