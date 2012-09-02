package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairState;
import net.sf.laja.cdd.state.hair.HairStateBuilder;

public class HairFactory extends HairEntityFactory {
    public HairFactory(HairState state) {
        super(state);
    }

    public HairFactory(HairState state, HairStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
