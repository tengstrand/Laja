package net.sf.laja.cdd.behaviour.eye;

import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;

public class EyeFactory extends EyeValueFactory {
    public EyeFactory(EyeState state) {
        super(state);
    }

    public EyeFactory(EyeState state, EyeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
