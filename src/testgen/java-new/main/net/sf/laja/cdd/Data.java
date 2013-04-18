package net.sf.laja.cdd;

import org.joda.time.DateMidnight;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Data implements Serializable {
    private final Map<String, Object> map;
    private final Map<String, Object> attributes;

    private Data(int version, String type, Map<String, Object> attributes) {
        this.attributes = attributes;
        map = new LinkedHashMap<String, Object>();
        map.put("version", version);
        map.put("type", type);
        map.put("attributes", attributes);
    }

    private Data(Map<String, Object> map) {
        this.map = map;
        attributes = (Map<String, Object>)map.get("attributes");
    }

    public static Data create(Map<String, Object> map) {
        return new Data(map);
    }

    public static AttributesBuilder build(int version, String type) {
        return new Data(version, type, new LinkedHashMap<String, Object>()).new AttributesBuilder();
    }

    public class AttributesBuilder {

        public AttributesBuilder value(String attribute, int value) {
            attributes.put(attribute, value);
            return this;
        }

        public AttributesBuilder value(String attribute, String value) {
            if (value != null) {
                attributes.put(attribute, value);
            }
            return this;
        }

        public AttributesBuilder value(String attribute, List<Map> value) {
            if (value != null) {
                attributes.put(attribute, value);
            }
            return this;
        }

        public AttributesBuilder value(String attribute, Map map) {
            if (map != null) {
                attributes.put(attribute, map);
            }
            return this;
        }

        public AttributesBuilder value(String attribute, DateMidnight value) {
            if (value != null) {
                attributes.put(attribute, value.getMillis());
            }
            return this;
        }

        public Map<String, Object> map() {
            return map;
        }
    }

    public String string(String attribute) {
        return (String) attributes.get(attribute);
    }

    public DateMidnight dateMidnight(String attribute) {
        return new DateMidnight(attributes.get(attribute));
    }

    public int integer(String attribute) {
        return (Integer) attributes.get(attribute);
    }

    public Map data(String attribute) {
        return (Map) attributes.get(attribute);
    }

    public List<Map> list(String attribute) {
        return (List<Map>) attributes.get(attribute);
    }

    public static interface DataConverter<T> {
        T convert(Map map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return map.equals(((Data)o).map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }

    @Override
    public String toString() {
        return "Data" + map;
    }
}
