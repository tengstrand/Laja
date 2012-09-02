package net.sf.laja.context;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an adapter that convert arrays to java.util.List.
 * 
 * @author joakim.tengstrand
 *
 * @param <E>
 */
public class MapListAdapter<E> extends AbstractList<E> {
	private List keyValuePairs = new ArrayList();

	public MapListAdapter(Map map) {
		for (Object key : map.keySet()) {
			keyValuePairs.add(getKeyValue(key, map.get(key)));
		}
	}
	
	@Override
	public E get(int index) {
		return (E)keyValuePairs.get(index);
	}

	@Override
	public int size() {
		return keyValuePairs.size();
	}

	private Map getKeyValue(Object key, Object value) {
		Map keyValue = new LinkedHashMap();
		keyValue.put("key", key);
		keyValue.put("value", value);
		return keyValue;
	}
}
