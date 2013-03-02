package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;
// Bus

public class TruckTypeEncapsulator implements TruckTypeStateComparable {
    public final TruckTypeStateBuilder builder;

    public TruckTypeEncapsulator(TruckTypeStateBuilder builder) {
        this.builder = builder;
    }

    public TruckType asTruckType() {
        return (TruckType)builder.as(new TruckTypeFactory.TruckTypeFactory_(builder));
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
