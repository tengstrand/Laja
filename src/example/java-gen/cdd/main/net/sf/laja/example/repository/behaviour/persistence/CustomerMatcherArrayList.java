package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.domain.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerMatcherArrayList implements CustomerMatcherList, RandomAccess, Cloneable, java.io.Serializable {
    protected CustomerStateList stateList;
    protected final List<CustomerMatcher> list;

    public CustomerMatcherArrayList(CustomerMatcher... list) {
        this.list = new ArrayList<CustomerMatcher>();
        this.list.addAll(Arrays.asList(list));
    }

    public CustomerMatcherArrayList(Collection<CustomerMatcher> list) {
        this.list = new ArrayList<CustomerMatcher>();
        this.list.addAll(list);
    }

    public CustomerMatcherArrayList(CustomerStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<CustomerMatcher> elements = new ArrayList<CustomerMatcher>(stateList.size());

        for (CustomerState state : stateList) {
            CustomerStateBuilder builder = new CustomerStateBuilderImpl(state);
            CustomerMatcher entry = (CustomerMatcher) builder.as(new CustomerFactory.CustomerMatcherFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<CustomerMatcher> {
        private final CustomerStateList stateList;

        public StateInSyncList(CustomerStateList stateList, List<CustomerMatcher> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(CustomerMatcher element) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, CustomerMatcher element) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends CustomerMatcher> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            boolean modified = super.addAll(collection);

            for (CustomerMatcher element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends CustomerMatcher> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (CustomerMatcher element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            if (!(element instanceof CustomerMatcher)) {
                return false;
            }
            stateList.remove(((CustomerMatcher) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof CustomerMatcher) {
                    elements.add(element);
                    states.add(((CustomerMatcher)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof CustomerMatcher) {
                    elements.add(element);
                    states.add(((CustomerMatcher)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public CustomerMatcher set(int index, CustomerMatcher element) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public CustomerMatcher remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(CustomerMatcherArrayList.this);
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

    public Iterator<CustomerMatcher> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <CustomerMatcher> CustomerMatcher[] toArray(CustomerMatcher[] array) {
        return list.toArray(array);
    }

    public boolean add(CustomerMatcher element) {
        return list.add(element);
    }

    public void add(int index, CustomerMatcher element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends CustomerMatcher> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends CustomerMatcher> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof CustomerMatcher)) {
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

    public CustomerMatcher get(int index) {
        return list.get(index);
    }

    public CustomerMatcher set(int index, CustomerMatcher element) {
        return list.set(index, element);
    }

    public CustomerMatcher remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<CustomerMatcher> listIterator() {
        return list.listIterator();
    }

    public ListIterator<CustomerMatcher> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<CustomerMatcher> subList(int fromIndex, int toIndex) {
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
