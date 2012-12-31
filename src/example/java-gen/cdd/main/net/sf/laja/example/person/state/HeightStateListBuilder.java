package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class HeightStateListBuilder {
    private final Certificate certificate;
    private final HeightStateList states;

    public HeightStateListBuilder() {
        certificate = Certificate.get(new HeightStateImpl());
        states = HeightStateListImpl.emptyList();
    }

    public HeightStateListBuilder(HeightStateList states) {
        this.states = states;
        certificate = Certificate.get(new HeightStateImpl());
    }

    public HeightStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<HeightStateBuilder> getStateBuilders() {
        List<HeightStateBuilder> builders = new ArrayList<HeightStateBuilder>(states.size());

        for (HeightState state : states) {
            builders.add(new HeightStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(HeightStateBuilder builder) {
        states.add(builder.getHeightState(certificate));
    }

    public void add(HeightState state) {
        states.add(state);
    }

    public void add(int index, HeightState state) {
        states.add(index, state);
    }

    public void addAll(int index, HeightStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, HeightState state) {
        states.set(index, state);
    }

    public boolean remove(HeightState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(HeightStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "HeightStateListBuilder{" + states + "}";
    }
}
