package net.sf.laja.parser.cdd.state;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypeTest {

    @Test
    public void asString() {
        Type type = type("ImmutableMap", null, map("String", "AddressState", null, null));

        assertThat(type.asString(), equalTo("ImmutableMap<String,AddressState>"));
    }

    @Test
    public void asMutable() {
        Type type = type("ImmutableMap", null, map("String", "AddressState", null, null));

        assertThat(type.asMutable().asString(), equalTo("Map<String,AddressMutableState>"));
    }

    private Type string(String name) {
        return type(name, null, null);
    }

    private Type type(String name, CollectionType collectionType, MapType mapType) {
        Type type = new Type();
        type.setName(name);
        type.setCollectionType(collectionType);
        type.setMapType(mapType);
        return type;
    }

    private CollectionType collection(String name, CollectionType collectionType, MapType mapType) {
        CollectionType type = new CollectionType();
        type.setType(type(name, collectionType, mapType));
        return type;
    }

    private MapType map(String key, String name, CollectionType collectionType, MapType mapType) {
        MapType type = new MapType();
        type.setKey(string(key));
        type.setEntry(type(name, collectionType, mapType));
        return type;
    }
}
