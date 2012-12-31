package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.behaviour.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class DestinationAccountArrayList implements DestinationAccountList, RandomAccess, Cloneable, java.io.Serializable {
    protected AccountStateList stateList;
    protected final List<DestinationAccount> list;

    public DestinationAccountArrayList(DestinationAccount... list) {
        this.list = new ArrayList<DestinationAccount>();
        this.list.addAll(Arrays.asList(list));
    }

    public DestinationAccountArrayList(Collection<DestinationAccount> list) {
        this.list = new ArrayList<DestinationAccount>();
        this.list.addAll(list);
    }

    public DestinationAccountArrayList(AccountStateList stateList) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<DestinationAccount> elements = new ArrayList<DestinationAccount>(stateList.size());

        for (AccountState state : stateList) {
            AccountStateBuilder builder = new AccountStateBuilderImpl(state);
            DestinationAccount entry = (DestinationAccount) builder.as(new AccountFactory.DestinationAccountFactory_(builder));
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public class StateInSyncList extends ArrayList<DestinationAccount> {
        private final AccountStateList stateList;

        public StateInSyncList(AccountStateList stateList, List<DestinationAccount> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(DestinationAccount element) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, DestinationAccount element) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends DestinationAccount> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            boolean modified = super.addAll(collection);

            for (DestinationAccount element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends DestinationAccount> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (DestinationAccount element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            if (!(element instanceof DestinationAccount)) {
                return false;
            }
            stateList.remove(((DestinationAccount) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof DestinationAccount) {
                    elements.add(element);
                    states.add(((DestinationAccount)element).getState(stateList));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof DestinationAccount) {
                    elements.add(element);
                    states.add(((DestinationAccount)element).getState(stateList));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public DestinationAccount set(int index, DestinationAccount element) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public DestinationAccount remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(DestinationAccountArrayList.this);
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

    public Iterator<DestinationAccount> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <DestinationAccount> DestinationAccount[] toArray(DestinationAccount[] array) {
        return list.toArray(array);
    }

    public boolean add(DestinationAccount element) {
        return list.add(element);
    }

    public void add(int index, DestinationAccount element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends DestinationAccount> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends DestinationAccount> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof DestinationAccount)) {
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

    public DestinationAccount get(int index) {
        return list.get(index);
    }

    public DestinationAccount set(int index, DestinationAccount element) {
        return list.set(index, element);
    }

    public DestinationAccount remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<DestinationAccount> listIterator() {
        return list.listIterator();
    }

    public ListIterator<DestinationAccount> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<DestinationAccount> subList(int fromIndex, int toIndex) {
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
