package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeEncapsulator {
    public final VehicleSizeStateBuilder builder;

    public VehicleSizeEncapsulator(VehicleSizeStateBuilder builder) {
        this.builder = builder;
    }

    public VehicleSize asVehicleSize() {
        return (VehicleSize)builder.as(new VehicleSizeFactory.VehicleSizeFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
