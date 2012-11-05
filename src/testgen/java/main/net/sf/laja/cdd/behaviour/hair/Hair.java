package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairState;

public class Hair extends HairFactory {
    public Hair(HairState state) {
        super(state);
    }

    // (factory)
    public Hair asHair() {
        return new Hair(state);
    }

    // (factory)
    public FakeHair asFakeHair() {
        return new FakeHair(state);
    }
}
