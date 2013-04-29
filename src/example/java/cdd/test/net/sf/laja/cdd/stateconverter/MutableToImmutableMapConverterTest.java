package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableMap;
import net.sf.laja.cdd.state.AddressState;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.stateconverter.TypeConversion.asImmutableMap;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toImmutable;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toImmutableMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MutableToImmutableMapConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asImmutableMap(null));
    }

    @Test
    public void shouldConvertFromMutableMapOfIntegersToImmutableMap() {
        Map<String,Integer> mutableMap = new HashMap();
        mutableMap.put("a", 123);
        mutableMap.put("b", 456);

        ImmutableMap<String,Integer> immutableMap = asImmutableMap(mutableMap);

        Map expectedMap = new HashMap();
        expectedMap.put("a", 123);
        expectedMap.put("b", 456);

        assertThat(immutableMap, equalTo(ImmutableMap.<String, Integer>builder().put("a", 123).put("b", 456).build()));
    }

    @Test
    public void shouldConvertFromMutableMapOfStateToImmutableStateMap() {
        AddressMapBuilder builder = createAddressMap(
                addressEntry("first", createAddress().streetName("First street")),
                addressEntry("second", buildAddress().withStreetName("Second street")));

        Map<String, AddressState> mutableMap = builder.asMutableStateMap();
        ImmutableMap<String,AddressState> immutableMap = asImmutableMap(mutableMap, toImmutable);

        assertThat(immutableMap, equalTo(builder.asStateMap()));
    }

    @Test
    public void shouldConvertFromMutableMapOfMutableMapOfIntegerToMutableMap() {
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("a", 123);
        map2.put("b", 456);
        Map mutableMap = new HashMap();
        mutableMap.put("c", map1);
        mutableMap.put("d", map2);

        ImmutableMap<String, ImmutableMap<String,Integer>> immutableMap = asImmutableMap(mutableMap, toImmutableMap);

        ImmutableMap<String,Integer> expected1 = ImmutableMap.<String,Integer>builder().put("a", 123).build();
        ImmutableMap<String,Integer> expected2 = ImmutableMap.<String,Integer>builder().put("b", 456).build();
        ImmutableMap<String,ImmutableMap<String,Integer>> expectedMap =
                ImmutableMap.<String,ImmutableMap<String,Integer>>builder()
                .put("c", expected1)
                .put("d", expected2).build();

        assertThat(immutableMap, equalTo(expectedMap));
    }
}
