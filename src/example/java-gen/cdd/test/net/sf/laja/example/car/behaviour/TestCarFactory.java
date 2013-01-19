package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import net.sf.laja.example.car.state.CarState;
import java.util.ArrayList;

public class TestCarFactory extends CarBehaviour {

    public TestCarFactory(CarState state) {
        super(state);
    }

    public TestCarFactory(CarState state, CarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TestCarCreator.Name_ lengthInCentimeters(int lengthInCentimeters) {
        return new TestCarCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static TestCarBuilder build() {
        return new TestCarBuilder();
    }

    public static TestCarListEncapsulator createList(TestCarEncapsulator... encapsulators) {
        return new TestCarListEncapsulator(encapsulators);
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
        VehicleSize size = (VehicleSize)args[0];

        return new Car(state, size);
    
      }
    }
}
