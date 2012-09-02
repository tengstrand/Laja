package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;

public class BusCreator {
    private final BusStateBuilder builder = BusStateImpl.build();

    public class Name_ {
        public LengthInCentimeters_ name(String name) {
            builder.withName(name);
            return new LengthInCentimeters_();
        }
    }

    public class LengthInCentimeters_ {
        public BusEncapsulator lengthInCentimeters(int lengthInCentimeters) {
            builder.withLengthInCentimeters(lengthInCentimeters);
            return create();
        }
    }

    public BusEncapsulator create() {
        return new BusEncapsulator(builder);
     }
}
