package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;
// Bus

public class TruckEncapsulator implements TruckStateComparable {
    public final TruckStateBuilder builder;

    public TruckEncapsulator(TruckStateBuilder builder) {
        this.builder = builder;
    }

    public Truck asTruck() {
        return (Truck)builder.as(new TruckFactory.TruckFactory_());
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
