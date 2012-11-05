package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.car.state.BusState;

public class BusValueFactory extends BusValue {

    public BusValueFactory(BusState state) {
        super(state);
    }

    public BusValueFactory(BusState state, BusStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static BusCreator.LengthInCentimeters_ name(String name) {
        return new BusCreator().new Name_().name(name);
    }

    public static BusBuilder build() {
        return new BusBuilder();
    }

    public static BusListCreator createList(BusEncapsulator... encapsulators) {
        return new BusListCreator(encapsulators);
    }

    public static class BusFactory_ implements BusStateBehaviourFactory {
        private final BusStateBuilder builder;

        public BusFactory_(BusStateBuilder builder) {
            this.builder = builder;
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
