package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.NoseState;
import net.sf.laja.cdd.state.nose.NoseStateBuilder;

public class NoseFactory extends NoseValueFactory {
    public NoseFactory(NoseState state) {
        super(state);
    }

    public NoseFactory(NoseState state, NoseStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
