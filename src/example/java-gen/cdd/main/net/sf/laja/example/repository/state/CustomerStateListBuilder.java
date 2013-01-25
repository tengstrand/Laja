package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class CustomerStateListBuilder {
    private final Certificate certificate;
    private final CustomerStateList states;

    public CustomerStateListBuilder() {
        certificate = Certificate.get(new CustomerStateImpl());
        states = CustomerStateArrayList.emptyList();
    }

    public CustomerStateListBuilder(CustomerStateList states) {
        this.states = states;
        certificate = Certificate.get(new CustomerStateImpl());
    }

    public CustomerStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<CustomerStateBuilder> getStateBuilders() {
        List<CustomerStateBuilder> builders = new ArrayList<CustomerStateBuilder>(states.size());

        for (CustomerState state : states) {
            builders.add(new CustomerStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(CustomerStateBuilder builder) {
        states.add(builder.getCustomerState(certificate));
    }

    public void add(CustomerState state) {
        states.add(state);
    }

    public void add(int index, CustomerState state) {
        states.add(index, state);
    }

    public void addAll(int index, CustomerStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, CustomerState state) {
        states.set(index, state);
    }

    public boolean remove(CustomerState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(CustomerStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "CustomerStateListBuilder{" + states + "}";
    }
}
