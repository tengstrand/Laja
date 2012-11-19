package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class TruckTypeStateListBuilder {
    private final Certificate certificate;
    private final TruckTypeStateList states;

    public TruckTypeStateListBuilder() {
        certificate = Certificate.get(new TruckTypeStateImpl());
        states = TruckTypeStateListImpl.emptyList();
    }

    public TruckTypeStateListBuilder(TruckTypeStateList states) {
        this.states = states;
        certificate = Certificate.get(new TruckTypeStateImpl());
    }

    public TruckTypeStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<TruckTypeStateBuilder> getStateBuilders() {
        List<TruckTypeStateBuilder> builders = new ArrayList<TruckTypeStateBuilder>(states.size());

        for (TruckTypeState state : states) {
            builders.add(new TruckTypeStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(TruckTypeStateBuilder builder) {
        states.add(builder.getTruckTypeState(certificate));
    }

    public void add(TruckTypeState state) {
        states.add(state);
    }

    public void add(int index, TruckTypeState state) {
        states.add(index, state);
    }

    public void addAll(int index, TruckTypeStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, TruckTypeState state) {
        states.set(index, state);
    }

    public boolean remove(TruckTypeState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(TruckTypeStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "TruckTypeStateListBuilder{states=" + states + "}";
    }
}
