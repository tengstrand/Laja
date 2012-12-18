package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TruckTypeStateBuilderImpl implements TruckTypeStateBuilder {
    private boolean encapsulated;
    private Object encapsulator;
    private TruckTypeState state;
    private final Certificate certificate;
    private boolean trusted;

    TruckTypeStateBuilderImpl() {
        state = new TruckTypeStateImpl();
        certificate = Certificate.get(this);
    }

    public TruckTypeStateBuilderImpl(TruckTypeState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public TruckTypeStateBuilderImpl(TruckTypeState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withNumberOfWheels(int numberOfWheels) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setNumberOfWheels(numberOfWheels, encapsulator);
    }

    public void withTruckName(String truckName) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setTruckName(truckName, encapsulator);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"TruckType\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(TruckTypeStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public TruckTypeState getTruckTypeState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }
}
