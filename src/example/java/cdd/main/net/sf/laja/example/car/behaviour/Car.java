package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;

public class Car extends CarFactory {
    private final VehicleSize size;

    public Car(CarState state) {
        super(state);
        size = new VehicleSize(state.getSize());
    }

    // Used by test context to inject mocks.
    public Car(CarState state, VehicleSize size) {
        super(state);
        this.size = size;
    }

    // (factory)
    public Car asCar() {
        return new Car(state);
    }

    public boolean isBig() {
        return size.isBig();
    }
}
