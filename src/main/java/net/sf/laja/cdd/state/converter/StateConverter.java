package net.sf.laja.cdd.state.converter;

public interface StateConverter {
    Object convert(Object from, int index, StateConverter... converters);
}
