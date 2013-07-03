package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.BusState;

import static net.sf.laja.example.car.behaviour.BusCreator.BusBehaviour;

public class Bus extends BusBehaviour {
    private final VehicleSize size;

    public Bus(BusState state) {
        super(state);
        size = new VehicleSize(state.getSize());
    }

    public boolean isNormalSize() {
        return size.isNormalSize();
    }
}
