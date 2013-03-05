package net.sf.laja.example.car.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;

public class BusFactory extends BusBehaviour {

    public BusFactory(BusState state) {
        super(state);
    }

    public static BusCreator.Size_ name(String name) {
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
