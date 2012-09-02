package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeBuilder {
    public final VehicleSizeStateBuilder builder;

    public VehicleSizeBuilder() {
        builder = VehicleSizeStateImpl.build();
    }

    public VehicleSizeBuilder(VehicleSizeState state) {
        builder = VehicleSizeStateImpl.build(state);
    }

    public VehicleSizeBuilder withLengthInCentimeters(int lengthInCentimeters) {
        builder.withLengthInCentimeters(lengthInCentimeters);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public VehicleSize asVehicleSize() {
        return (VehicleSize)builder.as(new VehicleSizeFactory.VehicleSizeFactory_(builder));
    }
}
