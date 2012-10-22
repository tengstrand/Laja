package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;

import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.behaviour.text.TextDirectoryList;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class DirectoryAbstractList implements List<Directory> {
    protected DirectoryStateList stateList;
    protected final List<Directory> list = new ArrayList<Directory>();

    public DirectoryAbstractList(Directory... list) {
        this.list.addAll(Arrays.asList(list));
    }

    public DirectoryAbstractList(List<Directory> list) {
        this.list.addAll(list);
    }

    public DirectoryAbstractList(DirectoryStateList stateList) {
        this.stateList = stateList;

        for (DirectoryState state : stateList) {
            DirectoryStateBuilder builder = new DirectoryStateBuilderImpl(state);
            Directory entry = (Directory) builder.as(new DirectoryFactory.DirectoryFactory_(builder));
            list.add(entry);
        }
    }

    public TextDirectoryList asTextDirectoryList() {
        List<TextDirectory> result = new ArrayList<TextDirectory>();
        for (Directory entry : list) {
            result.add(entry.asTextDirectory());
        }
        return new TextDirectoryList(result);
    }

    public boolean isStateInSync() {
        if (stateList == null) {
            return true;
        }
        if (stateList.size() != list.size()) {
            return false;
        }
        for (Directory element : list) {
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

        for (Directory entry : list) {
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

    public Iterator<Directory> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Directory> Directory[] toArray(Directory[] array) {
        return list.toArray(array);
    }

    public boolean add(Directory element) {
        return list.add(element);
    }

    public void add(int index, Directory element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Directory> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Directory> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Directory)) {
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

    public Directory get(int index) {
        return list.get(index);
    }

    public Directory set(int index, Directory element) {
        return list.set(index, element);
    }

    public Directory remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Directory> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Directory> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Directory> subList(int fromIndex, int toIndex) {
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
