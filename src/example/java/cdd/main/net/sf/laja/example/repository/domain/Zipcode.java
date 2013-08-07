package net.sf.laja.example.repository.domain;

import net.sf.laja.example.repository.state.ZipcodeState;

import static net.sf.laja.example.repository.domain.ZipcodeCreator.ZipcodeBehaviour;
import static net.sf.laja.example.repository.state.ZipcodeState.CODE;

public class Zipcode extends ZipcodeBehaviour {
    public final int code;

    public Zipcode(int code) {
        super(new ZipcodeState(code));
        this.code = code;

        assertThat(code >= 10000 && code <= 99999, CODE, "Zipcode must be a value between 10000 and 99999");
    }
}
