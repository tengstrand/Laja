package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class OwnerStateBuilderImpl implements OwnerStateBuilder {
    private boolean encapsulated;
    private OwnerState state;
    private final Certificate certificate;
    private boolean trusted;

    OwnerStateBuilderImpl() {
        state = new OwnerStateImpl();
        certificate = Certificate.get(this);
    }

    public OwnerStateBuilderImpl(OwnerState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withSsn(long ssn) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setSsn(ssn);
    }

    public void withSsn(String ssn) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setSsn(Long.parseLong(ssn));
    }

    public void withName(String name) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setName(name);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Owner\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(OwnerStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public OwnerState getOwnerState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }
}
