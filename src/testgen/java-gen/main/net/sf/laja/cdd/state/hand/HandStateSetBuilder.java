package net.sf.laja.cdd.state.hand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class HandStateSetBuilder {
    private final Certificate certificate;
    private final HandStateSet states;

    public HandStateSetBuilder() {
        certificate = Certificate.get(new HandStateImpl());
        states = HandStateHashSet.emptySet();
    }

    public HandStateSetBuilder(HandStateSet states) {
        this.states = states;
        certificate = Certificate.get(new HandStateImpl());
    }

    public HandStateSet getStateSet(Certificate certificate) {
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

    public boolean remove(HandState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(HandStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "HandStateSetBuilder{" + states + "}";
    }
}
