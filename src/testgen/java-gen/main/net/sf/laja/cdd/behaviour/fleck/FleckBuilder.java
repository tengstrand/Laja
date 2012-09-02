package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckBuilder {
    public final FleckStateBuilder builder;

    public FleckBuilder() {
        builder = FleckStateImpl.build();
    }

    public FleckBuilder(FleckState state) {
        builder = FleckStateImpl.build(state);
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Fleck asFleck() {
        return (Fleck)builder.as(new FleckFactory.FleckFactory_(builder));
    }
}
