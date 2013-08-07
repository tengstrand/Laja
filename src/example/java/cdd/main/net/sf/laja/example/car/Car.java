package net.sf.laja.example.car;

import net.sf.laja.example.car.state.CarState;

import static net.sf.laja.example.car.CarCreator.CarBehaviour;

public class Car extends CarBehaviour {
    private final VehicleSize size;

    public Car(CarState state) {
        super(state);
        size = new VehicleSize(state.size);
    }

    // Used by test context to inject mocks.
    public Car(CarState state, VehicleSize size) {
        super(state);
        this.size = size;
    }

    public boolean isBig() {
        return size.isBig();
    }
}
