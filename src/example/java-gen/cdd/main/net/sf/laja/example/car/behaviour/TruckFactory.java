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

    public static TruckCreator.WeightInKilograms_ size(VehicleSizeEncapsulator size) {
        return new TruckCreator().new Size_().size(size);
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
