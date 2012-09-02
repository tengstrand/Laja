package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckState;

public class Truck extends TruckFactory {
    public Truck(TruckState state) {
        super(state);
    }

    // (factory)
    public Truck asTruck() {
        return new Truck(state);
    }
}
