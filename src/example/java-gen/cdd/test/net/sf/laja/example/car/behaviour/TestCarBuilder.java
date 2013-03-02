package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class TestCarBuilder {
    public final CarStateBuilder builder;

    public TestCarBuilder() {
        builder = CarStateImpl.build();
    }

    public TestCarBuilder(CarState state) {
        builder = new CarStateBuilderImpl(state);
    }

    public TestCarBuilder(CarState state, Object encapsulator) {
        builder = new CarStateBuilderImpl(state, encapsulator);
    }

    public TestCarBuilder withSize(VehicleSizeBuilder size) {
        builder.withSize(size.builder);
        return this;
    }

    public TestCarBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public TestCarBuilder withOwner(OwnerBuilder owner) {
        builder.withOwner(owner.builder);
        return this;
    }

    public TestCarBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Car asCar(VehicleSize size) {
        return (Car)builder.as(new TestCarFactory.CarFactory_(builder), size);
    }
}
