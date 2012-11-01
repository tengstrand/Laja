package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.state.foot.FootState;

public class Foot extends FootFactory {
    public final ToeList toes;

    public Foot(FootState state) {
        super(state);
        toes = new ToeList(state.getToes());
    }

    // (factory)
    public Foot asFoot() {
        return new Foot(state);
    }
}
