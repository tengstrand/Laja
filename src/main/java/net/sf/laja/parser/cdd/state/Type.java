package net.sf.laja.parser.cdd.state;

public class Type implements StateParser.IType {
    public String name;
    public CollectionType collectionType;
    public MapType mapType;

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
        return name.endsWith("State");
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

    public boolean isPrimitive() {
        return collectionType == null && mapType == null && net.sf.laja.parser.cdd.Type.isPrimitive(name);
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                ", collectionType=" + collectionType +
                ", mapType=" + mapType +
                '}';
    }
}
