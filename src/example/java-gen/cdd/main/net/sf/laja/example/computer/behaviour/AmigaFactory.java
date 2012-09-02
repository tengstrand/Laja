package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerStateBuilder;

public class AmigaFactory extends AmigaValueFactory {
    public AmigaFactory(ComputerState state) {
        super(state);
    }

    public AmigaFactory(ComputerState state, ComputerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
