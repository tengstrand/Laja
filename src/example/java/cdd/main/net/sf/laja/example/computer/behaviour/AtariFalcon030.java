package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerValue;
import net.sf.laja.example.computer.state.Processor;

public class AtariFalcon030 extends ComputerValue {
    public AtariFalcon030(ComputerState state) {
        super(state);
        state.setName("Atari Falcon030", this);
        state.setReleaseYear(1992, this);
        state.setProcessor(Processor.M68030.name(), this);
        state.setMemoryInKilobytes(1024, this);
    }
}
