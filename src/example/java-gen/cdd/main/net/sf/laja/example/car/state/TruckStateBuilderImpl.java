package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.VehicleSizeStateBehaviourFactory;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.TruckTypeStateBuilder;
import net.sf.laja.example.car.state.OwnerStateBuilder;
import net.sf.laja.example.car.state.TruckTypeStateBuilderImpl;
import net.sf.laja.example.car.state.OwnerStateBuilderImpl;
import net.sf.laja.example.car.state.CarStateBuilderImpl;
import net.sf.laja.example.car.state.CarStateBuilder;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckStateBuilderImpl implements TruckStateBuilder {
    private Object encapsulator;
    private TruckState state;
    private final Certificate certificate;
    private TruckTypeStateBuilder typeStateBuilder;
    private OwnerStateBuilder ownerStateBuilder;

    TruckStateBuilderImpl() {
        state = new TruckStateImpl();
        certificate = Certificate.get(this);
    }

    public TruckStateBuilderImpl(TruckState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public TruckStateBuilderImpl(TruckState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public CarStateBuilder carStateBuilder() {
        return new CarStateBuilderImpl(state.getCarState());
    }

    public void withLengthInCentimeters(int lengthInCentimeters) {
        state.setLengthInCentimeters(lengthInCentimeters, encapsulator);
    }

    public void withWeightInKilograms(int weightInKilograms) {
        state.setWeightInKilograms(weightInKilograms, encapsulator);
    }

    public void withType(TruckTypeStateBuilder type) {
        state.setType(type.getTruckTypeState(certificate), encapsulator);
    }

    public void withColor(String color) {
        state.setColor(color, encapsulator);
    }

    public void withOwner(OwnerStateBuilder owner) {
        state.setOwner(owner.getOwnerState(certificate), encapsulator);
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

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(TruckStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(VehicleSizeStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public TruckState getTruckState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    public VehicleSizeState getVehicleSizeState(Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
