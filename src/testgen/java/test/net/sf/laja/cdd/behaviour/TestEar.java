package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.ear.EarState;

public class TestEar extends TestEarFactory {
    public TestEar(EarState state) {
        super(state);
    }

    // (factory)
    public TestEar asTestEar() {
        return new TestEar(state);
    }
}
