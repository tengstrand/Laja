package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;

public class OtherTerrestrialFactory extends OtherTerrestrialValueFactory {
    public OtherTerrestrialFactory(TerrestrialState state) {
        super(state);
    }

    public OtherTerrestrialFactory(TerrestrialState state, TerrestrialStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
