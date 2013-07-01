package net.sf.laja.example.person.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.person.state.BmiState.BmiMutableState;

@State
public class PersonState implements ImmutableState {
    public final String givenName;
    public final String surname;
    public final BmiState size;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String GIVEN_NAME = "givenName";
    public static final String SURNAME = "surname";
    public static final String SIZE = "size";

    public PersonState(
            String givenName,
            String surname,
            BmiState size) {
        this.givenName = givenName;
        this.surname = surname;
        this.size = size;

        if (givenName == null) throw new InvalidPersonStateException("'givenName' can not be null");
        if (surname == null) throw new InvalidPersonStateException("'surname' can not be null");
        if (size == null) throw new InvalidPersonStateException("'size' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidPersonStateException(message);
        }
    }

    public static class InvalidPersonStateException extends InvalidStateException {
        public InvalidPersonStateException(String message) {
            super(message);
        }

        public InvalidPersonStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public BmiState getSize() { return size; }

    public PersonState withGivenName(String givenName) { return new PersonState(givenName, surname, size); }
    public PersonState withSurname(String surname) { return new PersonState(givenName, surname, size); }
    public PersonState withSize(BmiState size) { return new PersonState(givenName, surname, size); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(
                givenName,
                surname,
                size.asMutable());
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        PersonState state = (PersonState)that;

        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (size != null ? !size.equals(state.size) : state.size != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                ", size=" + size + '}';
    }

    @State(type = "mutable")
    public static class PersonMutableState implements MutableState {
        public String givenName;
        public String surname;
        public BmiMutableState size;

        public PersonMutableState() {
            size = new BmiMutableState();
        }

        public PersonMutableState(
                String givenName,
                String surname,
                BmiMutableState size) {
            this.givenName = givenName;
            this.surname = surname;
            this.size = size;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public String getGivenName() { return givenName; }
        public String getSurname() { return surname; }
        public BmiMutableState getSize() { return size; }

        public void setGivenName(String givenName) { this.givenName = givenName; }
        public void setSurname(String surname) { this.surname = surname; }
        public void setSize(BmiMutableState size) { this.size = size; }

        public PersonMutableState withGivenName(String givenName) { this.givenName = givenName; return this; }
        public PersonMutableState withSurname(String surname) { this.surname = surname; return this; }
        public PersonMutableState withSize(BmiMutableState size) { this.size = size; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidPersonStateException(errors);
            }
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors, validators);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            if (givenName == null) errors.addIsNullError(rootElement, parent, "givenName");
            if (surname == null) errors.addIsNullError(rootElement, parent, "surname");
            if (size == null) errors.addIsNullError(rootElement, parent, "size");

            if (size != null) size.validate(rootElement, concatenate(parent, "size"), errors);

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public PersonState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new PersonState(
                    givenName,
                    surname,
                    size != null ? size.asImmutable() : null);
        }

        @Override
        public int hashCode() {
            int result = givenName != null ? givenName.hashCode() : 0;
            result = 31 * result + (surname != null ? surname.hashCode() : 0);
            result = 31 * result + (size != null ? size.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            PersonMutableState state = (PersonMutableState)that;

            if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
            if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
            if (size != null ? !size.equals(state.size) : state.size != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                    ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                    ", size=" + size + '}';
        }
    }
}
