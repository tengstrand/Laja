package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;
// Bus

public class TestCarEncapsulator implements CarStateComparable {
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
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
