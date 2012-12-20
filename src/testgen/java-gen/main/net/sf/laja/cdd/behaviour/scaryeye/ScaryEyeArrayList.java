package net.sf.laja.cdd.behaviour.scaryeye;

import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.eye.*;

import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.eye.EyeFactory;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ScaryEyeArrayList implements ScaryEyeList, RandomAccess, Cloneable, java.io.Serializable {
    protected EyeStateList stateList;
    protected final List<ScaryEye> list;

    public ScaryEyeArrayList(ScaryEye... list) {
        this.list = new ArrayList<ScaryEye>();
        this.list.addAll(Arrays.asList(list));
    }

    public ScaryEyeArrayList(Collection<ScaryEye> list) {
        this.list = new ArrayList<ScaryEye>();
        this.list.addAll(list);
    }

    public class StateInSyncList extends ArrayList<ScaryEye> {
        private final EyeStateList stateList;

        public StateInSyncList(EyeStateList stateList, List<ScaryEye> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(ScaryEye element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, ScaryEye element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends ScaryEye> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            boolean modified = super.addAll(collection);

            for (ScaryEye element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends ScaryEye> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (ScaryEye element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            if (!(element instanceof ScaryEye)) {
                return false;
            }
            stateList.remove(((ScaryEye) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof ScaryEye) {
                    elements.add(element);
                    states.add(((ScaryEye)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof ScaryEye) {
                    elements.add(element);
                    states.add(((ScaryEye)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public ScaryEye set(int index, ScaryEye element) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public ScaryEye remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(ScaryEyeArrayList.this);
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

    public Iterator<ScaryEye> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <ScaryEye> ScaryEye[] toArray(ScaryEye[] array) {
        return list.toArray(array);
    }

    public boolean add(ScaryEye element) {
        return list.add(element);
    }

    public void add(int index, ScaryEye element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends ScaryEye> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends ScaryEye> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof ScaryEye)) {
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

    public ScaryEye get(int index) {
        return list.get(index);
    }

    public ScaryEye set(int index, ScaryEye element) {
        return list.set(index, element);
    }

    public ScaryEye remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<ScaryEye> listIterator() {
        return list.listIterator();
    }

    public ListIterator<ScaryEye> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<ScaryEye> subList(int fromIndex, int toIndex) {
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
