package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckTypeState;

import static net.sf.laja.example.car.behaviour.TruckTypeCreator.TruckTypeBehaviour;

public class TruckType extends TruckTypeBehaviour {
    public TruckType(TruckTypeState state) {
        super(state);
    }
}
