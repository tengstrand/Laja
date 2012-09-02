package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.eye.EyeBuilder;

public class OtherTerrestrialBuilder {
    public final TerrestrialStateBuilder builder;

    public OtherTerrestrialBuilder() {
        builder = TerrestrialStateImpl.build();
    }

    public OtherTerrestrialBuilder(TerrestrialState state) {
        builder = TerrestrialStateImpl.build(state);
    }

    public OtherTerrestrialBuilder withNumberOfLegs(int numberOfLegs) {
        builder.withNumberOfLegs(numberOfLegs);
        return this;
    }

    public OtherTerrestrialBuilder withLeftEye(EyeBuilder leftEye) {
        builder.withLeftEye(leftEye.builder);
        return this;
    }

    public OtherTerrestrialBuilder withMiddleEye(EyeBuilder middleEye) {
        builder.withMiddleEye(middleEye.builder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public OtherTerrestrial asOtherTerrestrial() {
        return (OtherTerrestrial)builder.as(new OtherTerrestrialFactory.OtherTerrestrialFactory_(builder));
    }
}
