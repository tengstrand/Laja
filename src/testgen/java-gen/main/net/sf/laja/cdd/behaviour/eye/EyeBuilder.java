package net.sf.laja.cdd.behaviour.eye;

import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;
import java.math.BigDecimal;

public class EyeBuilder {
    public final EyeStateBuilder builder;

    public EyeBuilder() {
        builder = EyeStateImpl.build();
    }

    public EyeBuilder(EyeState state) {
        builder = EyeStateImpl.build(state);
    }

    public EyeBuilder withEyeWeightInGrams(int eyeWeightInGrams) {
        builder.withEyeWeightInGrams(eyeWeightInGrams);
        return this;
    }

    public EyeBuilder withEyeWeightInGrams(String eyeWeightInGrams) {
        builder.withEyeWeightInGrams(eyeWeightInGrams);
        return this;
    }

    public EyeBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public EyeBuilder withColor(BigDecimal color) {
        builder.withColor(color);
        return this;
    }

    public EyeBuilder withColor(int color) {
        builder.withColor(color);
        return this;
    }

    public EyeBuilder withHasEar(Boolean hasEar) {
        builder.withHasEar(hasEar);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Eye asEye() {
        return (Eye)builder.as(new EyeFactory.EyeFactory_(builder));
    }
}
