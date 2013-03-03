package net.sf.laja.example.car.behaviour;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeCreator {
    private final VehicleSizeStateBuilder builder = VehicleSizeStateImpl.build();

    public class LengthInCentimeters_ {
        public VehicleSizeEncapsulator lengthInCentimeters(int lengthInCentimeters) {
            builder.withLengthInCentimeters(lengthInCentimeters);
            return create();
        }
    }

    public VehicleSizeEncapsulator create() {
        return new VehicleSizeEncapsulator(builder);
     }
}
