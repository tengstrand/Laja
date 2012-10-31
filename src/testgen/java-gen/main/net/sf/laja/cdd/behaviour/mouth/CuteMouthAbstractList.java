package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class CuteMouthAbstractList implements List<CuteMouth> {
    protected MouthStateList stateList;
    protected final List<CuteMouth> list = new ArrayList<CuteMouth>();

    public CuteMouthAbstractList(CuteMouth... list) {
        this.list.addAll(Arrays.asList(list));
    }

    public CuteMouthAbstractList(List<CuteMouth> list) {
        this.list.addAll(list);
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

    public Iterator<CuteMouth> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <CuteMouth> CuteMouth[] toArray(CuteMouth[] array) {
        return list.toArray(array);
    }

    public boolean add(CuteMouth element) {
        if (stateList != null) {
            stateList.add(element.getState(stateList));
        }
        return list.add(element);
    }

    public void add(int index, CuteMouth element) {
        if (stateList != null) {
            stateList.add(index, element.getState(stateList));
        }
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends CuteMouth> collection) {
        if (stateList != null) {
            List newElements = new ArrayList(collection.size());
            for (CuteMouth element : collection) {
                newElements.add(element.getState(stateList));
            }
            stateList.addAll(newElements);
        }
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends CuteMouth> collection) {
        if (stateList != null) {
            List newElements = new ArrayList(collection.size());
            for (CuteMouth element : collection) {
                newElements.add(element.getState(stateList));
            }
            stateList.addAll(index, newElements);
        }
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof CuteMouth)) {
            return false;
        }
        if (stateList != null) {
            stateList.remove(((CuteMouth)element).getState(stateList));
        }
        return list.remove(element);
    }

    public boolean containsAll(Collection<?> collection) {
        return list.containsAll(collection);
    }

    public boolean removeAll(Collection<?> collection) {
        if (stateList != null) {
            List removedElements = new ArrayList(collection.size());
            List removedStateElements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof CuteMouth) {
                    removedElements.add(element);
                    removedStateElements.add(((CuteMouth)element).getState(stateList));
                }
            }
            stateList.removeAll(removedStateElements);
            return list.removeAll(removedElements);
        }
        return list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        if (stateList != null) {
            List retainedElements = new ArrayList(collection.size());
            List retainedStateElements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof CuteMouth) {
                    retainedElements.add(element);
                    retainedStateElements.add(((CuteMouth)element).getState(stateList));
                }
            }
            stateList.retainAll(retainedStateElements);
            return list.retainAll(retainedElements);
        }
        return list.retainAll(collection);
    }

    public void clear() {
        if (stateList != null) {
            stateList.clear();
        }
        list.clear();
    }

    public CuteMouth get(int index) {
        return list.get(index);
    }

    public CuteMouth set(int index, CuteMouth element) {
        if (stateList != null) {
            stateList.set(index, element.getState(stateList));
        }
        return list.set(index, element);
    }

    public CuteMouth remove(int index) {
        if (stateList != null) {
            stateList.remove(index);
        }
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<CuteMouth> listIterator() {
        return list.listIterator();
    }

    public ListIterator<CuteMouth> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<CuteMouth> subList(int fromIndex, int toIndex) {
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
