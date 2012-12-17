package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.CarStateBuilder;
import net.sf.laja.example.car.state.CarStateImpl;

public class CarBuilder {
    public final CarStateBuilder builder;

    public CarBuilder() {
        builder = CarStateImpl.build();
    }

    public CarBuilder(CarState state) {
        builder = CarStateImpl.build(state);
    }

    public CarBuilder withLengthInCentimeters(int lengthInCentimeters) {
        builder.withLengthInCentimeters(lengthInCentimeters);
        return this;
    }

    public CarBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public CarBuilder withOwner(OwnerBuilder owner) {
        builder.withOwner(owner.builder);
        return this;
    }

    public CarBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Car asCar() {
        return (Car)builder.as(new CarFactory.CarFactory_(builder));
    }
}
