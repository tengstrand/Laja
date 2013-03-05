package net.sf.laja.example.car.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.car.behaviour.VehicleSizeEncapsulator;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class CarFactory extends CarBehaviour {

    public CarFactory(CarState state) {
        super(state);
    }

    public static CarCreator.Name_ size(VehicleSizeEncapsulator size) {
        return new CarCreator().new Size_().size(size);
    }

    public static CarBuilder build() {
        return new CarBuilder();
    }

    public static CarSetEncapsulator createSet(CarEncapsulator... encapsulators) {
        return new CarSetEncapsulator(encapsulators);
    }

    public static CarListEncapsulator createList(CarEncapsulator... encapsulators) {
        return new CarListEncapsulator(encapsulators);
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
        return new Car(state);
    
      }
    }
}
