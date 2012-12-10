package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;
import net.sf.laja.example.repository.state.AddressStateList;
import net.sf.laja.example.repository.state.AddressStateListImpl;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class CustomerStateImpl implements CustomerState {
    protected long ssn; // (key)
    protected String givenName;
    protected String surname; // (optional)
    protected int age;
    protected String pet; // (optional)
    protected int addressId; // (id)
    protected String streetName;
    protected int zipcode;
    protected String city;
    protected AddressStateList oldAddresses; // (optional)

    private boolean _encapsulated = false;

    CustomerStateImpl() {
        oldAddresses = AddressStateListImpl.emptyList();
    }

    public static CustomerStateBuilder build() {
        return new CustomerStateBuilderImpl();
    }

    public static CustomerStateBuilder build(CustomerState state) {
        return new CustomerStateBuilderImpl(state);
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
        if (givenName == null
           || streetName == null
           || city == null
           || (oldAddresses != null && !oldAddresses.isValid())) {
            return false;
        }
        if (!isAddressValid()) {
            return false;
        }
        return age >= 0 && ssn >= 190000000000L;
    }

    private boolean isAddressValid() {
        return city.length() > 0 && Character.isLetter(city.subSequence(0, 1).charAt(0));
    }

    // Getters
    public long getSsn() { return ssn; }
    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public String getPet() { return pet; }
    public int getAddressId() { return addressId; }
    public String getStreetName() { return streetName; }
    public int getZipcode() { return zipcode; }
    public String getCity() { return city; }
    public AddressStateList getOldAddresses() { return oldAddresses; }

    // Setters
    public void setSsn(long ssn) { this.ssn = ssn; }
    public void setGivenName(String givenName) { this.givenName = givenName; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setAge(int age) { this.age = age; }
    public void setPet(String pet) { this.pet = pet; }
    public void setAddressId(int addressId) { this.addressId = addressId; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public void setZipcode(int zipcode) { this.zipcode = zipcode; }
    public void setCity(String city) { this.city = city; }
    public void setOldAddresses(AddressStateList oldAddresses) { this.oldAddresses.clear(); this.oldAddresses.addAll(oldAddresses); }

    public void encapsulate() {
        _encapsulated = true;
        if (oldAddresses != null) oldAddresses.encapsulate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerStateImpl state = (CustomerStateImpl)o;

        if (ssn != state.getSsn()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerStateImpl state = (CustomerStateImpl)o;

        if (ssn != state.getSsn()) return false;
        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (age != state.getAge()) return false;
        if (pet != null ? !pet.equals(state.pet) : state.pet != null) return false;
        if (streetName != null ? !streetName.equals(state.streetName) : state.streetName != null) return false;
        if (zipcode != state.getZipcode()) return false;
        if (city != null ? !city.equals(state.city) : state.city != null) return false;
        if (oldAddresses != null ? !oldAddresses.equals(state.oldAddresses) : state.oldAddresses != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));

        return result;
    }

    public int valueHashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (pet != null ? pet.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{ssn=" + ssn +
                ", givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                ", age=" + age +
                ", pet=" + (pet == null ? null : '\'' + pet + '\'' ) +
                ", addressId=" + addressId +
                ", streetName=" + (streetName == null ? null : '\'' + streetName + '\'' ) +
                ", zipcode=" + zipcode +
                ", city=" + (city == null ? null : '\'' + city + '\'' ) +
                ", oldAddresses=" + oldAddresses + "}";
    }
}
