package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.domain.*;

import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherSet;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherHashSet;

import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDbSet;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDbHashSet;

import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGuiSet;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGuiHashSet;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerHashSet implements CustomerSet, RandomAccess, Cloneable, java.io.Serializable {
    protected CustomerStateSet stateSet;
    protected final Set<Customer> set;

    public CustomerHashSet(Customer... array) {
        this.set = new HashSet<Customer>();
        this.set.addAll(Arrays.asList(array));
    }

    public CustomerHashSet(Collection<Customer> collection) {
        this.set = new HashSet<Customer>();
        this.set.addAll(collection);
    }

    public CustomerHashSet(CustomerStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Customer> elements = new HashSet<Customer>(stateSet.size());

        for (CustomerState state : stateSet) {
            CustomerStateBuilder builder = new CustomerStateBuilderImpl(state);
            Customer entry = (Customer) builder.as(new CustomerFactory.CustomerFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public CustomerMatcherHashSet asCustomerMatcherSet() {
        if (stateSet != null) {
            return new CustomerMatcherHashSet(stateSet);
        }
        Set<CustomerMatcher> result = new HashSet<CustomerMatcher>();
        for (Customer entry : set) {
            result.add(entry.asCustomerMatcher());
        }
        return new CustomerMatcherHashSet(result);
    }

    public CustomerInDbHashSet asCustomerInDbSet() {
        Set<CustomerInDb> result = new HashSet<CustomerInDb>();
        for (Customer entry : set) {
            result.add(entry.asCustomerInDb());
        }
        return new CustomerInDbHashSet(result);
    }

    public CustomerInGuiHashSet asCustomerInGuiSet() {
        Set<CustomerInGui> result = new HashSet<CustomerInGui>();
        for (Customer entry : set) {
            result.add(entry.asCustomerInGui());
        }
        return new CustomerInGuiHashSet(result);
    }

    public class StateInSyncSet extends HashSet<Customer> {
        private final CustomerStateSet stateSet;

        public StateInSyncSet(CustomerStateSet stateSet, Set<Customer> elements) {
            this.stateSet = stateSet;
            super.addAll(elements);
        }

        @Override
        public boolean add(Customer element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Customer> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerHashSet.this);
            boolean modified = super.addAll(collection);

            for (Customer element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerHashSet.this);
            if (!(element instanceof Customer)) {
                return false;
            }
            stateSet.remove(((Customer) element).getState(stateSet.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Customer) {
                    elements.add(element);
                    states.add(((Customer)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Customer) {
                    elements.add(element);
                    states.add(((Customer)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerHashSet.this);
            stateSet.clear();
            super.clear();
        }
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(Object element) {
        return set.contains(element);
    }

    public Iterator<Customer> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Customer> Customer[] toArray(Customer[] array) {
        return set.toArray(array);
    }

    public boolean add(Customer element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Customer> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Customer)) {
            return false;
        }
        return set.remove(element);
    }

    public boolean containsAll(Collection<?> collection) {
        return set.containsAll(collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return set.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return set.retainAll(collection);
    }

    public void clear() {
        set.clear();
    }

    @Override
    public boolean equals(Object o) {
        return set.equals(o);
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + set + '}';
    }
}
