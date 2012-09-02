package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeValueFactory extends VehicleSizeValue {

    public VehicleSizeValueFactory(VehicleSizeState state) {
        super(state);
    }

    public VehicleSizeValueFactory(VehicleSizeState state, VehicleSizeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static VehicleSizeEncapsulator lengthInCentimeters(int lengthInCentimeters) {
        return new VehicleSizeCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static VehicleSizeBuilder build() {
        return new VehicleSizeBuilder();
    }

    public static class VehicleSizeFactory_ implements VehicleSizeStateBehaviourFactory {
        private final VehicleSizeStateBuilder builder;

        public VehicleSizeFactory_(VehicleSizeStateBuilder builder) {
            this.builder = builder;
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
