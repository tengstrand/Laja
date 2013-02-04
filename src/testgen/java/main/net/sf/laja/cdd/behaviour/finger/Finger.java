package net.sf.laja.cdd.behaviour.finger;

import net.sf.laja.cdd.state.finger.FingerState;

public class Finger extends FingerFactory {
    public Finger(FingerState state) {
        super(state);
    }

    // (factory)
    public Finger asFinger() {
        return new Finger(state);
    }
}
