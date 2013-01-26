package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class TruckTypeStateSetBuilder {
    private final Certificate certificate;
    private final TruckTypeStateSet states;

    public TruckTypeStateSetBuilder() {
        certificate = Certificate.get(new TruckTypeStateImpl());
        states = TruckTypeStateHashSet.emptySet();
    }

    public TruckTypeStateSetBuilder(TruckTypeStateSet states) {
        this.states = states;
        certificate = Certificate.get(new TruckTypeStateImpl());
    }

    public TruckTypeStateSet getStateSet(Certificate certificate) {
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

    public boolean remove(TruckTypeState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(TruckTypeStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "TruckTypeStateSetBuilder{" + states + "}";
    }
}
