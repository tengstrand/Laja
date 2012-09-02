package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.ear.EarStateBuilder;

public class EarFactory extends EarValueFactory {
    public EarFactory(EarState state) {
        super(state);
    }

    public EarFactory(EarState state, EarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
