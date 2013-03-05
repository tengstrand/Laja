package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariBuilder {
    public final ComputerStateBuilder builder;

    public AtariBuilder() {
        builder = ComputerStateImpl.build();
    }

    public AtariBuilder(ComputerState state) {
        builder = new ComputerStateBuilderImpl(state);
    }

    public AtariBuilder(ComputerState state, Object encapsulator) {
        builder = new ComputerStateBuilderImpl(state, encapsulator);
    }

    public AtariBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public AtariBuilder withProcessor(String processor) {
        builder.withProcessor(processor);
        return this;
    }

    public AtariBuilder withReleaseYear(int releaseYear) {
        builder.withReleaseYear(releaseYear);
        return this;
    }

    public AtariBuilder withMemoryInKilobytes(int memoryInKilobytes) {
        builder.withMemoryInKilobytes(memoryInKilobytes);
        return this;
    }

    public AtariBuilder withOwner(String owner) {
        builder.withOwner(owner);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public AtariST asAtariST() {
        return (AtariST)builder.as(new AtariFactory.AtariSTFactory_(builder));
    }

    public AtariFalcon030 asAtariFalcon030() {
        return (AtariFalcon030)builder.as(new AtariFactory.AtariFalcon030Factory_(builder));
    }
}
