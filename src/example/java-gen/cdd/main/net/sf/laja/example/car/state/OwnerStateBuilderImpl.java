package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class OwnerStateBuilderImpl implements OwnerStateBuilder {
    private Object encapsulator;
    private OwnerState state;
    private final Certificate certificate;

    OwnerStateBuilderImpl() {
        state = new OwnerStateImpl();
        certificate = Certificate.get(this);
    }

    public OwnerStateBuilderImpl(OwnerState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public OwnerStateBuilderImpl(OwnerState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withSsn(long ssn) {
        state.setSsn(ssn, encapsulator);
    }

    public void withSsn(String ssn) {
        state.setSsn(Long.parseLong(ssn), encapsulator);
    }

    public void withName(String name) {
        state.setName(name, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(OwnerStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public OwnerState getOwnerState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
