package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class TruckStateListBuilder {
    private final Certificate certificate;
    private final TruckStateList states;

    public TruckStateListBuilder() {
        certificate = Certificate.get(new TruckStateImpl());
        states = TruckStateArrayList.emptyList();
    }

    public TruckStateListBuilder(TruckStateList states) {
        this.states = states;
        certificate = Certificate.get(new TruckStateImpl());
    }

    public TruckStateList getStateList(Certificate certificate) {
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

    public void add(int index, TruckState state) {
        states.add(index, state);
    }

    public void addAll(int index, TruckStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, TruckState state) {
        states.set(index, state);
    }

    public boolean remove(TruckState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(TruckStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "TruckStateListBuilder{" + states + "}";
    }
}
