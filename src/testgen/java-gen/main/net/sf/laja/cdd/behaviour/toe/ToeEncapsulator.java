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

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
