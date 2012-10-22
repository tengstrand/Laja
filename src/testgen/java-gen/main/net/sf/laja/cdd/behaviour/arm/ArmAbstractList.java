package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class ArmAbstractList implements List<Arm> {
    protected ArmStateList stateList;
    protected final List<Arm> list = new ArrayList<Arm>();

    public ArmAbstractList(Arm... list) {
        this.list.addAll(Arrays.asList(list));
    }

    public ArmAbstractList(List<Arm> list) {
        this.list.addAll(list);
    }

    public ArmAbstractList(ArmStateList stateList) {
        this.stateList = stateList;

        for (ArmState state : stateList) {
            ArmStateBuilder builder = new ArmStateBuilderImpl(state);
            Arm entry = (Arm) builder.as(new ArmFactory.ArmFactory_(builder));
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
        for (Arm element : list) {
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

        for (Arm entry : list) {
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

    public Iterator<Arm> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Arm> Arm[] toArray(Arm[] array) {
        return list.toArray(array);
    }

    public boolean add(Arm element) {
        return list.add(element);
    }

    public void add(int index, Arm element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Arm> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Arm> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Arm)) {
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

    public Arm get(int index) {
        return list.get(index);
    }

    public Arm set(int index, Arm element) {
        return list.set(index, element);
    }

    public Arm remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Arm> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Arm> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Arm> subList(int fromIndex, int toIndex) {
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
