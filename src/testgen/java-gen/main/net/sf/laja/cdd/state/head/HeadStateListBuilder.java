package net.sf.laja.cdd.state.head;

import java.util.ArrayList;
import java.util.List;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class HeadStateListBuilder {
    private final Certificate certificate;
    private final HeadStateList states;

    public HeadStateListBuilder() {
        certificate = Certificate.get(new HeadStateImpl());
        states = HeadStateArrayList.emptyList();
    }

    public HeadStateListBuilder(HeadStateList states) {
        this.states = states;
        certificate = Certificate.get(new HeadStateImpl());
    }

    public HeadStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<HeadStateBuilder> getStateBuilders() {
        List<HeadStateBuilder> builders = new ArrayList<HeadStateBuilder>(states.size());

        for (HeadState state : states) {
            builders.add(new HeadStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(HeadStateBuilder builder) {
        states.add(builder.getHeadState(certificate));
    }

    public void add(HeadState state) {
        states.add(state);
    }

    public void add(int index, HeadState state) {
        states.add(index, state);
    }

    public void addAll(int index, HeadStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, HeadState state) {
        states.set(index, state);
    }

    public boolean remove(HeadState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(HeadStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "HeadStateListBuilder{" + states + "}";
    }
}
