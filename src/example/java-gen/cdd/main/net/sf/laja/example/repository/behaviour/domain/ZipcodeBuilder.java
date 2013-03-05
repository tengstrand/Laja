package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.ZipcodeState;

public class ZipcodeBuilder {
    public final ZipcodeStateBuilder builder;

    public ZipcodeBuilder() {
        builder = ZipcodeStateImpl.build();
    }

    public ZipcodeBuilder(ZipcodeState state) {
        builder = new ZipcodeStateBuilderImpl(state);
    }

    public ZipcodeBuilder(ZipcodeState state, Object encapsulator) {
        builder = new ZipcodeStateBuilderImpl(state, encapsulator);
    }

    public ZipcodeBuilder withZipcode(int zipcode) {
        builder.withZipcode(zipcode);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Zipcode asZipcode() {
        return (Zipcode)builder.as(new ZipcodeFactory.ZipcodeFactory_());
    }
}
