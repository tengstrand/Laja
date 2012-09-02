package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.LegState;
import net.sf.laja.cdd.state.leg.LegStateBuilder;

public class LegFactory extends LegValueFactory {
    public LegFactory(LegState state) {
        super(state);
    }

    public LegFactory(LegState state, LegStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
