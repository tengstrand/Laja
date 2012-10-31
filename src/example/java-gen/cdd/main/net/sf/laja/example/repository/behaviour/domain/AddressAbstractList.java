package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class AddressAbstractList implements List<Address> {
    protected AddressStateList stateList;
    protected final List<Address> list = new ArrayList<Address>();

    public AddressAbstractList(Address... list) {
        this.list.addAll(Arrays.asList(list));
    }

    public AddressAbstractList(List<Address> list) {
        this.list.addAll(list);
    }

    public AddressAbstractList(AddressStateList stateList) {
        this.stateList = stateList;

        for (AddressState state : stateList) {
            AddressStateBuilder builder = new AddressStateBuilderImpl(state);
            Address entry = (Address) builder.as(new AddressFactory.AddressFactory_(builder));
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

    public Iterator<Address> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Address> Address[] toArray(Address[] array) {
        return list.toArray(array);
    }

    public boolean add(Address element) {
        if (stateList != null) {
            stateList.add(element.getState(stateList));
        }
        return list.add(element);
    }

    public void add(int index, Address element) {
        if (stateList != null) {
            stateList.add(index, element.getState(stateList));
        }
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Address> collection) {
        if (stateList != null) {
            List newElements = new ArrayList(collection.size());
            for (Address element : collection) {
                newElements.add(element.getState(stateList));
            }
            stateList.addAll(newElements);
        }
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Address> collection) {
        if (stateList != null) {
            List newElements = new ArrayList(collection.size());
            for (Address element : collection) {
                newElements.add(element.getState(stateList));
            }
            stateList.addAll(index, newElements);
        }
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Address)) {
            return false;
        }
        if (stateList != null) {
            stateList.remove(((Address)element).getState(stateList));
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
                if (element instanceof Address) {
                    removedElements.add(element);
                    removedStateElements.add(((Address)element).getState(stateList));
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
                if (element instanceof Address) {
                    retainedElements.add(element);
                    retainedStateElements.add(((Address)element).getState(stateList));
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

    public Address get(int index) {
        return list.get(index);
    }

    public Address set(int index, Address element) {
        if (stateList != null) {
            stateList.set(index, element.getState(stateList));
        }
        return list.set(index, element);
    }

    public Address remove(int index) {
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

    public ListIterator<Address> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Address> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Address> subList(int fromIndex, int toIndex) {
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
