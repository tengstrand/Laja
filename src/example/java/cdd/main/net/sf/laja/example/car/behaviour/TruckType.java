package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckTypeState;

public class TruckType extends TruckTypeFactory {
    public TruckType(TruckTypeState state) {
        super(state);
    }

    // (factory)
    public TruckType asTruckType() {
        return new TruckType(state);
    }
}
