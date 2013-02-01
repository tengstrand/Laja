package net.sf.laja.example.repository.behaviour.gui;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.domain.*;

import net.sf.laja.example.repository.behaviour.domain.Customer;
import net.sf.laja.example.repository.behaviour.domain.CustomerFactory;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerInGuiHashSet implements CustomerInGuiSet, RandomAccess, Cloneable, java.io.Serializable {
    protected CustomerStateSet stateSet;
    protected final Set<CustomerInGui> set;

    public CustomerInGuiHashSet(CustomerInGui... array) {
        this.set = new HashSet<CustomerInGui>();
        this.set.addAll(Arrays.asList(array));
    }

    public CustomerInGuiHashSet(Collection<CustomerInGui> collection) {
        this.set = new HashSet<CustomerInGui>();
        this.set.addAll(collection);
    }

    public class StateInSyncSet extends HashSet<CustomerInGui> {
        private CustomerStateSet stateSet;

        public StateInSyncSet(CustomerStateSet stateSet, Set<CustomerInGui> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(CustomerInGui element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerInGuiHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends CustomerInGui> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerInGuiHashSet.this);
            boolean modified = super.addAll(collection);

            for (CustomerInGui element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerInGuiHashSet.this);
            if (!(element instanceof CustomerInGui)) {
                return false;
            }
            boolean removedState = stateSet.remove(((CustomerInGui) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerInGuiHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof CustomerInGui) {
                    elements.add(element);
                    states.add(((CustomerInGui)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerInGuiHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof CustomerInGui) {
                    elements.add(element);
                    states.add(((CustomerInGui)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(CustomerInGuiHashSet.this);
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

    public Iterator<CustomerInGui> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <CustomerInGui> CustomerInGui[] toArray(CustomerInGui[] array) {
        return set.toArray(array);
    }

    public boolean add(CustomerInGui element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends CustomerInGui> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof CustomerInGui)) {
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