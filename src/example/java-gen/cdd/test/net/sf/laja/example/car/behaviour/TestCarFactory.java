package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.CarStateBuilder;

public class TestCarFactory extends TestCarValueFactory {
    public TestCarFactory(CarState state) {
        super(state);
    }

    public TestCarFactory(CarState state, CarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
