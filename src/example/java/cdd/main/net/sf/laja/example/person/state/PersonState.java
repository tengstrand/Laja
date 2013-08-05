package net.sf.laja.example.person.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MapState;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StateValidator;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class PersonState implements ImmutableState {
    public final String givenName;
    public final String surname;
    public final int heightInCentimeters;
    public final int weightInKilograms;

    public static class PersonValidator extends StateValidator {
        public PersonValidator(Object rootElement) { super(rootElement); }
        public PersonValidator(Object rootElement, String parent, ValidationErrors.Builder errors) { super(rootElement, parent, errors); }

        public void validate(PersonState state) {
        }

        public void validate(PersonMutableState state) {
        }
    }

    // ===== Generated code =====

    public static final String GIVEN_NAME = "givenName";
    public static final String SURNAME = "surname";
    public static final String HEIGHT_IN_CENTIMETERS = "heightInCentimeters";
    public static final String WEIGHT_IN_KILOGRAMS = "weightInKilograms";

    public PersonState(
            String givenName,
            String surname,
            int heightInCentimeters,
            int weightInKilograms) {
        this.givenName = givenName;
        this.surname = surname;
        this.heightInCentimeters = heightInCentimeters;
        this.weightInKilograms = weightInKilograms;

        if (givenName == null) throw new InvalidPersonStateException("'givenName' can not be null");
        if (surname == null) throw new InvalidPersonStateException("'surname' can not be null");

        PersonValidator validator = new PersonValidator(this);

        if (!validator.isValid()) {
            throw new InvalidPersonStateException(validator.errors());
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
    public int getHeightInCentimeters() { return heightInCentimeters; }
    public int getWeightInKilograms() { return weightInKilograms; }

    public PersonState withGivenName(String givenName) { return new PersonState(givenName, surname, heightInCentimeters, weightInKilograms); }
    public PersonState withSurname(String surname) { return new PersonState(givenName, surname, heightInCentimeters, weightInKilograms); }
    public PersonState withHeightInCentimeters(int heightInCentimeters) { return new PersonState(givenName, surname, heightInCentimeters, weightInKilograms); }
    public PersonState withWeightInKilograms(int weightInKilograms) { return new PersonState(givenName, surname, heightInCentimeters, weightInKilograms); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(
                givenName,
                surname,
                heightInCentimeters,
                weightInKilograms);
    }

    public PersonStringState asStringState() {
        return asMutable().asStringState();
    }

    public PersonStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public PersonStringState asStringState(PersonStringStateConverter converter) {
        return asMutable().asStringState(converter);
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
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        PersonState state = (PersonState)that;

        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (heightInCentimeters != state.heightInCentimeters) return false;
        if (weightInKilograms != state.weightInKilograms) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{givenName=" + (givenName == null ? null : '\"' + givenName + '\"' ) +
                ", surname=" + (surname == null ? null : '\"' + surname + '\"' ) +
                ", heightInCentimeters=" + heightInCentimeters +
                ", weightInKilograms=" + weightInKilograms + '}';
    }

    @State(type = "mutable")
    public static class PersonMutableState implements MutableState {
        public String givenName;
        public String surname;
        public int heightInCentimeters;
        public int weightInKilograms;

        public PersonMutableState() {
        }

        public PersonMutableState(
                String givenName,
                String surname,
                int heightInCentimeters,
                int weightInKilograms) {
            this.givenName = givenName;
            this.surname = surname;
            this.heightInCentimeters = heightInCentimeters;
            this.weightInKilograms = weightInKilograms;
        }

        public String getGivenName() { return givenName; }
        public String getSurname() { return surname; }
        public int getHeightInCentimeters() { return heightInCentimeters; }
        public int getWeightInKilograms() { return weightInKilograms; }

        public void setGivenName(String givenName) { this.givenName = givenName; }
        public void setSurname(String surname) { this.surname = surname; }
        public void setHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }
        public void setWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public PersonMutableState withGivenName(String givenName) { this.givenName = givenName; return this; }
        public PersonMutableState withSurname(String surname) { this.surname = surname; return this; }
        public PersonMutableState withHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; return this; }
        public PersonMutableState withWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public PersonState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new PersonState(
                    givenName,
                    surname,
                    heightInCentimeters,
                    weightInKilograms);
        }

        public PersonStringState asStringState() {
            return asStringState(new PersonStringStateConverter());
        }

        public PersonStringState asStringState(StringStateConverter converter) {
            return asStringState(new PersonStringStateConverter(converter));
        }

        public PersonStringState asStringState(PersonStringStateConverter converter) {
            return new PersonStringState(
                    converter.givenNameToString(givenName),
                    converter.surnameToString(surname),
                    converter.heightInCentimetersToString(heightInCentimeters),
                    converter.weightInKilogramsToString(weightInKilograms));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors, validators);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            if (givenName == null) errors.addIsNullError(rootElement, "givenName", parent);
            if (surname == null) errors.addIsNullError(rootElement, "surname", parent);

            new PersonValidator(rootElement, parent, errors).validate(this);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidPersonStateException(errors);
            }
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
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            PersonMutableState state = (PersonMutableState)that;

            if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
            if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
            if (heightInCentimeters != state.heightInCentimeters) return false;
            if (weightInKilograms != state.weightInKilograms) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{givenName=" + (givenName == null ? null : '\"' + givenName + '\"' ) +
                    ", surname=" + (surname == null ? null : '\"' + surname + '\"' ) +
                    ", heightInCentimeters=" + heightInCentimeters +
                    ", weightInKilograms=" + weightInKilograms + '}';
        }
    }

    @State(type = "map")
    public static class PersonMapState extends MapState {

        public PersonMapState() {
        }

        public PersonMapState(
                String givenName,
                String surname,
                int heightInCentimeters,
                int weightInKilograms) {
            put("givenName", givenName);
            put("surname", surname);
            put("heightInCentimeters", heightInCentimeters);
            put("weightInKilograms", weightInKilograms);
        }

        public String getGivenName() { return (String) get("givenName"); }
        public String getSurname() { return (String) get("surname"); }
        public int getHeightInCentimeters() { return (int) get("heightInCentimeters"); }
        public int getWeightInKilograms() { return (int) get("weightInKilograms"); }

        public void setGivenName(String givenName) { put("givenName", givenName); }
        public void setSurname(String surname) { put("surname", surname); }
        public void setHeightInCentimeters(int heightInCentimeters) { put("heightInCentimeters", heightInCentimeters); }
        public void setWeightInKilograms(int weightInKilograms) { put("weightInKilograms", weightInKilograms); }

        public PersonMapState withGivenName(String givenName) { put("givenName", givenName); return this; }
        public PersonMapState withSurname(String surname) { put("surname", surname); return this; }
        public PersonMapState withHeightInCentimeters(int heightInCentimeters) { put("heightInCentimeters", heightInCentimeters); return this; }
        public PersonMapState withWeightInKilograms(int weightInKilograms) { put("weightInKilograms", weightInKilograms); return this; }

        public PersonState asImmutable(Validator... validators) {
            return asMutable().asImmutable(validators);
        }

        public PersonMutableState asMutable() {
            return new PersonMutableState(
                    getGivenName(),
                    getSurname(),
                    getHeightInCentimeters(),
                    getWeightInKilograms());
        }
    }

    @State(type = "string")
    public static class PersonStringState implements StringState {
        public String givenName;
        public String surname;
        public String heightInCentimeters;
        public String weightInKilograms;

        public PersonStringState() {
        }

        public PersonStringState(
                String givenName,
                String surname,
                String heightInCentimeters,
                String weightInKilograms) {
            this.givenName = givenName;
            this.surname = surname;
            this.heightInCentimeters = heightInCentimeters;
            this.weightInKilograms = weightInKilograms;
        }

        public String getGivenName() { return givenName; }
        public String getSurname() { return surname; }
        public String getHeightInCentimeters() { return heightInCentimeters; }
        public String getWeightInKilograms() { return weightInKilograms; }

        public void setGivenName(String givenName) { this.givenName = givenName; }
        public void setSurname(String surname) { this.surname = surname; }
        public void setHeightInCentimeters(String heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }
        public void setWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public PersonStringState withGivenName(String givenName) { this.givenName = givenName; return this; }
        public PersonStringState withSurname(String surname) { this.surname = surname; return this; }
        public PersonStringState withHeightInCentimeters(String heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; return this; }
        public PersonStringState withWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public PersonState asImmutable() {
            return asMutable().asImmutable();
        }

        public PersonMutableState asMutable() {
            return asMutable(new PersonStringStateConverter());
        }

        public PersonMutableState asMutable(PersonStringStateConverter converter) {
            return new PersonMutableState(
                    converter.toGivenName(givenName),
                    converter.toSurname(surname),
                    converter.toHeightInCentimeters(heightInCentimeters),
                    converter.toWeightInKilograms(weightInKilograms));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new PersonStringStateValidator(), validators);
        }

        public ValidationErrors validate(PersonStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors, validators);
            return errors.build();
        }

        public void validate(PersonStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateValidator.validateGivenName(givenName, rootElement, parent, errors);
            stateValidator.validateSurname(surname, rootElement, parent, errors);
            stateValidator.validateHeightInCentimeters(heightInCentimeters, rootElement, parent, errors);
            stateValidator.validateWeightInKilograms(weightInKilograms, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new PersonStringStateValidator(), validators);
        }

        public void assertIsValid(PersonStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors errors = validate(stateValidator, validators);

            if (errors.isInvalid()) {
                throw new InvalidPersonStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = givenName != null ? givenName.hashCode() : 0;
            result = 31 * result + (surname != null ? surname.hashCode() : 0);
            result = 31 * result + (heightInCentimeters != null ? heightInCentimeters.hashCode() : 0);
            result = 31 * result + (weightInKilograms != null ? weightInKilograms.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            PersonStringState state = (PersonStringState)that;

            if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
            if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
            if (heightInCentimeters != null ? !heightInCentimeters.equals(state.heightInCentimeters) : state.heightInCentimeters != null) return false;
            if (weightInKilograms != null ? !weightInKilograms.equals(state.weightInKilograms) : state.weightInKilograms != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{givenName=" + (givenName == null ? null : '\"' + givenName + '\"' ) +
                    ", surname=" + (surname == null ? null : '\"' + surname + '\"' ) +
                    ", heightInCentimeters=" + (heightInCentimeters == null ? null : '\"' + heightInCentimeters + '\"' ) +
                    ", weightInKilograms=" + (weightInKilograms == null ? null : '\"' + weightInKilograms + '\"' ) + "}";
        }
    }

    public static class PersonStringStateConverter {
        private final StringStateConverter converter;

        public PersonStringStateConverter() { converter = new StringStateConverter(); }
        public PersonStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String givenNameToString(String givenName) { return givenName; }
        public String surnameToString(String surname) { return surname; }
        public String heightInCentimetersToString(int heightInCentimeters) { return converter.intToString(heightInCentimeters); }
        public String weightInKilogramsToString(int weightInKilograms) { return converter.intToString(weightInKilograms); }

        public String toGivenName(String givenName) { return givenName; }
        public String toSurname(String surname) { return surname; }
        public int toHeightInCentimeters(String heightInCentimeters) { return converter.toInt(heightInCentimeters); }
        public int toWeightInKilograms(String weightInKilograms) { return converter.toInt(weightInKilograms); }
    }

    public static class PersonStringStateValidator {
        private final PersonStringStateConverter converter;

        public PersonStringStateValidator() { converter = new PersonStringStateConverter(); }
        public PersonStringStateValidator(PersonStringStateConverter converter) { this.converter = converter; }

        public void validateGivenName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateSurname(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateHeightInCentimeters(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toHeightInCentimeters(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "heightInCentimeters", parent); }
        }

        public void validateWeightInKilograms(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toWeightInKilograms(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "weightInKilograms", parent); }
        }
    }
}
