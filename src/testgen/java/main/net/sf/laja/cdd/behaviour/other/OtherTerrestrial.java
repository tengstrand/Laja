package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.TerrestrialState;

public class OtherTerrestrial extends OtherTerrestrialFactory {
    public OtherTerrestrial(TerrestrialState state) {
        super(state);
    }

    // (factory)
    public OtherTerrestrial asOtherTerrestrial() {
        return new OtherTerrestrial(state);
    }
}
