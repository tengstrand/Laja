package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.mouth.*;
import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class MouthArrayList implements MouthList, RandomAccess, Cloneable, java.io.Serializable {
    protected MouthStateList stateList;
    protected final List<Mouth> list;

    public MouthArrayList(Mouth... list) {
        this.list = new ArrayList<Mouth>();
        this.list.addAll(Arrays.asList(list));
    }

    public MouthArrayList(Collection<Mouth> list) {
        this.list = new ArrayList<Mouth>();
        this.list.addAll(list);
    }

    public MouthArrayList(MouthStateList stateList, MouthSize size) {
        this.stateList = stateList;
        this.stateList.encapsulate(this);
        List<Mouth> elements = new ArrayList<Mouth>(stateList.size());

        for (MouthState state : stateList) {
            MouthStateBuilder builder = new MouthStateBuilderImpl(state);
            Mouth entry = (Mouth) builder.as(new MouthFactory.MouthFactory_(builder), size);
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public CuteMouthArrayList asCuteMouthList(MouthSize size, int x) {
        List<CuteMouth> result = new ArrayList<CuteMouth>();
        for (Mouth entry : list) {
            result.add(entry.asCuteMouth(size, x));
        }
        return new CuteMouthArrayList(result);
    }

    public class StateInSyncList extends ArrayList<Mouth> {
        private final MouthStateList stateList;

        public StateInSyncList(MouthStateList stateList, List<Mouth> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Mouth element) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            stateList.add(element.getState(stateList.certificate()));
            return super.add(element);
        }

        @Override
        public void add(int index, Mouth element) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            stateList.add(index, element.getState(stateList.certificate()));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Mouth> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            boolean modified = super.addAll(collection);

            for (Mouth element : collection) {
                stateList.add(element.getState(stateList.certificate()));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Mouth> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Mouth element : collection) {
                elements.add(element.getState(stateList.certificate()));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            if (!(element instanceof Mouth)) {
                return false;
            }
            stateList.remove(((Mouth) element).getState(stateList.certificate()));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Mouth) {
                    elements.add(element);
                    states.add(((Mouth)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.removeAll(elements);
            stateList.removeAll(states);

            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Mouth) {
                    elements.add(element);
                    states.add(((Mouth)element).getState(stateList.certificate()));
                }
            }
            boolean modified = super.retainAll(elements);
            stateList.retainAll(states);

            return modified;
        }

        @Override
        public void clear() {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            stateList.clear();
            super.clear();
        }

        @Override
        public Mouth set(int index, Mouth element) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
            stateList.set(index, element.getState(stateList.certificate()));
            return super.set(index, element);
        }

        @Override
        public Mouth remove(int index) {
            stateList.throwExceptionIfNotEncapsulatedBy(MouthArrayList.this);
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

    public Iterator<Mouth> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <Mouth> Mouth[] toArray(Mouth[] array) {
        return list.toArray(array);
    }

    public boolean add(Mouth element) {
        return list.add(element);
    }

    public void add(int index, Mouth element) {
        list.add(index, element);
    }

    public boolean addAll(Collection<? extends Mouth> collection) {
        return list.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Mouth> collection) {
        return list.addAll(index, collection);
    }

    public boolean remove(Object element) {
        if (!(element instanceof Mouth)) {
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

    public Mouth get(int index) {
        return list.get(index);
    }

    public Mouth set(int index, Mouth element) {
        return list.set(index, element);
    }

    public Mouth remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object element) {
        return list.indexOf(element);
    }

    public int lastIndexOf(Object element) {
        return list.lastIndexOf(element);
    }

    public ListIterator<Mouth> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Mouth> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Mouth> subList(int fromIndex, int toIndex) {
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
