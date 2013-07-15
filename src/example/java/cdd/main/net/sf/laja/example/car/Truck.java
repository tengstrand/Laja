package net.sf.laja.example.car;

import net.sf.laja.example.car.state.TruckState;

public class Truck extends TruckCreator.TruckBehaviour {
    public Truck(TruckState state) {
        super(state);
    }
}
