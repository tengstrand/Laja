package net.sf.laja.cdd.typeconverter;

import net.sf.laja.cdd.annotation.TypeConverter;
import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;

import java.util.Calendar;
import java.util.Date;

@TypeConverter
public class DateMidnightConverter {
    public DateMidnight convert() { return new DateMidnight(); }
    public DateMidnight convert(Chronology chronology) { return new DateMidnight(chronology); }
    public DateMidnight convert(DateTimeZone zone) { return new DateMidnight(zone); }
    public DateMidnight convert(int year, int monthOfYear, int dayOfMonth) { return new DateMidnight(year, monthOfYear, dayOfMonth); }
    public DateMidnight convert(int year, int monthOfYear, int dayOfMonth, Chronology chronology) { return new DateMidnight(year, monthOfYear, dayOfMonth, chronology); }
    public DateMidnight convert(int year, int monthOfYear, int dayOfMonth, DateTimeZone zone) { return new DateMidnight(year, monthOfYear, dayOfMonth, zone); }
    public DateMidnight convert(long instant) { return new DateMidnight(instant); }
    public DateMidnight convert(long instant, Chronology chronology) { return new DateMidnight(instant, chronology); }
    public DateMidnight convert(long instant, DateTimeZone zone) { return new DateMidnight(instant, zone); }
    public DateMidnight convert(Date date) { return new DateMidnight(date); }
    public DateMidnight convert(Calendar calendar) { return new DateMidnight(calendar); }
    public DateMidnight convert(ReadableInstant instant) { return new DateMidnight(instant); }
}
