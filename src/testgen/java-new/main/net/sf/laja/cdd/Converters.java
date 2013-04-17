package net.sf.laja.cdd;

import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;

public class Converters {

    private static String DATE_MIDNIGHT_FORMAT = "yyyy-MM-dd";

    public static String asString(DateMidnight date) {
        return new SimpleDateFormat(DATE_MIDNIGHT_FORMAT).format(date.toDate());
    }

    public static DateMidnight asDateMidnight(String date) {
        return DateTimeFormat.forPattern(DATE_MIDNIGHT_FORMAT).parseDateTime(date).toDateMidnight();
    }
}
