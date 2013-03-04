package net.sf.laja.example.computer.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ComputerStateBuilderImpl implements ComputerStateBuilder {
    private Object encapsulator;
    private ComputerState state;
    private final Certificate certificate;

    ComputerStateBuilderImpl() {
        state = new ComputerStateImpl();
        certificate = Certificate.get(this);
    }

    public ComputerStateBuilderImpl(ComputerState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public ComputerStateBuilderImpl(ComputerState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withName(String name) {
        state.setName(name, encapsulator);
    }

    public void withProcessor(String processor) {
        state.setProcessor(processor, encapsulator);
    }

    public void withReleaseYear(int releaseYear) {
        state.setReleaseYear(releaseYear, encapsulator);
    }

    public void withMemoryInKilobytes(int memoryInKilobytes) {
        state.setMemoryInKilobytes(memoryInKilobytes, encapsulator);
    }

    public void withOwner(String owner) {
        state.setOwner(owner, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(ComputerBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public ComputerState getComputerState(net.sf.laja.example.computer.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComputerStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
