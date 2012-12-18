package net.sf.laja.example.person.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HeightStateBuilderImpl implements HeightStateBuilder {
    private boolean encapsulated;
    private Object encapsulator;
    private HeightState state;
    private final Certificate certificate;
    private boolean trusted;

    HeightStateBuilderImpl() {
        state = new HeightStateImpl();
        certificate = Certificate.get(this);
    }

    public HeightStateBuilderImpl(HeightState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public HeightStateBuilderImpl(HeightState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withHeightInCentimeters(int heightInCentimeters) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setHeightInCentimeters(heightInCentimeters, encapsulator);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Height\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(HeightStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public HeightState getHeightState(net.sf.laja.example.person.state.Certificate certificate) {
        return state;
    }
}
