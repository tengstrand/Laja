package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TruckStateBuilderImpl implements TruckStateBuilder {
    private boolean encapsulated;
    private TruckState state;
    private final Certificate certificate;
    private boolean trusted;
    private TruckTypeStateBuilder typeStateBuilder;
    private OwnerStateBuilder ownerStateBuilder;

    TruckStateBuilderImpl() {
        state = new TruckStateImpl();
        certificate = Certificate.get(this);
    }

    public TruckStateBuilderImpl(TruckState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public CarStateBuilder carStateBuilder() {
        return new CarStateBuilderImpl(state.getCarState());
    }

    public void withLengthInCentimeters(int lengthInCentimeters) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setLengthInCentimeters(lengthInCentimeters);
    }

    public void withWeightInKilograms(int weightInKilograms) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setWeightInKilograms(weightInKilograms);
    }

    public void withType(TruckTypeStateBuilder type) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setType(type.getTruckTypeState(certificate));
    }

    public void withColor(String color) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setColor(color);
    }

    public void withOwner(OwnerStateBuilder owner) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setOwner(owner.getOwnerState(certificate));
    }

    public TruckTypeStateBuilder getTypeStateBuilder() {
        if (typeStateBuilder == null) {
            typeStateBuilder = new TruckTypeStateBuilderImpl(state.getType());
        }
        return typeStateBuilder;
    }

    public OwnerStateBuilder getOwnerStateBuilder() {
        if (ownerStateBuilder == null) {
            ownerStateBuilder = new OwnerStateBuilderImpl(state.getOwner());
        }
        return ownerStateBuilder;
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Truck\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(TruckStateBehaviourFactory factory, Object... args) {
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

    public TruckState getTruckState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    public VehicleSizeState getVehicleSizeState(Certificate certificate) {
        return state;
    }
}
