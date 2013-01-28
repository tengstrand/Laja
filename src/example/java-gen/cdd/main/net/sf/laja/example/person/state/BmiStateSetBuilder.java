package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class BmiStateSetBuilder {
    private final Certificate certificate;
    private final BmiStateSet states;

    public BmiStateSetBuilder() {
        certificate = Certificate.get(new BmiStateImpl());
        states = BmiStateHashSet.emptySet();
    }

    public BmiStateSetBuilder(BmiStateSet states) {
        this.states = states;
        certificate = Certificate.get(new BmiStateImpl());
    }

    public BmiStateSet getStateSet(Certificate certificate) {
        return states;
    }

    public List<BmiStateBuilder> getStateBuilders() {
        List<BmiStateBuilder> builders = new ArrayList<BmiStateBuilder>(states.size());

        for (BmiState state : states) {
            builders.add(new BmiStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(BmiStateBuilder builder) {
        states.add(builder.getBmiState(certificate));
    }

    public void add(BmiState state) {
        states.add(state);
    }

    public boolean remove(BmiState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(BmiStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "BmiStateSetBuilder{" + states + "}";
    }
}
