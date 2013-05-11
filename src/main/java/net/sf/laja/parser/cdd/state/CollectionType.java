package net.sf.laja.parser.cdd.state;

public class CollectionType implements StateParser.ICollectionType {
    public Type type;

    public void setType(StateParser.IType itype) {
        type = (Type)itype;
    }

    @Override
    public String toString() {
        return "CollectionType{" +
                "type=" + type +
                '}';
    }
}
