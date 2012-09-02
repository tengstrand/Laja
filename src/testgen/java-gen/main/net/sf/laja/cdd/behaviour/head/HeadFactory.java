package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.head.HeadStateBuilder;

public class HeadFactory extends HeadValueFactory {
    public HeadFactory(HeadState state) {
        super(state);
    }

    public HeadFactory(HeadState state, HeadStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
