package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.ZipcodeState;

public class ZipcodeCreator {
    private final ZipcodeStateBuilder builder = ZipcodeStateImpl.build();

    public class Zipcode_ {
        public ZipcodeEncapsulator zipcode(int zipcode) {
            builder.withZipcode(zipcode);
            return create();
        }
    }

    public ZipcodeEncapsulator create() {
        return new ZipcodeEncapsulator(builder);
     }
}
