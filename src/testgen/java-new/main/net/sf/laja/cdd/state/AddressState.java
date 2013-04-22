package net.sf.laja.cdd.state;

import net.sf.laja.cdd.Data;

import java.io.Serializable;
import java.util.Map;

import static net.sf.laja.cdd.AddressCreator.buildAddress;

public class AddressState implements Serializable {
    public final int id; // (id)
    public final String streetName;
    public final String city; // (optional)

    // Only increase version if making changes that is not backward compatible.
    private static int VERSION = 1;

    private static void defaults(AddressMutableState state) {
        state.streetName = "";
        state.city = "";
    }

    private void postAssertIsValid() {
    }

    // Generated code goes here...

    public static AddressToDataConverter converter = new AddressToDataConverter();

    public AddressState(String streetName, String city) {
        this.id = 0;
        this.streetName = streetName;
        this.city = city;
    }

    public AddressState(int id, String streetName, String city) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
    }

    public static class IllegalAddressStateException extends RuntimeException { }
    public static class IllegalStreetNameException extends IllegalAddressStateException { }
    public static class StreetNameNullException extends IllegalAddressStateException { }

    public void assertIsValid() {
        if (streetName == null) {
            throw new StreetNameNullException();
        }

        postAssertIsValid();
    }

    public AddressMutableState asMutable() {
        return new AddressMutableState(id, streetName, city);
    }

    public Map<String, Object> asData() {
        return converter.asDataFromState(this);
    }

    public AddressState withAge(int id) { return new AddressState(id, streetName, city); }
    public AddressState withStreetName(String streetName) { return new AddressState(id, streetName, city); }
    public AddressState withCity(String city) { return new AddressState(id, streetName, city); }

    public int hashCode() {
        int result = id;
        result = 31 * result + streetName.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressState that = (AddressState) o;

        if (id != that.id) return false;
        if (!city.equals(that.city)) return false;
        if (!streetName.equals(that.streetName)) return false;

        return true;
    }

    public String toString() {
        return "{id=" + id + ", streetName='" + streetName + "\', city='" + city + "\'}";
    }

    public static class AddressMutableState {
        public int id; // (id)
        public String streetName;
        public String city; // (optional)

        private AddressMutableState() {
            defaults(this);
        }

        public static AddressMutableState create() {
            return new AddressMutableState();
        }

        public static AddressMutableState createWithDefaults() {
            AddressMutableState state = create();
            defaults(state);
            return state;
        }

        public AddressMutableState(int id, String streetName, String city) {
            this.id = id;
            this.streetName = streetName;
            this.city = city;
        }

        public void assertIsValid() {
            if (streetName == null) {
                throw new StreetNameNullException();
            }
        }

        public AddressState asImmutable() {
            return new AddressState(id, streetName, city);
        }

        public Map<String,Object> asData() {
            return converter.asDataFromMutableState(this);
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

    public static class AddressToDataConverter implements Data.DataConverter<AddressState,AddressMutableState> {

        public AddressState asState(Map map) {
            return asMutableState(map).asImmutable();
        }

        public AddressMutableState asMutableState(Map map) {
            Data data = new Data(map);
            return buildAddress()
                    .withId(data.integer("id"))
                    .withStreetName(data.string("streetName"))
                    .withCity(data.string("city")).getMutableState();
        }

        public Map asDataFromState(AddressState state) {
            return Data.build(VERSION, getClass().getCanonicalName())
                    .value("id", state.id)
                    .value("streetName", state.streetName)
                    .value("city", state.city).map();
        }

        public Map asDataFromMutableState(AddressMutableState state) {
            return Data.build(VERSION, AddressState.class.getCanonicalName())
                    .value("id", state.id)
                    .value("streetName", state.streetName)
                    .value("city", state.city).map();
        }
    }
}
