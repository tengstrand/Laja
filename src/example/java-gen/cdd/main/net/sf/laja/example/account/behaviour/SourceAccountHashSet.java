package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class SourceAccountHashSet implements SourceAccountSet, RandomAccess, Cloneable, java.io.Serializable {
    protected AccountStateSet stateSet;
    protected final Set<SourceAccount> set;

    public SourceAccountHashSet(SourceAccount... array) {
        this.set = new HashSet<SourceAccount>();
        this.set.addAll(Arrays.asList(array));
    }

    public SourceAccountHashSet(Collection<SourceAccount> collection) {
        this.set = new HashSet<SourceAccount>();
        this.set.addAll(collection);
    }

    public SourceAccountHashSet(AccountStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<SourceAccount> elements = new HashSet<SourceAccount>(stateSet.size());

        for (AccountState state : stateSet) {
            AccountStateBuilder builder = new AccountStateBuilderImpl(state);
            SourceAccount entry = (SourceAccount) builder.as(new AccountFactory.SourceAccountFactory_());
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<SourceAccount> {
        private AccountStateSet stateSet;

        public StateInSyncSet(AccountStateSet stateSet, Set<SourceAccount> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(SourceAccount element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(SourceAccountHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends SourceAccount> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(SourceAccountHashSet.this);
            boolean modified = super.addAll(collection);

            for (SourceAccount element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(SourceAccountHashSet.this);
            if (!(element instanceof SourceAccount)) {
                return false;
            }
            boolean removedState = stateSet.remove(((SourceAccount) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(SourceAccountHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof SourceAccount) {
                    elements.add(element);
                    states.add(((SourceAccount)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(SourceAccountHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof SourceAccount) {
                    elements.add(element);
                    states.add(((SourceAccount)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(SourceAccountHashSet.this);
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

    public Iterator<SourceAccount> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <SourceAccount> SourceAccount[] toArray(SourceAccount[] array) {
        return set.toArray(array);
    }

    public boolean add(SourceAccount element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends SourceAccount> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof SourceAccount)) {
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
