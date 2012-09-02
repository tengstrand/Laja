package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class TestMouthFactory extends TestMouthEntityFactory {
    public TestMouthFactory(MouthState state) {
        super(state);
    }

    public TestMouthFactory(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
