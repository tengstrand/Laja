package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerValue;
import net.sf.laja.example.computer.state.Processor;

public class Amiga500 extends ComputerValue implements Amiga {
    public Amiga500(ComputerState state) {
        super(state);
        state.setName("Amiga 500");
        state.setReleaseYear(1987);
        state.setProcessor(Processor.M68000);
        state.setMemoryInKilobytes(512);
    }

    public boolean hasFastFloatingPointUnit() {
        return false;
    }
}
