package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;

public class AmigaCreator {
    private final ComputerStateBuilder builder = ComputerStateImpl.build();

    public class Owner_ {
        public AmigaEncapsulator owner(String owner) {
            builder.withOwner(owner);
            return create();
        }
    }

    public AmigaEncapsulator create() {
        return new AmigaEncapsulator(builder);
     }
}
