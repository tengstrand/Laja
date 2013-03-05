package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class BodyMassIndexArrayList implements BodyMassIndexList, RandomAccess, Cloneable, java.io.Serializable {
    protected BmiStateList stateList;
    protected final List<BodyMassIndex> list;

    public BodyMassIndexArrayList(BodyMassIndex... array) {
        this.list = new ArrayList<BodyMassIndex>();
        this.list.addAll(Arrays.asList(array));
    }

    public BodyMassIndexArrayList(Collection<BodyMassIndex> collection) {
        this.list = new ArrayList<BodyMassIndex>();
        this.list.addAll(collection);
    }

    public BodyMassIndexArrayList(BmiStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<BodyMassIndex> elements = new ArrayList<BodyMassIndex>(stateList.size());

        for (BmiState state : stateList) {
            BmiStateBuilder builder = new BmiStateBuilderImpl(state);
            BodyMassIndex entry = (BodyMassIndex) builder.as(new BodyMassIndexFactory.BodyMassIndexFactory_());
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<BodyMassIndex> {
        private final BmiStateList stateList;

        public StateInSyncList(BmiStateList stateList, List<BodyMassIndex> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(BodyMassIndex element) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            stateList.add(element.getState(stateList.certificate()));
            return super.add(element);
        }

        @Override
        public void add(int index, BodyMassIndex element) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            stateList.add(index, element.getState(stateList.certificate()));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends BodyMassIndex> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            boolean modified = super.addAll(collection);

            for (BodyMassIndex element : collection) {
                stateList.add(element.getState(stateList.certificate()));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends BodyMassIndex> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (BodyMassIndex element : collection) {
                elements.add(element.getState(stateList.certificate()));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            if (!(element instanceof BodyMassIndex)) {
                return false;
            }
            stateList.remove(((BodyMassIndex) element).getState(stateList.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof BodyMassIndex) {
                    elements.add(element);
                    states.add(((BodyMassIndex)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof BodyMassIndex) {
                    elements.add(element);
                    states.add(((BodyMassIndex)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public BodyMassIndex set(int index, BodyMassIndex element) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
            stateList.set(index, element.getState(stateList.certificate()));
            return super.set(index, element);
        }

        @Override
        public BodyMassIndex remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(BodyMassIndexArrayList.this);
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

    public Iterator<BodyMassIndex> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <BodyMassIndex> BodyMassIndex[] toArray(BodyMassIndex[] array) {
        return list.toArray(array);
    }

    public boolean add(BodyMassIndex element) {
        return list.add(element);
    }

    public void add(int index, BodyMassIndex element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends BodyMassIndex> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends BodyMassIndex> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof BodyMassIndex)) {
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

    public BodyMassIndex get(int index) {
        return list.get(index);
    }

    public BodyMassIndex set(int index, BodyMassIndex element) {
        return list.set(index, element);
    }

    public BodyMassIndex remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<BodyMassIndex> listIterator() {
        return list.listIterator();
    }

    public ListIterator<BodyMassIndex> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<BodyMassIndex> subList(int fromIndex, int toIndex) {
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
