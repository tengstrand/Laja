package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.CarBehaviourFactory;
import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.CarStateBuilder;
import net.sf.laja.example.car.state.CarStateBuilderImpl;
import net.sf.laja.example.car.state.VehicleSizeBehaviourFactory;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeStateBuilder;
import net.sf.laja.example.car.state.VehicleSizeStateBuilderImpl;
import net.sf.laja.example.car.state.OwnerStateBuilder;
import net.sf.laja.example.car.state.OwnerStateBuilderImpl;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class VehicleStateBuilderImpl implements VehicleStateBuilder {
    private Object encapsulator;
    private VehicleState state;
    private final Certificate certificate;
    private OwnerStateBuilder ownerStateBuilder;

    VehicleStateBuilderImpl() {
        state = new VehicleStateImpl();
        certificate = Certificate.get(this);
    }

    public VehicleStateBuilderImpl(VehicleState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public VehicleStateBuilderImpl(VehicleState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public CarStateBuilder getCarStateBuilder() {
        return new CarStateBuilderImpl(state.getCarState());
    }

    public void withLengthInCentimeters(int lengthInCentimeters) {
        state.setLengthInCentimeters(lengthInCentimeters, encapsulator);
    }

    public void withName(String name) {
        state.setName(name, encapsulator);
    }

    public void withOwner(OwnerStateBuilder owner) {
        state.setOwner(owner.getOwnerState(certificate), encapsulator);
    }

    public void withColor(String color) {
        state.setColor(color, encapsulator);
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

    public Object as(VehicleBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public VehicleState getVehicleState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VehicleStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}