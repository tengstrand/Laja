package net.sf.laja.cdd.state;

import net.sf.laja.cdd.Data;

import java.io.Serializable;

import static net.sf.laja.cdd.AddressCreator.buildAddress;
import static net.sf.laja.cdd.Data.createMap;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState.AddressToDataConverter;

public class AddressState implements Serializable {
    public final int id; // (id)
    public final String streetName;
    public final String city; // (optional)

    private static int _version_ = 1;

    private void postAssertValidState() {
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

    public void assertValidState() {
        if (streetName == null) {
            throw new StreetNameNullException();
        }

        postAssertValidState();
    }

    public AddressMutableState asMutable() {
        return new AddressMutableState(id, streetName, city);
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

        public AddressMutableState() {
            streetName = "";
            city = "";
        }

        public AddressMutableState(int id, String streetName, String city) {
            this.id = id;
            this.streetName = streetName;
            this.city = city;
        }

        public void assertValidState() {
            if (streetName == null) {
                throw new StreetNameNullException();
            }
        }

        public AddressState asImmutable() {
            return new AddressState(id, streetName, city);
        }

        public AddressStringState asStringState() {
            return new AddressStringState(
                    String.valueOf(id),
                    streetName,
                    city);
        }

        public Data asData() {
            return new Data(
                    _version_,
                    getClass().getCanonicalName(),
                    createMap()
                        .value("id", id)
                        .value("streetName", streetName)
                        .value("city", city).build());
        }

        public static class AddressToDataConverter implements Data.DataConverter<AddressMutableState> {

            public AddressMutableState convert(Data data) {
                return buildAddress()
                        .withId(data.integer("id"))
                        .withStreetName(data.string("streetName"))
                        .withCity(data.string("city")).getMutableState();
            }
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

    public static class AddressStringState {
        public String id;
        public String streetName;
        public String city;

        public AddressStringState() {
        }

        public AddressStringState(String id, String streetName, String city) {
            this.id = id;
            this.streetName = streetName;
            this.city = city;
        }

        public AddressState asState() {
            return new AddressState(Integer.parseInt(id), streetName, city);
        }

        public AddressMutableState asMutableState() {
            return new AddressMutableState(Integer.parseInt(id), streetName, city);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
            result = 31 * result + (city != null ? city.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AddressStringState that = (AddressStringState) o;

            if (city != null ? !city.equals(that.city) : that.city != null) return false;
            if (id != null ? !id.equals(that.id) : that.id != null) return false;
            if (streetName != null ? !streetName.equals(that.streetName) : that.streetName != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "AddressStringState{" +
                    "id='" + id + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}
