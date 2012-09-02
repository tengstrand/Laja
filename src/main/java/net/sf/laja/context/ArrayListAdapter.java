package net.sf.laja.context;

import java.lang.reflect.Array;
import java.util.AbstractList;

/**
 * This is an adapter that convert arrays to java.util.List.
 * 
 * @author joakim.tengstrand
 *
 * @param <E>
 */
public class ArrayListAdapter<E> extends AbstractList<E> {
	private Object array;

	public ArrayListAdapter(Object array) {
		this.array = array;
	}
	
	@Override
	public E get(int index) {
		Object element = (E)Array.get(array, index);
		// TODO: Change to isArray() ?
		if (element.getClass().getComponentType() == null) {
			return (E)element;
		}
		return (E)new ArrayListAdapter(element);
	}

	@Override
	public int size() {
		return Array.getLength(array);
	}
	
	public Object getArray() {
		return array;
	}
}
