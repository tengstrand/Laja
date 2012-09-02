package net.sf.laja.example.file.state;

import net.sf.laja.example.file.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class DirectoryStateBuilderImpl implements DirectoryStateBuilder {
    private boolean encapsulated;
    private DirectoryState state;
    private final Certificate certificate;
    private boolean trusted;

    DirectoryStateBuilderImpl() {
        state = new DirectoryStateImpl();
        certificate = Certificate.get(this);
    }

    public DirectoryStateBuilderImpl(DirectoryState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withDirectoryPath(String directoryPath) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setDirectoryPath(directoryPath);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Directory\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(DirectoryStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public DirectoryState getDirectoryState(net.sf.laja.example.file.state.Certificate certificate) {
        return state;
    }
}
