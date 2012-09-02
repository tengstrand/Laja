package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeCreator {
    private final TruckTypeStateBuilder builder = TruckTypeStateImpl.build();

    public class NumberOfWheels_ {
        public TruckName_ numberOfWheels(int numberOfWheels) {
            builder.withNumberOfWheels(numberOfWheels);
            return new TruckName_();
        }
    }

    public class TruckName_ {
        public TruckTypeEncapsulator truckName(String truckName) {
            builder.withTruckName(truckName);
            return create();
        }
    }

    public TruckTypeEncapsulator create() {
        return new TruckTypeEncapsulator(builder);
     }
}
