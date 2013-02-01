package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.behaviour.fleck.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class FleckHashSet implements FleckSet, RandomAccess, Cloneable, java.io.Serializable {
    protected FleckStateSet stateSet;
    protected final Set<Fleck> set;

    public FleckHashSet(Fleck... array) {
        this.set = new HashSet<Fleck>();
        this.set.addAll(Arrays.asList(array));
    }

    public FleckHashSet(Collection<Fleck> collection) {
        this.set = new HashSet<Fleck>();
        this.set.addAll(collection);
    }

    public FleckHashSet(FleckStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Fleck> elements = new HashSet<Fleck>(stateSet.size());

        for (FleckState state : stateSet) {
            FleckStateBuilder builder = new FleckStateBuilderImpl(state);
            Fleck entry = (Fleck) builder.as(new FleckFactory.FleckFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<Fleck> {
        private FleckStateSet stateSet;

        public StateInSyncSet(FleckStateSet stateSet, Set<Fleck> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Fleck element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(FleckHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Fleck> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(FleckHashSet.this);
            boolean modified = super.addAll(collection);

            for (Fleck element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(FleckHashSet.this);
            if (!(element instanceof Fleck)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Fleck) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(FleckHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Fleck) {
                    elements.add(element);
                    states.add(((Fleck)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(FleckHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Fleck) {
                    elements.add(element);
                    states.add(((Fleck)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(FleckHashSet.this);
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

    public Iterator<Fleck> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Fleck> Fleck[] toArray(Fleck[] array) {
        return set.toArray(array);
    }

    public boolean add(Fleck element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Fleck> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Fleck)) {
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