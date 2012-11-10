package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.*;

import net.sf.laja.example.file.behaviour.text.TextFile;
import net.sf.laja.example.file.behaviour.text.TextFileList;
import net.sf.laja.example.file.behaviour.text.TextFileArrayList;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ClosedFileArrayList implements ClosedFileList, RandomAccess, Cloneable, java.io.Serializable {
    protected FileStateList stateList;
    protected final List<ClosedFile> list;

    public ClosedFileArrayList(ClosedFile... list) {
        this.list = new ArrayList<ClosedFile>();
        this.list.addAll(Arrays.asList(list));
    }

    public ClosedFileArrayList(Collection<ClosedFile> list) {
        this.list = new ArrayList<ClosedFile>();
        this.list.addAll(list);
    }

    public ClosedFileArrayList(FileStateList stateList, Directory directory) {
        this.stateList = stateList;
        List<ClosedFile> elements = new ArrayList<ClosedFile>(stateList.size());

        for (FileState state : stateList) {
            FileStateBuilder builder = new FileStateBuilderImpl(state);
            ClosedFile entry = (ClosedFile) builder.as(new FileFactory.ClosedFileFactory_(builder), directory);
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public TextFileArrayList asTextFileList() {
        List<TextFile> result = new ArrayList<TextFile>();
        for (ClosedFile entry : list) {
            result.add(entry.asTextFile());
        }
        return new TextFileArrayList(result);
    }

    public static class StateInSyncList extends ArrayList<ClosedFile> {
        private final FileStateList stateList;

        public StateInSyncList(FileStateList stateList, List<ClosedFile> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(ClosedFile element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, ClosedFile element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends ClosedFile> collection) {
            boolean modified = super.addAll(collection);

            for (ClosedFile element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends ClosedFile> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (ClosedFile element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof ClosedFile)) {
                return false;
            }
            stateList.remove(((ClosedFile) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof ClosedFile) {
                    elements.add(element);
                    states.add(((ClosedFile)element).getState(stateList));
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
                if (element instanceof ClosedFile) {
                    elements.add(element);
                    states.add(((ClosedFile)element).getState(stateList));
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
        public ClosedFile set(int index, ClosedFile element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public ClosedFile remove(int index) {
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

    public Iterator<ClosedFile> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <ClosedFile> ClosedFile[] toArray(ClosedFile[] array) {
        return list.toArray(array);
    }

    public boolean add(ClosedFile element) {
        return list.add(element);
    }

    public void add(int index, ClosedFile element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends ClosedFile> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends ClosedFile> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof ClosedFile)) {
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

    public ClosedFile get(int index) {
        return list.get(index);
    }

    public ClosedFile set(int index, ClosedFile element) {
        return list.set(index, element);
    }

    public ClosedFile remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<ClosedFile> listIterator() {
        return list.listIterator();
    }

    public ListIterator<ClosedFile> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<ClosedFile> subList(int fromIndex, int toIndex) {
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
