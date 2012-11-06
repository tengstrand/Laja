package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.behaviour.leg.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class LegArrayList implements LegList, RandomAccess, Cloneable, java.io.Serializable {
    protected LegStateList stateList;
    protected final List<Leg> list;

    public LegArrayList(Leg... list) {
        this.list = new ArrayList<Leg>();
        this.list.addAll(Arrays.asList(list));
    }

    public LegArrayList(List<Leg> list) {
        this.list = new ArrayList<Leg>();
        this.list.addAll(list);
    }

    public LegArrayList(LegStateList stateList) {
        this.stateList = stateList;
        List<Leg> elements = new ArrayList<Leg>(stateList.size());

        for (LegState state : stateList) {
            LegStateBuilder builder = new LegStateBuilderImpl(state);
            Leg entry = (Leg) builder.as(new LegFactory.LegFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<Leg> {
        private final LegStateList stateList;

        public StateInSyncList(LegStateList stateList, List<Leg> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Leg element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Leg element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Leg> collection) {
            boolean modified = super.addAll(collection);

            for (Leg element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Leg> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Leg element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Leg)) {
                return false;
            }
            stateList.remove(((Leg) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Leg) {
                    elements.add(element);
                    states.add(((Leg)element).getState(stateList));
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
                if (element instanceof Leg) {
                    elements.add(element);
                    states.add(((Leg)element).getState(stateList));
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
        public Leg set(int index, Leg element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Leg remove(int index) {
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

    public Iterator<Leg> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Leg> Leg[] toArray(Leg[] array) {
        return list.toArray(array);
    }

    public boolean add(Leg element) {
        return list.add(element);
    }

    public void add(int index, Leg element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Leg> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Leg> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Leg)) {
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

    public Leg get(int index) {
        return list.get(index);
    }

    public Leg set(int index, Leg element) {
        return list.set(index, element);
    }

    public Leg remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Leg> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Leg> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Leg> subList(int fromIndex, int toIndex) {
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