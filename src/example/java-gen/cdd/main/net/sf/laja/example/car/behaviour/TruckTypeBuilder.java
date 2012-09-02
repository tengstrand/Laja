package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeBuilder {
    public final TruckTypeStateBuilder builder;

    public TruckTypeBuilder() {
        builder = TruckTypeStateImpl.build();
    }

    public TruckTypeBuilder(TruckTypeState state) {
        builder = TruckTypeStateImpl.build(state);
    }

    public TruckTypeBuilder withNumberOfWheels(int numberOfWheels) {
        builder.withNumberOfWheels(numberOfWheels);
        return this;
    }

    public TruckTypeBuilder withTruckName(String truckName) {
        builder.withTruckName(truckName);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TruckType asTruckType() {
        return (TruckType)builder.as(new TruckTypeFactory.TruckTypeFactory_(builder));
    }
}
