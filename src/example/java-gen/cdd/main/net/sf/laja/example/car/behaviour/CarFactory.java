package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.CarStateBuilder;

public class CarFactory extends CarValueFactory {
    public CarFactory(CarState state) {
        super(state);
    }

    public CarFactory(CarState state, CarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
