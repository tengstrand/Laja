package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.ZipcodeState;

public class Zipcode extends ZipcodeFactory {
    public Zipcode(ZipcodeState state) {
        super(state);
    }

    // (factory)
    public Zipcode asZipcode() {
        return new Zipcode(state);
    }
}
