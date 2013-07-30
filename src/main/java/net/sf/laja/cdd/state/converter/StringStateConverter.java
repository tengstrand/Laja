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
import org.joda.time.Partial;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.YearMonth;
import org.joda.time.Years;

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

    public String toString(Instant value) { return value == null ? null : value.toString(); }
    public String toString(DateTime value) { return value == null ? null : value.toString(); }
    public String toString(DateMidnight value) { return value == null ? null : value.toString(); }
    public String toString(LocalDate value) { return value == null ? null : value.toString(); }
    public String toString(LocalTime value) { return value == null ? null : value.toString(); }
    public String toString(LocalDateTime value) { return value == null ? null : value.toString(); }
    public String toString(YearMonth value) { return value == null ? null : value.toString(); }
    public String toString(MonthDay value) { return value == null ? null : value.toString(); }
    public String toString(Partial value) { return value == null ? null : value.toString(); }
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

    public String toString(Object value) { return value == null ? null : value.toString(); }

    public DateMidnight toDateMidnight(String date) { return new DateMidnight(date); }
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

    public StateConverter objectToStringConverter() {
        return new StateConverter() {
            public Object convert(Object from, int index, StateConverter... converters) {
                return from == null ? null : from.toString();
            }
        };
    }
}
