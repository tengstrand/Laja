package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairState;

public class Hair extends HairFactory {
    public Hair(HairState state) {
        super(state);
    }

    // (factory) (list)
    public Hair asHair() {
        return new Hair(state);
    }

    // (factory) (list)
    public FakeHair asFakeHair() {
        return new FakeHair(state);
    }
}
