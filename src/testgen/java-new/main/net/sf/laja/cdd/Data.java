package net.sf.laja.cdd;

import org.joda.time.DateMidnight;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Data implements Serializable {
    private int version;
    private String type;
    private Map<String, Object> attributes;

    public Data(int version, String type, Map<String, Object> attributes) {
        this.version = version;
        this.type = type;
        this.attributes = attributes;
    }

    public static MapBuilder createMap() {
        return new MapBuilder();
    }

    public String string(String attribute) {
        return (String)attributes.get(attribute);
    }

    public DateMidnight dateMidnight(String attribute) {
        return new DateMidnight(attributes.get(attribute));
    }

    public int integer(String attribute) {
        return (Integer)attributes.get(attribute);
    }

    public Data data(String attribute) {
        return (Data)attributes.get(attribute);
    }

    public List<Data> list(String attribute) {
        return (List<Data>)attributes.get(attribute);
    }

    public static class MapBuilder {
        private Map<String, Object> map = new LinkedHashMap<String, Object>();

        public MapBuilder value(String attribute, int value) {
            map.put(attribute, value);
            return this;
        }

        public MapBuilder value(String attribute, String value) {
            map.put(attribute, value);
            return this;
        }

        public MapBuilder value(String attribute, List<Data> value) {
            map.put(attribute, value);
            return this;
        }

        public MapBuilder value(String attribute, Data data) {
            map.put(attribute, data);
            return this;
        }

        public MapBuilder value(String attribute, DateMidnight value) {
            map.put(attribute, value.getMillis());
            return this;
        }

        public Map<String, Object> build() {
            return map;
        }
    }

    public static interface DataConverter<T> {
        public T convert(Data data);
    }

    @Override
    public int hashCode() {
        int result = version;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (version != data.version) return false;
        if (attributes != null ? !attributes.equals(data.attributes) : data.attributes != null) return false;
        if (type != null ? !type.equals(data.type) : data.type != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Data{" +
                "version=" + version +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }
}
