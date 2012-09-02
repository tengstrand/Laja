package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;

public class ForeheadFactory extends ForeheadValueFactory {
    public ForeheadFactory(ForeheadState state) {
        super(state);
    }

    public ForeheadFactory(ForeheadState state, ForeheadStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
