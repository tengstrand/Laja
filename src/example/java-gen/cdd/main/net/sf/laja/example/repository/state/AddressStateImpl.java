package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.ZipcodeStateImpl;
import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.ZipcodeStateImpl;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class AddressStateImpl implements AddressState {
    protected int addressId; // (id)
    protected String streetName;
    protected int zipcode;
    protected String city;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    public ZipcodeState getZipcodeState() {
        return new ZipcodeState() {
            public Certificate certificate() { return certificate(); }

            public int getZipcode() { return AddressStateImpl.this.getZipcode(); }
            public void setZipcode(int zipcode, Object mutator) { AddressStateImpl.this.setZipcode(zipcode, mutator); }

            public void encapsulate() { AddressStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { AddressStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                return true;
            }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof AddressStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                ZipcodeStateImpl state = (ZipcodeStateImpl)value;

                if (zipcode != state.getZipcode()) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = zipcode;

                return result;
            }

            @Override
            public String toString() {
                return "{zipcode=" + zipcode + "}";
            }
        };
    }

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
    public void setAddressId(int addressId, Object mutator) { checkMutator(mutator); this.addressId = addressId; }
    public void setStreetName(String streetName, Object mutator) { checkMutator(mutator); this.streetName = streetName; }
    public void setZipcode(int zipcode, Object mutator) { checkMutator(mutator); this.zipcode = zipcode; }
    public void setCity(String city, Object mutator) { checkMutator(mutator); this.city = city; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by current instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
        }
    }

    public void encapsulate() {
        _encapsulated = true;
    }

    public void setEncapsulator(Object encapsulator) {
        _encapsulator = encapsulator;
    }

    @Override
    public boolean equals(Object that) {
       if (this == that) return true;
       if (!(that instanceof AddressStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        AddressStateImpl state = (AddressStateImpl)value;

        if (streetName != null ? !streetName.equals(state.getStreetName()) : state.getStreetName() != null) return false;
        if (zipcode != state.getZipcode()) return false;
        if (city != null ? !city.equals(state.getCity()) : state.getCity() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
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
