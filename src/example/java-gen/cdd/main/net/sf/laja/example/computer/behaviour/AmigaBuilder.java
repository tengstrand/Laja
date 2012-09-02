package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;

public class AmigaBuilder {
    public final ComputerStateBuilder builder;

    public AmigaBuilder() {
        builder = ComputerStateImpl.build();
    }

    public AmigaBuilder(ComputerState state) {
        builder = ComputerStateImpl.build(state);
    }

    public AmigaBuilder withOwner(String owner) {
        builder.withOwner(owner);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Amiga asAmiga(Configuration context) {
        return (Amiga)builder.as(new AmigaFactory.AmigaFactory_(builder), context);
    }
}
