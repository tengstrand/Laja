package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;
// Computer

public class AmigaEncapsulator implements ComputerStateComparable {
    public final ComputerStateBuilder builder;

    public AmigaEncapsulator(ComputerStateBuilder builder) {
        this.builder = builder;
    }

    public Amiga asAmiga(Configuration context) {
        return (Amiga)builder.as(new AmigaFactory.AmigaFactory_(), context);
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
