package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.behaviour.brow.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BrowArrayList implements BrowList, RandomAccess, Cloneable, java.io.Serializable {
    protected BrowStateList stateList;
    protected final List<Brow> list;

    public BrowArrayList(Brow... list) {
        this.list = new ArrayList<Brow>();
        this.list.addAll(Arrays.asList(list));
    }

    public BrowArrayList(List<Brow> list) {
        this.list = new ArrayList<Brow>();
        this.list.addAll(list);
    }

    public BrowArrayList(BrowStateList stateList) {
        this.stateList = stateList;
        List<Brow> elements = new ArrayList<Brow>(stateList.size());

        for (BrowState state : stateList) {
            BrowStateBuilder builder = new BrowStateBuilderImpl(state);
            Brow entry = (Brow) builder.as(new BrowFactory.BrowFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<Brow> {
        private final BrowStateList stateList;

        public StateInSyncList(BrowStateList stateList, List<Brow> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Brow element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Brow element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Brow> collection) {
            boolean modified = super.addAll(collection);

            for (Brow element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Brow> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Brow element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Brow)) {
                return false;
            }
            stateList.remove(((Brow) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Brow) {
                    elements.add(element);
                    states.add(((Brow)element).getState(stateList));
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
                if (element instanceof Brow) {
                    elements.add(element);
                    states.add(((Brow)element).getState(stateList));
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
        public Brow set(int index, Brow element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Brow remove(int index) {
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

    public Iterator<Brow> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Brow> Brow[] toArray(Brow[] array) {
        return list.toArray(array);
    }

    public boolean add(Brow element) {
        return list.add(element);
    }

    public void add(int index, Brow element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Brow> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Brow> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Brow)) {
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

    public Brow get(int index) {
        return list.get(index);
    }

    public Brow set(int index, Brow element) {
        return list.set(index, element);
    }

    public Brow remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Brow> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Brow> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Brow> subList(int fromIndex, int toIndex) {
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
