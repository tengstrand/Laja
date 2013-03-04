package net.sf.laja.example.person.state;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class PersonStateSetBuilder {
    private final Certificate certificate;
    private final PersonStateSet states;

    public PersonStateSetBuilder() {
        certificate = Certificate.get(new PersonStateImpl());
        states = PersonStateHashSet.emptySet();
    }

    public PersonStateSetBuilder(PersonStateSet states) {
        this.states = states;
        certificate = Certificate.get(new PersonStateImpl());
    }

    public PersonStateSet getStateSet(Certificate certificate) {
        return states;
    }

    public List<PersonStateBuilder> getStateBuilders() {
        List<PersonStateBuilder> builders = new ArrayList<PersonStateBuilder>(states.size());

        for (PersonState state : states) {
            builders.add(new PersonStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(PersonStateBuilder builder) {
        states.add(builder.getPersonState(certificate));
    }

    public void add(PersonState state) {
        states.add(state);
    }

    public boolean remove(PersonState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(PersonStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "PersonStateSetBuilder{" + states + "}";
    }
}
