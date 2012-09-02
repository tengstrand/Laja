package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;

public class AmigaTemplate extends ComputerValue {
    public AmigaTemplate(ComputerState state) {
        super(state);
    }

    // (factory)
    public Amiga asAmiga(Configuration context) {
        if (context == Configuration.FAST) {
            return new Amiga4000(state);
        }
        return new Amiga500(state);
    }
}
