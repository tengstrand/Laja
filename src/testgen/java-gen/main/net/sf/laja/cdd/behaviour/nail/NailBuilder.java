package net.sf.laja.cdd.behaviour.nail;

import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.state.nail.NailState;

public class NailBuilder {
    public final NailStateBuilder builder;

    public NailBuilder() {
        builder = NailStateImpl.build();
    }

    public NailBuilder(NailState state) {
        builder = new NailStateBuilderImpl(state);
    }

    public NailBuilder(NailState state, Object encapsulator) {
        builder = new NailStateBuilderImpl(state, encapsulator);
    }

    public NailBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Nail asNail() {
        return (Nail)builder.as(new NailFactory.NailFactory_(builder));
    }
}
