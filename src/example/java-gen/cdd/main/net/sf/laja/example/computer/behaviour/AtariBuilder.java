package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariBuilder {
    public final ComputerStateBuilder builder;

    public AtariBuilder() {
        builder = ComputerStateImpl.build();
    }

    public AtariBuilder(ComputerState state) {
        builder = ComputerStateImpl.build(state);
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
