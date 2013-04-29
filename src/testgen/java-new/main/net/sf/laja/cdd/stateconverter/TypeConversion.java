package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.MutableState;
import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.stateconverter.TypeConverters.*;

public class TypeConversion {
    private static String DATE_MIDNIGHT_FORMAT = "yyyy-MM-dd";

    public static ImmutableState asImmutable(MutableState from) { return toImmutable.convert(from); }
    public static MutableState asMutable(ImmutableState from) { return toMutable.convert(from); }

    public static Set asMutableSet(Object from, TypeConverter... converters) { return toMutableSet.convert(from, converters); }
    public static ImmutableSet asImmutableSet(Object from, TypeConverter... converters) { return toImmutableSet.convert(from, converters); }

    public static List asMutableList(Object from, TypeConverter... converters) { return toMutableList.convert(from, converters); }
    public static ImmutableList asImmutableList(Object from, TypeConverter... converters) { return toImmutableList.convert(from, converters); }

    public static Map asMutableMap(Object from, TypeConverter... converters) { return toMutableMap.convert(from, converters); }
    public static ImmutableMap asImmutableMap(Object from, TypeConverter... converters) { return toImmutableMap.convert(from, converters); }

    // TODO: May be moved when introducing StringState.
    public static String asString(DateMidnight date) {
        return new SimpleDateFormat(DATE_MIDNIGHT_FORMAT).format(date.toDate());
    }

    public static DateMidnight asDateMidnight(String date) {
        return DateTimeFormat.forPattern(DATE_MIDNIGHT_FORMAT).parseDateTime(date).toDateMidnight();
    }
}
