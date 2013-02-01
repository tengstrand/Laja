package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckHashSet implements TruckSet, RandomAccess, Cloneable, java.io.Serializable {
    protected TruckStateSet stateSet;
    protected final Set<Truck> set;

    public TruckHashSet(Truck... array) {
        this.set = new HashSet<Truck>();
        this.set.addAll(Arrays.asList(array));
    }

    public TruckHashSet(Collection<Truck> collection) {
        this.set = new HashSet<Truck>();
        this.set.addAll(collection);
    }

    public TruckHashSet(TruckStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Truck> elements = new HashSet<Truck>(stateSet.size());

        for (TruckState state : stateSet) {
            TruckStateBuilder builder = new TruckStateBuilderImpl(state);
            Truck entry = (Truck) builder.as(new TruckFactory.TruckFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<Truck> {
        private TruckStateSet stateSet;

        public StateInSyncSet(TruckStateSet stateSet, Set<Truck> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Truck element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TruckHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Truck> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TruckHashSet.this);
            boolean modified = super.addAll(collection);

            for (Truck element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TruckHashSet.this);
            if (!(element instanceof Truck)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Truck) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TruckHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Truck) {
                    elements.add(element);
                    states.add(((Truck)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TruckHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Truck) {
                    elements.add(element);
                    states.add(((Truck)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(TruckHashSet.this);
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

    public Iterator<Truck> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Truck> Truck[] toArray(Truck[] array) {
        return set.toArray(array);
    }

    public boolean add(Truck element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Truck> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Truck)) {
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
