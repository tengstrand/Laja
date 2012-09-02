package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariCreator {
    private final ComputerStateBuilder builder = ComputerStateImpl.build();

    public class Owner_ {
        public AtariEncapsulator owner(String owner) {
            builder.withOwner(owner);
            return create();
        }
    }

    public AtariEncapsulator create() {
        return new AtariEncapsulator(builder);
     }
}
