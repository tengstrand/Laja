package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class ToeAbstractList implements List<Toe>, RandomAccess, Cloneable, java.io.Serializable {
    protected ToeStateList stateList;
    protected final List<Toe> list;

    public ToeAbstractList(Toe... list) {
        this.list = new ArrayList<Toe>();
        this.list.addAll(Arrays.asList(list));
    }

    public ToeAbstractList(List<Toe> list) {
        this.list = new ArrayList<Toe>();
        this.list.addAll(list);
    }

    public ToeAbstractList(ToeStateList stateList) {
        this.stateList = stateList;
        List<Toe> elements = new ArrayList<Toe>(stateList.size());

        for (ToeState state : stateList) {
            ToeStateBuilder builder = new ToeStateBuilderImpl(state);
            Toe entry = (Toe) builder.as(new ToeFactory.ToeFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public ValToeList asValToeList() {
        List<ValToe> result = new ArrayList<ValToe>();
        for (Toe entry : list) {
            result.add(entry.asValToe());
        }
        return new ValToeList(result);
    }

    public static class StateInSyncList extends ArrayList<Toe> {
        private final ToeStateList stateList;

        public StateInSyncList(ToeStateList stateList, List<Toe> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Toe element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Toe element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Toe> collection) {
            boolean modified = super.addAll(collection);

            for (Toe element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Toe> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Toe element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Toe)) {
                return false;
            }
            stateList.remove(((Toe) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Toe) {
                    elements.add(element);
                    states.add(((Toe)element).getState(stateList));
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
                if (element instanceof Toe) {
                    elements.add(element);
                    states.add(((Toe)element).getState(stateList));
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
        public Toe set(int index, Toe element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Toe remove(int index) {
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

    public Iterator<Toe> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Toe> Toe[] toArray(Toe[] array) {
        return list.toArray(array);
    }

    public boolean add(Toe element) {
        return list.add(element);
    }

    public void add(int index, Toe element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Toe> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Toe> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Toe)) {
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

    public Toe get(int index) {
        return list.get(index);
    }

    public Toe set(int index, Toe element) {
        return list.set(index, element);
    }

    public Toe remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Toe> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Toe> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Toe> subList(int fromIndex, int toIndex) {
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