package net.sf.laja.example.car.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeFactory extends VehicleSizeBehaviour {

    public VehicleSizeFactory(VehicleSizeState state) {
        super(state);
    }

    public static VehicleSizeEncapsulator lengthInCentimeters(int lengthInCentimeters) {
        return new VehicleSizeCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static VehicleSizeBuilder build() {
        return new VehicleSizeBuilder();
    }

    public static VehicleSizeSetEncapsulator createSet(VehicleSizeEncapsulator... encapsulators) {
        return new VehicleSizeSetEncapsulator(encapsulators);
    }

    public static VehicleSizeListEncapsulator createList(VehicleSizeEncapsulator... encapsulators) {
        return new VehicleSizeListEncapsulator(encapsulators);
    }

    public static class VehicleSizeFactory_ implements VehicleSizeBehaviourFactory {

        public Object create(VehicleSizeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'VehicleSize'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(VehicleSizeState state, Object... args) {
        return new VehicleSize(state);
    
      }
    }
}
