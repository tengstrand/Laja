package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;
// Vehicle

public class CarEncapsulator implements CarStateComparable {
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
