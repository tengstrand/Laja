package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;

public class Head extends HeadFactory {
    private final MouthList mouths;

    public Head(HeadState state, HeadStateBuilder stateBuilder) {
        super(state, stateBuilder);

        mouths = new MouthList(state.getMouths(), MouthSize.SMALL);
    }

    // (factory)
    public Head asHead() {
        return new Head(state, stateBuilder);
    }

    @Override
    public String toString() {
        return "Head{mouths=" + mouths + ", state=" + state + "}";
    }
}
