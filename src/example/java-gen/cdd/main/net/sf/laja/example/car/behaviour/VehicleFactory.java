package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import net.sf.laja.example.car.state.VehicleState;
import java.util.ArrayList;

public class VehicleFactory extends VehicleBehaviour {

    public VehicleFactory(VehicleState state) {
        super(state);
    }

    public VehicleFactory(VehicleState state, VehicleStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static VehicleCreator.Name_ lengthInCentimeters(int lengthInCentimeters) {
        return new VehicleCreator().new LengthInCentimeters_().lengthInCentimeters(lengthInCentimeters);
    }

    public static VehicleBuilder build() {
        return new VehicleBuilder();
    }

    public static VehicleSetEncapsulator createSet(VehicleEncapsulator... encapsulators) {
        return new VehicleSetEncapsulator(encapsulators);
    }

    public static VehicleListEncapsulator createList(VehicleEncapsulator... encapsulators) {
        return new VehicleListEncapsulator(encapsulators);
    }

    public static class VehicleFactory_ implements VehicleBehaviourFactory {
        private final VehicleStateBuilder stateBuilder;

        public VehicleFactory_(VehicleStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(VehicleState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Vehicle'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(VehicleState state, Object... args) {
        return new Vehicle(state);
    
      }
    }
}
