package net.sf.laja.cdd.behaviour.nail;

import net.sf.laja.cdd.state.nail.NailState;

public class Nail extends NailFactory {
    public Nail(NailState state) {
        super(state);
    }

    // (factory)
    public Nail asNail() {
        return new Nail(state);
    }
}
