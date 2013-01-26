package net.sf.laja.example.computer.state;

import net.sf.laja.example.computer.state.ComputerStateImpl;
import net.sf.laja.example.computer.state.ComputerStateHashSet;
import net.sf.laja.example.computer.state.ComputerStateArrayList;
import net.sf.laja.example.computer.state.ComputerStateBuilderImpl;

/**
 * Code generated by Laja - Do not change!
 * Version: laja2-006-alpha
 *
 *   http://laja.tengstrand.nu
 */
public final class Certificate {
    Certificate() {
    }

    private static Certificate certificate(Object state) {
        if (state == null) {
            throw new IllegalArgumentException();
        }
        return new Certificate();
    }

    public static Certificate get(ComputerStateImpl state) { return certificate(state); }
    public static Certificate get(ComputerStateHashSet state) { return certificate(state); }
    public static Certificate get(ComputerStateArrayList state) { return certificate(state); }
    public static Certificate get(ComputerStateBuilderImpl state) { return certificate(state); }
}
