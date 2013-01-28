package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.ToeState;

public class Toe extends ToeFactory {
    public Toe(ToeState state) {
        super(state);
    }

    // (factory)
    public Toe asToe() {
        return new Toe(state);
    }

    public String value() {
        return state.getLength() + "," + state.getWeight();
    }
}
