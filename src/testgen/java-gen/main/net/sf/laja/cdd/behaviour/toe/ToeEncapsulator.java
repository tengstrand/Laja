package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;

public class ToeEncapsulator {
    public final ToeStateBuilder builder;

    public ToeEncapsulator(ToeStateBuilder builder) {
        this.builder = builder;
    }

    public Toe asToe() {
        return (Toe)builder.as(new ToeFactory.ToeFactory_(builder));
    }

    public ValToe asValToe() {
        return (ValToe)builder.as(new ToeFactory.ValToeFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
