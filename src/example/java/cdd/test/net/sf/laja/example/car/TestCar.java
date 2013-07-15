package net.sf.laja.example.car;

import net.sf.laja.example.car.behaviour.Car;
import net.sf.laja.example.car.behaviour.VehicleSize;
import net.sf.laja.example.car.state.CarState;

public class TestCar extends TestCarCreator.CarBehaviour {
    public TestCar(CarState state) {
        super(state);
    }

    public Car asCar(VehicleSize size) {
        return new Car(s, size);
    }
}
