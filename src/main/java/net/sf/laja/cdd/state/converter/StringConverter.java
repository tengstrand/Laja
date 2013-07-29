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

public class StringConverter {
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

    public StateConverter integerToStringConverter() {
        return new StateConverter() {
            public Object convert(Object from, int index, StateConverter... converters) {
                return from == null ? null : from.toString();
            }
        };
    }

}
