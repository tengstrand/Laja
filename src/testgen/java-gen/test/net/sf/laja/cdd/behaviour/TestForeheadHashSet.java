package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TestForeheadHashSet implements TestForeheadSet, RandomAccess, Cloneable, java.io.Serializable {
    protected ForeheadStateSet stateSet;
    protected final Set<TestForehead> set;

    public TestForeheadHashSet(TestForehead... array) {
        this.set = new HashSet<TestForehead>();
        this.set.addAll(Arrays.asList(array));
    }

    public TestForeheadHashSet(Collection<TestForehead> collection) {
        this.set = new HashSet<TestForehead>();
        this.set.addAll(collection);
    }

    public TestForeheadHashSet(ForeheadStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<TestForehead> elements = new HashSet<TestForehead>(stateSet.size());

        for (ForeheadState state : stateSet) {
            ForeheadStateBuilder builder = new ForeheadStateBuilderImpl(state);
            TestForehead entry = (TestForehead) builder.as(new TestForeheadFactory.TestForeheadFactory_());
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public class StateInSyncSet extends HashSet<TestForehead> {
        private ForeheadStateSet stateSet;

        public StateInSyncSet(ForeheadStateSet stateSet, Set<TestForehead> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(TestForehead element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestForeheadHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends TestForehead> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestForeheadHashSet.this);
            boolean modified = super.addAll(collection);

            for (TestForehead element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestForeheadHashSet.this);
            if (!(element instanceof TestForehead)) {
                return false;
            }
            boolean removedState = stateSet.remove(((TestForehead) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestForeheadHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TestForehead) {
                    elements.add(element);
                    states.add(((TestForehead)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestForeheadHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TestForehead) {
                    elements.add(element);
                    states.add(((TestForehead)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestForeheadHashSet.this);
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

    public Iterator<TestForehead> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <TestForehead> TestForehead[] toArray(TestForehead[] array) {
        return set.toArray(array);
    }

    public boolean add(TestForehead element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends TestForehead> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof TestForehead)) {
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
