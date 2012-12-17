package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarStateBuilder;

public class CarEncapsulator {
    public final CarStateBuilder builder;

    public CarEncapsulator(CarStateBuilder builder) {
        this.builder = builder;
    }

    public Car asCar() {
        return (Car)builder.as(new CarFactory.CarFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
