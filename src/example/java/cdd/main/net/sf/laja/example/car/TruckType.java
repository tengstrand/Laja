package net.sf.laja.example.car;

import net.sf.laja.example.car.state.TruckTypeState;

public class TruckType extends TruckTypeCreator.TruckTypeBehaviour {
    public TruckType(TruckTypeState state) {
        super(state);
    }
}
