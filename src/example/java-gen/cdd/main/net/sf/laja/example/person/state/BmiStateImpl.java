package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BmiStateImpl implements BmiState {
    protected int heightInCentimeters;
    protected int weightInKilograms;

    private boolean _encapsulated = false;

    BmiStateImpl() {
    }

    public static BmiStateBuilder build() {
        return new BmiStateBuilderImpl();
    }

    public static BmiStateBuilder build(BmiState state) {
        return new BmiStateBuilderImpl(state);
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
    public int getWeightInKilograms() { return weightInKilograms; }

    // Setters
    public void setHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }
    public void setWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; }

    public void encapsulate() {
        _encapsulated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BmiStateImpl state = (BmiStateImpl)o;

        if (heightInCentimeters != state.getHeightInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BmiStateImpl state = (BmiStateImpl)o;

        if (heightInCentimeters != state.getHeightInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = heightInCentimeters;
        result = 31 * result + weightInKilograms;

        return result;
    }

    public int valueHashCode() {
        int result = heightInCentimeters;
        result = 31 * result + weightInKilograms;

        return result;
    }

    @Override
    public String toString() {
        return "{heightInCentimeters=" + heightInCentimeters +
                ", weightInKilograms=" + weightInKilograms + "}";
    }
}
