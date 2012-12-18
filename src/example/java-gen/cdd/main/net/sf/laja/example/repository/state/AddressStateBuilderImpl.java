package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.ZipcodeStateBehaviourFactory;
import net.sf.laja.example.repository.state.ZipcodeState;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AddressStateBuilderImpl implements AddressStateBuilder {
    private Object encapsulator;
    private AddressState state;
    private final Certificate certificate;

    AddressStateBuilderImpl() {
        state = new AddressStateImpl();
        certificate = Certificate.get(this);
    }

    public AddressStateBuilderImpl(AddressState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public AddressStateBuilderImpl(AddressState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
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

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(AddressStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(ZipcodeStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public AddressState getAddressState(net.sf.laja.example.repository.state.Certificate certificate) {
        return state;
    }

    public ZipcodeState getZipcodeState(Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
