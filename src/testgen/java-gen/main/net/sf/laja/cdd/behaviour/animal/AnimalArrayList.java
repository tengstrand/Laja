package net.sf.laja.cdd.behaviour.animal;

import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.behaviour.animal.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AnimalArrayList implements AnimalList, RandomAccess, Cloneable, java.io.Serializable {
    protected AnimalStateList stateList;
    protected final List<Animal> list;

    public AnimalArrayList(Animal... list) {
        this.list = new ArrayList<Animal>();
        this.list.addAll(Arrays.asList(list));
    }

    public AnimalArrayList(Collection<Animal> list) {
        this.list = new ArrayList<Animal>();
        this.list.addAll(list);
    }

    public AnimalArrayList(AnimalStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<Animal> elements = new ArrayList<Animal>(stateList.size());

        for (AnimalState state : stateList) {
            AnimalStateBuilder builder = new AnimalStateBuilderImpl(state);
            Animal entry = (Animal) builder.as(new AnimalFactory.AnimalFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<Animal> {
        private final AnimalStateList stateList;

        public StateInSyncList(AnimalStateList stateList, List<Animal> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Animal element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Animal element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Animal> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            boolean modified = super.addAll(collection);

            for (Animal element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Animal> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Animal element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            if (!(element instanceof Animal)) {
                return false;
            }
            stateList.remove(((Animal) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Animal) {
                    elements.add(element);
                    states.add(((Animal)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Animal) {
                    elements.add(element);
                    states.add(((Animal)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public Animal set(int index, Animal element) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Animal remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(AnimalArrayList.this);
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

    public Iterator<Animal> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Animal> Animal[] toArray(Animal[] array) {
        return list.toArray(array);
    }

    public boolean add(Animal element) {
        return list.add(element);
    }

    public void add(int index, Animal element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Animal> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Animal> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Animal)) {
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

    public Animal get(int index) {
        return list.get(index);
    }

    public Animal set(int index, Animal element) {
        return list.set(index, element);
    }

    public Animal remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Animal> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Animal> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Animal> subList(int fromIndex, int toIndex) {
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
