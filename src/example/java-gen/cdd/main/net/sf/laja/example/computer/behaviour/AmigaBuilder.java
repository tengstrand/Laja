package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;

public class AmigaBuilder {
    public final ComputerStateBuilder builder;

    public AmigaBuilder() {
        builder = ComputerStateImpl.build();
    }

    public AmigaBuilder(ComputerState state) {
        builder = new ComputerStateBuilderImpl(state);
    }

    public AmigaBuilder(ComputerState state, Object encapsulator) {
        builder = new ComputerStateBuilderImpl(state, encapsulator);
    }

    public AmigaBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public AmigaBuilder withProcessor(String processor) {
        builder.withProcessor(processor);
        return this;
    }

    public AmigaBuilder withReleaseYear(int releaseYear) {
        builder.withReleaseYear(releaseYear);
        return this;
    }

    public AmigaBuilder withMemoryInKilobytes(int memoryInKilobytes) {
        builder.withMemoryInKilobytes(memoryInKilobytes);
        return this;
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
