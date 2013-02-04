package net.sf.laja.example.computer.state;

import net.sf.laja.example.computer.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ComputerBehaviour implements ComputerStateComparable {
    protected final ComputerState state;
    protected ComputerStateBuilder stateBuilder;

    public ComputerBehaviour(ComputerState state) {
        this.state = state;
        state.setEncapsulator(this);
    }

    public ComputerBehaviour(ComputerState state, ComputerStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
        state.setEncapsulator(this);
    }

    public ComputerState getState(Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null!");
        }
        return state;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComputerStateComparable)) return false;
        return state.equals(obj);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + state;
    }
}
