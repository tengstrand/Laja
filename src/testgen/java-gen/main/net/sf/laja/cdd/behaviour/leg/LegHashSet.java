package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.behaviour.leg.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class LegHashSet implements LegSet, RandomAccess, Cloneable, java.io.Serializable {
    protected LegStateSet stateSet;
    protected final Set<Leg> set;

    public LegHashSet(Leg... array) {
        this.set = new HashSet<Leg>();
        this.set.addAll(Arrays.asList(array));
    }

    public LegHashSet(Collection<Leg> collection) {
        this.set = new HashSet<Leg>();
        this.set.addAll(collection);
    }

    public LegHashSet(LegStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Leg> elements = new HashSet<Leg>(stateSet.size());

        for (LegState state : stateSet) {
            LegStateBuilder builder = new LegStateBuilderImpl(state);
            Leg entry = (Leg) builder.as(new LegFactory.LegFactory_());
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<Leg> {
        private LegStateSet stateSet;

        public StateInSyncSet(LegStateSet stateSet, Set<Leg> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Leg element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(LegHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Leg> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(LegHashSet.this);
            boolean modified = super.addAll(collection);

            for (Leg element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(LegHashSet.this);
            if (!(element instanceof Leg)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Leg) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(LegHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Leg) {
                    elements.add(element);
                    states.add(((Leg)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(LegHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Leg) {
                    elements.add(element);
                    states.add(((Leg)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(LegHashSet.this);
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

    public Iterator<Leg> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Leg> Leg[] toArray(Leg[] array) {
        return set.toArray(array);
    }

    public boolean add(Leg element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Leg> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Leg)) {
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
