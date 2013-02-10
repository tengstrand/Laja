package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.AddressBehaviourFactory;
import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.ZipcodeBehaviourFactory;
import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.AddressStateBuilder;
import net.sf.laja.example.repository.state.AddressStateBuilderImpl;
import net.sf.laja.example.repository.state.AddressStateListBuilder;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerStateBuilderImpl implements CustomerStateBuilder {
    private Object encapsulator;
    private CustomerState state;
    private final Certificate certificate;
    private AddressStateListBuilder oldAddressesStateListBuilder;

    CustomerStateBuilderImpl() {
        state = new CustomerStateImpl();
        certificate = Certificate.get(this);
    }

    public CustomerStateBuilderImpl(CustomerState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public CustomerStateBuilderImpl(CustomerState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public AddressStateBuilder getAddressStateBuilder() {
        return new AddressStateBuilderImpl(state.getAddressState());
    }

    public void withSsn(long ssn) {
        state.setSsn(ssn, encapsulator);
    }

    public void withGivenName(String givenName) {
        state.setGivenName(givenName, encapsulator);
    }

    public void withSurname(String surname) {
        state.setSurname(surname, encapsulator);
    }

    public void withAge(int age) {
        state.setAge(age, encapsulator);
    }

    public void withPet(String pet) {
        state.setPet(pet, encapsulator);
    }

    public void withAddressId(int addressId) {
        state.setAddressId(addressId, encapsulator);
    }

    public void withStreetName(String streetName) {
        state.setStreetName(streetName, encapsulator);
    }

    public void withZipcode(int zipcode) {
        state.setZipcode(zipcode, encapsulator);
    }

    public void withCity(String city) {
        state.setCity(city, encapsulator);
    }

    public void withOldAddresses(net.sf.laja.example.repository.state.AddressStateListBuilder listBuilder) {
        state.setOldAddresses(listBuilder.getStateList(certificate), encapsulator);
    }

    public AddressStateListBuilder getOldAddressesStateListBuilder() {
        if (oldAddressesStateListBuilder == null) {
            oldAddressesStateListBuilder = new AddressStateListBuilder(state.getOldAddresses());
        }
        return oldAddressesStateListBuilder;
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(CustomerBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public CustomerState getCustomerState(net.sf.laja.example.repository.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomerStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
