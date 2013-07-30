package net.sf.laja.cdd.testgen.state;

import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class AddressState implements ImmutableState {
    @Id
    public final int id;
    @Optional
    public final String streetName;
    @Optional
    public final String city;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String ID = "id";
    public static final String STREET_NAME = "streetName";
    public static final String CITY = "city";

    public AddressState(
            int id,
            String streetName,
            String city) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidAddressStateException(message);
        }
    }

    public static class InvalidAddressStateException extends InvalidStateException {
        public InvalidAddressStateException(String message) {
            super(message);
        }

        public InvalidAddressStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getId() { return id; }
    public String getStreetName() { return streetName; }
    public String getCity() { return city; }

    public AddressState withId(int id) { return new AddressState(id, streetName, city); }
    public AddressState withStreetName(String streetName) { return new AddressState(id, streetName, city); }
    public AddressState withCity(String city) { return new AddressState(id, streetName, city); }

    public AddressMutableState asMutable() {
        return new AddressMutableState(
                id,
                streetName,
                city);
    }

    @Override
    public int hashCode() {
        int result = id;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AddressState state = (AddressState)that;

        if (id != state.id) return false;

        return true;
    }

    public int hashCodeValue() {
        int result = id;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);

        return result;
    }

    public boolean equalsValue(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AddressState state = (AddressState)that;

        if (id != state.id) return false;
        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", streetName=" + (streetName == null ? null : '\"' + streetName + '\"' ) +
                ", city=" + (city == null ? null : '\"' + city + '\"' ) + "}";
    }

    @State(type = "mutable")
    public static class AddressMutableState implements MutableState {
        @Id
        public int id;
        @Optional
        public String streetName;
        @Optional
        public String city;

        public AddressMutableState() {
        }

        public AddressMutableState(
                int id,
                String streetName,
                String city) {
            this.id = id;
            this.streetName = streetName;
            this.city = city;
        }

        public int getId() { return id; }
        public String getStreetName() { return streetName; }
        public String getCity() { return city; }

        public void setId(int id) { this.id = id; }
        public void setStreetName(String streetName) { this.streetName = streetName; }
        public void setCity(String city) { this.city = city; }

        public AddressMutableState withId(int id) { this.id = id; return this; }
        public AddressMutableState withStreetName(String streetName) { this.streetName = streetName; return this; }
        public AddressMutableState withCity(String city) { this.city = city; return this; }

        public AddressState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new AddressState(
                    id,
                    streetName,
                    city);
        }

        public AddressStringState asStringState() {
            return asStringState(new StringStateConverter());
        }

        public AddressStringState asStringState(StringStateConverter c) {
            return new AddressStringState(
                    c.intToString(id),
                    streetName,
                    city);
        }

        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
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
            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidAddressStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = id;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AddressMutableState state = (AddressMutableState)that;

            if (id != state.id) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{id=" + id +
                    ", streetName=" + (streetName == null ? null : '\"' + streetName + '\"' ) +
                    ", city=" + (city == null ? null : '\"' + city + '\"' ) + "}";
        }
    }

    @State(type = "string")
    public static class AddressStringState implements MutableStringState {
        @Id
        public String id;
        @Optional
        public String streetName;
        @Optional
        public String city;

        public AddressStringState() {
        }

        public AddressStringState(
                String id,
                String streetName,
                String city) {
            this.id = id;
            this.streetName = streetName;
            this.city = city;
        }

        public String getId() { return id; }
        public String getStreetName() { return streetName; }
        public String getCity() { return city; }

        public void setId(String id) { this.id = id; }
        public void setStreetName(String streetName) { this.streetName = streetName; }
        public void setCity(String city) { this.city = city; }

        public AddressStringState withId(String id) { this.id = id; return this; }
        public AddressStringState withStreetName(String streetName) { this.streetName = streetName; return this; }
        public AddressStringState withCity(String city) { this.city = city; return this; }

        public AddressState asImmutable() {
            return asMutable().asImmutable();
        }

        public AddressMutableState asMutable() {
            return asMutable(new AddressStringStateConverter());
        }

        public AddressMutableState asMutable(AddressStringStateConverter converter) {
            return new AddressMutableState(
                    converter.toId(id),
                    converter.toStreetName(streetName),
                    converter.toCity(city));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new AddressStringStateValidator(), validators);
        }

        public ValidationErrors validate(AddressStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors, validators);
            return errors.build();
        }

        public void validate(AddressStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateValidator.validateId(id, rootElement, parent, errors);
            stateValidator.validateStreetName(streetName, rootElement, parent, errors);
            stateValidator.validateCity(city, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new AddressStringStateValidator(), validators);
        }

        public void assertIsValid(AddressStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors errors = validate(stateValidator, validators);

            if (errors.isInvalid()) {
                throw new InvalidAddressStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AddressStringState state = (AddressStringState)that;

            if (id != null ? !id.equals(state.id) : state.id != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{id=" + (id == null ? null : '\"' + id + '\"' ) +
                    ", streetName=" + (streetName == null ? null : '\"' + streetName + '\"' ) +
                    ", city=" + (city == null ? null : '\"' + city + '\"' ) + "}";
        }
    }

    public static class AddressStringStateConverter {
        private final StringStateConverter c;

        public AddressStringStateConverter() { c = new StringStateConverter(); }
        public AddressStringStateConverter(StringStateConverter converter) { c = converter; }

        public int toId(String id) { return c.toInt(id); }
        public String toStreetName(String streetName) { return streetName; }
        public String toCity(String city) { return city; }
    }

    public static class AddressStringStateValidator {
        private final AddressStringStateConverter c;

        public AddressStringStateValidator() { this.c = new AddressStringStateConverter(); }
        public AddressStringStateValidator(AddressStringStateConverter converter) { this.c = converter; }

        public void validateId(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { c.toId(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, parent, "id"); }
        }

        public void validateStreetName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateCity(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
