package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.FleckState;

public class Fleck extends FleckFactory {
    public Fleck(FleckState state) {
        super(state);
    }

    // (factory)
    public Fleck asFleck() {
        return new Fleck(state);
    }
}
