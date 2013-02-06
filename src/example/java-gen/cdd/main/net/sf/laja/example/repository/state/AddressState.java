package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface AddressState extends AddressStateComparable, ZipcodeState {
    int getAddressId(); // (id)
    void setAddressId(int addressId, Object mutator);

    String getStreetName();
    void setStreetName(String streetName, Object mutator);

    int getZipcode();
    void setZipcode(int zipcode, Object mutator);

    String getCity();
    void setCity(String city, Object mutator);
    ZipcodeState getZipcodeState();
}
