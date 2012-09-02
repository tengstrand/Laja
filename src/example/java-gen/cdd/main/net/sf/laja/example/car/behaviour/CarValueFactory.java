package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class CarValueFactory extends CarValue {

    public CarValueFactory(CarState state) {
        super(state);
    }

    public CarValueFactory(CarState state, CarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static CarCreator.Name_ lengthInCentimeters(int lengthInCentimeters) {
        return new CarCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static CarBuilder build() {
        return new CarBuilder();
    }

    public static class CarFactory_ implements CarStateBehaviourFactory {
        private final CarStateBuilder builder;

        public CarFactory_(CarStateBuilder builder) {
            this.builder = builder;
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
