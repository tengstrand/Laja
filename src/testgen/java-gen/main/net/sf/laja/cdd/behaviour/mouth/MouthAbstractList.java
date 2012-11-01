package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.*;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public abstract class MouthAbstractList implements List<Mouth>, RandomAccess, Cloneable, java.io.Serializable {
    protected MouthStateList stateList;
    protected final List<Mouth> list;

    public MouthAbstractList(Mouth... list) {
        this.list = new ArrayList<Mouth>();
        this.list.addAll(Arrays.asList(list));
    }

    public MouthAbstractList(List<Mouth> list) {
        this.list = new ArrayList<Mouth>();
        this.list.addAll(list);
    }

    public MouthAbstractList(MouthStateList stateList, MouthSize size) {
        this.stateList = stateList;
        List<Mouth> elements = new ArrayList<Mouth>(stateList.size());

        for (MouthState state : stateList) {
            MouthStateBuilder builder = new MouthStateBuilderImpl(state);
            Mouth entry = (Mouth) builder.as(new MouthFactory.MouthFactory_(builder), size);
            elements.add(entry);
        }
        this.list = new StateInSyncList(stateList, elements);
    }

    public CuteMouthList asCuteMouthList(MouthSize size, int x) {
        List<CuteMouth> result = new ArrayList<CuteMouth>();
        for (Mouth entry : list) {
            result.add(entry.asCuteMouth(size, x));
        }
        return new CuteMouthList(result);
    }

    public static class StateInSyncList extends ArrayList<Mouth> {
        private final MouthStateList stateList;

        public StateInSyncList(MouthStateList stateList, List<Mouth> elements) {
            this.stateList = stateList;
            super.addAll(elements);
        }

        @Override
        public boolean add(Mouth element) {
            stateList.add(element.getState(stateList));
            return super.add(element);
        }

        @Override
        public void add(int index, Mouth element) {
            stateList.add(index, element.getState(stateList));
            super.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends Mouth> collection) {
            boolean modified = super.addAll(collection);

            for (Mouth element : collection) {
                stateList.add(element.getState(stateList));
            }
            return modified;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Mouth> collection) {
            boolean modified = super.addAll(index, collection);

            List elements = new ArrayList(collection.size());
            for (Mouth element : collection) {
                elements.add(element.getState(stateList));
            }
            stateList.addAll(index, elements);

            return modified;
        }

        @Override
        public boolean remove(Object element) {
            if (!(element instanceof Mouth)) {
                return false;
            }
            stateList.remove(((Mouth) element).getState(stateList));

            return super.remove(element);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            List states = new ArrayList(collection.size());
            List elements = new ArrayList(collection.size());
            for (Object element : collection) {
                if (element instanceof Mouth) {
                    elements.add(element);
                    states.add(((Mouth)element).getState(stateList));
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
                if (element instanceof Mouth) {
                    elements.add(element);
                    states.add(((Mouth)element).getState(stateList));
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
        public Mouth set(int index, Mouth element) {
            stateList.set(index, element.getState(stateList));
            return super.set(index, element);
        }

        @Override
        public Mouth remove(int index) {
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
