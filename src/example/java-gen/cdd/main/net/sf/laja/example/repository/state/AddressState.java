package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface AddressState {
    int getAddressId(); // (id)
    void setAddressId(int addressId, Object mutator);

    String getStreetName();
    void setStreetName(String streetName, Object mutator);

    int getZipcode();
    void setZipcode(int zipcode, Object mutator);

    String getCity();
    void setCity(String city, Object mutator);

    ZipcodeState getZipcodeState();

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
