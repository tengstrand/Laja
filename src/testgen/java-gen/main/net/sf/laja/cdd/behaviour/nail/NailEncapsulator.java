package net.sf.laja.cdd.behaviour.nail;

import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.state.nail.NailState;
// Toe

public class NailEncapsulator implements NailStateComparable {
    public final NailStateBuilder builder;

    public NailEncapsulator(NailStateBuilder builder) {
        this.builder = builder;
    }

    public Nail asNail() {
        return (Nail)builder.as(new NailFactory.NailFactory_());
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
