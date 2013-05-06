package net.sf.laja.cdd.state;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.InvalidStateException;
import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressState implements ImmutableState {
    public final int id; // (id)
    public final String streetName;
    public final String city; // (optional)

    private static void setDefaults(AddressMutableState state) {
    }

    private static void validate(AddressMutableState state, Object rootElement, String parent, ValidationErrors.Builder errors) {
    }

    // ------ Generated code ------

    public static final String ID = "id";
    public static final String STREET_NAME = "streetName";
    public static final String CITY = "city";

    public AddressState(int id, String streetName, String city) {
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

    public AddressMutableState asMutable() {
        return new AddressMutableState(id, streetName, city);
    }

    public AddressState withAge(int id) { return new AddressState(id, streetName, city); }
    public AddressState withStreetName(String streetName) { return new AddressState(id, streetName, city); }
    public AddressState withCity(String city) { return new AddressState(id, streetName, city); }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressState that = (AddressState) o;

        if (id != that.id) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (streetName != null ? !streetName.equals(that.streetName) : that.streetName != null) return false;

        return true;
    }

    public String toString() {
        return "{id=" + id + ", streetName='" + streetName + "\', city='" + city + "\'}";
    }

    public static class AddressMutableState implements MutableState {
        public int id; // (id)
        public String streetName;
        public String city; // (optional)

        public AddressMutableState() {
            setDefaults(this);
        }

        public AddressMutableState(int id, String streetName, String city) {
            this.id = id;
            this.streetName = streetName;
            this.city = city;
        }

        public static AddressMutableState addressMutableState() {
            return new AddressMutableState();
        }

        public static List<AddressMutableState> addressMutableStateArrayList(AddressMutableState... states) {
            return new ArrayList<AddressMutableState>(Arrays.asList(states));
        }

        public static Set<AddressMutableState> addressMutableStateHashSet(AddressMutableState... states) {
            return new HashSet<AddressMutableState>(Arrays.asList(states));
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

            return new AddressState(id, streetName, city);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
            result = 31 * result + (city != null ? city.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AddressMutableState that = (AddressMutableState) o;

            if (id != that.id) return false;
            if (city != null ? !city.equals(that.city) : that.city != null) return false;
            if (streetName != null ? !streetName.equals(that.streetName) : that.streetName != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{id=" + id + ", streetName='" + streetName + "\', city='" + city + "\'}";
        }
    }
}
