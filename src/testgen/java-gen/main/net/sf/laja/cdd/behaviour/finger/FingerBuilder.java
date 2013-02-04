package net.sf.laja.cdd.behaviour.finger;

import net.sf.laja.cdd.state.finger.*;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;

public class FingerBuilder {
    public final FingerStateBuilder builder;

    public FingerBuilder() {
        builder = FingerStateImpl.build();
    }

    public FingerBuilder(FingerState state) {
        builder = new FingerStateBuilderImpl(state);
    }

    public FingerBuilder(FingerState state, Object encapsulator) {
        builder = new FingerStateBuilderImpl(state, encapsulator);
    }

    public FingerBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Finger asFinger() {
        return (Finger)builder.as(new FingerFactory.FingerFactory_(builder));
    }
}
