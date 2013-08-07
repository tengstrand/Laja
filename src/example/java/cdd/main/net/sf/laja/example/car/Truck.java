package net.sf.laja.example.car;

import net.sf.laja.example.car.state.TruckState;

import static net.sf.laja.example.car.TruckCreator.TruckBehaviour;

public class Truck extends TruckBehaviour {
    public Truck(TruckState state) {
        super(state);
    }
}
