package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.terrestrial.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TerrestrialArrayList implements TerrestrialList, RandomAccess, Cloneable, java.io.Serializable {
    protected TerrestrialStateList stateList;
    protected final List<Terrestrial> list;

    public TerrestrialArrayList(Terrestrial... list) {
        this.list = new ArrayList<Terrestrial>();
        this.list.addAll(Arrays.asList(list));
    }

    public TerrestrialArrayList(List<Terrestrial> list) {
        this.list = new ArrayList<Terrestrial>();
        this.list.addAll(list);
    }

    public TerrestrialArrayList(TerrestrialStateList stateList) {
        this.stateList = stateList;
        List<Terrestrial> elements = new ArrayList<Terrestrial>(stateList.size());

        for (TerrestrialState state : stateList) {
            TerrestrialStateBuilder builder = new TerrestrialStateBuilderImpl(state);
            Terrestrial entry = (Terrestrial) builder.as(new TerrestrialFactory.TerrestrialFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<Terrestrial> {
        private final TerrestrialStateList stateList;

        public StateInSyncList(TerrestrialStateList stateList, List<Terrestrial> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Terrestrial element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Terrestrial element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Terrestrial> collection) {
            boolean modified = super.addAll(collection);

            for (Terrestrial element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Terrestrial> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Terrestrial element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Terrestrial)) {
                return false;
            }
            stateList.remove(((Terrestrial) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Terrestrial) {
                    elements.add(element);
                    states.add(((Terrestrial)element).getState(stateList));
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
                if (element instanceof Terrestrial) {
                    elements.add(element);
                    states.add(((Terrestrial)element).getState(stateList));
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
        public Terrestrial set(int index, Terrestrial element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Terrestrial remove(int index) {
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

    public Iterator<Terrestrial> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Terrestrial> Terrestrial[] toArray(Terrestrial[] array) {
        return list.toArray(array);
    }

    public boolean add(Terrestrial element) {
        return list.add(element);
    }

    public void add(int index, Terrestrial element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Terrestrial> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Terrestrial> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Terrestrial)) {
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

    public Terrestrial get(int index) {
        return list.get(index);
    }

    public Terrestrial set(int index, Terrestrial element) {
        return list.set(index, element);
    }

    public Terrestrial remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Terrestrial> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Terrestrial> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Terrestrial> subList(int fromIndex, int toIndex) {
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