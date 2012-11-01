package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.foot.FootStateBuilder;

public class FootFactory extends FootValueFactory {
    public FootFactory(FootState state) {
        super(state);
    }

    public FootFactory(FootState state, FootStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
