package net.sf.laja.parser.cdd.state;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypeTest {

    @Test
    public void asString() {
        Type type = type("ImmutableMap", null, map("String", "AddressState", null, null));

        assertThat(type.toString(), equalTo("ImmutableMap<String,AddressState>"));
    }

    @Test
    public void asMutable() {
        Type type = type("ImmutableMap", null, map("String", "AddressState", null, null));

        assertThat(type.asMutable().toString(), equalTo("Map<String,AddressMutableState>"));
    }

    @Test
    public void isNotLeafState_Integer() {
        Type type = type("List",
                collection(
                        "Set",
                        collection(
                                "Integer",
                                null,
                                null),
                        null
                ), null
        );

        assertThat(type.toString(), equalTo("List<Set<Integer>>"));
        assertThat(type.isLeafState(), is(false));
    }

    @Test
    public void isLeafState_List() {
        Type type = type("List",
                collection(
                        "Set",
                        collection(
                                "AddressState",
                                null,
                                null),
                        null
                ), null
        );

        assertThat(type.toString(), equalTo("List<Set<AddressState>>"));
        assertThat(type.isLeafState(), is(true));
    }

    @Test
    public void isLeafState_Map() {
        Type type = type("List",
                collection(
                        "Map",
                        null,
                        map("String", "AddressState", null, null)
                ), null
        );

        assertThat(type.toString(), equalTo("List<Map<String,AddressState>>"));
        assertThat(type.isLeafState(), is(true));
    }

    @Test
    public void asImmutable() {
        // List<Set<Map<String,Integer>>>
        Type type = type("List",
                         collection(
                            "Set",
                            collection(
                                "Map",
                                null,
                                map("String", "Integer", null, null)), null
                            ), null
                         );

        assertThat(type.asImmutable().toString(), equalTo("ImmutableList<ImmutableSet<ImmutableMap<String,Integer>>>"));
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
