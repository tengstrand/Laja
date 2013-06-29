package net.sf.laja.cdd.stateconverter;

public interface StateConverter {
    Object convert(Object from, int index, StateConverter... converters);
}
