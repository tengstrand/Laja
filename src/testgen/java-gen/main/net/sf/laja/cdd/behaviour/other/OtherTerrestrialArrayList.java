package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.other.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class OtherTerrestrialArrayList implements OtherTerrestrialList, RandomAccess, Cloneable, java.io.Serializable {
    protected TerrestrialStateList stateList;
    protected final List<OtherTerrestrial> list;

    public OtherTerrestrialArrayList(OtherTerrestrial... list) {
        this.list = new ArrayList<OtherTerrestrial>();
        this.list.addAll(Arrays.asList(list));
    }

    public OtherTerrestrialArrayList(List<OtherTerrestrial> list) {
        this.list = new ArrayList<OtherTerrestrial>();
        this.list.addAll(list);
    }

    public OtherTerrestrialArrayList(TerrestrialStateList stateList) {
        this.stateList = stateList;
        List<OtherTerrestrial> elements = new ArrayList<OtherTerrestrial>(stateList.size());

        for (TerrestrialState state : stateList) {
            TerrestrialStateBuilder builder = new TerrestrialStateBuilderImpl(state);
            OtherTerrestrial entry = (OtherTerrestrial) builder.as(new OtherTerrestrialFactory.OtherTerrestrialFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public static class StateInSyncList extends ArrayList<OtherTerrestrial> {
        private final TerrestrialStateList stateList;

        public StateInSyncList(TerrestrialStateList stateList, List<OtherTerrestrial> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(OtherTerrestrial element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, OtherTerrestrial element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends OtherTerrestrial> collection) {
            boolean modified = super.addAll(collection);

            for (OtherTerrestrial element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends OtherTerrestrial> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (OtherTerrestrial element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof OtherTerrestrial)) {
                return false;
            }
            stateList.remove(((OtherTerrestrial) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof OtherTerrestrial) {
                    elements.add(element);
                    states.add(((OtherTerrestrial)element).getState(stateList));
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
                if (element instanceof OtherTerrestrial) {
                    elements.add(element);
                    states.add(((OtherTerrestrial)element).getState(stateList));
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
        public OtherTerrestrial set(int index, OtherTerrestrial element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public OtherTerrestrial remove(int index) {
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

    public Iterator<OtherTerrestrial> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <OtherTerrestrial> OtherTerrestrial[] toArray(OtherTerrestrial[] array) {
        return list.toArray(array);
    }

    public boolean add(OtherTerrestrial element) {
        return list.add(element);
    }

    public void add(int index, OtherTerrestrial element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends OtherTerrestrial> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends OtherTerrestrial> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof OtherTerrestrial)) {
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

    public OtherTerrestrial get(int index) {
        return list.get(index);
    }

    public OtherTerrestrial set(int index, OtherTerrestrial element) {
        return list.set(index, element);
    }

    public OtherTerrestrial remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<OtherTerrestrial> listIterator() {
        return list.listIterator();
    }

    public ListIterator<OtherTerrestrial> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<OtherTerrestrial> subList(int fromIndex, int toIndex) {
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