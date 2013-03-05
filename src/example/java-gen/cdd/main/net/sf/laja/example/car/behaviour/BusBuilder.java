package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;

public class BusBuilder {
    public final BusStateBuilder builder;

    public BusBuilder() {
        builder = BusStateImpl.build();
    }

    public BusBuilder(BusState state) {
        builder = new BusStateBuilderImpl(state);
    }

    public BusBuilder(BusState state, Object encapsulator) {
        builder = new BusStateBuilderImpl(state, encapsulator);
    }

    public BusBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public BusBuilder withSize(VehicleSizeBuilder size) {
        builder.withSize(size.builder);
        return this;
    }

    public BusBuilder withWeightInKilograms(int weightInKilograms) {
        builder.withWeightInKilograms(weightInKilograms);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Bus asBus() {
        return (Bus)builder.as(new BusFactory.BusFactory_());
    }
}
