package net.sf.laja.cdd.stateconverter;

public interface TypeConverter {
    Object convert(Object from, TypeConverter... converters);
}
