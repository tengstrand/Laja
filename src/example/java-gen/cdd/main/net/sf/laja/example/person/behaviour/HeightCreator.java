package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;

public class HeightCreator {
    private final HeightStateBuilder builder = HeightStateImpl.build();

    public class HeightInCentimeters_ {
        public HeightEncapsulator heightInCentimeters(int heightInCentimeters) {
            builder.withHeightInCentimeters(heightInCentimeters);
            return create();
        }
    }

    public HeightEncapsulator create() {
        return new HeightEncapsulator(builder);
     }
}
