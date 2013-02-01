package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;
import java.util.Arrays;
import java.util.ArrayList;

public class TruckFactory extends TruckBehaviour {

    public TruckFactory(TruckState state) {
        super(state);
    }

    public TruckFactory(TruckState state, TruckStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TruckCreator.WeightInKilograms_ lengthInCentimeters(int lengthInCentimeters) {
        return new TruckCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static TruckBuilder build() {
        return new TruckBuilder();
    }

    public static TruckSetEncapsulator createSet(TruckEncapsulator... encapsulators) {
        return new TruckSetEncapsulator(encapsulators);
    }

    public static TruckListEncapsulator createList(TruckEncapsulator... encapsulators) {
        return new TruckListEncapsulator(encapsulators);
    }

    public static class TruckFactory_ implements TruckBehaviourFactory {
        private final TruckStateBuilder stateBuilder;

        public TruckFactory_(TruckStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
