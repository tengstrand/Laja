package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;

public class HeightEncapsulator {
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
}
