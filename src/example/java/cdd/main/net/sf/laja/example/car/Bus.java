package net.sf.laja.example.car;

import net.sf.laja.example.car.state.BusState;

import static net.sf.laja.example.car.BusCreator.BusBehaviour;

public class Bus extends BusBehaviour {
    private final VehicleSize size;

    public Bus(BusState state) {
        super(state);
        size = new VehicleSize(state.size);
    }

    public boolean isNormalSize() {
        return size.isNormalSize();
    }
}
