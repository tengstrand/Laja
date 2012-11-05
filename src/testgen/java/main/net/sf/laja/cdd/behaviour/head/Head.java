package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.mouth.MouthArrayList;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;

public class Head extends HeadFactory {
    private final Eye eye;
    private final Eye leftEye;
    private final Eye rightEye;
    private Eye midEye;
    private final MouthList mouths;

    public Head(HeadState state, HeadStateBuilder stateBuilder) {
        super(state, stateBuilder);
        eye = new Eye(state);
        leftEye = new Eye(state.getLeftEye());
        rightEye = new Eye(state.getRightEye());
        if (state.getMidEye() != null) {
            midEye = new Eye(state.getMidEye());
        }
        mouths = new MouthArrayList(state.getMouths(), MouthSize.SMALL);
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
