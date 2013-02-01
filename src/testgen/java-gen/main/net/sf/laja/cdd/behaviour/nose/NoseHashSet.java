package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.behaviour.nose.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class NoseHashSet implements NoseSet, RandomAccess, Cloneable, java.io.Serializable {
    protected NoseStateSet stateSet;
    protected final Set<Nose> set;

    public NoseHashSet(Nose... array) {
        this.set = new HashSet<Nose>();
        this.set.addAll(Arrays.asList(array));
    }

    public NoseHashSet(Collection<Nose> collection) {
        this.set = new HashSet<Nose>();
        this.set.addAll(collection);
    }

    public NoseHashSet(NoseStateSet stateSet, int extraParameter) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Nose> elements = new HashSet<Nose>(stateSet.size());

        for (NoseState state : stateSet) {
            NoseStateBuilder builder = new NoseStateBuilderImpl(state);
            Nose entry = (Nose) builder.as(new NoseFactory.NoseFactory_(builder), extraParameter);
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public BigNoseHashSet asBigNoseSet() {
        if (stateSet != null) {
            return new BigNoseHashSet(stateSet);
        }
        Set<BigNose> result = new HashSet<BigNose>();
        for (Nose entry : set) {
            result.add(entry.asBigNose());
        }
        return new BigNoseHashSet(result);
    }

    public class StateInSyncSet extends HashSet<Nose> {
        private NoseStateSet stateSet;

        public StateInSyncSet(NoseStateSet stateSet, Set<Nose> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Nose element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NoseHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Nose> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NoseHashSet.this);
            boolean modified = super.addAll(collection);

            for (Nose element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NoseHashSet.this);
            if (!(element instanceof Nose)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Nose) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NoseHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Nose) {
                    elements.add(element);
                    states.add(((Nose)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(NoseHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Nose) {
                    elements.add(element);
                    states.add(((Nose)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(NoseHashSet.this);
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

    public Iterator<Nose> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Nose> Nose[] toArray(Nose[] array) {
        return set.toArray(array);
    }

    public boolean add(Nose element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Nose> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Nose)) {
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
