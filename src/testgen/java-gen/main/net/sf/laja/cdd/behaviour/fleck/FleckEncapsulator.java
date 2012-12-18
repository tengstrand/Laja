package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckEncapsulator {
    public final FleckStateBuilder builder;

    public FleckEncapsulator(FleckStateBuilder builder) {
        this.builder = builder;
    }

    public Fleck asFleck() {
        return (Fleck)builder.as(new FleckFactory.FleckFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
