package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TestBrowHashSet implements TestBrowSet, RandomAccess, Cloneable, java.io.Serializable {
    protected BrowStateSet stateSet;
    protected final Set<TestBrow> set;

    public TestBrowHashSet(TestBrow... array) {
        this.set = new HashSet<TestBrow>();
        this.set.addAll(Arrays.asList(array));
    }

    public TestBrowHashSet(Collection<TestBrow> collection) {
        this.set = new HashSet<TestBrow>();
        this.set.addAll(collection);
    }

    public TestBrowHashSet(BrowStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<TestBrow> elements = new HashSet<TestBrow>(stateSet.size());

        for (BrowState state : stateSet) {
            BrowStateBuilder builder = new BrowStateBuilderImpl(state);
            TestBrow entry = (TestBrow) builder.as(new TestBrowFactory.TestBrowFactory_(builder));
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<TestBrow> {
        private BrowStateSet stateSet;

        public StateInSyncSet(BrowStateSet stateSet, Set<TestBrow> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(TestBrow element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestBrowHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends TestBrow> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestBrowHashSet.this);
            boolean modified = super.addAll(collection);

            for (TestBrow element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestBrowHashSet.this);
            if (!(element instanceof TestBrow)) {
                return false;
            }
            boolean removedState = stateSet.remove(((TestBrow) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestBrowHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TestBrow) {
                    elements.add(element);
                    states.add(((TestBrow)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestBrowHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TestBrow) {
                    elements.add(element);
                    states.add(((TestBrow)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestBrowHashSet.this);
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

    public Iterator<TestBrow> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <TestBrow> TestBrow[] toArray(TestBrow[] array) {
        return set.toArray(array);
    }

    public boolean add(TestBrow element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends TestBrow> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof TestBrow)) {
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
