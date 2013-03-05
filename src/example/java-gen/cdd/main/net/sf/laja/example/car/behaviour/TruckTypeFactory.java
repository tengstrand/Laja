package net.sf.laja.example.car.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeFactory extends TruckTypeBehaviour {

    public TruckTypeFactory(TruckTypeState state) {
        super(state);
    }

    public static TruckTypeCreator.TruckName_ numberOfWheels(int numberOfWheels) {
        return new TruckTypeCreator().new NumberOfWheels_().numberOfWheels(numberOfWheels);
    }

    public static TruckTypeBuilder build() {
        return new TruckTypeBuilder();
    }

    public static TruckTypeSetEncapsulator createSet(TruckTypeEncapsulator... encapsulators) {
        return new TruckTypeSetEncapsulator(encapsulators);
    }

    public static TruckTypeListEncapsulator createList(TruckTypeEncapsulator... encapsulators) {
        return new TruckTypeListEncapsulator(encapsulators);
    }

    public static class TruckTypeFactory_ implements TruckTypeBehaviourFactory {

        public Object create(TruckTypeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TruckType'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(TruckTypeState state, Object... args) {
        return new TruckType(state);
    
      }
    }
}
