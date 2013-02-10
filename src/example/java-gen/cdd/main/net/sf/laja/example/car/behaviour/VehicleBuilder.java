package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleState;

public class VehicleBuilder {
    public final VehicleStateBuilder builder;

    public VehicleBuilder() {
        builder = VehicleStateImpl.build();
    }

    public VehicleBuilder(VehicleState state) {
        builder = new VehicleStateBuilderImpl(state);
    }

    public VehicleBuilder(VehicleState state, Object encapsulator) {
        builder = new VehicleStateBuilderImpl(state, encapsulator);
    }

    public VehicleBuilder withLengthInCentimeters(int lengthInCentimeters) {
        builder.withLengthInCentimeters(lengthInCentimeters);
        return this;
    }

    public VehicleBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public VehicleBuilder withOwner(OwnerBuilder owner) {
        builder.withOwner(owner.builder);
        return this;
    }

    public VehicleBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Vehicle asVehicle() {
        return (Vehicle)builder.as(new VehicleFactory.VehicleFactory_(builder));
    }
}
