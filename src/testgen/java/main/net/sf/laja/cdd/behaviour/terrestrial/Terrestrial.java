package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;

public class Terrestrial extends TerrestrialFactory {
    public Terrestrial(TerrestrialState state) {
        super(state);

        state.setNumberOfWings(3, this);
        new TerrestrialBuilder(state, this).withRightEye(Eye.build().withEyeWeightInGrams(100).withColor("Red"));
    }

    // (factory)
    public Terrestrial asTerrestrial() {
        return new Terrestrial(state);
    }
}
