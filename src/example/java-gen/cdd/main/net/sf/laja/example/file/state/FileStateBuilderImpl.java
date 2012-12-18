package net.sf.laja.example.file.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class FileStateBuilderImpl implements FileStateBuilder {
    private boolean encapsulated;
    private FileState state;
    private final Certificate certificate;
    private boolean trusted;

    FileStateBuilderImpl() {
        state = new FileStateImpl();
        certificate = Certificate.get(this);
    }

    public FileStateBuilderImpl(FileState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withFilename(String filename) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setFilename(filename, null);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"File\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(FileStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public FileState getFileState(net.sf.laja.example.file.state.Certificate certificate) {
        return state;
    }
}
