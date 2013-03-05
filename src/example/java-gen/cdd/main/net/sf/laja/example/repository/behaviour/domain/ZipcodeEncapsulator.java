package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.ZipcodeState;
// Zipcode

public class ZipcodeEncapsulator implements ZipcodeStateComparable {
    public final ZipcodeStateBuilder builder;

    public ZipcodeEncapsulator(ZipcodeStateBuilder builder) {
        this.builder = builder;
    }

    public Zipcode asZipcode() {
        return (Zipcode)builder.as(new ZipcodeFactory.ZipcodeFactory_());
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
