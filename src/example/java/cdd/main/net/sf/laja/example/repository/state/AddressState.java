package net.sf.laja.example.repository.state;

import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.StateValidator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class AddressState implements ImmutableState {
    @Id public final int addressId;
    public final String streetName;
    public final int zipcode;
    public final String city;

    public static class AddressValidator extends StateValidator {
        public AddressValidator(Object rootElement) { super(rootElement); }
        public AddressValidator(Object rootElement, String parent, ValidationErrors.Builder errors) { super(rootElement, parent, errors); }

        public void validate(AddressState state) {
            validateCity(state.city);
        }

        public void validate(AddressMutableState state) {
            validateCity(state.city);
        }

        private void validateCity(String city) {
            if (city.length() == 0 || !Character.isLetter(city.subSequence(0, 1).charAt(0))) {
                addError(CITY, "illegal-city");
            }
        }
    }

    // ===== Generated code =====

    public static final String ADDRESS_ID = "addressId";
    public static final String STREET_NAME = "streetName";
    public static final String ZIPCODE = "zipcode";
    public static final String CITY = "city";

    public AddressState(
            int addressId,
            String streetName,
            int zipcode,
            String city) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.zipcode = zipcode;
        this.city = city;

        if (streetName == null) throw new InvalidAddressStateException("'streetName' can not be null");
        if (city == null) throw new InvalidAddressStateException("'city' can not be null");

        AddressValidator validator = new AddressValidator(this);

        if (!validator.isValid()) {
            throw new InvalidAddressStateException(validator.errors());
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

    public int getAddressId() { return addressId; }
    public String getStreetName() { return streetName; }
    public int getZipcode() { return zipcode; }
    public String getCity() { return city; }

    public AddressState withAddressId(int addressId) { return new AddressState(addressId, streetName, zipcode, city); }
    public AddressState withStreetName(String streetName) { return new AddressState(addressId, streetName, zipcode, city); }
    public AddressState withZipcode(int zipcode) { return new AddressState(addressId, streetName, zipcode, city); }
    public AddressState withCity(String city) { return new AddressState(addressId, streetName, zipcode, city); }

    public AddressMutableState asMutable() {
        return new AddressMutableState(
                addressId,
                streetName,
                zipcode,
                city);
    }

    public AddressStringState asStringState() {
        return asMutable().asStringState();
    }

    public AddressStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public AddressStringState asStringState(AddressStringStateConverter converter) {
        return asMutable().asStringState(converter);
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
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);

        return result;
    }

    public boolean equalsValue(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AddressState state = (AddressState)that;

        if (addressId != state.addressId) return false;
        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (zipcode != state.zipcode) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{addressId=" + addressId +
                ", streetName=" + (streetName == null ? null : '\"' + streetName + '\"' ) +
                ", zipcode=" + zipcode +
                ", city=" + (city == null ? null : '\"' + city + '\"' ) + "}";
    }

    @State(type = "mutable")
    public static class AddressMutableState implements MutableState {
        @Id public int addressId;
        public String streetName;
        public int zipcode;
        public String city;

        public AddressMutableState() {
        }

        public AddressMutableState(
                int addressId,
                String streetName,
                int zipcode,
                String city) {
            this.addressId = addressId;
            this.streetName = streetName;
            this.zipcode = zipcode;
            this.city = city;
        }

        public int getAddressId() { return addressId; }
        public String getStreetName() { return streetName; }
        public int getZipcode() { return zipcode; }
        public String getCity() { return city; }

        public void setAddressId(int addressId) { this.addressId = addressId; }
        public void setStreetName(String streetName) { this.streetName = streetName; }
        public void setZipcode(int zipcode) { this.zipcode = zipcode; }
        public void setCity(String city) { this.city = city; }

        public AddressMutableState withAddressId(int addressId) { this.addressId = addressId; return this; }
        public AddressMutableState withStreetName(String streetName) { this.streetName = streetName; return this; }
        public AddressMutableState withZipcode(int zipcode) { this.zipcode = zipcode; return this; }
        public AddressMutableState withCity(String city) { this.city = city; return this; }

        public AddressState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new AddressState(
                    addressId,
                    streetName,
                    zipcode,
                    city);
        }

        public AddressStringState asStringState() {
            return asStringState(new AddressStringStateConverter());
        }

        public AddressStringState asStringState(StringStateConverter converter) {
            return asStringState(new AddressStringStateConverter(converter));
        }

        public AddressStringState asStringState(AddressStringStateConverter converter) {
            return new AddressStringState(
                    converter.addressIdToString(addressId),
                    converter.streetNameToString(streetName),
                    converter.zipcodeToString(zipcode),
                    converter.cityToString(city));
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
            if (streetName == null) errors.addIsNullError(rootElement, "streetName", parent);
            if (city == null) errors.addIsNullError(rootElement, "city", parent);

            new AddressValidator(rootElement, parent, errors).validate(this);

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
                    ", streetName=" + (streetName == null ? null : '\"' + streetName + '\"' ) +
                    ", zipcode=" + zipcode +
                    ", city=" + (city == null ? null : '\"' + city + '\"' ) + "}";
        }
    }

    @State(type = "string")
    public static class AddressStringState implements MutableStringState {
        @Id public String addressId;
        public String streetName;
        public String zipcode;
        public String city;

        public AddressStringState() {
        }

        public AddressStringState(
                String addressId,
                String streetName,
                String zipcode,
                String city) {
            this.addressId = addressId;
            this.streetName = streetName;
            this.zipcode = zipcode;
            this.city = city;
        }

        public String getAddressId() { return addressId; }
        public String getStreetName() { return streetName; }
        public String getZipcode() { return zipcode; }
        public String getCity() { return city; }

        public void setAddressId(String addressId) { this.addressId = addressId; }
        public void setStreetName(String streetName) { this.streetName = streetName; }
        public void setZipcode(String zipcode) { this.zipcode = zipcode; }
        public void setCity(String city) { this.city = city; }

        public AddressStringState withAddressId(String addressId) { this.addressId = addressId; return this; }
        public AddressStringState withStreetName(String streetName) { this.streetName = streetName; return this; }
        public AddressStringState withZipcode(String zipcode) { this.zipcode = zipcode; return this; }
        public AddressStringState withCity(String city) { this.city = city; return this; }

        public AddressState asImmutable() {
            return asMutable().asImmutable();
        }

        public AddressMutableState asMutable() {
            return asMutable(new AddressStringStateConverter());
        }

        public AddressMutableState asMutable(AddressStringStateConverter converter) {
            return new AddressMutableState(
                    converter.toAddressId(addressId),
                    converter.toStreetName(streetName),
                    converter.toZipcode(zipcode),
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
            stateValidator.validateAddressId(addressId, rootElement, parent, errors);
            stateValidator.validateStreetName(streetName, rootElement, parent, errors);
            stateValidator.validateZipcode(zipcode, rootElement, parent, errors);
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
            int result = addressId != null ? addressId.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AddressStringState state = (AddressStringState)that;

            if (addressId != null ? !addressId.equals(state.addressId) : state.addressId != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{addressId=" + (addressId == null ? null : '\"' + addressId + '\"' ) +
                    ", streetName=" + (streetName == null ? null : '\"' + streetName + '\"' ) +
                    ", zipcode=" + (zipcode == null ? null : '\"' + zipcode + '\"' ) +
                    ", city=" + (city == null ? null : '\"' + city + '\"' ) + "}";
        }
    }

    public static class AddressStringStateConverter {
        private final StringStateConverter converter;

        public AddressStringStateConverter() { converter = new StringStateConverter(); }
        public AddressStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String addressIdToString(int addressId) { return converter.intToString(addressId); }
        public String streetNameToString(String streetName) { return streetName; }
        public String zipcodeToString(int zipcode) { return converter.intToString(zipcode); }
        public String cityToString(String city) { return city; }

        public int toAddressId(String addressId) { return converter.toInt(addressId); }
        public String toStreetName(String streetName) { return streetName; }
        public int toZipcode(String zipcode) { return converter.toInt(zipcode); }
        public String toCity(String city) { return city; }
    }

    public static class AddressStringStateValidator {
        private final AddressStringStateConverter converter;

        public AddressStringStateValidator() { converter = new AddressStringStateConverter(); }
        public AddressStringStateValidator(AddressStringStateConverter converter) { this.converter = converter; }

        public void validateAddressId(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toAddressId(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "addressId", parent); }
        }

        public void validateStreetName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateZipcode(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toZipcode(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "zipcode", parent); }
        }

        public void validateCity(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
