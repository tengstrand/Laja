package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;

public class TestCar extends TestCarFactory {
    public TestCar(CarState state) {
        super(state);
    }

    // (factory)
    public Car asCar(VehicleSize size) {
        return new Car(state, size);
    }
}
