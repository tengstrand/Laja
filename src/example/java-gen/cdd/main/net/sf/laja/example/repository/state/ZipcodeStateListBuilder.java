package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public final class ZipcodeStateListBuilder {
    private final Certificate certificate;
    private final ZipcodeStateList states;

    public ZipcodeStateListBuilder() {
        certificate = Certificate.get(new ZipcodeStateImpl());
        states = ZipcodeStateListImpl.emptyList(certificate);
    }

    public ZipcodeStateListBuilder(ZipcodeStateList states) {
        this.states = states;
        certificate = Certificate.get(new ZipcodeStateImpl());
    }

    public ZipcodeStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<ZipcodeStateBuilder> getStateBuilders() {
        List<ZipcodeStateBuilder> builders = new ArrayList<ZipcodeStateBuilder>(states.size());

        for (ZipcodeState state : states) {
            builders.add(new ZipcodeStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(ZipcodeStateBuilder builder) {
        states.add(builder.getZipcodeState(certificate));
    }

    public void add(ZipcodeState state) {
        states.add(state);
    }

    public void add(int index, ZipcodeState state) {
        states.add(index, state);
    }

    public void addAll(int index, ZipcodeStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, ZipcodeState state) {
        states.set(index, state);
    }

    public boolean remove(ZipcodeState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(ZipcodeStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "ZipcodeStateListBuilder{states=" + states + "}";
    }
}
