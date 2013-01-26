package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class AtariSTHashSet implements AtariSTSet, RandomAccess, Cloneable, java.io.Serializable {
    protected ComputerStateList stateSet;
    protected final Set<AtariST> set;

    public AtariSTHashSet(AtariST... array) {
        this.set = new HashSet<AtariST>();
        this.set.addAll(Arrays.asList(array));
    }

    public AtariSTHashSet(Collection<AtariST> collection) {
        this.set = new HashSet<AtariST>();
        this.set.addAll(collection);
    }

    public AtariSTHashSet(ComputerStateList stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<AtariST> elements = new HashSet<AtariST>(stateSet.size());

        for (ComputerState state : stateSet) {
            ComputerStateBuilder builder = new ComputerStateBuilderImpl(state);
            AtariST entry = (AtariST) builder.as(new AtariFactory.AtariSTFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<AtariST> {
        private final ComputerStateList stateSet;

        public StateInSyncSet(ComputerStateList stateSet, Set<AtariST> elements) {
            this.stateSet = stateSet;
            super.addAll(elements);
        }

        @Override
        public boolean add(AtariST element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(AtariSTHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends AtariST> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(AtariSTHashSet.this);
            boolean modified = super.addAll(collection);

            for (AtariST element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(AtariSTHashSet.this);
            if (!(element instanceof AtariST)) {
                return false;
            }
            stateSet.remove(((AtariST) element).getState(stateSet.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(AtariSTHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof AtariST) {
                    elements.add(element);
                    states.add(((AtariST)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(AtariSTHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof AtariST) {
                    elements.add(element);
                    states.add(((AtariST)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(AtariSTHashSet.this);
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

    public Iterator<AtariST> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <AtariST> AtariST[] toArray(AtariST[] array) {
        return set.toArray(array);
    }

    public boolean add(AtariST element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends AtariST> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof AtariST)) {
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
