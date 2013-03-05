package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.*;

import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.behaviour.text.TextDirectorySet;
import net.sf.laja.example.file.behaviour.text.TextDirectoryHashSet;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class DirectoryHashSet implements DirectorySet, RandomAccess, Cloneable, java.io.Serializable {
    protected DirectoryStateSet stateSet;
    protected final Set<Directory> set;

    public DirectoryHashSet(Directory... array) {
        this.set = new HashSet<Directory>();
        this.set.addAll(Arrays.asList(array));
    }

    public DirectoryHashSet(Collection<Directory> collection) {
        this.set = new HashSet<Directory>();
        this.set.addAll(collection);
    }

    public DirectoryHashSet(DirectoryStateSet stateSet) {
        this.stateSet = stateSet;
        this.stateSet.encapsulate(this);
        Set<Directory> elements = new HashSet<Directory>(stateSet.size());

        for (DirectoryState state : stateSet) {
            DirectoryStateBuilder builder = new DirectoryStateBuilderImpl(state);
            Directory entry = (Directory) builder.as(new DirectoryFactory.DirectoryFactory_());
            elements.add(entry);
        }
        this.set = new StateInSyncSet(stateSet, elements);
    }

    public TextDirectoryHashSet asTextDirectorySet() {
        Set<TextDirectory> result = new HashSet<TextDirectory>();
        for (Directory entry : set) {
            result.add(entry.asTextDirectory());
        }
        return new TextDirectoryHashSet(result);
    }

    public class StateInSyncSet extends HashSet<Directory> {
        private DirectoryStateSet stateSet;

        public StateInSyncSet(DirectoryStateSet stateSet, Set<Directory> elements) {
            this.stateSet = stateSet;
            this.stateSet.clear();
            super.addAll(elements);
        }

        @Override
        public boolean add(Directory element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(DirectoryHashSet.this);
            stateSet.add(element.getState(stateSet.certificate()));
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends Directory> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(DirectoryHashSet.this);
            boolean modified = super.addAll(collection);

            for (Directory element : collection) {
                stateSet.add(element.getState(stateSet.certificate()));
            }
            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateSet.throwExceptionIfNotEncapsulatedBy(DirectoryHashSet.this);
            if (!(element instanceof Directory)) {
                return false;
            }
            boolean removedState = stateSet.remove(((Directory) element).getState(stateSet.certificate()));
            boolean removedElement = super.remove(element);

            if (removedState != removedElement) {
                throw new IllegalStateException("The state and behaviour is out of sync. Please report this bug to the Laja project!");
            }
            return removedElement;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(DirectoryHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Directory) {
                    elements.add(element);
                    states.add(((Directory)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateSet.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateSet.throwExceptionIfNotEncapsulatedBy(DirectoryHashSet.this);
            Set states = new HashSet(collection.size());
            Set elements = new HashSet(collection.size());
            for (Object element : collection) {
                if (element instanceof Directory) {
                    elements.add(element);
                    states.add(((Directory)element).getState(stateSet.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateSet.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateSet.throwExceptionIfNotEncapsulatedBy(DirectoryHashSet.this);
            stateSet.clear();
            super.clear();
        }
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(Object element) {
        return set.contains(element);
    }

    public Iterator<Directory> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <Directory> Directory[] toArray(Directory[] array) {
        return set.toArray(array);
    }

    public boolean add(Directory element) {
        return set.add(element);
    }

    public boolean addAll(Collection<? extends Directory> collection) {
        return set.addAll(collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Directory)) {
            return false;
        }
        return set.remove(element);
    }

    public boolean containsAll(Collection<?> collection) {
        return set.containsAll(collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return set.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return set.retainAll(collection);
    }

    public void clear() {
        set.clear();
    }

    @Override
    public boolean equals(Object o) {
        return set.equals(o);
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + set + '}';
    }
}
