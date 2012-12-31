package net.sf.laja.example.computer.state;

import net.sf.laja.example.computer.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ComputerStateImpl implements ComputerState {
    protected String name; // (hide)
    protected String processor; // (hide)
    protected int releaseYear; // (hide)
    protected int memoryInKilobytes; // (hide)
    protected String owner;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    ComputerStateImpl() {
    }

    public ComputerStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static ComputerStateBuilder build() {
        return new ComputerStateBuilderImpl();
    }

    public static ComputerStateBuilder build(ComputerState state) {
        return new ComputerStateBuilderImpl(state);
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if ((encapsulated && name == null)
           || (encapsulated && processor == null)
           || owner == null) {
            return false;
        }
        return releaseYear > 0 && memoryInKilobytes > 0;
    }

    // Getters
    public String getName() { return name; }
    public String getProcessor() { return processor; }
    public int getReleaseYear() { return releaseYear; }
    public int getMemoryInKilobytes() { return memoryInKilobytes; }
    public String getOwner() { return owner; }

    // Setters
    public void setName(String name, Object mutator) { checkMutator(mutator); this.name = name; }
    public void setProcessor(String processor, Object mutator) { checkMutator(mutator); this.processor = processor; }
    public void setReleaseYear(int releaseYear, Object mutator) { checkMutator(mutator); this.releaseYear = releaseYear; }
    public void setMemoryInKilobytes(int memoryInKilobytes, Object mutator) { checkMutator(mutator); this.memoryInKilobytes = memoryInKilobytes; }
    public void setOwner(String owner, Object mutator) { checkMutator(mutator); this.owner = owner; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by current instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
        }
    }


    public void encapsulate() {
        _encapsulated = true;
    }

    public void setEncapsulator(Object encapsulator) {
        _encapsulator = encapsulator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerStateImpl state = (ComputerStateImpl)o;

        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (processor != null ? !processor.equals(state.processor) : state.processor != null) return false;
        if (releaseYear != state.getReleaseYear()) return false;
        if (memoryInKilobytes != state.getMemoryInKilobytes()) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerStateImpl state = (ComputerStateImpl)o;

        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (processor != null ? !processor.equals(state.processor) : state.processor != null) return false;
        if (releaseYear != state.getReleaseYear()) return false;
        if (memoryInKilobytes != state.getMemoryInKilobytes()) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (processor != null ? processor.hashCode() : 0);
        result = 31 * result + releaseYear;
        result = 31 * result + memoryInKilobytes;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);

        return result;
    }

    public int valueHashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (processor != null ? processor.hashCode() : 0);
        result = 31 * result + releaseYear;
        result = 31 * result + memoryInKilobytes;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{name=" + (name == null ? null : '\'' + name + '\'' ) +
                ", processor=" + (processor == null ? null : '\'' + processor + '\'' ) +
                ", releaseYear=" + releaseYear +
                ", memoryInKilobytes=" + memoryInKilobytes +
                ", owner='" + owner + '\'' + "}";
    }
}
