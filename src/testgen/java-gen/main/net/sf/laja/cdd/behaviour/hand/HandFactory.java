package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.HandState;
import net.sf.laja.cdd.state.hand.HandStateBuilder;

public class HandFactory extends HandEntityFactory {
    public HandFactory(HandState state) {
        super(state);
    }

    public HandFactory(HandState state, HandStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
