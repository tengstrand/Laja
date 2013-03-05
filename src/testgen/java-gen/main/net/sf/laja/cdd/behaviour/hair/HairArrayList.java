package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.behaviour.hair.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HairArrayList implements HairList, RandomAccess, Cloneable, java.io.Serializable {
    protected HairStateList stateList;
    protected final List<Hair> list;

    public HairArrayList(Hair... array) {
        this.list = new ArrayList<Hair>();
        this.list.addAll(Arrays.asList(array));
    }

    public HairArrayList(Collection<Hair> collection) {
        this.list = new ArrayList<Hair>();
        this.list.addAll(collection);
    }

    public HairArrayList(HairStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<Hair> elements = new ArrayList<Hair>(stateList.size());

        for (HairState state : stateList) {
            HairStateBuilder builder = new HairStateBuilderImpl(state);
            Hair entry = (Hair) builder.as(new HairFactory.HairFactory_());
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public FakeHairArrayList asFakeHairList() {
        if (stateList != null) {
            return new FakeHairArrayList(stateList);
        }
        List<FakeHair> result = new ArrayList<FakeHair>();
        for (Hair entry : list) {
            result.add(entry.asFakeHair());
        }
        return new FakeHairArrayList(result);
    }

    public class StateInSyncList extends ArrayList<Hair> {
        private final HairStateList stateList;

        public StateInSyncList(HairStateList stateList, List<Hair> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Hair element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            stateList.add(element.getState(stateList.certificate()));
            return super.add(element);
        }

        @Override
        public void add(int index, Hair element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            stateList.add(index, element.getState(stateList.certificate()));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Hair> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            boolean modified = super.addAll(collection);

            for (Hair element : collection) {
                stateList.add(element.getState(stateList.certificate()));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Hair> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Hair element : collection) {
                elements.add(element.getState(stateList.certificate()));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            if (!(element instanceof Hair)) {
                return false;
            }
            stateList.remove(((Hair) element).getState(stateList.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Hair) {
                    elements.add(element);
                    states.add(((Hair)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Hair) {
                    elements.add(element);
                    states.add(((Hair)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public Hair set(int index, Hair element) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
            stateList.set(index, element.getState(stateList.certificate()));
            return super.set(index, element);
        }

        @Override
        public Hair remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(HairArrayList.this);
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

    public Iterator<Hair> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Hair> Hair[] toArray(Hair[] array) {
        return list.toArray(array);
    }

    public boolean add(Hair element) {
        return list.add(element);
    }

    public void add(int index, Hair element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Hair> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Hair> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Hair)) {
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

    public Hair get(int index) {
        return list.get(index);
    }

    public Hair set(int index, Hair element) {
        return list.set(index, element);
    }

    public Hair remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Hair> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Hair> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Hair> subList(int fromIndex, int toIndex) {
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
