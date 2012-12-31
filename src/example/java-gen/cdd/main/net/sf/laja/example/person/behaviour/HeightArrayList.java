package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HeightArrayList implements HeightList, RandomAccess, Cloneable, java.io.Serializable {
    protected HeightStateList stateList;
    protected final List<Height> list;

    public HeightArrayList(Height... list) {
        this.list = new ArrayList<Height>();
        this.list.addAll(Arrays.asList(list));
    }

    public HeightArrayList(Collection<Height> list) {
        this.list = new ArrayList<Height>();
        this.list.addAll(list);
    }

    public HeightArrayList(HeightStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<Height> elements = new ArrayList<Height>(stateList.size());

        for (HeightState state : stateList) {
            HeightStateBuilder builder = new HeightStateBuilderImpl(state);
            Height entry = (Height) builder.as(new HeightFactory.HeightFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<Height> {
        private final HeightStateList stateList;

        public StateInSyncList(HeightStateList stateList, List<Height> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Height element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Height element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Height> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            boolean modified = super.addAll(collection);

            for (Height element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Height> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Height element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            if (!(element instanceof Height)) {
                return false;
            }
            stateList.remove(((Height) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Height) {
                    elements.add(element);
                    states.add(((Height)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Height) {
                    elements.add(element);
                    states.add(((Height)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public Height set(int index, Height element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Height remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(HeightArrayList.this);
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

    public Iterator<Height> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Height> Height[] toArray(Height[] array) {
        return list.toArray(array);
    }

    public boolean add(Height element) {
        return list.add(element);
    }

    public void add(int index, Height element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Height> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Height> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Height)) {
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

    public Height get(int index) {
        return list.get(index);
    }

    public Height set(int index, Height element) {
        return list.set(index, element);
    }

    public Height remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Height> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Height> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Height> subList(int fromIndex, int toIndex) {
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
