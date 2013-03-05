package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.eye.EyeBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.eye.EyeBuilder;

public class TerrestrialBuilder {
    public final TerrestrialStateBuilder builder;

    public TerrestrialBuilder() {
        builder = TerrestrialStateImpl.build();
    }

    public TerrestrialBuilder(TerrestrialState state) {
        builder = new TerrestrialStateBuilderImpl(state);
    }

    public TerrestrialBuilder(TerrestrialState state, Object encapsulator) {
        builder = new TerrestrialStateBuilderImpl(state, encapsulator);
    }

    public TerrestrialBuilder withNumberOfLegs(int numberOfLegs) {
        builder.withNumberOfLegs(numberOfLegs);
        return this;
    }

    public TerrestrialBuilder withNumberOfWings(int numberOfWings) {
        builder.withNumberOfWings(numberOfWings);
        return this;
    }

    public TerrestrialBuilder withLeftEye(EyeBuilder leftEye) {
        builder.withLeftEye(leftEye.builder);
        return this;
    }

    public TerrestrialBuilder withRightEye(EyeBuilder rightEye) {
        builder.withRightEye(rightEye.builder);
        return this;
    }

    public TerrestrialBuilder withMiddleEye(EyeBuilder middleEye) {
        builder.withMiddleEye(middleEye.builder);
        return this;
    }

    public TerrestrialBuilder withWeight(int weight) {
        builder.withWeight(weight);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Terrestrial asTerrestrial() {
        return (Terrestrial)builder.as(new TerrestrialFactory.TerrestrialFactory_());
    }
}
