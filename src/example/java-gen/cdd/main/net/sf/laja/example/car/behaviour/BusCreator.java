package net.sf.laja.example.car.behaviour;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;

public class BusCreator {
    private final BusStateBuilder builder = BusStateImpl.build();

    public class Name_ {
        public Size_ name(String name) {
            builder.withName(name);
            return new Size_();
        }
    }

    public class Size_ {
        public BusEncapsulator size(VehicleSizeEncapsulator size) {
            builder.withSize(size.builder);
            return create();
        }
    }

    public BusEncapsulator create() {
        return new BusEncapsulator(builder);
     }
}
