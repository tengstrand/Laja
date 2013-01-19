package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import net.sf.laja.example.car.state.VehicleSizeState;
import java.util.ArrayList;

public class VehicleSizeFactory extends VehicleSizeBehaviour {

    public VehicleSizeFactory(VehicleSizeState state) {
        super(state);
    }

    public VehicleSizeFactory(VehicleSizeState state, VehicleSizeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static VehicleSizeEncapsulator lengthInCentimeters(int lengthInCentimeters) {
        return new VehicleSizeCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static VehicleSizeBuilder build() {
        return new VehicleSizeBuilder();
    }

    public static VehicleSizeListEncapsulator createList(VehicleSizeEncapsulator... encapsulators) {
        return new VehicleSizeListEncapsulator(encapsulators);
    }

    public static class VehicleSizeFactory_ implements VehicleSizeBehaviourFactory {
        private final VehicleSizeStateBuilder stateBuilder;

        public VehicleSizeFactory_(VehicleSizeStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
