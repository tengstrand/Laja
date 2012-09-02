package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class OwnerStateImpl implements OwnerState {
    protected long ssn;
    protected String name;

    private boolean _encapsulated = false;

    OwnerStateImpl() {
    }

    public static OwnerStateBuilder build() {
        return new OwnerStateBuilderImpl();
    }

    public static OwnerStateBuilder build(OwnerState state) {
        return new OwnerStateBuilderImpl(state);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if (name == null) {
            return false;
        }
        return ssn >= 190000000000L;
    }

    // Getters
    public long getSsn() { return ssn; }
    public String getName() { return name; }

    // Setters
    public void setSsn(long ssn) { this.ssn = ssn; }
    public void setName(String name) { this.name = name; }

    public void encapsulate() {
        _encapsulated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerStateImpl state = (OwnerStateImpl)o;

        if (ssn != state.getSsn()) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerStateImpl state = (OwnerStateImpl)o;

        if (ssn != state.getSsn()) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)ssn;
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }

    public int valueHashCode() {
        int result = (int)ssn;
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{ssn=" + ssn +
                ", name='" + name + '\'' + "}";
    }
}
