package net.sf.laja.parser.cdd.state;

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

    public boolean isLeafState() {
        if (!isCollectionOrMap()) {
            return isState();
        }
        if (isCollection()) {
            return collectionType.type.isLeafState();
        }
        return mapType.entry.isLeafState();
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
