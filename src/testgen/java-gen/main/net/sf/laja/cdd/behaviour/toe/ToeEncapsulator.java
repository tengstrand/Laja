package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;
// Toe

public class ToeEncapsulator implements ToeStateComparable {
    public final ToeStateBuilder builder;

    public ToeEncapsulator(ToeStateBuilder builder) {
        this.builder = builder;
    }

    public Toe asToe() {
        return (Toe)builder.as(new ToeFactory.ToeFactory_());
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
