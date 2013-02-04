package net.sf.laja.cdd.behaviour.nail;

import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.behaviour.nail.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class NailHashSet implements NailSet, RandomAccess, Cloneable, java.io.Serializable {
    protected NailStateSet stateSet;
    protected final Set<Nail> set;

    public NailHashSet(Nail... array) {
        this.set = new HashSet<Nail>();
        this.set.addAll(Arrays.asList(array));
    }

    public NailHashSet(Collection<Nail> collection) {
        this.set = new HashSet<Nail>();
        this.set.addAll(collection);
    }

    public NailHashSet(NailStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Nail> elements = new HashSet<Nail>(stateSet.size());

        for (NailState state : stateSet) {
            NailStateBuilder builder = new NailStateBuilderImpl(state);
            Nail entry = (Nail) builder.as(new NailFactory.NailFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<Nail> {
        private NailStateSet stateSet;

        public StateInSyncSet(NailStateSet stateSet, Set<Nail> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Nail element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NailHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Nail> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NailHashSet.this);
            boolean modified = super.addAll(collection);

            for (Nail element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NailHashSet.this);
            if (!(element instanceof Nail)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Nail) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NailHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Nail) {
                    elements.add(element);
                    states.add(((Nail)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NailHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Nail) {
                    elements.add(element);
                    states.add(((Nail)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(NailHashSet.this);
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

    public Iterator<Nail> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Nail> Nail[] toArray(Nail[] array) {
        return set.toArray(array);
    }

    public boolean add(Nail element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Nail> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Nail)) {
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
