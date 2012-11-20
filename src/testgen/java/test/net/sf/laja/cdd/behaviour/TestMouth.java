package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.MouthState;

public class TestMouth extends TestMouthFactory {
    public TestMouth(MouthState state) {
        super(state);
    }

    // (factory)
    public TestMouth asTestMouth() {
        return new TestMouth(state);
    }

    public CuteMouth asCuteMouth() {
        return new CuteMouth(state);
    }
}
