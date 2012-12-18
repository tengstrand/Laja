package net.sf.laja.cdd.state.hair;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class HairStateListBuilder {
    private final Certificate certificate;
    private final HairStateList states;

    public HairStateListBuilder() {
        certificate = Certificate.get(new HairStateImpl());
        states = HairStateListImpl.emptyList();
    }

    public HairStateListBuilder(HairStateList states) {
        this.states = states;
        certificate = Certificate.get(new HairStateImpl());
    }

    public HairStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<HairStateBuilder> getStateBuilders() {
        List<HairStateBuilder> builders = new ArrayList<HairStateBuilder>(states.size());

        for (HairState state : states) {
            builders.add(new HairStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(HairStateBuilder builder) {
        states.add(builder.getHairState(certificate));
    }

    public void add(HairState state) {
        states.add(state);
    }

    public void add(int index, HairState state) {
        states.add(index, state);
    }

    public void addAll(int index, HairStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, HairState state) {
        states.set(index, state);
    }

    public boolean remove(HairState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(HairStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "HairStateListBuilder{" + states + "}";
    }
}
