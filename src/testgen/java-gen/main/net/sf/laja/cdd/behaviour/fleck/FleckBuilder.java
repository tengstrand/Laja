package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckBuilder {
    public final FleckStateBuilder builder;

    public FleckBuilder() {
        builder = FleckStateImpl.build();
    }

    public FleckBuilder(FleckState state) {
        builder = new FleckStateBuilderImpl(state);
    }

    public FleckBuilder(FleckState state, Object encapsulator) {
        builder = new FleckStateBuilderImpl(state, encapsulator);
    }

    public FleckBuilder withArea(int area) {
        builder.withArea(area);
        return this;
    }

    public FleckBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Fleck asFleck() {
        return (Fleck)builder.as(new FleckFactory.FleckFactory_(builder));
    }
}
