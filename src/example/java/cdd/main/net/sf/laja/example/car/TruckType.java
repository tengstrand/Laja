package net.sf.laja.example.car;

import net.sf.laja.example.car.state.TruckTypeState;

import static net.sf.laja.example.car.TruckTypeCreator.TruckTypeBehaviour;

public class TruckType extends TruckTypeBehaviour {
    public TruckType(TruckTypeState state) {
        super(state);
    }
}
