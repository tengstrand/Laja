package net.sf.laja.parser.cdd.state;

public class MapType implements StateParser.IMapType {
    public Type key;
    public Type entry;

    public void setKey(StateParser.IType ikey) {
        key = (Type)ikey;
    }

    public void setEntry(StateParser.IType ientry) {
        entry = (Type)ientry;
    }

    @Override
    public String toString() {
        return "MapType{" +
                "key=" + key +
                ", entry=" + entry +
                '}';
    }
}
