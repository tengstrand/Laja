package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;

public class Car extends CarFactory {
    private final VehicleSize size;

    public Car(CarState state) {
        super(state);
        size = new VehicleSize(state);
    }

    // (factory)
    public Car asCar() {
        return new Car(state);
    }

    public boolean isBig() {
        return size.isBig();
    }
}
