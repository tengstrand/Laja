package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BusStateBuilderImpl implements BusStateBuilder {
    private boolean encapsulated;
    private Object encapsulator;
    private BusState state;
    private final Certificate certificate;
    private boolean trusted;

    BusStateBuilderImpl() {
        state = new BusStateImpl();
        certificate = Certificate.get(this);
    }

    public BusStateBuilderImpl(BusState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public BusStateBuilderImpl(BusState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withName(String name) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setName(name, encapsulator);
    }

    public void withLengthInCentimeters(int lengthInCentimeters) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setLengthInCentimeters(lengthInCentimeters, encapsulator);
    }

    public void withWeightInKilograms(int weightInKilograms) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setWeightInKilograms(weightInKilograms, encapsulator);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Bus\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(BusStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public Object as(VehicleSizeStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public BusState getBusState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    public VehicleSizeState getVehicleSizeState(Certificate certificate) {
        return state;
    }
}
