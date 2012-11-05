package net.sf.laja.example.computer.behaviour;

import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AtariSTArrayList implements AtariSTList, RandomAccess, Cloneable, java.io.Serializable {
    protected ComputerStateList stateList;
    protected final List<AtariST> list;

    public AtariSTArrayList(AtariST... list) {
        this.list = new ArrayList<AtariST>();
        this.list.addAll(Arrays.asList(list));
    }

    public AtariSTArrayList(List<AtariST> list) {
        this.list = new ArrayList<AtariST>();
        this.list.addAll(list);
    }

    public AtariSTArrayList(ComputerStateList stateList) {
        this.stateList = stateList;
        List<AtariST> elements = new ArrayList<AtariST>(stateList.size());

        for (ComputerState state : stateList) {
            ComputerStateBuilder builder = new ComputerStateBuilderImpl(state);
            AtariST entry = (AtariST) builder.as(new AtariFactory.AtariSTFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<AtariST> {
        private final ComputerStateList stateList;

        public StateInSyncList(ComputerStateList stateList, List<AtariST> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(AtariST element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, AtariST element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends AtariST> collection) {
            boolean modified = super.addAll(collection);

            for (AtariST element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends AtariST> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (AtariST element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof AtariST)) {
                return false;
            }
            stateList.remove(((AtariST) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof AtariST) {
                    elements.add(element);
                    states.add(((AtariST)element).getState(stateList));
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
                if (element instanceof AtariST) {
                    elements.add(element);
                    states.add(((AtariST)element).getState(stateList));
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
        public AtariST set(int index, AtariST element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public AtariST remove(int index) {
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

    public Iterator<AtariST> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <AtariST> AtariST[] toArray(AtariST[] array) {
        return list.toArray(array);
    }

    public boolean add(AtariST element) {
        return list.add(element);
    }

    public void add(int index, AtariST element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends AtariST> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends AtariST> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof AtariST)) {
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

    public AtariST get(int index) {
        return list.get(index);
    }

    public AtariST set(int index, AtariST element) {
        return list.set(index, element);
    }

    public AtariST remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<AtariST> listIterator() {
        return list.listIterator();
    }

    public ListIterator<AtariST> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<AtariST> subList(int fromIndex, int toIndex) {
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
