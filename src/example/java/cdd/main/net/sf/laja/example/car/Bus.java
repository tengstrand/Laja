package net.sf.laja.example.car;

import net.sf.laja.example.car.state.BusState;

public class Bus extends BusCreator.BusBehaviour {
    private final VehicleSize size;

    public Bus(BusState state) {
        super(state);
        size = new VehicleSize(state.getSize());
    }

    public boolean isNormalSize() {
        return size.isNormalSize();
    }
}
