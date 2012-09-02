package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;

public class TruckValueFactory extends TruckValue {

    public TruckValueFactory(TruckState state) {
        super(state);
    }

    public TruckValueFactory(TruckState state, TruckStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TruckCreator.WeightInKilograms_ lengthInCentimeters(int lengthInCentimeters) {
        return new TruckCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static TruckBuilder build() {
        return new TruckBuilder();
    }

    public static class TruckFactory_ implements TruckStateBehaviourFactory {
        private final TruckStateBuilder builder;

        public TruckFactory_(TruckStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(TruckState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Truck'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(TruckState state, Object... args) {
        return new Truck(state);
    
      }
    }
}
