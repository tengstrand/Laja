package net.sf.laja.cdd.state;

public class AddressMutableState {
    public int id; // (id)
    public String streetName;
    public String city; // (optional)

    public AddressMutableState() {
    }

    public AddressMutableState(int id, String streetName, String city) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
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
