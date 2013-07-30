package net.sf.laja.cdd.state.converter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.MutableState;
import org.joda.time.DateMidnight;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StateConversion {

    public static ImmutableState asImmutable(MutableState from) { return StateConverters.toImmutable.convert(from, 0); }
    public static MutableState asMutable(ImmutableState from) { return StateConverters.toMutable.convert(from, 0); }

    public static Set asMutableSet(Object from, StateConverter... converters) { return StateConverters.toMutableSet.convert(from, 0, converters); }
    public static ImmutableSet asImmutableSet(Object from, StateConverter... converters) { return StateConverters.toImmutableSet.convert(from, 0, converters); }

    public static List asMutableList(Object from, StateConverter... converters) { return StateConverters.toMutableList.convert(from, 0, converters); }
    public static ImmutableList asImmutableList(Object from, StateConverter... converters) { return StateConverters.toImmutableList.convert(from, 0, converters); }

    public static Map asMutableMap(Object from, StateConverter... converters) { return StateConverters.toMutableMap.convert(from, 0, converters); }
    public static ImmutableMap asImmutableMap(Object from, StateConverter... converters) { return StateConverters.toImmutableMap.convert(from, 0, converters); }

    private static String DATE_MIDNIGHT_FORMAT = "yyyy-MM-dd";

    public static String intAsString(int value) {
        return String.valueOf(value);
    }

    public static String asString(DateMidnight date) {
        return new SimpleDateFormat(DATE_MIDNIGHT_FORMAT).format(date.toDate());
    }
}
