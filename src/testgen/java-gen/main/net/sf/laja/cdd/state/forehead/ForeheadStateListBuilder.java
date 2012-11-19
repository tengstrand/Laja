package net.sf.laja.cdd.state.forehead;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class ForeheadStateListBuilder {
    private final Certificate certificate;
    private final ForeheadStateList states;

    public ForeheadStateListBuilder() {
        certificate = Certificate.get(new ForeheadStateImpl());
        states = ForeheadStateListImpl.emptyList();
    }

    public ForeheadStateListBuilder(ForeheadStateList states) {
        this.states = states;
        certificate = Certificate.get(new ForeheadStateImpl());
    }

    public ForeheadStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<ForeheadStateBuilder> getStateBuilders() {
        List<ForeheadStateBuilder> builders = new ArrayList<ForeheadStateBuilder>(states.size());

        for (ForeheadState state : states) {
            builders.add(new ForeheadStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(ForeheadStateBuilder builder) {
        states.add(builder.getForeheadState(certificate));
    }

    public void add(ForeheadState state) {
        states.add(state);
    }

    public void add(int index, ForeheadState state) {
        states.add(index, state);
    }

    public void addAll(int index, ForeheadStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, ForeheadState state) {
        states.set(index, state);
    }

    public boolean remove(ForeheadState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(ForeheadStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "ForeheadStateListBuilder{states=" + states + "}";
    }
}
