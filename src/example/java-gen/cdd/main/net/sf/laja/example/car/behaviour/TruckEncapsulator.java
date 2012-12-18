package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;

public class TruckEncapsulator {
    public final TruckStateBuilder builder;

    public TruckEncapsulator(TruckStateBuilder builder) {
        this.builder = builder;
    }

    public Truck asTruck() {
        return (Truck)builder.as(new TruckFactory.TruckFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
