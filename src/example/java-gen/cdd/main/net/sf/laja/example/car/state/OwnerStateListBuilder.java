package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class OwnerStateListBuilder {
    private final Certificate certificate;
    private final OwnerStateList states;

    public OwnerStateListBuilder() {
        certificate = Certificate.get(new OwnerStateImpl());
        states = OwnerStateListImpl.emptyList();
    }

    public OwnerStateListBuilder(OwnerStateList states) {
        this.states = states;
        certificate = Certificate.get(new OwnerStateImpl());
    }

    public OwnerStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<OwnerStateBuilder> getStateBuilders() {
        List<OwnerStateBuilder> builders = new ArrayList<OwnerStateBuilder>(states.size());

        for (OwnerState state : states) {
            builders.add(new OwnerStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(OwnerStateBuilder builder) {
        states.add(builder.getOwnerState(certificate));
    }

    public void add(OwnerState state) {
        states.add(state);
    }

    public void add(int index, OwnerState state) {
        states.add(index, state);
    }

    public void addAll(int index, OwnerStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, OwnerState state) {
        states.set(index, state);
    }

    public boolean remove(OwnerState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(OwnerStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "OwnerStateListBuilder{" + states + "}";
    }
}
