package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class PersonStateImpl implements PersonState {
    protected String givenName;
    protected String surname;
    protected int heightInCentimeters;
    protected int weightInKilograms;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    public BmiState getSizeState() {
        return new BmiState() {
            public Certificate certificate() { return certificate(); }
            public int getHeightInCentimeters() { return 0; /* missing attribute 'heightInCentimeters' */ }
            public void setHeightInCentimeters(int heightInCentimeters, Object mutator) { /* missing attribute 'heightInCentimeters' */ }

            public int getWeightInKilograms() { return 0; /* missing attribute 'weightInKilograms' */ }
            public void setWeightInKilograms(int weightInKilograms, Object mutator) { /* missing attribute 'weightInKilograms' */ }

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
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof PersonStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                net.sf.laja.example.person.state.BmiState state = (net.sf.laja.example.person.state.BmiState)value;

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
           || surname == null) {
            return false;
        }
        return true;
    }

    // Getters
    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public int getHeightInCentimeters() { return heightInCentimeters; }
    public int getWeightInKilograms() { return weightInKilograms; }

    // Setters
    public void setGivenName(String givenName, Object mutator) { checkMutator(mutator); this.givenName = givenName; }
    public void setSurname(String surname, Object mutator) { checkMutator(mutator); this.surname = surname; }
    public void setHeightInCentimeters(int heightInCentimeters, Object mutator) { checkMutator(mutator); this.heightInCentimeters = heightInCentimeters; }
    public void setWeightInKilograms(int weightInKilograms, Object mutator) { checkMutator(mutator); this.weightInKilograms = weightInKilograms; }

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
    public boolean equals(Object that) {
       if (this == that) return true;
       if (!(that instanceof PersonStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        PersonStateImpl state = (PersonStateImpl)value;

        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (heightInCentimeters != state.getHeightInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + heightInCentimeters;
        result = 31 * result + weightInKilograms;

        return result;
    }

    @Override
    public String toString() {
        return "{givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                ", heightInCentimeters=" + heightInCentimeters +
                ", weightInKilograms=" + weightInKilograms + "}";
    }
}
