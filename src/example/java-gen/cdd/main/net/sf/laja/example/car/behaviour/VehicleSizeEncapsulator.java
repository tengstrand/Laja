package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;
// Bus

public class VehicleSizeEncapsulator implements VehicleSizeStateComparable {
    public final VehicleSizeStateBuilder builder;

    public VehicleSizeEncapsulator(VehicleSizeStateBuilder builder) {
        this.builder = builder;
    }

    public VehicleSize asVehicleSize() {
        return (VehicleSize)builder.as(new VehicleSizeFactory.VehicleSizeFactory_());
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
