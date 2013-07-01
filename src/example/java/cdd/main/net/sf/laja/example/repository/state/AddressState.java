package net.sf.laja.example.repository.state;

import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.repository.state.ZipcodeState.ZipcodeMutableState;

@State
public class AddressState implements ImmutableState {
    @Id public final int addressId;
    public final String streetName;
    public final ZipcodeState zipcode;
    public final String city;

    public boolean isValid() {
        return city.length() > 0 && Character.isLetter(city.subSequence(0, 1).charAt(0));
    }

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String ADDRESS_ID = "addressId";
    public static final String STREET_NAME = "streetName";
    public static final String ZIPCODE = "zipcode";
    public static final String CITY = "city";

    public AddressState(
            int addressId,
            String streetName,
            ZipcodeState zipcode,
            String city) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.zipcode = zipcode;
        this.city = city;

        if (streetName == null) throw new IllegalAddressStateException("'streetName' can not be null");
        if (zipcode == null) throw new IllegalAddressStateException("'zipcode' can not be null");
        if (city == null) throw new IllegalAddressStateException("'city' can not be null");

        assertIsValid();
    }

    public static class IllegalAddressStateException extends InvalidStateException {
        public IllegalAddressStateException(String message) {
            super(message);
        }

        public IllegalAddressStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getAddressId() { return addressId; }
    public String getStreetName() { return streetName; }
    public ZipcodeState getZipcode() { return zipcode; }
    public String getCity() { return city; }

    public AddressState withAddressId(int addressId) { return new AddressState(addressId, streetName, zipcode, city); }
    public AddressState withStreetName(String streetName) { return new AddressState(addressId, streetName, zipcode, city); }
    public AddressState withZipcode(ZipcodeState zipcode) { return new AddressState(addressId, streetName, zipcode, city); }
    public AddressState withCity(String city) { return new AddressState(addressId, streetName, zipcode, city); }

    public AddressMutableState asMutable() {
        return new AddressMutableState(
                addressId,
                streetName,
                zipcode.asMutable(),
                city);
    }

    @Override
    public int hashCode() {
        int result = addressId;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AddressState state = (AddressState)that;

        if (addressId != state.addressId) return false;

        return true;
    }

    public int hashCodeValue() {
        int result = addressId;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);

        return result;
    }

    public boolean equalsValue(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AddressState state = (AddressState)that;

        if (addressId != state.addressId) return false;
        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (zipcode != null ? !zipcode.equals(state.zipcode) : state.zipcode != null) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{addressId=" + addressId +
                ", streetName=" + (streetName == null ? null : '\'' + streetName + '\'' ) +
                ", zipcode=" + zipcode +
                ", city='" + city + "'}";
    }

    @State(type = "mutable")
    public static class AddressMutableState implements MutableState {
        @Id public int addressId;
        public String streetName;
        public ZipcodeMutableState zipcode;
        public String city;

        public AddressMutableState() {
            zipcode = new ZipcodeMutableState();
        }

        public AddressMutableState(
                int addressId,
                String streetName,
                ZipcodeMutableState zipcode,
                String city) {
            this.addressId = addressId;
            this.streetName = streetName;
            this.zipcode = zipcode;
            this.city = city;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public int getAddressId() { return addressId; }
        public String getStreetName() { return streetName; }
        public ZipcodeMutableState getZipcode() { return zipcode; }
        public String getCity() { return city; }

        public void setAddressId(int addressId) { this.addressId = addressId; }
        public void setStreetName(String streetName) { this.streetName = streetName; }
        public void setZipcode(ZipcodeMutableState zipcode) { this.zipcode = zipcode; }
        public void setCity(String city) { this.city = city; }

        public AddressMutableState withAddressId(int addressId) { this.addressId = addressId; return this; }
        public AddressMutableState withStreetName(String streetName) { this.streetName = streetName; return this; }
        public AddressMutableState withZipcode(ZipcodeMutableState zipcode) { this.zipcode = zipcode; return this; }
        public AddressMutableState withCity(String city) { this.city = city; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new IllegalAddressStateException(errors);
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
            if (streetName == null) errors.addIsNullError(rootElement, parent, "streetName");
            if (zipcode == null) errors.addIsNullError(rootElement, parent, "zipcode");
            if (city == null) errors.addIsNullError(rootElement, parent, "city");

            if (zipcode != null) zipcode.validate(rootElement, concatenate(parent, "zipcode"), errors);

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public AddressState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new AddressState(
                    addressId,
                    streetName,
                    zipcode != null ? zipcode.asImmutable() : null,
                    city);
        }

        @Override
        public int hashCode() {
            int result = addressId;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AddressMutableState state = (AddressMutableState)that;

            if (addressId != state.addressId) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{addressId=" + addressId +
                    ", streetName=" + (streetName == null ? null : '\'' + streetName + '\'' ) +
                    ", zipcode=" + zipcode +
                    ", city='" + city + "'}";
        }
    }
}
