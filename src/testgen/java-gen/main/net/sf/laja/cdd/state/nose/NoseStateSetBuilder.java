package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class NoseStateSetBuilder {
    private final Certificate certificate;
    private final NoseStateSet states;

    public NoseStateSetBuilder() {
        certificate = Certificate.get(new NoseStateImpl());
        states = NoseStateHashSet.emptySet();
    }

    public NoseStateSetBuilder(NoseStateSet states) {
        this.states = states;
        certificate = Certificate.get(new NoseStateImpl());
    }

    public NoseStateSet getStateSet(Certificate certificate) {
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

    public boolean remove(NoseState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(NoseStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "NoseStateSetBuilder{" + states + "}";
    }
}