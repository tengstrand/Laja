package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.DirectoryState;
import net.sf.laja.example.file.state.DirectoryStateBuilder;

public class DirectoryFactory extends DirectoryValueFactory {
    public DirectoryFactory(DirectoryState state) {
        super(state);
    }

    public DirectoryFactory(DirectoryState state, DirectoryStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
