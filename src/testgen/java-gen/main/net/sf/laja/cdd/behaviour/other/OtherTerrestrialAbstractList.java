package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class OtherTerrestrialAbstractList implements List<OtherTerrestrial> {
    protected TerrestrialStateList stateList;
    protected final List<OtherTerrestrial> list = new ArrayList<OtherTerrestrial>();

    public OtherTerrestrialAbstractList(OtherTerrestrial... list) {
        this.list.addAll(Arrays.asList(list));
    }

    public OtherTerrestrialAbstractList(List<OtherTerrestrial> list) {
        this.list.addAll(list);
    }


    public OtherTerrestrialAbstractList(TerrestrialStateList stateList) {
        this.stateList = stateList;

        for (TerrestrialState state : stateList) {
            TerrestrialStateBuilder builder = new TerrestrialStateBuilderImpl(state);
            OtherTerrestrial entry = (OtherTerrestrial) builder.as(new OtherTerrestrialFactory.OtherTerrestrialFactory_(builder));
            list.add(entry);
        }
    }

    public boolean isStateInSync() {
        if (stateList == null) {
            return true;
        }
        if (stateList.size() != list.size()) {
            return false;
        }
        for (OtherTerrestrial element : list) {
            if (!element.contains(stateList) || !element.isStateInSync()) {
                return false;
            }
        }
        return true;
    }

    public boolean syncState() {
        if (isStateInSync()) {
            return false;
        }
        stateList.clear();

        for (OtherTerrestrial entry : list) {
            entry.syncState();
            entry.addToList(stateList);
        }
        return true;
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
        return getClass().getSimpleName() + "{list=" + list + '}';
    }
}
