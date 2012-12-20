package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class BrowEncapsulator {
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
    public String toString() {
        return builder.toString();
    }
}
