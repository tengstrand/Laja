package net.sf.laja.example.repository.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AddressStateImpl implements AddressState {
    protected int addressId; // (id)
    protected String streetName;
    protected int zipcode;
    protected String city;

    private boolean _encapsulated = false;

    AddressStateImpl() {
    }

    public AddressStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static AddressStateBuilder build() {
        return new AddressStateBuilderImpl();
    }

    public static AddressStateBuilder build(AddressState state) {
        return new AddressStateBuilderImpl(state);
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if (streetName == null
           || city == null) {
            return false;
        }
        return city.length() > 0 && Character.isLetter(city.subSequence(0, 1).charAt(0));
    }

    // Getters
    public int getAddressId() { return addressId; }
    public String getStreetName() { return streetName; }
    public int getZipcode() { return zipcode; }
    public String getCity() { return city; }

    // Setters
    public void setAddressId(int addressId) { this.addressId = addressId; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public void setZipcode(int zipcode) { this.zipcode = zipcode; }
    public void setCity(String city) { this.city = city; }

    public void encapsulate() {
        _encapsulated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressStateImpl state = (AddressStateImpl)o;

        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (zipcode != state.getZipcode()) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressStateImpl state = (AddressStateImpl)o;

        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (zipcode != state.getZipcode()) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = streetName != null ? streetName.hashCode() : 0;
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);

        return result;
    }

    public int valueHashCode() {
        int result = streetName != null ? streetName.hashCode() : 0;
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{addressId=" + addressId +
                ", streetName=" + (streetName == null ? null : '\'' + streetName + '\'' ) +
                ", zipcode=" + zipcode +
                ", city='" + city + '\'' + "}";
    }
}
