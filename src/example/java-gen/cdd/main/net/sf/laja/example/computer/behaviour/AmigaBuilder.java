package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerStateBuilder;
import net.sf.laja.example.computer.state.ComputerStateBuilderImpl;
import net.sf.laja.example.computer.state.ComputerStateImpl;

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
