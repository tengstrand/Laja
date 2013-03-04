package net.sf.laja.cdd.state.nose;

import java.util.ArrayList;
import java.util.List;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class NoseStateListBuilder {
    private final Certificate certificate;
    private final NoseStateList states;

    public NoseStateListBuilder() {
        certificate = Certificate.get(new NoseStateImpl());
        states = NoseStateArrayList.emptyList();
    }

    public NoseStateListBuilder(NoseStateList states) {
        this.states = states;
        certificate = Certificate.get(new NoseStateImpl());
    }

    public NoseStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<NoseStateBuilder> getStateBuilders() {
        List<NoseStateBuilder> builders = new ArrayList<NoseStateBuilder>(states.size());

        for (NoseState state : states) {
            builders.add(new NoseStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(NoseStateBuilder builder) {
        states.add(builder.getNoseState(certificate));
    }

    public void add(NoseState state) {
        states.add(state);
    }

    public void add(int index, NoseState state) {
        states.add(index, state);
    }

    public void addAll(int index, NoseStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, NoseState state) {
        states.set(index, state);
    }

    public boolean remove(NoseState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(NoseStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "NoseStateListBuilder{" + states + "}";
    }
}
