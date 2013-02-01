package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.car.state.BusState;

public class BusFactory extends BusBehaviour {

    public BusFactory(BusState state) {
        super(state);
    }

    public BusFactory(BusState state, BusStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static BusCreator.LengthInCentimeters_ name(String name) {
        return new BusCreator().new Name_().name(name);
    }

    public static BusBuilder build() {
        return new BusBuilder();
    }

    public static BusSetEncapsulator createSet(BusEncapsulator... encapsulators) {
        return new BusSetEncapsulator(encapsulators);
    }

    public static BusListEncapsulator createList(BusEncapsulator... encapsulators) {
        return new BusListEncapsulator(encapsulators);
    }

    public static class BusFactory_ implements BusBehaviourFactory {
        private final BusStateBuilder stateBuilder;

        public BusFactory_(BusStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(BusState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Bus'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(BusState state, Object... args) {
        return new Bus(state);
    
      }
    }
}
