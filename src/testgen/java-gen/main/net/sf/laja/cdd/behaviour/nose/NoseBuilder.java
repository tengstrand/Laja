package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseBuilder {
    public final NoseStateBuilder builder;

    public NoseBuilder() {
        builder = NoseStateImpl.build();
    }

    public NoseBuilder(NoseState state) {
        builder = new NoseStateBuilderImpl(state);
    }

    public NoseBuilder(NoseState state, Object encapsulator) {
        builder = new NoseStateBuilderImpl(state, encapsulator);
    }

    public NoseBuilder withNoseDescription(String noseDescription) {
        builder.withNoseDescription(noseDescription);
        return this;
    }

    public NoseBuilder withDetails(String details) {
        builder.withDetails(details);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Nose asNose(int extraParameter) {
        return (Nose)builder.as(new NoseFactory.NoseFactory_(builder), extraParameter);
    }

    public BigNose asBigNose() {
        return (BigNose)builder.as(new NoseFactory.BigNoseFactory_(builder));
    }
}
