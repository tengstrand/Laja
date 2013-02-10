package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.BmiStateImpl;
import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.BmiStateImpl;
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

            public int getHeightInCentimeters() { return PersonStateImpl.this.getHeightInCentimeters(); }
            public void setHeightInCentimeters(int heightInCentimeters, Object mutator) { PersonStateImpl.this.setHeightInCentimeters(heightInCentimeters, mutator); }

            public int getWeightInKilograms() { return PersonStateImpl.this.getWeightInKilograms(); }
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
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof PersonStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                BmiStateImpl state = (BmiStateImpl)value;

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
                return "{heightInCentimeters=" + heightInCentimeters +
                        ", weightInKilograms=" + weightInKilograms + "}";
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

        if (givenName != null ? !givenName.equals(state.getGivenName()) : state.getGivenName() != null) return false;
        if (surname != null ? !surname.equals(state.getSurname()) : state.getSurname() != null) return false;
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
