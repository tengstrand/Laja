package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndexBuilder {
    public final BmiStateBuilder builder;

    public BodyMassIndexBuilder() {
        builder = BmiStateImpl.build();
    }

    public BodyMassIndexBuilder(BmiState state) {
        builder = new BmiStateBuilderImpl(state);
    }

    public BodyMassIndexBuilder(BmiState state, Object encapsulator) {
        builder = new BmiStateBuilderImpl(state, encapsulator);
    }

    public BodyMassIndexBuilder withHeightInCentimeters(int heightInCentimeters) {
        builder.withHeightInCentimeters(heightInCentimeters);
        return this;
    }

    public BodyMassIndexBuilder withWeightInKilograms(int weightInKilograms) {
        builder.withWeightInKilograms(weightInKilograms);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public BodyMassIndex asBodyMassIndex() {
        return (BodyMassIndex)builder.as(new BodyMassIndexFactory.BodyMassIndexFactory_());
    }
}
