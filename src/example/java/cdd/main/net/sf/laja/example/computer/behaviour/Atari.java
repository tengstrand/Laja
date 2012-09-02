package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.ComputerState;

public class Atari extends AtariFactory {
    public Atari(ComputerState state) {
        super(state);
    }

    // (factory)
    public AtariST asAtariST() {
        return new AtariST(state);
    }

    // (factory)
    public AtariFalcon030 asAtariFalcon030() {
        return new AtariFalcon030(state);
    }
}
