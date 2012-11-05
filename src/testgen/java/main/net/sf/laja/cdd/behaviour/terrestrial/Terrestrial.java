package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;

public class Terrestrial extends TerrestrialFactory {
    public Terrestrial(TerrestrialState state, TerrestrialStateBuilder stateBuilder) {
        super(state, stateBuilder);

        stateBuilder.withNumberOfWings(3);
        stateBuilder.withRightEye(Eye.eyeWeightInGrams(100).color("Red").builder);
    }

    // (factory)
    public Terrestrial asTerrestrial() {
        return new Terrestrial(state, stateBuilder);
    }
}
