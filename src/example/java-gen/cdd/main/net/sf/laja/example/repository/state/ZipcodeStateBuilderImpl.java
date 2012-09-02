package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ZipcodeStateBuilderImpl implements ZipcodeStateBuilder {
    private boolean encapsulated;
    private ZipcodeState state;
    private final Certificate certificate;
    private boolean trusted;

    ZipcodeStateBuilderImpl() {
        state = new ZipcodeStateImpl();
        certificate = Certificate.get(this);
    }

    public ZipcodeStateBuilderImpl(ZipcodeState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withZipcode(int zipcode) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setZipcode(zipcode);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Zipcode\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(ZipcodeStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public ZipcodeState getZipcodeState(net.sf.laja.example.repository.state.Certificate certificate) {
        return state;
    }
}
