package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.NoseState;

public class Nose extends NoseFactory {
    public Nose(NoseState state, int extraParameter) {
        super(state);
    }

    // (factory)
    public Nose asNose(int extraParameter) {
        return new Nose(state, extraParameter);
    }
}
