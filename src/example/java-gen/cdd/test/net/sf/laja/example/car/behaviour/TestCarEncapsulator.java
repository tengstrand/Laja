package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class TestCarEncapsulator {
    public final CarStateBuilder builder;

    public TestCarEncapsulator(CarStateBuilder builder) {
        this.builder = builder;
    }

    public Car asCar(VehicleSize size) {
        return (Car)builder.as(new TestCarFactory.CarFactory_(builder), size);
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
