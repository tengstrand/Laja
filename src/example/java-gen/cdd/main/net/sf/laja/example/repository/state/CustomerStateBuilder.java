package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.AddressStateBuilder;
import net.sf.laja.example.repository.state.ZipcodeStateBuilder;
import net.sf.laja.example.repository.state.AddressStateListBuilder;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface CustomerStateBuilder extends CustomerStateComparable, AddressStateBuilder {
    void withSsn(long ssn);
    void withGivenName(String givenName);
    void withSurname(String surname);
    void withAge(int age);
    void withPet(String pet);
    void withAddressId(int addressId);
    void withStreetName(String streetName);
    void withZipcode(int zipcode);
    void withCity(String city);
    void withOldAddresses(net.sf.laja.example.repository.state.AddressStateListBuilder listBuilder);
    AddressStateListBuilder getOldAddressesStateListBuilder();
    boolean isValid();
    Object as(CustomerBehaviourFactory factory, Object... args);
    CustomerState getCustomerState(net.sf.laja.example.repository.state.Certificate certificate);
}
