package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthFactory extends MouthEntityFactory {
    public MouthFactory(MouthState state) {
        super(state);
    }

    public MouthFactory(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
