package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;

public class TerrestrialFactory extends TerrestrialValueFactory {
    public TerrestrialFactory(TerrestrialState state) {
        super(state);
    }

    public TerrestrialFactory(TerrestrialState state, TerrestrialStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
