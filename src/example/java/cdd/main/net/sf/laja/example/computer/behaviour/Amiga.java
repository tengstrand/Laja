package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.Certificate;
import net.sf.laja.example.computer.state.ComputerState;
import net.sf.laja.example.computer.state.ComputerStateList;

public interface Amiga {
    public boolean hasFastFloatingPointUnit();
    ComputerState getState(Certificate certificate);
}
