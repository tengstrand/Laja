package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableMap;
import net.sf.laja.cdd.Address;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.stateconverter.TypeConversion.asMutableMap;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toMutableMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImmutableToMutableMapConverterTest {

    @Test
    public void shouldConvertFromImmutableMapOfIntegersToMutableMap() {
        ImmutableMap<String,Integer> immutableMap = ImmutableMap.<String,Integer>builder().put("a", 123).build();
        Map mutableMap = asMutableMap(immutableMap);

        Map expectedMap = new HashMap();
        expectedMap.put("a", 123);

        assertThat(mutableMap, equalTo(expectedMap));
    }

    @Test
    public void shouldConvertFromImmutableMapOfStateToMutableStateMap() {
        Map<String, Address> immutableMap = createAddressMap(
                addressEntry("first", createAddress().streetName("First street")),
                addressEntry("second", buildAddress().withStreetName("Second street"))).asAddressMap();

        assertThat(immutableMap.getClass().getSimpleName(), equalTo("RegularImmutableMap"));

        Map mutableMap = asMutableMap(immutableMap);

        Map expectedMap = new HashMap();
        expectedMap.put("first", createAddress().streetName("First street").asAddress());
        expectedMap.put("second", createAddress().streetName("Second street").asAddress());

        assertThat(mutableMap, equalTo(expectedMap));
    }

    @Test
    public void shouldConvertFromImmutableMapOfImmutableMapOfIntegerToMutableMap() {
        ImmutableMap<String,Integer> immutableMap1 = ImmutableMap.<String,Integer>builder().put("a", 123).build();
        ImmutableMap<String,Integer> immutableMap2 = ImmutableMap.<String,Integer>builder().put("b", 456).build();
        ImmutableMap<String,ImmutableMap<String,Integer>> immutableMap =
                ImmutableMap.<String,ImmutableMap<String,Integer>>builder()
                .put("c", immutableMap1)
                .put("d", immutableMap2).build();

        Map mutableMap = asMutableMap(immutableMap, toMutableMap);

        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("a", 123);
        map2.put("b", 456);
        Map expectedMap = new HashMap();
        expectedMap.put("c", map1);
        expectedMap.put("d", map2);

        assertThat(mutableMap, equalTo(expectedMap));
    }
}
