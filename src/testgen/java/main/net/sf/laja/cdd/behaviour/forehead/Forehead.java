package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;

public class Forehead extends ForeheadFactory {
    private final BrowList browList;

    public Forehead(ForeheadState state) {
        super(state);

        browList = new BrowList(state.getBrows());
    }

    // (factory)
    public Forehead asForehead() {
        return new Forehead(state);
    }
}
