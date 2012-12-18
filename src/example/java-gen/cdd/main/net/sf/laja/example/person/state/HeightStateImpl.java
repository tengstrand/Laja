package net.sf.laja.example.person.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HeightStateImpl implements HeightState {
    protected int heightInCentimeters;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    HeightStateImpl() {
    }

    public HeightStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static HeightStateBuilder build() {
        return new HeightStateBuilderImpl();
    }

    public static HeightStateBuilder build(HeightState state) {
        return new HeightStateBuilderImpl(state);
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
        return true;
    }

    // Getters
    public int getHeightInCentimeters() { return heightInCentimeters; }

    // Setters
    public void setHeightInCentimeters(int heightInCentimeters, Object mutator) { checkMutator(mutator); this.heightInCentimeters = heightInCentimeters; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
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

        HeightStateImpl state = (HeightStateImpl)o;

        if (heightInCentimeters != state.getHeightInCentimeters()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeightStateImpl state = (HeightStateImpl)o;

        if (heightInCentimeters != state.getHeightInCentimeters()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = heightInCentimeters;

        return result;
    }

    public int valueHashCode() {
        int result = heightInCentimeters;

        return result;
    }

    @Override
    public String toString() {
        return "{heightInCentimeters=" + heightInCentimeters + "}";
    }
}
