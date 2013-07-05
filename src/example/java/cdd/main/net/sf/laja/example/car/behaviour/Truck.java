package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckState;

import static net.sf.laja.example.car.behaviour.TruckCreator.TruckBehaviour;

public class Truck extends TruckBehaviour {
    public Truck(TruckState state) {
        super(state);
    }
}
