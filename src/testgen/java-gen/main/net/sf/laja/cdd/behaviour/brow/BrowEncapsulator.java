package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;
// Toe

public class BrowEncapsulator implements BrowStateComparable {
    public final BrowStateBuilder builder;

    public BrowEncapsulator(BrowStateBuilder builder) {
        this.builder = builder;
    }

    public Brow asBrow() {
        return (Brow)builder.as(new BrowFactory.BrowFactory_(builder));
    }

    public BigBrow asBigBrow() {
        return (BigBrow)builder.as(new BrowFactory.BigBrowFactory_(builder));
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
