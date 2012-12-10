package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface AddressState extends ZipcodeState {
    Certificate certificate();
    int getAddressId(); // (id)
    void setAddressId(int addressId);

    String getStreetName();
    void setStreetName(String streetName);

    int getZipcode();
    void setZipcode(int zipcode);

    String getCity();
    void setCity(String city);
}
