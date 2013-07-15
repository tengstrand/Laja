package net.sf.laja.cdd.state;

import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
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
                ", streetName=" + (streetName == null ? null : '\'' + streetName + '\'' ) +
                ", city='" + city + "'}";
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

        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
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

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidAddressStateException(errors);
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
            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public AddressState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new AddressState(
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

            AddressMutableState state = (AddressMutableState)that;

            if (id != state.id) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{id=" + id +
                    ", streetName=" + (streetName == null ? null : '\'' + streetName + '\'' ) +
                    ", city='" + city + "'}";
        }
    }
}
