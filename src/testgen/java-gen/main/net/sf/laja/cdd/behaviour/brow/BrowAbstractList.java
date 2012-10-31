package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class BrowAbstractList implements List<Brow> {
    protected BrowStateList stateList;
    protected final List<Brow> list = new ArrayList<Brow>();

    public BrowAbstractList(Brow... list) {
        this.list.addAll(Arrays.asList(list));
    }

    public BrowAbstractList(List<Brow> list) {
        this.list.addAll(list);
    }

    public BrowAbstractList(BrowStateList stateList) {
        this.stateList = stateList;

        for (BrowState state : stateList) {
            BrowStateBuilder builder = new BrowStateBuilderImpl(state);
            Brow entry = (Brow) builder.as(new BrowFactory.BrowFactory_(builder));
            list.add(entry);
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
        if (stateList != null) {
            stateList.add(element.getState(stateList));
        }
        return list.add(element);
    }

    public void add(int index, Brow element) {
        if (stateList != null) {
            stateList.add(index, element.getState(stateList));
        }
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Brow> collection) {
        if (stateList != null) {
            List newElements = new ArrayList(collection.size());
            for (Brow element : collection) {
                newElements.add(element.getState(stateList));
            }
            stateList.addAll(newElements);
        }
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Brow> collection) {
        if (stateList != null) {
            List newElements = new ArrayList(collection.size());
            for (Brow element : collection) {
                newElements.add(element.getState(stateList));
            }
            stateList.addAll(index, newElements);
        }
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Brow)) {
            return false;
        }
        if (stateList != null) {
            stateList.remove(((Brow)element).getState(stateList));
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
                if (element instanceof Brow) {
                    removedElements.add(element);
                    removedStateElements.add(((Brow)element).getState(stateList));
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
                if (element instanceof Brow) {
                    retainedElements.add(element);
                    retainedStateElements.add(((Brow)element).getState(stateList));
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

    public Brow get(int index) {
        return list.get(index);
    }

    public Brow set(int index, Brow element) {
        if (stateList != null) {
            stateList.set(index, element.getState(stateList));
        }
        return list.set(index, element);
    }

    public Brow remove(int index) {
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
        return getClass().getSimpleName() + "{list=" + list + '}';
    }
}
