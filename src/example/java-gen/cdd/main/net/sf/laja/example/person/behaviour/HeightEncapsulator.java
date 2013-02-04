package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;
// Person

public class HeightEncapsulator implements HeightStateComparable {
    public final HeightStateBuilder builder;

    public HeightEncapsulator(HeightStateBuilder builder) {
        this.builder = builder;
    }

    public Height asHeight() {
        return (Height)builder.as(new HeightFactory.HeightFactory_(builder));
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
