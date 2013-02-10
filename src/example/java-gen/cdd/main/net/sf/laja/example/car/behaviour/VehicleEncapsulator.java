package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleState;
// Vehicle

public class VehicleEncapsulator implements VehicleStateComparable {
    public final VehicleStateBuilder builder;

    public VehicleEncapsulator(VehicleStateBuilder builder) {
        this.builder = builder;
    }

    public Vehicle asVehicle() {
        return (Vehicle)builder.as(new VehicleFactory.VehicleFactory_(builder));
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
