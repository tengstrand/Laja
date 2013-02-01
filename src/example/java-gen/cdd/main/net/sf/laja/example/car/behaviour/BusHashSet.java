package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class BusHashSet implements BusSet, RandomAccess, Cloneable, java.io.Serializable {
    protected BusStateSet stateSet;
    protected final Set<Bus> set;

    public BusHashSet(Bus... array) {
        this.set = new HashSet<Bus>();
        this.set.addAll(Arrays.asList(array));
    }

    public BusHashSet(Collection<Bus> collection) {
        this.set = new HashSet<Bus>();
        this.set.addAll(collection);
    }

    public BusHashSet(BusStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Bus> elements = new HashSet<Bus>(stateSet.size());

        for (BusState state : stateSet) {
            BusStateBuilder builder = new BusStateBuilderImpl(state);
            Bus entry = (Bus) builder.as(new BusFactory.BusFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<Bus> {
        private BusStateSet stateSet;

        public StateInSyncSet(BusStateSet stateSet, Set<Bus> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Bus element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(BusHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Bus> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(BusHashSet.this);
            boolean modified = super.addAll(collection);

            for (Bus element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(BusHashSet.this);
            if (!(element instanceof Bus)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Bus) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(BusHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Bus) {
                    elements.add(element);
                    states.add(((Bus)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(BusHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Bus) {
                    elements.add(element);
                    states.add(((Bus)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(BusHashSet.this);
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

    public Iterator<Bus> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Bus> Bus[] toArray(Bus[] array) {
        return set.toArray(array);
    }

    public boolean add(Bus element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Bus> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Bus)) {
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