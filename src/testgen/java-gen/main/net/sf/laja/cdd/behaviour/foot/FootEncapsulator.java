package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.*;
import net.sf.laja.cdd.behaviour.toe.ToeArrayList;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.toe.ToeStateList;
// Toe
import net.sf.laja.cdd.behaviour.toe.ToeListEncapsulator;

public class FootEncapsulator implements FootStateComparable {
    public final FootStateBuilder builder;

    public FootEncapsulator(FootStateBuilder builder) {
        this.builder = builder;
    }

    public Foot asFoot() {
        return (Foot)builder.as(new FootFactory.FootFactory_());
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
