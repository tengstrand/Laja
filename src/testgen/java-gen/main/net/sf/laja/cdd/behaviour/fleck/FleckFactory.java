package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.FleckState;
import net.sf.laja.cdd.state.fleck.FleckStateBuilder;

public class FleckFactory extends FleckValueFactory {
    public FleckFactory(FleckState state) {
        super(state);
    }

    public FleckFactory(FleckState state, FleckStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
