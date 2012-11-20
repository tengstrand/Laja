package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerStateBuilder;

public class AtariFactory extends AtariValueFactory {
    public AtariFactory(ComputerState state) {
        super(state);
    }

    public AtariFactory(ComputerState state, ComputerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
