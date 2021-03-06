package net.sf.laja.cdd.testgen.state;

import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StateConverter;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

import java.util.LinkedHashMap;
import java.util.Map;

@State
public class AddressState implements ImmutableState {
    @Id
    public final int id;
    @Optional
    public final String streetName;
    @Optional
    public final String city;

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
                city
        );
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

        public AddressMutableState(AddressMutableState state) {
            id = state.id;
            streetName = state.streetName;
            city = state.city;
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

        public AddressState asImmutable() {
            assertIsValid();

            return new AddressState(
                    id,
                    streetName,
                    city
            );
        }

        public Map asMap() {
            Map result = new LinkedHashMap();

            result.put("id", id);
            result.put("streetName", streetName);
            result.put("city", city);

            return result;
        }

        public AddressStringState asStringState() {
            return asStringState(new AddressStringStateConverter());
        }

        public AddressStringState asStringState(StringStateConverter converter) {
            return asStringState(new AddressStringStateConverter(converter));
        }

        public AddressStringState asStringState(AddressStringStateConverter converter) {
            return new AddressStringState(
                    converter.idToString(id),
                    converter.streetNameToString(streetName),
                    converter.cityToString(city)
            );
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

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

    public int hashCodeValue() {
            int result = id;
            result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
            result = 31 * result + (city != null ? city.hashCode() : 0);

            return result;
    }

    public boolean equalsValue(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AddressMutableState state = (AddressMutableState)that;

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
    }

    public static MapToAddressConverter mapToAddressConverter = new MapToAddressConverter();

    public static AddressMutableState toAddressMutableState(Map map) {
        return mapToAddressConverter.convert(map, 0);
    }

    public static class MapToAddressConverter implements StateConverter {

        public AddressMutableState convert(Object from, int index, StateConverter... converters) {
            Map map = (Map)from;

            int id = (Integer) map.get("id");
            String streetName = (String) map.get("streetName");
            String city = (String) map.get("city");

            return new AddressMutableState(
                    id,
                    streetName,
                    city
            );
        }
    }

    @State(type = "string")
    public static class AddressStringState implements StringState {
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

        public AddressState asImmutable(AddressStringStateConverter converter) {
            return asMutable(converter).asImmutable();
        }

        public AddressMutableState asMutable() {
            return asMutable(new AddressStringStateConverter());
        }

        public AddressMutableState asMutable(AddressStringStateConverter converter) {
            return new AddressMutableState(
                    converter.toId(id),
                    converter.toStreetName(streetName),
                    converter.toCity(city)
            );
        }

        public Map asMap() {
            return asMutable().asMap();
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new AddressStringStateValidator());
        }

        public ValidationErrors validate(AddressStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(AddressStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateId(id, rootElement, parent, errors);
            stateValidator.validateStreetName(streetName, rootElement, parent, errors);
            stateValidator.validateCity(city, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new AddressStringStateValidator());
        }

        public void assertIsValid(AddressStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

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
        private final StringStateConverter converter;

        public AddressStringStateConverter() { converter = new StringStateConverter(); }
        public AddressStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String idToString(int id) { return converter.intToString(id); }
        public String streetNameToString(String streetName) { return streetName; }
        public String cityToString(String city) { return city; }

        public int toId(String id) { return converter.toInt(id); }
        public String toStreetName(String streetName) { return streetName; }
        public String toCity(String city) { return city; }
    }

    public static class AddressStringStateValidator {
        private final AddressStringStateConverter converter;

        public AddressStringStateValidator() { converter = new AddressStringStateConverter(); }
        public AddressStringStateValidator(AddressStringStateConverter converter) { this.converter = converter; }

        public void validateId(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toId(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "id", parent); }
        }

        public void validateStreetName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateCity(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
