package net.sf.laja.cdd.state;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.InvalidStateException;
import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.validator.Validator;

@State(version = 1)
public class AddressState implements ImmutableState {
    @Id
    public final int id;
    public final String streetName;
    @Optional
    public final String city;

    private static void setDefaults(AddressMutableState state) {
    }

    private static void validate(AddressMutableState state, Object rootElement, String parent, ValidationErrors.Builder errors) {
    }

    // ------ Generated code ------

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
    }

    public static class IllegalAddressStateException extends InvalidStateException {
        public IllegalAddressStateException(ValidationErrors errors) {
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
        int result = streetName != null ? streetName.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AddressState state = (AddressState)that;

        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;

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

    @State(version = 1, type = "mutable")
    public static class AddressMutableState implements MutableState {
        @Id
        public int id;
        public String streetName;
        @Optional
        public String city;

        public AddressMutableState() {
            AddressState.setDefaults(this);
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

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.hasErrors()) {
                throw new IllegalAddressStateException(errors);
            }
        }

        public boolean isValid() {
            return validate().isEmpty();
        }

        public ValidationErrors validate(Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors, validators);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            if (streetName == null) { errors.addIsNullError(rootElement, parent, "streetName"); }

            AddressState.validate(this, rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public AddressState asImmutable() {
            assertIsValid();

            return new AddressState(
                id,
                streetName,
                city);
        }

        @Override
        public int hashCode() {
            int result = streetName != null ? streetName.hashCode() : 0;
            result = 31 * result + (city != null ? city.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AddressMutableState state = (AddressMutableState)that;

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
    }
}
