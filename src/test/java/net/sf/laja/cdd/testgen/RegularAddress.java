package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.testgen.state.AddressState;

import static net.sf.laja.cdd.testgen.AddressCreator.AddressBehaviour;

@Behaviour
public class RegularAddress extends AddressBehaviour implements Address {

    public RegularAddress(AddressState state) {
        super(state);
    }

    public boolean isFromUppsala() {
        return "Uppsala".equals(state.city);
    }
}
