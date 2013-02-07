package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.AddressStateList;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface CustomerState {
    long getSsn(); // (key)
    void setSsn(long ssn, Object mutator);

    String getGivenName();
    void setGivenName(String givenName, Object mutator);

    String getSurname(); // (optional)
    void setSurname(String surname, Object mutator);

    int getAge();
    void setAge(int age, Object mutator);

    String getPet(); // (optional)
    void setPet(String pet, Object mutator);

    int getAddressId();
    void setAddressId(int addressId, Object mutator);

    String getStreetName();
    void setStreetName(String streetName, Object mutator);

    int getZipcode();
    void setZipcode(int zipcode, Object mutator);

    String getCity();
    void setCity(String city, Object mutator);

    AddressStateList getOldAddresses(); // (optional)
    void setOldAddresses(AddressStateList oldAddresses, Object mutator);
��
    AddressState getAddressState();

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
