package net.sf.laja.example.file.state;

import net.sf.laja.example.file.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class DirectoryStateBuilderImpl implements DirectoryStateBuilder {
    private Object encapsulator;
    private DirectoryState state;
    private final Certificate certificate;

    DirectoryStateBuilderImpl() {
        state = new DirectoryStateImpl();
        certificate = Certificate.get(this);
    }

    public DirectoryStateBuilderImpl(DirectoryState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public DirectoryStateBuilderImpl(DirectoryState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withDirectoryPath(String directoryPath) {
        state.setDirectoryPath(directoryPath, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(DirectoryBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public DirectoryState getDirectoryState(net.sf.laja.example.file.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DirectoryStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
