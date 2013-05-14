package net.sf.laja.cdd.stateconverter;

public interface TypeConverter {
    Object convert(Object from, int index, TypeConverter... converters);
}
