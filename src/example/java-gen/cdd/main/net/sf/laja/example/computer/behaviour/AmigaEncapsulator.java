package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;

public class AmigaEncapsulator {
    public final ComputerStateBuilder builder;

    public AmigaEncapsulator(ComputerStateBuilder builder) {
        this.builder = builder;
    }

    public Amiga asAmiga(Configuration context) {
        return (Amiga)builder.as(new AmigaFactory.AmigaFactory_(builder), context);
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
