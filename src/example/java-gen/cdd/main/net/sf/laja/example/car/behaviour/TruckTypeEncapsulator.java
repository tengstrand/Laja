package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeEncapsulator {
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
    public String toString() {
        return builder.toString();
    }
}
