package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TruckArrayList implements TruckList, RandomAccess, Cloneable, java.io.Serializable {
    protected TruckStateList stateList;
    protected final List<Truck> list;

    public TruckArrayList(Truck... list) {
        this.list = new ArrayList<Truck>();
        this.list.addAll(Arrays.asList(list));
    }

    public TruckArrayList(List<Truck> list) {
        this.list = new ArrayList<Truck>();
        this.list.addAll(list);
    }

    public TruckArrayList(TruckStateList stateList) {
        this.stateList = stateList;
        List<Truck> elements = new ArrayList<Truck>(stateList.size());

        for (TruckState state : stateList) {
            TruckStateBuilder builder = new TruckStateBuilderImpl(state);
            Truck entry = (Truck) builder.as(new TruckFactory.TruckFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<Truck> {
        private final TruckStateList stateList;

        public StateInSyncList(TruckStateList stateList, List<Truck> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Truck element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Truck element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Truck> collection) {
            boolean modified = super.addAll(collection);

            for (Truck element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Truck> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Truck element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Truck)) {
                return false;
            }
            stateList.remove(((Truck) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Truck) {
                    elements.add(element);
                    states.add(((Truck)element).getState(stateList));
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
                if (element instanceof Truck) {
                    elements.add(element);
                    states.add(((Truck)element).getState(stateList));
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
        public Truck set(int index, Truck element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Truck remove(int index) {
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

    public Iterator<Truck> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Truck> Truck[] toArray(Truck[] array) {
        return list.toArray(array);
    }

    public boolean add(Truck element) {
        return list.add(element);
    }

    public void add(int index, Truck element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Truck> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Truck> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Truck)) {
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

    public Truck get(int index) {
        return list.get(index);
    }

    public Truck set(int index, Truck element) {
        return list.set(index, element);
    }

    public Truck remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Truck> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Truck> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Truck> subList(int fromIndex, int toIndex) {
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