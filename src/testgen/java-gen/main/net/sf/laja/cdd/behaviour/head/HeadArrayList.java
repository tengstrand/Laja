package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.state.head.*;
import net.sf.laja.cdd.behaviour.head.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HeadArrayList implements HeadList, RandomAccess, Cloneable, java.io.Serializable {
    protected HeadStateList stateList;
    protected final List<Head> list;

    public HeadArrayList(Head... list) {
        this.list = new ArrayList<Head>();
        this.list.addAll(Arrays.asList(list));
    }

    public HeadArrayList(Collection<Head> list) {
        this.list = new ArrayList<Head>();
        this.list.addAll(list);
    }

    public HeadArrayList(HeadStateList stateList) {
        this.stateList = stateList;
        List<Head> elements = new ArrayList<Head>(stateList.size());

        for (HeadState state : stateList) {
            HeadStateBuilder builder = new HeadStateBuilderImpl(state);
            Head entry = (Head) builder.as(new HeadFactory.HeadFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<Head> {
        private final HeadStateList stateList;

        public StateInSyncList(HeadStateList stateList, List<Head> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Head element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Head element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Head> collection) {
            boolean modified = super.addAll(collection);

            for (Head element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Head> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Head element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Head)) {
                return false;
            }
            stateList.remove(((Head) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Head) {
                    elements.add(element);
                    states.add(((Head)element).getState(stateList));
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
                if (element instanceof Head) {
                    elements.add(element);
                    states.add(((Head)element).getState(stateList));
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
        public Head set(int index, Head element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Head remove(int index) {
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

    public Iterator<Head> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Head> Head[] toArray(Head[] array) {
        return list.toArray(array);
    }

    public boolean add(Head element) {
        return list.add(element);
    }

    public void add(int index, Head element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Head> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Head> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Head)) {
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

    public Head get(int index) {
        return list.get(index);
    }

    public Head set(int index, Head element) {
        return list.set(index, element);
    }

    public Head remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Head> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Head> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Head> subList(int fromIndex, int toIndex) {
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
