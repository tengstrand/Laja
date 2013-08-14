package net.sf.laja.cdd.state.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionCreator {

    public static List createList(Object... elements) {
        return Arrays.asList(elements);
    }

    public static Set createSet(Object... elements) {
        return new HashSet(Arrays.asList(elements));
    }

    public static Map createMap(Entry... elements) {
        Map map = new HashMap();
        for (Entry entry : elements) {
            map.put(entry.key, entry.value);
        }
        return map;
    }

    public static class Entry {
        public final Object key;
        public final Object value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public static Entry createEntry(Object key, Object value) {
            return new Entry(key, value);
        }
    }
}
