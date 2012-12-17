package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerValue;
import net.sf.laja.example.computer.state.Processor;

public class AtariST extends ComputerValue {
    public AtariST(ComputerState state) {
        super(state);
        state.setName("Atari ST");
        state.setReleaseYear(1985);
        state.setProcessor(Processor.M68000.name());
        state.setMemoryInKilobytes(512);
    }
}
