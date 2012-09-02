package net.sf.laja.example.file.state;

import net.sf.laja.example.file.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class DirectoryStateImpl implements DirectoryState {
    protected String directoryPath;

    private boolean _encapsulated = false;

    DirectoryStateImpl() {
    }

    public static DirectoryStateBuilder build() {
        return new DirectoryStateBuilderImpl();
    }

    public static DirectoryStateBuilder build(DirectoryState state) {
        return new DirectoryStateBuilderImpl(state);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if (directoryPath == null) {
            return false;
        }
        return true;
    }

    // Getters
    public String getDirectoryPath() { return directoryPath; }

    // Setters
    public void setDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; }

    public void encapsulate() {
        _encapsulated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectoryStateImpl state = (DirectoryStateImpl)o;

        if (directoryPath != null ? !directoryPath.equals(state.directoryPath) : state.directoryPath != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectoryStateImpl state = (DirectoryStateImpl)o;

        if (directoryPath != null ? !directoryPath.equals(state.directoryPath) : state.directoryPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directoryPath != null ? directoryPath.hashCode() : 0;

        return result;
    }

    public int valueHashCode() {
        int result = directoryPath != null ? directoryPath.hashCode() : 0;

        return result;
    }

    @Override
    public String toString() {
        return "{directoryPath=" + directoryPath + "}";
    }
}
