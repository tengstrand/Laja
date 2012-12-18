package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckTypeState;
import net.sf.laja.example.car.state.TruckTypeStateBuilder;
import net.sf.laja.example.car.state.TruckTypeStateBuilderImpl;
import net.sf.laja.example.car.state.TruckTypeStateImpl;

public class TruckTypeBuilder {
    public final TruckTypeStateBuilder builder;

    public TruckTypeBuilder() {
        builder = TruckTypeStateImpl.build();
    }

    public TruckTypeBuilder(TruckTypeState state) {
        builder = new TruckTypeStateBuilderImpl(state);
    }

    public TruckTypeBuilder(TruckTypeState state, Object encapsulator) {
        builder = new TruckTypeStateBuilderImpl(state, encapsulator);
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
