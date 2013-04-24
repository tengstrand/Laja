package net.sf.laja.cdd.state;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class AddressState implements Serializable {
    public final int id; // (id)
    public final String streetName;
    public final String city; // (optional)

    private static void setDefaults(AddressMutableState state) {
    }

    private void postAssertIsValid() {
    }

    // Generated code goes here...

    public AddressState(int id, String streetName, String city) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
    }

    public int getId() { return id; }
    public String getStreetName() { return streetName; }
    public String getCity() { return city; }

    public static class IllegalAddressStateException extends IllegalStateException { }
    public static class IllegalAddressStateIsNullException extends IllegalAddressStateException { }

    public static class IllegalAddressStateStreetNameException extends IllegalAddressStateException { }
    public static class IllegalAddressStateStreetNameIsNullException extends IllegalAddressStateIsNullException { }

    public void assertIsValid() {
        if (streetName == null) {
            throw new IllegalAddressStateStreetNameIsNullException();
        }
        postAssertIsValid();
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
            if (streetName == null) {
                throw new IllegalAddressStateStreetNameIsNullException();
            }
        }

        public AddressState asImmutable() {
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

    public static class AddressStateConverter {

        public static Set<AddressMutableState> asMutableSet(ImmutableSet<AddressState> set) {
            Set<AddressMutableState> result = new HashSet<AddressMutableState>();

            for (AddressState state : set) {
                result.add(state.asMutable());
            }
            return result;
        }

        public static ImmutableSet<AddressState> asImmutableSet(Set<AddressMutableState> set) {
            ImmutableSet.Builder<AddressState> builder = new ImmutableSet.Builder<AddressState>();

            for (AddressMutableState state : set) {
                builder.add(state.asImmutable());
            }
            return builder.build();
        }

        public static ImmutableMap<String, AddressState> asImmutableMap(Map<String, AddressMutableState> groupedAddresses) {
            ImmutableMap.Builder<String, AddressState> builder = new ImmutableMap.Builder<String, AddressState>();

            for (Map.Entry<String, AddressMutableState> entry : groupedAddresses.entrySet()) {
                builder.put(entry.getKey(), entry.getValue().asImmutable());
            }
            return builder.build();
        }

        public static Map<String, AddressMutableState> asMutableMap(ImmutableMap<String, AddressState> groupedAddresses) {
            Map<String, AddressMutableState> result = new HashMap<String, AddressMutableState>();

            for (Map.Entry<String, AddressState> entry : groupedAddresses.entrySet()) {
                result.put(entry.getKey(), entry.getValue().asMutable());
            }
            return result;
        }
    }
}
