package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.*;

import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthSet;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthHashSet;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TestMouthHashSet implements TestMouthSet, RandomAccess, Cloneable, java.io.Serializable {
    protected MouthStateSet stateSet;
    protected final Set<TestMouth> set;

    public TestMouthHashSet(TestMouth... array) {
        this.set = new HashSet<TestMouth>();
        this.set.addAll(Arrays.asList(array));
    }

    public TestMouthHashSet(Collection<TestMouth> collection) {
        this.set = new HashSet<TestMouth>();
        this.set.addAll(collection);
    }

    public TestMouthHashSet(MouthStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<TestMouth> elements = new HashSet<TestMouth>(stateSet.size());

        for (MouthState state : stateSet) {
            MouthStateBuilder builder = new MouthStateBuilderImpl(state);
            TestMouth entry = (TestMouth) builder.as(new TestMouthFactory.TestMouthFactory_());
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public CuteMouthHashSet asCuteMouthSet() {
        Set<CuteMouth> result = new HashSet<CuteMouth>();
        for (TestMouth entry : set) {
            result.add(entry.asCuteMouth());
        }
        return new CuteMouthHashSet(result);
    }

    public class StateInSyncSet extends HashSet<TestMouth> {
        private MouthStateSet stateSet;

        public StateInSyncSet(MouthStateSet stateSet, Set<TestMouth> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(TestMouth element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestMouthHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends TestMouth> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestMouthHashSet.this);
            boolean modified = super.addAll(collection);

            for (TestMouth element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestMouthHashSet.this);
            if (!(element instanceof TestMouth)) {
                return false;
            }
            boolean removedState = stateSet.remove(((TestMouth) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestMouthHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TestMouth) {
                    elements.add(element);
                    states.add(((TestMouth)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestMouthHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof TestMouth) {
                    elements.add(element);
                    states.add(((TestMouth)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(TestMouthHashSet.this);
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

    public Iterator<TestMouth> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <TestMouth> TestMouth[] toArray(TestMouth[] array) {
        return set.toArray(array);
    }

    public boolean add(TestMouth element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends TestMouth> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof TestMouth)) {
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
