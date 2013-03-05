package net.sf.laja.example.car.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.car.behaviour.VehicleSizeEncapsulator;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class TestCarFactory extends CarBehaviour {

    public TestCarFactory(CarState state) {
        super(state);
    }

    public static TestCarCreator.Name_ size(VehicleSizeEncapsulator size) {
        return new TestCarCreator().new Size_().size(size);
    }

    public static TestCarBuilder build() {
        return new TestCarBuilder();
    }

    public static TestCarSetEncapsulator createSet(TestCarEncapsulator... encapsulators) {
        return new TestCarSetEncapsulator(encapsulators);
    }

    public static TestCarListEncapsulator createList(TestCarEncapsulator... encapsulators) {
        return new TestCarListEncapsulator(encapsulators);
    }

    public static class CarFactory_ implements CarBehaviourFactory {

        public Object create(CarState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Car'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(CarState state, Object... args) {
        VehicleSize size = (VehicleSize)args[0];

        return new Car(state, size);
    
      }
    }
}
