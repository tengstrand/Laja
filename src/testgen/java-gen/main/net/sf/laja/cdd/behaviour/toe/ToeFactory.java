package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.ToeState;
import net.sf.laja.cdd.state.toe.ToeStateBuilder;

public class ToeFactory extends ToeEntityFactory {
    public ToeFactory(ToeState state) {
        super(state);
    }

    public ToeFactory(ToeState state, ToeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
