package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;
import net.sf.laja.example.car.behaviour.CarColor;

public class TruckBuilder {
    public final TruckStateBuilder builder;

    public TruckBuilder() {
        builder = TruckStateImpl.build();
    }

    public TruckBuilder(TruckState state) {
        builder = TruckStateImpl.build(state);
    }

    public TruckBuilder withLengthInCentimeters(int lengthInCentimeters) {
        builder.withLengthInCentimeters(lengthInCentimeters);
        return this;
    }

    public TruckBuilder withWeightInKilograms(int weightInKilograms) {
        builder.withWeightInKilograms(weightInKilograms);
        return this;
    }

    public TruckBuilder withType(TruckTypeBuilder type) {
        builder.withType(type.builder);
        return this;
    }

    public TruckBuilder withColor(CarColor color) {
        builder.withColor(color);
        return this;
    }

    public TruckBuilder withOwner(OwnerBuilder owner) {
        builder.withOwner(owner.builder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Truck asTruck() {
        return (Truck)builder.as(new TruckFactory.TruckFactory_(builder));
    }
}
