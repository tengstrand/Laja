package net.sf.laja.example.repository.domain;

import net.sf.laja.example.repository.state.ZipcodeState;

import static net.sf.laja.example.repository.domain.ZipcodeCreator.ZipcodeBehaviour;

public class Zipcode extends ZipcodeBehaviour {

    public Zipcode(ZipcodeState state) {
        super(state);
    }
}
