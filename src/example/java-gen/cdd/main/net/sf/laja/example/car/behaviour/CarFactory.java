package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import net.sf.laja.example.car.state.CarState;
import java.util.ArrayList;

public class CarFactory extends CarBehaviour {

    public CarFactory(CarState state) {
        super(state);
    }

    public CarFactory(CarState state, CarStateBuilder stateBuilder) {
        super(state, stateBuilder);
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
        private final CarStateBuilder stateBuilder;

        public CarFactory_(CarStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
