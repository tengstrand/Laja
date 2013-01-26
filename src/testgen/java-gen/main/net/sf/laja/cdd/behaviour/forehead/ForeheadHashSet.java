package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.forehead.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ForeheadHashSet implements ForeheadSet, RandomAccess, Cloneable, java.io.Serializable {
    protected ForeheadStateList stateSet;
    protected final Set<Forehead> set;

    public ForeheadHashSet(Forehead... array) {
        this.set = new HashSet<Forehead>();
        this.set.addAll(Arrays.asList(array));
    }

    public ForeheadHashSet(Collection<Forehead> collection) {
        this.set = new HashSet<Forehead>();
        this.set.addAll(collection);
    }

    public ForeheadHashSet(ForeheadStateList stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Forehead> elements = new HashSet<Forehead>(stateSet.size());

        for (ForeheadState state : stateSet) {
            ForeheadStateBuilder builder = new ForeheadStateBuilderImpl(state);
            Forehead entry = (Forehead) builder.as(new ForeheadFactory.ForeheadFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public ForeheadWithBigBrowsHashSet asForeheadWithBigBrowsSet() {
        if (stateSet != null) {
            return new ForeheadWithBigBrowsHashSet(stateSet);
        }
        Set<ForeheadWithBigBrows> result = new HashSet<ForeheadWithBigBrows>();
        for (Forehead entry : set) {
            result.add(entry.asForeheadWithBigBrows());
        }
        return new ForeheadWithBigBrowsHashSet(result);
    }

    public class StateInSyncSet extends HashSet<Forehead> {
        private final ForeheadStateList stateSet;

        public StateInSyncSet(ForeheadStateList stateSet, Set<Forehead> elements) {
            this.stateSet = stateSet;
            super.addAll(elements);
        }

        @Override
        public boolean add(Forehead element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(ForeheadHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Forehead> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(ForeheadHashSet.this);
            boolean modified = super.addAll(collection);

            for (Forehead element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(ForeheadHashSet.this);
            if (!(element instanceof Forehead)) {
                return false;
            }
            stateSet.remove(((Forehead) element).getState(stateSet.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(ForeheadHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Forehead) {
                    elements.add(element);
                    states.add(((Forehead)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(ForeheadHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Forehead) {
                    elements.add(element);
                    states.add(((Forehead)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(ForeheadHashSet.this);
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

    public Iterator<Forehead> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Forehead> Forehead[] toArray(Forehead[] array) {
        return set.toArray(array);
    }

    public boolean add(Forehead element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Forehead> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Forehead)) {
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
