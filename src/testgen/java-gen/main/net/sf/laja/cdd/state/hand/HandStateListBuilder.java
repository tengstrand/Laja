package net.sf.laja.cdd.state.hand;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class HandStateListBuilder {
    private final Certificate certificate;
    private final HandStateList states;

    public HandStateListBuilder() {
        certificate = Certificate.get(new HandStateImpl());
        states = HandStateListImpl.emptyList(certificate);
    }

    public HandStateListBuilder(HandStateList states) {
        this.states = states;
        certificate = Certificate.get(new HandStateImpl());
    }

    public HandStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<HandStateBuilder> getStateBuilders() {
        List<HandStateBuilder> builders = new ArrayList<HandStateBuilder>(states.size());

        for (HandState state : states) {
            builders.add(new HandStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(HandStateBuilder builder) {
        states.add(builder.getHandState(certificate));
    }

    public void add(HandState state) {
        states.add(state);
    }

    public void add(int index, HandState state) {
        states.add(index, state);
    }

    public void addAll(int index, HandStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, HandState state) {
        states.set(index, state);
    }

    public boolean remove(HandState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(HandStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "HandStateListBuilder{states=" + states + "}";
    }
}
