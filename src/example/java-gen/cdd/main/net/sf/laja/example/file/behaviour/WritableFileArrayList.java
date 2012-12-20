package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class WritableFileArrayList implements WritableFileList, RandomAccess, Cloneable, java.io.Serializable {
    protected FileStateList stateList;
    protected final List<WritableFile> list;

    public WritableFileArrayList(WritableFile... list) {
        this.list = new ArrayList<WritableFile>();
        this.list.addAll(Arrays.asList(list));
    }

    public WritableFileArrayList(Collection<WritableFile> list) {
        this.list = new ArrayList<WritableFile>();
        this.list.addAll(list);
    }

    public class StateInSyncList extends ArrayList<WritableFile> {
        private final FileStateList stateList;

        public StateInSyncList(FileStateList stateList, List<WritableFile> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(WritableFile element) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, WritableFile element) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends WritableFile> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            boolean modified = super.addAll(collection);

            for (WritableFile element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends WritableFile> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (WritableFile element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            if (!(element instanceof WritableFile)) {
                return false;
            }
            stateList.remove(((WritableFile) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof WritableFile) {
                    elements.add(element);
                    states.add(((WritableFile)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof WritableFile) {
                    elements.add(element);
                    states.add(((WritableFile)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public WritableFile set(int index, WritableFile element) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public WritableFile remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(WritableFileArrayList.this);
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

    public Iterator<WritableFile> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <WritableFile> WritableFile[] toArray(WritableFile[] array) {
        return list.toArray(array);
    }

    public boolean add(WritableFile element) {
        return list.add(element);
    }

    public void add(int index, WritableFile element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends WritableFile> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends WritableFile> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof WritableFile)) {
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

    public WritableFile get(int index) {
        return list.get(index);
    }

    public WritableFile set(int index, WritableFile element) {
        return list.set(index, element);
    }

    public WritableFile remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<WritableFile> listIterator() {
        return list.listIterator();
    }

    public ListIterator<WritableFile> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<WritableFile> subList(int fromIndex, int toIndex) {
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
