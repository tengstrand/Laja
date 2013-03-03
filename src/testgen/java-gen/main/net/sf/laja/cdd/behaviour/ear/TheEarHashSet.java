package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.behaviour.ear.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TheEarHashSet implements TheEarSet, RandomAccess, Cloneable, java.io.Serializable {
    protected EarStateSet stateSet;
    protected final Set<TheEar> set;

    public TheEarHashSet(TheEar... array) {
        this.set = new HashSet<TheEar>();
        this.set.addAll(Arrays.asList(array));
    }

    public TheEarHashSet(Collection<TheEar> collection) {
        this.set = new HashSet<TheEar>();
        this.set.addAll(collection);
    }

    public TheEarHashSet(EarStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<TheEar> elements = new HashSet<TheEar>(stateSet.size());

        for (EarState state : stateSet) {
            EarStateBuilder builder = new EarStateBuilderImpl(state);
            TheEar entry = (TheEar) builder.as(new TheEarFactory.TheEarFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<TheEar> {
        private EarStateSet stateSet;

        public StateInSyncSet(EarStateSet stateSet, Set<TheEar> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(TheEar element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TheEarHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends TheEar> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TheEarHashSet.this);
            boolean modified = super.addAll(collection);

            for (TheEar element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TheEarHashSet.this);
            if (!(element instanceof TheEar)) {
                return false;
            }
            boolean removedState = stateSet.remove(((TheEar) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TheEarHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TheEar) {
                    elements.add(element);
                    states.add(((TheEar)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TheEarHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TheEar) {
                    elements.add(element);
                    states.add(((TheEar)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(TheEarHashSet.this);
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

    public Iterator<TheEar> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <TheEar> TheEar[] toArray(TheEar[] array) {
        return set.toArray(array);
    }

    public boolean add(TheEar element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends TheEar> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof TheEar)) {
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