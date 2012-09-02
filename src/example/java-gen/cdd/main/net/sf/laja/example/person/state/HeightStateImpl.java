package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HeightStateImpl implements HeightState {
    protected int heightInCentimeters;

    private boolean _encapsulated = false;

    HeightStateImpl() {
    }

    public static HeightStateBuilder build() {
        return new HeightStateBuilderImpl();
    }

    public static HeightStateBuilder build(HeightState state) {
        return new HeightStateBuilderImpl(state);
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
    public void setHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }

    public void encapsulate() {
        _encapsulated = true;
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
