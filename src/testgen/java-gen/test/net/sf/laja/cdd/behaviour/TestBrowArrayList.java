package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TestBrowArrayList implements TestBrowList, RandomAccess, Cloneable, java.io.Serializable {
    protected BrowStateList stateList;
    protected final List<TestBrow> list;

    public TestBrowArrayList(TestBrow... array) {
        this.list = new ArrayList<TestBrow>();
        this.list.addAll(Arrays.asList(array));
    }

    public TestBrowArrayList(Collection<TestBrow> collection) {
        this.list = new ArrayList<TestBrow>();
        this.list.addAll(collection);
    }

    public TestBrowArrayList(BrowStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<TestBrow> elements = new ArrayList<TestBrow>(stateList.size());

        for (BrowState state : stateList) {
            BrowStateBuilder builder = new BrowStateBuilderImpl(state);
            TestBrow entry = (TestBrow) builder.as(new TestBrowFactory.TestBrowFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<TestBrow> {
        private final BrowStateList stateList;

        public StateInSyncList(BrowStateList stateList, List<TestBrow> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(TestBrow element) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            stateList.add(element.getState(stateList.certificate()));
            return super.add(element);
        }

        @Override
        public void add(int index, TestBrow element) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            stateList.add(index, element.getState(stateList.certificate()));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends TestBrow> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            boolean modified = super.addAll(collection);

            for (TestBrow element : collection) {
                stateList.add(element.getState(stateList.certificate()));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends TestBrow> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (TestBrow element : collection) {
                elements.add(element.getState(stateList.certificate()));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            if (!(element instanceof TestBrow)) {
                return false;
            }
            stateList.remove(((TestBrow) element).getState(stateList.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof TestBrow) {
                    elements.add(element);
                    states.add(((TestBrow)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof TestBrow) {
                    elements.add(element);
                    states.add(((TestBrow)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public TestBrow set(int index, TestBrow element) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            stateList.set(index, element.getState(stateList.certificate()));
            return super.set(index, element);
        }

        @Override
        public TestBrow remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(TestBrowArrayList.this);
            stateList.remove(index);
            return super.remove(index);
        }
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object element) {
        return list.contains(element);
    }

    public Iterator<TestBrow> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <TestBrow> TestBrow[] toArray(TestBrow[] array) {
        return list.toArray(array);
    }

    public boolean add(TestBrow element) {
        return list.add(element);
    }

    public void add(int index, TestBrow element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends TestBrow> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends TestBrow> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof TestBrow)) {
            return false;
        }
        return list.remove(element);
    }

    public boolean containsAll(Collection<?> collection) {
        return list.containsAll(collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return list.retainAll(collection);
    }

    public void clear() {
        list.clear();
    }

    public TestBrow get(int index) {
        return list.get(index);
    }

    public TestBrow set(int index, TestBrow element) {
        return list.set(index, element);
    }

    public TestBrow remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<TestBrow> listIterator() {
        return list.listIterator();
    }

    public ListIterator<TestBrow> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<TestBrow> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object o) {
        return list.equals(o);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + list + '}';
    }
}
