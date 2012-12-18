package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.ear.EarStateBuilder;
import net.sf.laja.cdd.state.ear.EarStateBuilderImpl;
import net.sf.laja.cdd.state.ear.EarStateImpl;

public class EarBuilder {
    public final EarStateBuilder builder;

    public EarBuilder() {
        builder = EarStateImpl.build();
    }

    public EarBuilder(EarState state) {
        builder = new EarStateBuilderImpl(state);
    }

    public EarBuilder(EarState state, Object encapsulator) {
        builder = new EarStateBuilderImpl(state, encapsulator);
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Ear asEar() {
        return (Ear)builder.as(new EarFactory.EarFactory_(builder));
    }
}
