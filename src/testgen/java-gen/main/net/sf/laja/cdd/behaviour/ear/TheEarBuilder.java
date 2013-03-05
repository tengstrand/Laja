package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TheEarBuilder {
    public final EarStateBuilder builder;

    public TheEarBuilder() {
        builder = EarStateImpl.build();
    }

    public TheEarBuilder(EarState state) {
        builder = new EarStateBuilderImpl(state);
    }

    public TheEarBuilder(EarState state, Object encapsulator) {
        builder = new EarStateBuilderImpl(state, encapsulator);
    }

    public TheEarBuilder withSize(double size) {
        builder.withSize(size);
        return this;
    }

    public TheEarBuilder withWeight(int weight) {
        builder.withWeight(weight);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TheEar asTheEar() {
        return (TheEar)builder.as(new TheEarFactory.TheEarFactory_(builder));
    }
}
