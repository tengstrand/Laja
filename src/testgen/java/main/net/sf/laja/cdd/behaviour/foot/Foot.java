package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.behaviour.toe.ToeArrayList;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.behaviour.toe.ValToeList;
import net.sf.laja.cdd.state.foot.FootState;

public class Foot extends FootFactory {
    private final ToeList toes;

    public Foot(FootState state) {
        super(state);
        toes = new ToeArrayList(state.getToes());
    }

    public ToeList toes() {
        return new ToeArrayList(state.getToes());
    }

    public ValToeList valToes() {
        return toes().asValToeList();
    }

    // (factory)
    public Foot asFoot() {
        return new Foot(state);
    }
}
