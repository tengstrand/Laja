package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class AtariFalcon030ArrayList implements AtariFalcon030List, RandomAccess, Cloneable, java.io.Serializable {
    protected ComputerStateList stateList;
    protected final List<AtariFalcon030> list;

    public AtariFalcon030ArrayList(AtariFalcon030... list) {
        this.list = new ArrayList<AtariFalcon030>();
        this.list.addAll(Arrays.asList(list));
    }

    public AtariFalcon030ArrayList(Collection<AtariFalcon030> list) {
        this.list = new ArrayList<AtariFalcon030>();
        this.list.addAll(list);
    }

    public AtariFalcon030ArrayList(ComputerStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<AtariFalcon030> elements = new ArrayList<AtariFalcon030>(stateList.size());

        for (ComputerState state : stateList) {
            ComputerStateBuilder builder = new ComputerStateBuilderImpl(state);
            AtariFalcon030 entry = (AtariFalcon030) builder.as(new AtariFactory.AtariFalcon030Factory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<AtariFalcon030> {
        private final ComputerStateList stateList;

        public StateInSyncList(ComputerStateList stateList, List<AtariFalcon030> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(AtariFalcon030 element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, AtariFalcon030 element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends AtariFalcon030> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            boolean modified = super.addAll(collection);

            for (AtariFalcon030 element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends AtariFalcon030> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (AtariFalcon030 element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            if (!(element instanceof AtariFalcon030)) {
                return false;
            }
            stateList.remove(((AtariFalcon030) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof AtariFalcon030) {
                    elements.add(element);
                    states.add(((AtariFalcon030)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof AtariFalcon030) {
                    elements.add(element);
                    states.add(((AtariFalcon030)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public AtariFalcon030 set(int index, AtariFalcon030 element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public AtariFalcon030 remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(AtariFalcon030ArrayList.this);
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

    public Iterator<AtariFalcon030> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <AtariFalcon030> AtariFalcon030[] toArray(AtariFalcon030[] array) {
        return list.toArray(array);
    }

    public boolean add(AtariFalcon030 element) {
        return list.add(element);
    }

    public void add(int index, AtariFalcon030 element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends AtariFalcon030> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends AtariFalcon030> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof AtariFalcon030)) {
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

    public AtariFalcon030 get(int index) {
        return list.get(index);
    }

    public AtariFalcon030 set(int index, AtariFalcon030 element) {
        return list.set(index, element);
    }

    public AtariFalcon030 remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<AtariFalcon030> listIterator() {
        return list.listIterator();
    }

    public ListIterator<AtariFalcon030> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<AtariFalcon030> subList(int fromIndex, int toIndex) {
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
