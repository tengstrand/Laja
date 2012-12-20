package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.BrowState;

public class Brow extends BrowFactory {
    public Brow(BrowState state) {
        super(state);
    }

    // (factory)
    public Brow asBrow() {
        return new Brow(state);
    }


    // (factory)
    public BigBrow asBigBrow() {
        return new BigBrow(state);
    }

    public int area() {
        return state.getArea();
    }
}
