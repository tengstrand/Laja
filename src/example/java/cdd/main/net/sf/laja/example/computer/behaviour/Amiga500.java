package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerBehaviour;
import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.Processor;

public class Amiga500 extends ComputerBehaviour implements Amiga {
    public Amiga500(ComputerState state) {
        super(state);
        state.setName("Amiga 500", this);
        state.setReleaseYear(1987, this);
        state.setProcessor(Processor.M68000.name(), this);
        state.setMemoryInKilobytes(512, this);
    }

    public boolean hasFastFloatingPointUnit() {
        return false;
    }
}
