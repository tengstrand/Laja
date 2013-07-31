package net.sf.laja.cdd.state.converter;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.MonthDay;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.YearMonth;
import org.joda.time.Years;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StringStateConverter {
    public String booleanToString(boolean value) { return String.valueOf(value); }
    public String byteToString(byte value) { return String.valueOf(value); }
    public String shortToString(short value) { return String.valueOf(value); }
    public String charToString(char value) { return String.valueOf(value); }
    public String intToString(int value) { return String.valueOf(value); }
    public String longToString(long value) { return String.valueOf(value); }
    public String floatToString(float value) { return String.valueOf(value); }
    public String doubleToString(double value) { return String.valueOf(value); }

    public String toString(Boolean value) { return value == null ? null : value.toString(); }
    public String toString(Byte value) { return value == null ? null : value.toString(); }
    public String toString(Short value) { return value == null ? null : value.toString(); }
    public String toString(Character value) { return value == null ? null : value.toString(); }
    public String toString(Integer value) { return value == null ? null : value.toString(); }
    public String toString(Long value) { return value == null ? null : value.toString(); }
    public String toString(Float value) { return value == null ? null : value.toString(); }
    public String toString(Double value) { return value == null ? null : value.toString(); }

    public String toString(Object value) { return value == null ? null : value.toString(); }

    public String toString(Instant value) { return value == null ? null : value.toString(); }
    public String toString(DateTime value) { return value == null ? null : value.toString(); }
    public String toString(DateMidnight value) { return value == null ? null : value.toString(); }
    public String toString(LocalDate value) { return value == null ? null : value.toString(); }
    public String toString(LocalTime value) { return value == null ? null : value.toString(); }
    public String toString(LocalDateTime value) { return value == null ? null : value.toString(); }
    public String toString(YearMonth value) { return value == null ? null : value.toString(); }
    public String toString(MonthDay value) { return value == null ? null : value.toString(); }
    public String toString(Interval value) { return value == null ? null : value.toString(); }
    public String toString(Duration value) { return value == null ? null : value.toString(); }
    public String toString(Period value) { return value == null ? null : value.toString(); }
    public String toString(Years value) { return value == null ? null : value.toString(); }
    public String toString(Months value) { return value == null ? null : value.toString(); }
    public String toString(Weeks value) { return value == null ? null : value.toString(); }
    public String toString(Days value) { return value == null ? null : value.toString(); }
    public String toString(Hours value) { return value == null ? null : value.toString(); }
    public String toString(Minutes value) { return value == null ? null : value.toString(); }
    public String toString(Seconds value) { return value == null ? null : value.toString(); }

    public Boolean toBoolean(String value) { return value == null || value.trim().isEmpty() ? null : Boolean.valueOf(value); }
    public boolean toBooleanPrimitive(String value) { return value == null || value.trim().isEmpty() ? false : Boolean.valueOf(value); }
    public Byte toByte(String value) { return value == null || value.trim().isEmpty() ? null : Byte.valueOf(value); }
    public byte toBytePrimitive(String value) { return value == null || value.trim().isEmpty() ? 0 : Byte.valueOf(value); }
    public Short toShort(String value) { return value == null || value.trim().isEmpty() ? null : Short.valueOf(value); }
    public short toShortPrimitive(String value) { return value == null || value.trim().isEmpty() ? 0 : Short.valueOf(value); }
    public Character toCharacter(String value) { return value == null || value.trim().isEmpty() ? null : Character.valueOf(value.charAt(0)); }
    public char toChar(String value) { return value == null || value.trim().isEmpty() ? 0 : Character.valueOf(value.charAt(0)); }
    public Integer toInteger(String value) { return value == null || value.trim().isEmpty() ? null : Integer.valueOf(value); }
    public int toInt(String value) { return value == null || value.trim().isEmpty() ? 0 : Integer.valueOf(value); }
    public Long toLong(String value) { return value == null || value.trim().isEmpty() ? null : Long.valueOf(value); }
    public long toLongPrimitive(String value) { return value == null || value.trim().isEmpty() ? 0 : Long.valueOf(value); }
    public Float toFloat(String value) { return value == null || value.trim().isEmpty() ? null : Float.valueOf(value); }
    public float toFloatPrimitive(String value) { return value == null || value.trim().isEmpty() ? 0 : Float.valueOf(value); }
    public Double toDouble(String value) { return value == null || value.trim().isEmpty() ? null : Double.valueOf(value); }
    public double toDoublePrimitive(String value) { return value == null || value.trim().isEmpty() ? 0 : Double.valueOf(value); }

    public BigInteger toBigInteger(String value) { return value == null || value.trim().isEmpty() ? null : new BigInteger(value); }
    public BigDecimal toBigDecimal(String value) { return value == null || value.trim().isEmpty() ? null : new BigDecimal(value); }

    public Instant toInstant(String value) { return value == null || value.trim().isEmpty() ? null : new Instant(value); }
    public DateTime toDateTime(String value) { return value == null || value.trim().isEmpty() ? null : new DateTime(value); }
    public DateMidnight toDateMidnight(String value) { return value == null || value.trim().isEmpty() ? null : new DateMidnight(value); }
    public LocalDate toLocalDate(String value) { return value == null || value.trim().isEmpty() ? null : new LocalDate(value); }
    public LocalTime toLocalTime(String value) { return value == null || value.trim().isEmpty() ? null : new LocalTime(value); }
    public LocalDateTime toLocalDateTime(String value) { return value == null || value.trim().isEmpty() ? null : new LocalDateTime(value); }
    public YearMonth toYearMonth(String value) { return value == null || value.trim().isEmpty() ? null : new YearMonth(value); }
    public MonthDay toMonthDay(String value) { return value == null || value.trim().isEmpty() ? null : new MonthDay(value); }
    public Interval toInterval(String value) { return value == null || value.trim().isEmpty() ? null : new Interval(value); }
    public Duration toDuration(String value) { return value == null || value.trim().isEmpty() ? null : new Duration(value); }
    public Period toPeriod(String value) { return value == null || value.trim().isEmpty() ? null : new Period(value); }
    public Years toYears(String value) { return value == null || value.trim().isEmpty() ? null : Years.parseYears(value); }
    public Months toMonths(String value) { return value == null || value.trim().isEmpty() ? null : Months.parseMonths(value); }
    public Weeks toWeeks(String value) { return value == null || value.trim().isEmpty() ? null : Weeks.parseWeeks(value); }
    public Days toDays(String value) { return value == null || value.trim().isEmpty() ? null : Days.parseDays(value); }
    public Hours toHours(String value) { return value == null || value.trim().isEmpty() ? null : Hours.parseHours(value); }
    public Minutes toMinutes(String value) { return value == null || value.trim().isEmpty() ? null : Minutes.parseMinutes(value); }
    public Seconds toSeconds(String value) { return value == null || value.trim().isEmpty() ? null : Seconds.parseSeconds(value); }

    public StateConverter objectToStringConverter() {
        return new StateConverter() {
            public Object convert(Object from, int index, StateConverter... converters) {
                return from == null ? null : from.toString();
            }
        };
    }
}
