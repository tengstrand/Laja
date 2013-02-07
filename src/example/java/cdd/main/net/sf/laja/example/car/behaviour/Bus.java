package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.BusState;

public class Bus extends BusFactory {
    private final VehicleSize size;

    public Bus(BusState state) {
        super(state);
        size = new VehicleSize(state.getSizeState());
    }

    public boolean isNormalSize() {
        return size.isNormalSize();
    }

    // (factory)
    public Bus asBus() {
        return new Bus(state);
    }
}
