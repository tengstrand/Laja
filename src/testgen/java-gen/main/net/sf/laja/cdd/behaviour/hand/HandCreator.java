package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandCreator {
    private final HandStateBuilder builder = HandStateImpl.build();

    public class Area_ {
        public HandEncapsulator area(int area) {
            builder.withArea(area);
            return create();
        }
    }

    public HandEncapsulator create() {
        return new HandEncapsulator(builder);
     }
}
