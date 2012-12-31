package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class PersonArrayList implements PersonList, RandomAccess, Cloneable, java.io.Serializable {
    protected PersonStateList stateList;
    protected final List<Person> list;

    public PersonArrayList(Person... list) {
        this.list = new ArrayList<Person>();
        this.list.addAll(Arrays.asList(list));
    }

    public PersonArrayList(Collection<Person> list) {
        this.list = new ArrayList<Person>();
        this.list.addAll(list);
    }

    public PersonArrayList(PersonStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<Person> elements = new ArrayList<Person>(stateList.size());

        for (PersonState state : stateList) {
            PersonStateBuilder builder = new PersonStateBuilderImpl(state);
            Person entry = (Person) builder.as(new PersonFactory.PersonFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<Person> {
        private final PersonStateList stateList;

        public StateInSyncList(PersonStateList stateList, List<Person> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Person element) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Person element) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Person> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            boolean modified = super.addAll(collection);

            for (Person element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Person> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Person element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            if (!(element instanceof Person)) {
                return false;
            }
            stateList.remove(((Person) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Person) {
                    elements.add(element);
                    states.add(((Person)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Person) {
                    elements.add(element);
                    states.add(((Person)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public Person set(int index, Person element) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Person remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(PersonArrayList.this);
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

    public Iterator<Person> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Person> Person[] toArray(Person[] array) {
        return list.toArray(array);
    }

    public boolean add(Person element) {
        return list.add(element);
    }

    public void add(int index, Person element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Person> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Person> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Person)) {
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

    public Person get(int index) {
        return list.get(index);
    }

    public Person set(int index, Person element) {
        return list.set(index, element);
    }

    public Person remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Person> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Person> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Person> subList(int fromIndex, int toIndex) {
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
