package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariEncapsulator {
    public final ComputerStateBuilder builder;

    public AtariEncapsulator(ComputerStateBuilder builder) {
        this.builder = builder;
    }

    public AtariST asAtariST() {
        return (AtariST)builder.as(new AtariSTFactory.AtariSTFactory_(builder));
    }

    public AtariFalcon030 asAtariFalcon030() {
        return (AtariFalcon030)builder.as(new AtariSTFactory.AtariFalcon030Factory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
