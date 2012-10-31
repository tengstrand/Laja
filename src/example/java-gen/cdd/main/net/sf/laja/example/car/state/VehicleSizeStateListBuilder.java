package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class VehicleSizeStateListBuilder {
    private final Certificate certificate;
    private final VehicleSizeStateList states;

    public VehicleSizeStateListBuilder() {
        certificate = Certificate.get(new VehicleSizeStateImpl());
        states = VehicleSizeStateListImpl.emptyList(certificate);
    }

    public VehicleSizeStateListBuilder(VehicleSizeStateList states) {
        this.states = states;
        certificate = Certificate.get(new VehicleSizeStateImpl());
    }

    public VehicleSizeStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<VehicleSizeStateBuilder> getStateBuilders() {
        List<VehicleSizeStateBuilder> builders = new ArrayList<VehicleSizeStateBuilder>(states.size());

        for (VehicleSizeState state : states) {
            builders.add(new VehicleSizeStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(VehicleSizeStateBuilder builder) {
        states.add(builder.getVehicleSizeState(certificate));
    }

    public void add(VehicleSizeState state) {
        states.add(state);
    }

    public void add(int index, VehicleSizeState state) {
        states.add(index, state);
    }

    public void addAll(int index, VehicleSizeStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, VehicleSizeState state) {
        states.set(index, state);
    }

    public boolean remove(VehicleSizeState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(VehicleSizeStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "VehicleSizeStateListBuilder{states=" + states + "}";
    }
}
