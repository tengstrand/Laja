package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerValue;
import net.sf.laja.example.computer.state.Processor;

public class Amiga4000 extends ComputerValue implements Amiga {
    public Amiga4000(ComputerState state) {
        super(state);
        state.setName("Amiga 4000", this);
        state.setReleaseYear(1992, this);
        state.setProcessor(Processor.M68040.name(), this);
        state.setMemoryInKilobytes(2048, this);
    }

    public boolean hasFastFloatingPointUnit() {
        return true;
    }
}
