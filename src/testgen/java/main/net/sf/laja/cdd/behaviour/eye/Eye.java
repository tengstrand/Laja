package net.sf.laja.cdd.behaviour.eye;

import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;

public class Eye extends EyeFactory {
    public Eye(EyeState state) {
        super(state);
        state.setDecease("Healthy");
    }

    // (factory) (list)
    public Eye asEye() {
        return new Eye(state);
    }

    // (list)
    public ScaryEye asScaryEye() {
        return new ScaryEye(state);
    }
}
