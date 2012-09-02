package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class EarBuilder {
    public final EarStateBuilder builder;

    public EarBuilder() {
        builder = EarStateImpl.build();
    }

    public EarBuilder(EarState state) {
        builder = EarStateImpl.build(state);
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Ear asEar() {
        return (Ear)builder.as(new EarFactory.EarFactory_(builder));
    }
}
