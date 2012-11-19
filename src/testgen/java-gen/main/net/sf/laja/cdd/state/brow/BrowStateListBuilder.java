package net.sf.laja.cdd.state.brow;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class BrowStateListBuilder {
    private final Certificate certificate;
    private final BrowStateList states;

    public BrowStateListBuilder() {
        certificate = Certificate.get(new BrowStateImpl());
        states = BrowStateListImpl.emptyList();
    }

    public BrowStateListBuilder(BrowStateList states) {
        this.states = states;
        certificate = Certificate.get(new BrowStateImpl());
    }

    public BrowStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<BrowStateBuilder> getStateBuilders() {
        List<BrowStateBuilder> builders = new ArrayList<BrowStateBuilder>(states.size());

        for (BrowState state : states) {
            builders.add(new BrowStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(BrowStateBuilder builder) {
        states.add(builder.getBrowState(certificate));
    }

    public void add(BrowState state) {
        states.add(state);
    }

    public void add(int index, BrowState state) {
        states.add(index, state);
    }

    public void addAll(int index, BrowStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, BrowState state) {
        states.set(index, state);
    }

    public boolean remove(BrowState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(BrowStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "BrowStateListBuilder{states=" + states + "}";
    }
}
