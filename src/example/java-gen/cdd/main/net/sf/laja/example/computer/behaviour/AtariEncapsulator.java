package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;
// Computer

public class AtariEncapsulator implements ComputerStateComparable {
    public final ComputerStateBuilder builder;

    public AtariEncapsulator(ComputerStateBuilder builder) {
        this.builder = builder;
    }

    public AtariST asAtariST() {
        return (AtariST)builder.as(new AtariFactory.AtariSTFactory_(builder));
    }

    public AtariFalcon030 asAtariFalcon030() {
        return (AtariFalcon030)builder.as(new AtariFactory.AtariFalcon030Factory_(builder));
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
