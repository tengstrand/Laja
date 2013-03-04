package net.sf.laja.example.car.state;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class TruckStateSetBuilder {
    private final Certificate certificate;
    private final TruckStateSet states;

    public TruckStateSetBuilder() {
        certificate = Certificate.get(new TruckStateImpl());
        states = TruckStateHashSet.emptySet();
    }

    public TruckStateSetBuilder(TruckStateSet states) {
        this.states = states;
        certificate = Certificate.get(new TruckStateImpl());
    }

    public TruckStateSet getStateSet(Certificate certificate) {
        return states;
    }

    public List<TruckStateBuilder> getStateBuilders() {
        List<TruckStateBuilder> builders = new ArrayList<TruckStateBuilder>(states.size());

        for (TruckState state : states) {
            builders.add(new TruckStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(TruckStateBuilder builder) {
        states.add(builder.getTruckState(certificate));
    }

    public void add(TruckState state) {
        states.add(state);
    }

    public boolean remove(TruckState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(TruckStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "TruckStateSetBuilder{" + states + "}";
    }
}
