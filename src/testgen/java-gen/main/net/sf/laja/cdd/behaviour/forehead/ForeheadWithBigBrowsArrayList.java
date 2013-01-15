package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.forehead.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ForeheadWithBigBrowsArrayList implements ForeheadWithBigBrowsList, RandomAccess, Cloneable, java.io.Serializable {
    protected ForeheadStateList stateList;
    protected final List<ForeheadWithBigBrows> list;

    public ForeheadWithBigBrowsArrayList(ForeheadWithBigBrows... list) {
        this.list = new ArrayList<ForeheadWithBigBrows>();
        this.list.addAll(Arrays.asList(list));
    }

    public ForeheadWithBigBrowsArrayList(Collection<ForeheadWithBigBrows> list) {
        this.list = new ArrayList<ForeheadWithBigBrows>();
        this.list.addAll(list);
    }

    public ForeheadWithBigBrowsArrayList(ForeheadStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<ForeheadWithBigBrows> elements = new ArrayList<ForeheadWithBigBrows>(stateList.size());

        for (ForeheadState state : stateList) {
            ForeheadStateBuilder builder = new ForeheadStateBuilderImpl(state);
            ForeheadWithBigBrows entry = (ForeheadWithBigBrows) builder.as(new ForeheadFactory.ForeheadWithBigBrowsFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<ForeheadWithBigBrows> {
        private final ForeheadStateList stateList;

        public StateInSyncList(ForeheadStateList stateList, List<ForeheadWithBigBrows> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(ForeheadWithBigBrows element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            stateList.add(element.getState(stateList.certificate()));
            return super.add(element);
        }

        @Override
        public void add(int index, ForeheadWithBigBrows element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            stateList.add(index, element.getState(stateList.certificate()));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends ForeheadWithBigBrows> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            boolean modified = super.addAll(collection);

            for (ForeheadWithBigBrows element : collection) {
                stateList.add(element.getState(stateList.certificate()));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends ForeheadWithBigBrows> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (ForeheadWithBigBrows element : collection) {
                elements.add(element.getState(stateList.certificate()));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            if (!(element instanceof ForeheadWithBigBrows)) {
                return false;
            }
            stateList.remove(((ForeheadWithBigBrows) element).getState(stateList.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof ForeheadWithBigBrows) {
                    elements.add(element);
                    states.add(((ForeheadWithBigBrows)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof ForeheadWithBigBrows) {
                    elements.add(element);
                    states.add(((ForeheadWithBigBrows)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public ForeheadWithBigBrows set(int index, ForeheadWithBigBrows element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
            stateList.set(index, element.getState(stateList.certificate()));
            return super.set(index, element);
        }

        @Override
        public ForeheadWithBigBrows remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(ForeheadWithBigBrowsArrayList.this);
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

    public Iterator<ForeheadWithBigBrows> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <ForeheadWithBigBrows> ForeheadWithBigBrows[] toArray(ForeheadWithBigBrows[] array) {
        return list.toArray(array);
    }

    public boolean add(ForeheadWithBigBrows element) {
        return list.add(element);
    }

    public void add(int index, ForeheadWithBigBrows element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends ForeheadWithBigBrows> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends ForeheadWithBigBrows> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof ForeheadWithBigBrows)) {
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

    public ForeheadWithBigBrows get(int index) {
        return list.get(index);
    }

    public ForeheadWithBigBrows set(int index, ForeheadWithBigBrows element) {
        return list.set(index, element);
    }

    public ForeheadWithBigBrows remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<ForeheadWithBigBrows> listIterator() {
        return list.listIterator();
    }

    public ListIterator<ForeheadWithBigBrows> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<ForeheadWithBigBrows> subList(int fromIndex, int toIndex) {
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
