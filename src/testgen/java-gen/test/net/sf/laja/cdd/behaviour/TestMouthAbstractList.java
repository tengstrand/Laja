package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.*;

import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthList;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class TestMouthAbstractList implements List<TestMouth>, RandomAccess, Cloneable, java.io.Serializable {
    protected MouthStateList stateList;
    protected final List<TestMouth> list;

    public TestMouthAbstractList(TestMouth... list) {
        this.list = new ArrayList<TestMouth>();
        this.list.addAll(Arrays.asList(list));
    }

    public TestMouthAbstractList(List<TestMouth> list) {
        this.list = new ArrayList<TestMouth>();
        this.list.addAll(list);
    }

    public TestMouthAbstractList(MouthStateList stateList) {
        this.stateList = stateList;
        List<TestMouth> elements = new ArrayList<TestMouth>(stateList.size());

        for (MouthState state : stateList) {
            MouthStateBuilder builder = new MouthStateBuilderImpl(state);
            TestMouth entry = (TestMouth) builder.as(new TestMouthFactory.TestMouthFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public CuteMouthList asCuteMouthList() {
        List<CuteMouth> result = new ArrayList<CuteMouth>();
        for (TestMouth entry : list) {
            result.add(entry.asCuteMouth());
        }
        return new CuteMouthList(result);
    }

    public static class StateInSyncList extends ArrayList<TestMouth> {
        private final MouthStateList stateList;

        public StateInSyncList(MouthStateList stateList, List<TestMouth> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(TestMouth element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, TestMouth element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends TestMouth> collection) {
            boolean modified = super.addAll(collection);

            for (TestMouth element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends TestMouth> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (TestMouth element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof TestMouth)) {
                return false;
            }
            stateList.remove(((TestMouth) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof TestMouth) {
                    elements.add(element);
                    states.add(((TestMouth)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof TestMouth) {
                    elements.add(element);
                    states.add(((TestMouth)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.clear();
            super.clear();
        }

        @Override
        public TestMouth set(int index, TestMouth element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public TestMouth remove(int index) {
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

    public Iterator<TestMouth> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <TestMouth> TestMouth[] toArray(TestMouth[] array) {
        return list.toArray(array);
    }

    public boolean add(TestMouth element) {
        return list.add(element);
    }

    public void add(int index, TestMouth element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends TestMouth> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends TestMouth> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof TestMouth)) {
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

    public TestMouth get(int index) {
        return list.get(index);
    }

    public TestMouth set(int index, TestMouth element) {
        return list.set(index, element);
    }

    public TestMouth remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<TestMouth> listIterator() {
        return list.listIterator();
    }

    public ListIterator<TestMouth> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<TestMouth> subList(int fromIndex, int toIndex) {
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
