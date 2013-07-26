package net.sf.laja.parser.cdd.state;

import java.util.HashMap;
import java.util.Map;

public class Type implements StateParser.IType {
    public String name;
    public CollectionType collectionType;
    public MapType mapType;

    private TypeConverter typeConverter = new TypeConverter();

    public void setName(String name) {
        this.name = name;
    }

    public void setCollectionType(StateParser.ICollectionType icollectionType) {
        collectionType = (CollectionType)icollectionType;
    }

    public void setMapType(StateParser.IMapType imapType) {
        mapType = (MapType)imapType;
    }

    public boolean isDate() {
        return !isCollectionOrMap() && net.sf.laja.parser.cdd.Type.isDate(name);
    }

    public boolean isState() {
        return !isCollectionOrMap() && name.endsWith("State");
    }

    public boolean isCollection() {
        return collectionType != null;
    }

    public boolean isList() {
        return isCollection() && name.endsWith("List");
    }

    public boolean isSet() {
        return isCollection() && name.endsWith("Set");
    }

    public boolean isMap() {
        return mapType != null;
    }

    public boolean isCollectionOrMap() {
        return isCollection() || isMap();
    }

    public boolean isString() {
        return !isCollectionOrMap() && name.equals("String");
    }

    public boolean isObject() {
        return !isCollectionOrMap() && net.sf.laja.parser.cdd.Type.isObject(name);
    }

    public boolean isPrimitive() {
        return !isCollectionOrMap() && net.sf.laja.parser.cdd.Type.isPrimitive(name);
    }

    public boolean isPrimitiveInteger() {
        return !isCollectionOrMap() && net.sf.laja.parser.cdd.Type.isPrimitiveInteger(name);
    }

    public boolean isBoolean() {
        return isPrimitive() && name.equals("boolean");
    }

    public boolean isLong() {
        return isPrimitive() && name.equals("long");
    }

    public boolean isPrimitiveFloatingPoint() {
        return isPrimitive() && (name.equals("float") || name.endsWith("double"));
    }

    public boolean isValid() {
        if (!isCollectionOrMap()) {
            return isState() || net.sf.laja.parser.cdd.Type.isValid(name);
        }
        if (isCollection()) {
            return collectionType.type.isValid();
        }
        return mapType.entry.isValid();
    }

    public boolean isCollectionOrMapWithState() {
        return isCollection() && collectionType.type.isState() ||
                isMap() && mapType.entry.isState();
    }

    public boolean isLeafState() {
        if (!isCollectionOrMap()) {
            return isState();
        }
        if (isCollection()) {
            return collectionType.type.isLeafState();
        }
        return mapType.entry.isLeafState();
    }

    public String getLeafState() {
        if (!isCollectionOrMap()) {
            return getState();
        }
        if (isCollection()) {
            return collectionType.type.getLeafState();
        }
        return mapType.entry.getLeafState();
    }

    public String getState() {
        if (name.endsWith("MutableState")) {
            return name.substring(0, name.length() - "MutableState".length());
        } else if (name.endsWith("State")) {
            return name.substring(0, name.length() - "State".length());
        }
        throw new IllegalStateException("The type " + name + " is not a state!");
    }

    public String collectionOrMapType() {
        if (isSet()) {
            return "Set";
        } else if (isList()) {
            return "List";
        } else if (isMap()) {
            return "Map";
        }
        throw new IllegalStateException("The type " + name + " is not a Set/List/Map");
    }

    public Type asMutable() {
        Type result = new Type();
        result.setName(typeConverter.asMutable(name));
        CollectionType ctype = null;
        if (collectionType != null) {
            ctype = new CollectionType();
            ctype.setType(collectionType.type.asMutable());
        }
        MapType mtype = null;
        if (mapType != null) {
            mtype = new MapType();
            mtype.setKey(mapType.key.asMutable());
            mtype.setEntry(mapType.entry.asMutable());
        }
        result.setCollectionType(ctype);
        result.setMapType(mtype);

        return result;
    }

    public Type asMutableString() {
        Type result = new Type();
        result.setName(typeConverter.asMutableString(name));
        CollectionType ctype = null;
        if (collectionType != null) {
            ctype = new CollectionType();
            ctype.setType(collectionType.type.asMutableString());
        }
        MapType mtype = null;
        if (mapType != null) {
            mtype = new MapType();
            mtype.setKey(mapType.key.asMutable());
            mtype.setEntry(mapType.entry.asMutableString());
        }
        result.setCollectionType(ctype);
        result.setMapType(mtype);

        return result;
    }

    public Type asImmutable() {
        Type result = new Type();
        result.setName(typeConverter.asImmutable(name));
        CollectionType ctype = null;
        if (collectionType != null) {
            ctype = new CollectionType();
            ctype.setType(collectionType.type.asImmutable());
        }
        MapType mtype = null;
        if (mapType != null) {
            mtype = new MapType();
            mtype.setKey(mapType.key.asMutable());
            mtype.setEntry(mapType.entry.asImmutable());
        }
        result.setCollectionType(ctype);
        result.setMapType(mtype);

        return result;
    }

    public String getTypeConversionMethod(String prefix) {
        if (isCollectionOrMap() || isString()) {
            return "";
        }
        Map<String,String> methods = new HashMap<String,String>();
        methods.put("boolean", "BooleanPrimitive");
        methods.put("byte", "BytePrimitive");
        methods.put("short", "ShortPrimitive");
        methods.put("char", "Char");
        methods.put("int", "Int");
        methods.put("long", "LongPrimitive");
        methods.put("float", "FloatPrimitive");
        methods.put("double", "DoublePrimitive");
        methods.put("Boolean", "Boolean");
        methods.put("Byte", "Byte");
        methods.put("Short", "Short");
        methods.put("Character", "Character");
        methods.put("Integer", "Integer");
        methods.put("Long", "Long");
        methods.put("Float", "Float");
        methods.put("Double", "Double");

        if (methods.containsKey(name)) {
            return prefix + methods.get(name);
        }
        return "new " + name;
    }

    @Override
    public String toString() {
        if (collectionType != null) {
            return name + "<" + collectionType.type + ">";
        }
        if (mapType != null) {
            return name + "<" + mapType.key + "," + mapType.entry + ">";
        }
        return name;
    }
}
