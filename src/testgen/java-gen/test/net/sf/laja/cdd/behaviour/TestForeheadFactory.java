package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;

public class TestForeheadFactory extends TestForeheadValueFactory {
    public TestForeheadFactory(ForeheadState state) {
        super(state);
    }

    public TestForeheadFactory(ForeheadState state, ForeheadStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
