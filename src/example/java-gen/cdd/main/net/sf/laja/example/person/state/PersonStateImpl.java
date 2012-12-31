package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.HeightState;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class PersonStateImpl implements PersonState {
    protected String givenName;
    protected String surname;
    protected int weightInKilograms;
    protected HeightState height;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    public BmiState getBmiState() {
        return new BmiState() {
            public Certificate certificate() { return certificate(); }
            public int getHeightInCentimeters() { return PersonStateImpl.this.height.getHeightInCentimeters(); }
            public void setHeightInCentimeters(int heightInCentimeters, Object mutator) { PersonStateImpl.this.height.setHeightInCentimeters(heightInCentimeters, mutator); }

            public int getWeightInKilograms() { return PersonStateImpl.this.weightInKilograms; }
            public void setWeightInKilograms(int weightInKilograms, Object mutator) { PersonStateImpl.this.setWeightInKilograms(weightInKilograms, mutator); }

            public void encapsulate() { PersonStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { PersonStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                return true;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                net.sf.laja.example.person.state.BmiState state = (net.sf.laja.example.person.state.BmiState)o;

                if (height.getHeightInCentimeters() != state.getHeightInCentimeters()) return false;
                if (weightInKilograms != state.getWeightInKilograms()) return false;

                return true;
            }

            public boolean valueEquals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                net.sf.laja.example.person.state.BmiState state = (net.sf.laja.example.person.state.BmiState)o;

                if (height.getHeightInCentimeters() != state.getHeightInCentimeters()) return false;
                if (weightInKilograms != state.getWeightInKilograms()) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = height.getHeightInCentimeters();
                result = 31 * result + weightInKilograms;

                return result;
            }

            public int valueHashCode() {
                int result = height.getHeightInCentimeters();
                result = 31 * result + weightInKilograms;

                return result;
            }

            @Override
            public String toString() {
                return "{heightInCentimeters=" + getHeightInCentimeters() +
                        ", weightInKilograms=" + getWeightInKilograms() + "}";
            }
        };
    }

    PersonStateImpl() {
    }

    public PersonStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static PersonStateBuilder build() {
        return new PersonStateBuilderImpl();
    }

    public static PersonStateBuilder build(PersonState state) {
        return new PersonStateBuilderImpl(state);
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
        if (givenName == null
           || surname == null
           || (height == null || !height.isValid())) {
            return false;
        }
        return true;
    }

    // Getters
    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public int getWeightInKilograms() { return weightInKilograms; }
    public HeightState getHeight() { return height; }

    // Setters
    public void setGivenName(String givenName, Object mutator) { checkMutator(mutator); this.givenName = givenName; }
    public void setSurname(String surname, Object mutator) { checkMutator(mutator); this.surname = surname; }
    public void setWeightInKilograms(int weightInKilograms, Object mutator) { checkMutator(mutator); this.weightInKilograms = weightInKilograms; }
    public void setHeight(HeightState height, Object mutator) { checkMutator(mutator); this.height = height; }

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

        PersonStateImpl state = (PersonStateImpl)o;

        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;
        if (height != null ? !height.equals(state.height) : state.height != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStateImpl state = (PersonStateImpl)o;

        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;
        if (height != null ? !height.equals(state.height) : state.height != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + weightInKilograms;
        result = 31 * result + (height != null ? height.hashCode() : 0);

        return result;
    }

    public int valueHashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + weightInKilograms;
        result = 31 * result + (height != null ? height.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                ", weightInKilograms=" + weightInKilograms +
                ", height=" + height + "}";
    }
}
