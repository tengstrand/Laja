package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerStateBuilder;

public class AtariSTFactory extends AtariValueFactory {
    public AtariSTFactory(ComputerState state) {
        super(state);
    }

    public AtariSTFactory(ComputerState state, ComputerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
